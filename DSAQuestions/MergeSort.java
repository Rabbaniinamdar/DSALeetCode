public class MergeSort {
    public static void divide(int arr[], int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        divide(arr, low, mid);
        divide(arr, mid + 1, high);
        conqure(arr, low, mid, high);
    }

    public static void conqure(int[] arr, int low, int mid, int high) {
        int merge[] = new int[high - low + 1];
        int idx1 = low;
        int idx2 = mid + 1;
        int k = 0;
        while (idx1 <= mid && idx2 <= high) {
            if (arr[idx1] <= arr[idx2]) {
                merge[k++] = arr[idx1++];
            } else {
                merge[k++] = arr[idx2++];
            }
        }
        while (idx1 <= mid) {
            merge[k++] = arr[idx1++];
        }
        while (idx2 <= high) {
            merge[k++] = arr[idx2++];
        }
        for (int i = low; i <= high; i++) {
            arr[i] = merge[i - low];
        }
    }

    public static void main(String[] args) {
        int arr[] = { 3, 4, 5, 2, 1, 3, 4, 5, 6 };
        divide(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
