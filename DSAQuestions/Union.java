import java.util.Arrays;

public class Union {
    public static int[] unioOfTwoArray(int[] arr1, int[] arr2) {
        int i = 0, j = 0, k = 0;
        int n = arr1.length;
        int m = arr2.length;

        int arr[] = new int[m + n];
        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                arr[k++] = arr1[i++];
            } else if (arr1[i] > arr2[j]) {
                arr[k++] = arr2[j++];
            } else {
                arr[k++] = arr1[i++];
                j++;
            }
        }
        while (i < n) {
            arr[k++] = arr1[i++];
        }
        while (j < m) {
            arr[k++] = arr2[j++];
        }
        return arr;
    }

    public static void merge(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int i = n - 1, j = 0;

        while (i >= 0 && j < m) {
            if (arr1[i] > arr2[j]) {
                int temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
            }
            i--;
            j++;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    public static void main(String[] args) {
        int arr1[] = { 1, 2, 4, 4 };
        int arr2[] = { 3, 4, 4,5 };
        merge(arr1, arr2);
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }

    }
}
