public class SubArray {
    public static int kedansAlgoProdu(int arr[]) {
        int product1 = arr[0];
        int product2 = arr[0];
        int prod = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int temp = Math.max(arr[i], Math.max(product1 * arr[i], product2 * arr[i]));
            product2 = Math.min(arr[i], Math.min(product1 * arr[i], product2 * arr[i]));
            product1 = temp;
            prod = Math.max(prod, product1);
        }
        return prod;
    }

    public static int kedansAlgo(int arr[]) {
        int maxsum = arr[0];
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum = Math.max(arr[i], arr[i] + sum);
            maxsum = Math.max(maxsum, sum);
        }
        return maxsum;

    }

    public static int maximumSubArrayProduct(int arr[]) {
        int maxProduct = arr[0];
        for (int i = 0; i < arr.length; i++) {
            int product = 1;
            for (int j = i; j < arr.length; j++) {
                product *= arr[j];
                maxProduct = Math.max(maxProduct, product);
            }
        }
        return maxProduct;
    }

    public static int maximumSubArraySum(int arr[]) {
        int maxSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    public static int buySell(int arr[]) {
        int maxprof = 0;
        int minprice = Integer.MAX_VALUE;
        for (int j = 0; j < arr.length; j++) {
            minprice = Math.min(minprice, arr[j]);
            maxprof = Math.max(maxprof, arr[j] - minprice);
        }
        return maxprof;
    }

    public static void main(String[] args) {
        int arr[] = { 2, -3, -2, 4};
        System.out.println(maximumSubArrayProduct(arr));
        System.out.println(kedansAlgoProdu(arr));

    }
}
