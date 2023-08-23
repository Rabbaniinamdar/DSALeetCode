import java.util.*;

class High_Lowfreq {
    public class Pattren {
        public static void countFrequency(int[] arr) {
            int n = arr.length;
            int[] hash = new int[16];

            for (int i = 0; i < n; i++) {
                hash[arr[i]]++;
            }
            for (int i = 0; i < n; i++) {
                if (hash[arr[i]] != 0) {
                    System.out.println(arr[i] + ":" + hash[arr[i]]);
                    hash[arr[i]] = 0;
                }
            }
        }
    }

    public static void countFrequency(int n, int x, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> enry : map.entrySet()) {
            System.out.println(enry.getKey() + ": " + enry.getValue());
        }
        int maxFreq = 0, minFreq = n;
        int maxEle = 0, minEle = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int element = entry.getKey();
            int count = entry.getValue();

            if (count > maxFreq) {
                maxEle = element;
                maxFreq = count;
            }
            if (count < minFreq) {
                minEle = element;
                minFreq = count;
            }
        }
        System.out.println("The highest frequency element is: " + maxEle);
        System.out.println("The lowest frequency element is: " + minEle);
    }

    public static void main(String[] args) {
        int arr[] = { 10, 5, 10, 15, 10, 5 };
        countFrequency(arr.length, 9, arr);
    }
}
