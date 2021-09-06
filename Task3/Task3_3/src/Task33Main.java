import java.util.Collection;
import java.util.HashSet;

class Task33Main {
    private  <T> Collection<T> removeDuplicates(Collection<T> collection){
        return new HashSet<>(collection);
    }
}
