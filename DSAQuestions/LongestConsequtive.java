import java.util.*;

public class LongestConsequtive {
    public static int longestConsequtiveSequence(int arr[]) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        int maxLength = 1;
        for (int n : set) {
            if (!set.contains(n - 1)) {
                int currNum = n;
                int currLength = 1;
                while (set.contains(currNum + 1)) {
                    currNum++;
                    currLength++;
                }
                maxLength = Math.max(maxLength, currLength);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = { 100, 4, 200, 1, 3, 2, 5 };
        int result = longestConsequtiveSequence(arr);
        System.out.println("The length of the longest consecutive sequence is: " + result);
    }

}
