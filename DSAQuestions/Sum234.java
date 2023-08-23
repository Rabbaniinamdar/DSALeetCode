import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sum234 {
    public static int[] twoSum(int arr[], int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(target - arr[i])) {
                return new int[] { map.get(target - arr[i]), i };
            }
            map.put(arr[i], i);
        }
        return new int[] {};
    }

    public static List<List<Integer>> threeSum(int arr[]) {
        Arrays.sort(arr);
        Set<List<Integer>> list = new HashSet<>();
        int n = arr.length;
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum == 0) {
                    list.add(List.of(arr[i], arr[j], arr[k]));
                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return new ArrayList<>(list);
    }

    public static List<List<Integer>> fourSum(int arr[], int target) {
        Arrays.sort(arr);
        Set<List<Integer>> list = new HashSet<>();
        int n = arr.length;
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                int k = i + 1;
                int l = n - 1;
                while (k < l) {
                    int sum = arr[i] + arr[j] + arr[k] + arr[l];
                    if (sum == target) {
                        ArrayList<Integer> li = new ArrayList<>();
                        li.add(arr[i]);
                        li.add(arr[j]);
                        li.add(arr[k]);
                        li.add(arr[l]);
                        list.add(li);
                        // list.add(List.of(arr[i], arr[j], arr[k], arr[l]));
                        k++;
                        l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }
        return new ArrayList<>(list);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 0, -1, 0, -2, 2 };
        List<List<Integer>> sum = fourSum(arr, 0);
        for (List<Integer> list : sum) {
            System.out.println(list);
        }
    }
}
