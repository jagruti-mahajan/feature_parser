import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Feature implements Serializable {
    private String name;
    private List<String> type;
    private List<String> aliases;

    public Feature() {
    }

    public Feature(String name, List<String> type, List<String> aliases){
        this.name = name;
        this.type = type;
        this.aliases = aliases;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getType() {
        return type;
    }

    public void setType(List<String> type) {
        this.type = type;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof Feature)) return false;
        Feature feature = (Feature) o;
        return Objects.equals(name, feature.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String toString() {
        return "Feature{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", aliases=" + aliases +
                '}';
    }
}
