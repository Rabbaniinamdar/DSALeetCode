import java.util.ArrayList;
import java.util.List;

public class MajorityElement {
    public static int majorityElement1(int arr[]) {
        int n = arr.length;
        int count = 0;
        int elem = 0;
        for (int i = 0; i < n; i++) {
            if (count == 0) {
                count = 1;
                elem = arr[i];
            } else if (arr[i] == elem) {
                count++;
            } else {
                count--;
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] == elem) {
                count++;
            }
        }
        if (count > n / 2) {
            return elem;
        }
        return -1;
    }

    public static int[] majorityElement2(int arr[]) {
        int n = arr.length;
        int count1 = 0;
        int count2 = 0;

        int elem1 = 0;
        int elem2 = 0;

        for (int i = 0; i < n; i++) {
            if (count1 == 0 && elem2 != arr[i]) {
                count1 = 1;
                elem1 = arr[i];
            } else if (count2 == 0 && elem1 != arr[i]) {
                count2 = 1;
                elem2 = arr[i];
            } else if (arr[i] == elem1)
                count1++;
            else if (arr[i] == elem2)
                count2++;
            else {
                count1--;
                count2--;
            }
        }
        List<Integer> list = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        for (int j = 0; j < n; j++) {
            if (arr[j] == elem1)
                count1++;
            if (arr[j] == elem2)
                count2++;
        }

        if (count1 > n / 3)
            list.add(elem1);
        if (count2 > n / 3)
            list.add(elem2);

        int ans[] = new int[list.size()];
        int i = 0;
        for (int j2 = 0; j2 < list.size(); j2++) {
            ans[i++] = list.get(j2);

        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2 };
        int ans[] = majorityElement2(arr);
        for (int i = 0; i < ans.length; i++) {
            System.err.println(ans[i]);
        }
    }
}
