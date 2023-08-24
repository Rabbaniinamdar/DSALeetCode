class ProductArray {
    public static int[] ProductOfArray(int arr[]) {

        for (int i = arr.length -2; i >= 0; i--) {
            // for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i + 1] * arr[i];
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4 };
        int ans[] = ProductOfArray(arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
