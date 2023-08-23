import java.util.Arrays;

public class Profit {
    public static int sellPrice(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int buyPrice(int[] arr) {
        Arrays.sort(arr);
        return arr[1];
    }

    public static void main(String[] args) {
        int arr[] = { 200, 50, 90, 100, 20 };
        System.out.println("profit is " + (sellPrice(arr) - buyPrice(arr)));
    }
}
