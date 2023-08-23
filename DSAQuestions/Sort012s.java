public class Sort012s {
    public static int[] Sort012(int arr[]) {
        int low = 0, mid = 0, high = arr.length - 1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else if (arr[mid] == 2) {
                swap(arr, mid, high);
                high--;
            }
        }
        return arr;
    }

    public static int[] moveNegative(int arr[]) {
        int low = 0, mid = 0, high = arr.length - 1;
        while (mid <= high) {
            if (arr[mid] < 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] >= 0) {
                mid++;
            }
        }
        return arr;
    }

    static void swap(int[] arr, int low, int mid) {
        int temp = arr[low];
        arr[low] = arr[mid];
        arr[mid] = temp;
    }

    public static void main(String[] args) {
        int arr[] = { -1, 2, -3, 4, 0, -4 };
        int ans[] = moveNegative(arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
