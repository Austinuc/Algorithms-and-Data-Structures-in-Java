package Maps;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapProblem {

    public boolean contains3(List<String> strList) {
        Map<String, Integer> freq = new HashMap<>();

        for (String s : strList) {
            if (freq.containsKey(s)) {
                freq.replace(s, freq.get(s)+1);
            } else freq.put(s, 1);
        }

        return freq.values().stream().anyMatch((integer -> integer >= 3));
    }

    public Map<String, Integer> intersect(Map<String, Integer> m1, Map<String, Integer> m2) {
        Map<String, Integer> loop = m1.size() >= m2.size() ? m1 : m2;
        Map<String, Integer> comp = m1.size() >= m2.size() ? m2 : m1;
        Map<String, Integer> res = new HashMap<>();

        loop.keySet().stream()
                .filter(comp::containsKey)
                .filter((key) -> loop.get(key).equals(comp.get(key)))
                .forEach((key) -> res.put(key, loop.get(key)));

        return res;
    }

    public static void main(String[] args) {
        Map<String, Integer> m1 = new HashMap<>();
        Map<String, Integer> m2 = new HashMap<>();
        m1.put("Janet", 87);
        m1.put("Logan", 62);
        m1.put("Whitaker", 46);
        m1.put("Alyssa", 100);
        m1.put("Jeff", 88);
        m1.put("Kim", 52);
        m1.put("Stefanie", 80);
        m1.put("Sylvia", 95);

        Map<String, Integer> s = new TreeMap<>();
        for (Map.Entry<String, Integer> stringIntegerEntry : m1.entrySet()) {

        }
        Iterator<Map.Entry<String, Integer>> itr = m1.entrySet().iterator();




        m2.put("Logan", 62);
        m2.put("Kim", 52);
        m2.put("Whitaker", 52);
        m2.put("Jeff", 88);
        m2.put("Stefanie", 80);
        m2.put("Brian", 60);
        m2.put("Lisa", 83);
        m2.put("Sylvia", 87);

        System.out.println(new MapProblem().contains3(Arrays.asList("373", "is", "fun", "HI", "fun", "fun")));

        System.out.println(new MapProblem().intersect(m1, m2));
    }
}
