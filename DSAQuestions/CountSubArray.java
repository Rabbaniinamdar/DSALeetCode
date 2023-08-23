public class CountSubArray {
    public static int countSubArraySum(int arr[], int k) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int countLongestSubArraySum(int arr[], int k) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == 0) {
                    count = Math.max(count, j - i + 1);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = { 9, -3, 3, -1, 6, -5 };
        System.out.println(countSubArraySum(arr, 2));
    }
}
