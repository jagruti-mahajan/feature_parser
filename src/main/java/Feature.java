import java.awt.desktop.SystemEventListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Feature {

    public static LinkedList<String> sortedMasterFeatureList = new LinkedList<>();
    public static String masterFeatureFilePath = "src/main/resources/master-feature-list";
    public static HashMap<String, Integer> countKeysWithLine = new HashMap<>();
    public static void loadFile(String filePath) {
        String line;
        try{
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            try {
                while((line = br.readLine()) != null) {
                    countKeysWithLine.put(line, Arrays.asList(line.split(" ")).size());

                }
                br.close();
                System.out.println("File reading completed");
                Object[] a = countKeysWithLine.entrySet().toArray();
                Arrays.sort(a, new Comparator() {
                    public int compare(Object o1, Object o2) {
                        return ((Map.Entry<String, Integer>) o2).getValue()
                                .compareTo(((Map.Entry<String, Integer>) o1).getValue());
                    }
                });

                for(Object e :a){
                    sortedMasterFeatureList.add(((Map.Entry<String, Integer>) e).getKey());
                }

                System.out.println("Sorted list :" + sortedMasterFeatureList);

            } catch(IOException e) {
                e.printStackTrace();
            }
        }catch(Exception e){
            e.getStackTrace();
        }
    }

    public static String readFeature(String inputData) {
        loadFile(masterFeatureFilePath);
        String[] inputArrayList = inputData.split("\\|");
        //Key => masterFeature values => inputText
        HashMap<String, String> fullMatchedFeatures = new HashMap<>();
        HashMap<String, String> partialMatchedFeatures = new HashMap<>();
        //
        for(String inputStmt : inputArrayList) {
            for(String masterFeatureStmt : sortedMasterFeatureList) {
                double count = findMatch(inputStmt, masterFeatureStmt);
                int size = getWords(masterFeatureStmt).size();
                if(count == 100.0) {
                    fullMatchedFeatures.put(masterFeatureStmt, inputStmt);
                    break;
                } else if(count > 0.0 && count <= 50.0) {
                    partialMatchedFeatures.put(masterFeatureStmt, inputStmt);
                }
            }
        }
        System.out.println(" Full Match Key Value :");
        fullMatchedFeatures.forEach((key, value) -> {
            System.out.println(" " + key + " => " + value);
        });
        System.out.println(" \n Partial Match ");
        partialMatchedFeatures.forEach((key, value) -> {
            System.out.println(" " + key + " => " + value);
        });

    return null;


    }

    public static double findMatch(String inputStmt, String featureStmt) {
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
}
