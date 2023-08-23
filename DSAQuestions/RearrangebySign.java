public class RearrangebySign {
    public static void rearrangebySign(int arr[]) {
        int pos[] = new int[arr.length];
        int neg[] = new int[arr.length];
        int posCount = 0;
        int negCount = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                pos[posCount++] = arr[i];
            } else {
                neg[negCount++] = arr[i];
            }
        }
        for (int i = 0; i < arr.length / 2; i++) {
            arr[2 * i] = pos[i];
            arr[2 * i + 1] = neg[i];
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, -4, -5 };
        rearrangebySign(arr);
    }
}
