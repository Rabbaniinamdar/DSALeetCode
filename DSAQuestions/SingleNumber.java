import java.util.*;

public class SingleNumber {
    static int singleNumber(int arr[]) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (set.contains(i)) {
                set.remove(i);
            } else {
                set.add(i);
            }
        }
        if (set.isEmpty()) {
            return -1;
        }
        return set.iterator().next();
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 1, 2, 4, 6 };
        System.out.println(singleNumber(arr));
    }
}
