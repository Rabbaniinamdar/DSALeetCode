public class MovePrime {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
        int ans[] = movePrime(arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    public static int[] movePrime(int arr[]) {
        int low = 0, mid = 0, high = arr.length - 1;
        while (mid <= high) {
            if (!isprime(arr[mid])) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else {
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

    static boolean isprime(int n) {
        int cou = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                cou++;
            }
        }
        if (cou == 2) {
            return true;
        } else {
            return false;
        }
    }
}