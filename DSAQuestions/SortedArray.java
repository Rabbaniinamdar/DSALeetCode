
public class SortedArray {
    public static long kthElement(int arr1[], int arr2[], int n, int m, int key) {
        int i = 0, j = 0, k = 0;

        int arr[] = new int[m + n];
        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                arr[k++] = arr1[i++];
            } else {
                arr[k++] = arr2[j++];
            }
        }
        while (i < n) {
            arr[k++] = arr1[i++];
        }
        while (j < m) {
            arr[k++] = arr2[j++];
        }
        return arr[key - 1];
    }

    public static void main(String[] args) {
        int arr1[] = { 2, 3, 6, 7, 9 };
        int arr2[] = { 1, 4, 8, 10 };

        System.out.println(kthElement(arr1, arr2, arr1.length, arr2.length, 5));

    }
}