import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

class Task34Main {
    private <K,V> Map<V, Collection<K>> swapKeyAndValueInMap(Map<K,V> map){
        Map<V, Collection<K>> result = new HashMap<>();
        map.forEach((key, value) -> result.computeIfAbsent(value, k -> new ArrayList<>()).add(key));
        return result;

    }
}
