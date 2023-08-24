import java.util.Arrays;

public class BinarySearch {

    public static int singleNonDuplicate(int arr[]) {
        int n = arr.length;
        int low = 1;
        int high = n - 2;
        if (n == 1)
            return arr[0];
        if (arr[0] != arr[1])
            return arr[0];
        if (arr[n - 1] != arr[n - 2])
            return arr[n - 1];
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] != arr[mid + 1] && arr[mid] != arr[mid - 1]) {
                return arr[mid];
            }
            if (mid % 2 == 1 && arr[mid] == arr[mid - 1] || mid % 2 == 0 && arr[mid + 1] == arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int searchInRotated(int arr[], int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < arr[high]) {
                if (target >= arr[mid] && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (target >= arr[low] && target <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    // 34. Find First and Last Position of Element in Sorted Array
    public static void findFirstAnsLast(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static int findFirst(int[] nums, int target) {
        int st = 0, ed = nums.length - 1;
        int idx = -1;
        while (st <= ed) {
            int mid = (st + ed) / 2;
            if (nums[mid] == target) {
                idx = mid;
                ed = mid - 1;
            } else if (nums[mid] < target) {
                st = mid + 1;
            } else {
                ed = mid - 1;
            }
        }
        return idx;
    }

    public static int findUpperbond(int[] nums, int target) {
        int st = 0, ed = nums.length - 1;
        int idx = -1;
        while (st <= ed) {
            int mid = (st + ed) / 2;
            if (nums[mid] > target) {
                idx = mid;
                ed = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return idx;
    }

    public static int findLowerbond(int[] nums, int target) {
        int st = 0, ed = nums.length - 1;
        int idx = -1;
        while (st <= ed) {
            int mid = (st + ed) / 2;
            if (nums[mid] >= target) {
                idx = mid;
                ed = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return idx;
    }

    public int findPeakElement(int[] arr) {
        int n = arr.length;
        if (n == 1)
            return 0;
        if (arr[0] > arr[1])
            return 0;
        if (arr[n - 1] > arr[n - 2])
            return n - 1;
        int st = 1, ed = n - 2;
        while (st <= ed) {
            int mid = (st + ed) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (arr[mid - 1] < arr[mid]) {
                st = mid + 1;
            } else if (arr[mid - 1] > arr[mid]) {
                ed = mid - 1;
            }
        }
        return -1;
    }

    public static int findLast(int[] nums, int target) {
        int st = 0, ed = nums.length - 1;
        int idx = -1;
        while (st <= ed) {
            int mid = (st + ed) / 2;
            if (nums[mid] == target) {
                idx = mid;
                st = mid + 1;
            } else if (nums[mid] < target) {
                st = mid + 1;
            } else {
                ed = mid - 1;
            }
        }
        return idx;
    }

    public static int findMin(int[] nums) {
        int st = 0, ed = nums.length - 1;
        while (st < ed) {
            int mid = (st + ed) / 2;
            if (nums[mid] == nums[ed]) {
                return st;
            }
            if (nums[mid] < nums[ed]) {
                ed = mid;
            } else {
                st = mid + 1;
            }
        }
        return st;
    }

    static int findFloor(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] <= x) {
                ans = arr[mid];
                // look for smaller index on the left
                low = mid + 1;
            } else {
                high = mid - 1; // look on the right
            }
        }
        return ans;
    }

    static int findCeil(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] >= x) {
                ans = arr[mid];
                // look for smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }

    public static int[] getFloorAndCeil(int[] arr, int n, int x) {
        int f = findFloor(arr, n, x);
        int c = findCeil(arr, n, x);
        return new int[] { f, c };
    }

    public static int findKthMissingNumber(int arr[], int k) {
        int st = 0, ed = arr.length - 1;
        while (st <= ed) {
            int mid = (st + ed) / 2;
            int miss = arr[mid] - (mid + 1);
            if (miss < k) {
                st = mid + 1;
            } else {
                ed = mid - 1;
            }
        }
        return st + k;
    }

    public static int sumDiv(int arr[], int div) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += Math.ceil(((double) arr[i]) / (double) div);
        }
        return sum;
    }

    public static int smallestDivisor(int[] nums, int threshold) {
        int ans = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int low = 0, high = max;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (sumDiv(nums, mid) <= threshold) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int aggresiveCows(int arr[], int cows) {
        Arrays.sort(arr);// sort the array in ascending order
        int low = 0, high = arr[arr.length - 1] - arr[0];
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canWePlace(arr, mid, cows) == true) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    private static boolean canWePlace(int[] arr, int mid, int cows) {
        int cntCows = 1, last = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - last >= mid) {
                cntCows++;
                last = arr[i];
            }
            if (cntCows >= cows)
                return true;
        }
        return false;
    }

    

    public static void main(String[] args) {
        int arr[] = { 1, 2, 5, 9 };
        System.out.println(smallestDivisor(arr, 5));
    }
}