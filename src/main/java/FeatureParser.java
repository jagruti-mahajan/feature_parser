import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class FeatureParser {

    private static String filePath = "src/main/resources/features.json";
    public static HashMap<String, Feature> masterFeatureMap = new LinkedHashMap<>();

    /**
     * Builds a masterFeatureMap using a valid JSON string
     * @param filePath  path of file having  A JSON representation of a master feature
     */
    private static void buildMasterFeature(String filePath) throws IOException {
        String jsonContent = new String(Files.readAllBytes(Paths.get(filePath)));
        ObjectMapper mapper = new ObjectMapper();
        List<Feature> features = Arrays.asList(mapper.readValue(jsonContent, Feature[].class));
        features.forEach(x -> masterFeatureMap.put(x.getName(), x));
    }

    public static void parseFeature(String inputFeatures){
        //load master Features in memory
        try {
            buildMasterFeature(filePath);
        }
        catch(IOException e){
            e.printStackTrace();
        }
        List<String> inputFeatureList = new LinkedList<String>(Arrays.asList(inputFeatures.split("[\\|\\,]")));

        //key is input statement and values is matched feature object
        HashMap<String, Feature> fullMatched = new HashMap<>();
        Set<String> nonMappedInputStmt = new LinkedHashSet<>();
        Map<String, Feature> partialMatchedFeatureMap = new HashMap<>();

        //iterate on each input feature
        for(String inputFeatureStmt : inputFeatureList){
            Map<String, Feature> matchedFeatureMap = new HashMap<>();
            masterFeatureMap.entrySet()
                    .stream()
                    .filter(feature -> {
                        double percentage = findMatch(inputFeatureStmt, feature.getKey());
                        if(percentage != 100.0){
                            double puralPerc   = findPlural(inputFeatureStmt, feature.getKey());
                            if(puralPerc == 100.0) return true;
                        }
                        if(percentage >= 70.0) return true;
                        return false;
                    })
                    .forEach(entry -> matchedFeatureMap.put(entry.getKey(), entry.getValue()));

            if(matchedFeatureMap.size() > 0) {
                for(String key : matchedFeatureMap.keySet()) {
                    Set<String> featureWords = getWords(key);
                    Set<String> inputFeatureWords = getWords(inputFeatureStmt);

                    if(!featureWords.containsAll(inputFeatureWords)) {
                        List<String> featureTypes = matchedFeatureMap.get(key).getType();
                        if(featureTypes.size() == 0) partialMatchedFeatureMap.put(inputFeatureStmt.trim(), matchedFeatureMap.get(key));
                        for(String type : featureTypes){
                            if(wordMatcher(inputFeatureStmt, type + " " + key)) {
                                fullMatched.put(inputFeatureStmt.trim(), matchedFeatureMap.get(key));
                                break;
                            }
                            else {
                                partialMatchedFeatureMap.put(inputFeatureStmt.trim(), matchedFeatureMap.get(key));
                            }
                        }
                    }
                    else {
                        fullMatched.put(inputFeatureStmt.trim(), matchedFeatureMap.get(key));
                    }

                }
            } else {
               nonMappedInputStmt.add(inputFeatureStmt.trim());
            }
        }

        for(String key : fullMatched.keySet()){
            System.out.println(key + " =>> " + fullMatched.get(key));
            partialMatchedFeatureMap.remove(key);
        }
        System.out.println("Full match count : " + fullMatched.size() + " out of " + inputFeatureList.size());

        nonMappedInputStmt.removeAll(fullMatched.keySet());
        System.out.println("Non mapped list :: " + nonMappedInputStmt.size());

        for(String nn : nonMappedInputStmt){
            System.out.println(nn);
        }

        System.out.println("Partial Matched : " + partialMatchedFeatureMap.size());
        for(String key : partialMatchedFeatureMap.keySet()){
            System.out.println(key + " can be mapped to " +partialMatchedFeatureMap.get(key));
        }

    }

    //Check each word(plural/singular) of inputStmt and featureString if matches all words then true
    public static boolean wordMatcher(String inputStmt, String featureString){
        Set<String> inputStmtWord = getWords(inputStmt);
        Set<String> featureStringWords = getWords(featureString);
        List<String> wordsInInputTermThatAreFound = new LinkedList<>();
        List<String> pluralWords = new LinkedList<>();
        pluralWords = inputStmtWord.stream()
                .filter(s -> featureStringWords.stream()
                        .anyMatch(w -> s.matches(w + "(?:s)") || w.matches(s + "(?:s)")))
                .collect(Collectors.toList());
        List<String> actualMatch =  new ArrayList<>();
        List<String> secondaryWords =  new ArrayList<>();
        for(String featureWord : featureStringWords){
            actualMatch =  pluralWords.stream().filter(s -> s.matches(featureWord + "(?:s)") || featureWord.matches(s + "(?:s)")).collect(Collectors.toList());
            if(actualMatch != null && !actualMatch.isEmpty()) secondaryWords.add(featureWord);

        }
        wordsInInputTermThatAreFound = inputStmtWord.stream()
                .filter(s -> featureStringWords.contains(s))
                .collect(Collectors.toList());
        actualMatch.addAll(wordsInInputTermThatAreFound);
        List<String> testFeatureWord = new ArrayList<>();
        testFeatureWord.addAll(featureStringWords);
        testFeatureWord.removeAll(actualMatch);
        testFeatureWord.removeAll(secondaryWords);
        if(testFeatureWord.isEmpty() || testFeatureWord.size() == 0 ) {
            return true;
        }

        if(inputStmtWord.containsAll(featureStringWords)) return true;

        return false;
    }

    private static double findMatch(String inputStmt, String featureStmt) {
        int wordsInInputTermThatAreFound = -1;
        Set<String> inputWords = getWords(inputStmt);
        Set<String> featureWords = getWords(featureStmt);
        wordsInInputTermThatAreFound = (int) inputWords.stream()
                .filter(s -> featureWords.contains(s))
                .count();

        return ((wordsInInputTermThatAreFound / Double.valueOf(featureWords.size())) * 100f);
    }

    private static Set<String> getWords(String statement) {
        return Arrays.stream(statement.split("\\b"))
                .map(String::trim)
                .map(String::toLowerCase)
                .filter(s -> s.matches("[A-Za-z0-9]+"))
                .collect(Collectors.toSet());
    }

    private static double findPlural(String inputStmt, String masterFeatureStmt) {
        List<String> wordsInInputTermThatAreFound = new LinkedList<>();
        List<String> pluralWordsInInputTermThatAreFound = new LinkedList<>();
        Set<String> inputWords = getWords(inputStmt);
        Set<String> featureWords = getWords(masterFeatureStmt);

        pluralWordsInInputTermThatAreFound = inputWords.stream()
                .filter(s -> featureWords.stream()
                        .anyMatch(w -> s.matches(w + "(?:s)") || w.matches(s + "(?:s)")))
                .collect(Collectors.toList());

        wordsInInputTermThatAreFound = inputWords.stream()
                .filter(s -> featureWords.contains(s))
                .collect(Collectors.toList());

        List<String> actualMatch =  new ArrayList<>();
        List<String> secondaryWords =  new ArrayList<>();
        for(String featureWord : featureWords){
            actualMatch =  pluralWordsInInputTermThatAreFound.stream().filter(s -> s.matches(featureWord + "(?:s)") || featureWord.matches(s + "(?:s)")).collect(Collectors.toList());
            if(actualMatch != null && !actualMatch.isEmpty()) secondaryWords.add(featureWord);

        }
        actualMatch.addAll(wordsInInputTermThatAreFound);
        List<String> testFeatureWord = new ArrayList<>();
        testFeatureWord.addAll(featureWords);
        testFeatureWord.removeAll(actualMatch);
        testFeatureWord.removeAll(secondaryWords);
        if(testFeatureWord.isEmpty() || testFeatureWord.size() == 0 ) {
            return 100f;
        }

        return ((pluralWordsInInputTermThatAreFound.size() / Double.valueOf(featureWords.size())) * 100f);

    }


}
