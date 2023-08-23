import java.util.*;

public class MissandRepeat {
    public static int[] findMissingAndRepeatingNumber(int arr[]) {
        int miss = -1, rep = -1;
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (set.contains(i)) {
                rep = i;
            } else {
                set.add(i);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (!set.contains(i)) {
                miss = i;
                break;
            }
        }
        return new int[] { rep, miss };
    }

    public static void main(String[] args) {
        int arr[] = { 0, 1, 2, 2, 3, 4, 4 };
        int ans[] = findMissingAndRepeatingNumber(arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
