public class RotateArray {
    public static void MoveZeroes(int[] nums, int k) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            if (nums[low] == 0) {
                swap(nums, low++, high--);
            } else {
                low++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        int key = k - 1;
        key = key % n;
        int[] arr = new int[nums.length];
        int j = 0;
        for (int i = nums.length - key; i < nums.length; i++) {
            arr[j++] = nums[i];
        }
        for (int i = 0; i < nums.length - key; i++) {
            arr[j++] = nums[i];
        }
        for (int i = 0; i < j; i++) {
            nums[i] = arr[i];
        }
    }
    

    public static void main(String[] args) {
        int arr[] = { 3, 1, 6, 5, 10, 7, 6, 6, 1, 7, };
        rotate(arr, 10);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
