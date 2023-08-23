import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MissingNumber {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 3, 5, 6 };
        int ans[] = findMissingRepeatingNumbers(arr);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    public static int pairs(int arr[], int k) {
        int cout = 1;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == k) {
                    cout++;
                }
            }
        }
        return cout;
    }

    public static void pow(int arr[]) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                arr[i] = -1;
                arr[i + 1] = -1;
            }
        }
        for (int i : arr) {
            if (i > 0) {
                System.out.print(i + " ");
            }
        }
    }

    public static int[] findMissingRepeatingNumbers(int[] nums) {
        int repetingNumber = -1, missNumber = -1;
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) {
                repetingNumber = i;
            } else {
                set.add(i);
            }
        }
        for (int i = 1; i < nums.length; i++) {
            if (!set.contains(i)) {
                missNumber = i;
                break;
            }
        }
        return new int[] { repetingNumber, missNumber };
    }
}
