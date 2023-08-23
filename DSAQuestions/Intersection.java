import java.util.HashSet;
import java.util.Set;

public class Intersection {
    public static int[] intersectionofArray(int arr1[], int arr2[]) {
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> intersction = new HashSet<Integer>();
        for (int i = 0; i < arr2.length; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            if (set.contains(arr1[i])) {
                intersction.add(arr2[i]);
            }
        }
        int newarr[] = new int[intersction.size()];
        int i = 0;
        for (Integer num : intersction) {
            newarr[i++] = num;
        }
        return newarr;
    }

    public static void main(String[] args) {
        int arr1[] = { 1, 2, 3, 4, 5 };
        int arr2[] = { 3, 4, 5 };
        int arr[] = intersectionofArray(arr1, arr2);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
