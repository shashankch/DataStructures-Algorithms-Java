package hashmaps;

import java.util.HashMap;
import java.util.Set;

public class test {

    public static void main(String[] args) {


        HashMap<String, Integer> map = new HashMap<>();

        map.put("key", 1);

        if (map.containsKey("key")) {
            System.out.println("it has");
        }

        int v = map.get("key"); // null pointer exp when

        map.remove("key"); // no exception if not exists.
        int l = map.size();

        Set<String> keys = map.keySet();
        for (String str : keys) {
            System.out.println(str);
        }

        
    }


}
