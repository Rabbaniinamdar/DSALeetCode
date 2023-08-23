
// Initialize two variables: maxSum to store the maximum subarray sum found so far and sum to keep track of the current subarray sum.

// Start iterating through the array from the second element (index 1).
// For each element in the array:
// a. Compare the current element with the sum of the current element and the previous sum. Take the maximum of the two.
// b. Update the sum to be the greater value between the current element and the sum of the current element and the previous sum.
// c. Update maxSum to be the greater value between maxSum and the updated sum.

// After iterating through the entire array, maxSum will hold the maximum subarray sum.
// Return the maxSum as the result.
public class KadansAlgo {
    public static int kadansAlgorithem(int arr[]) {
        int n = arr.length;
        int maxSum = arr[0];
        int sum = arr[0];
        for (int i = 1; i < n; i++) {
            sum = Math.max(sum, sum + arr[i]);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public static int maximumProductBruteforce(int arr[]) {
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

    // 1.Initialize three variables: product1, product2, and product to keep track
    // of
    // the maximum product of subarrays. Initialize them with the first element of
    // the array.

    // 2.Iterate through the array starting from the second element.

    // 3.For each element in the array:
    // a. Calculate three values:

    // temp: The maximum value among the current element, the product of product1
    // and the current element, and the product of product2 and the current element.
    // product2: The minimum value among the current element, the product of
    // product1 and the current element, and the product of product2 and the current
    // element.
    // product1: Assign the value of temp to product1.
    // b. Compare the current product with the updated product1, and assign the
    // greater value to product.
    // 4.After iterating through the entire array, product will hold the maximum
    // product of subarrays.

    // 5.Return the value of product as the result.
    public static int maximumProductOptimal(int arr[]) {
        int product1 = arr[0];
        int product2 = arr[0];
        int product = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int temp = Math.max(arr[i], Math.max(product1 * arr[i], product2 * arr[i]));
            product2 = Math.min(arr[i], Math.min(product1 * arr[i], product2 * arr[i]));
            product1 = temp;
            product = Math.max(product, product1);
        }
        return product;
    }

    public static void main(String[] args) {
    }
}