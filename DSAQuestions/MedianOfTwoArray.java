public class MedianOfTwoArray {
    public static int[] mergeTwoArray(int[] arr1, int[] arr2) {
        int i = 0, j = 0, k = 0;
        int n = arr1.length;
        int m = arr2.length;

        int arr[] = new int[m + n];
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
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
        return arr;
    }

    public static double medianOfTwoArray(int arr1[], int arr2[]) {
        int merge[] = mergeTwoArray(arr1, arr2);
        int m = merge.length;
        if (m % 2 == 1) {
            return merge[m / 2];
        } else {
            return (merge[m / 2 - 1] + merge[m / 2]) / 2.0;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3 };
        int[] arr2 = { 4, 5 ,6};
        System.out.println(medianOfTwoArray(arr1, arr2));

    }
}
