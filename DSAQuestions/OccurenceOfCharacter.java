import java.util.LinkedHashMap;
import java.util.Map;

public class OccurenceOfCharacter {
    public static void occurenceOfCharacter(String str) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        str = str.replaceAll("\\s+", "").toLowerCase();
        for (char c : str.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (Map.Entry<Character, Integer> enry : map.entrySet()) {
            System.out.println(enry.getKey() + ": " + enry.getValue());
        }
            
    }

    public static void occurenceOfCharacter1(String str) {
        int[] count = new int[285];
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (count[str.charAt(i)] != 0 && str.charAt(i) != ' ') {
                System.out.println(str.charAt(i) + ": " + count[str.charAt(i)]);
                count[str.charAt(i)] = 0;
            }
        }
    }

    public static void main(String[] args) {
        occurenceOfCharacter1("Hello  World! ");
    }
}
