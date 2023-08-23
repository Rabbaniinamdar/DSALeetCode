/**
 * nextPermutation
 */
class nextPermutation {
    public static void nextPer(int arr[]) {
        int ind1 = -1;
        int ind2 = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                ind1 = i;
                break;
            }
        }
        if (ind1 == -1) {
            reverse(arr, 0);
        } else {
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i] > arr[ind1]) {
                    ind2 = i;
                    break;
                }
            }
            swap(arr, ind1, ind2);
            reverse(arr, ind1 + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    static void reverse(int[] nums, int start) {
        int i = start;
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3 };
        nextPer(arr);
    }
}