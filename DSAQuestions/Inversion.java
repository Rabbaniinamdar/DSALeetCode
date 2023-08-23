public class Inversion {
    public static int NumberOfInversion(int arr[]) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 6, 4, 5 };
        System.out.println(NumberOfInversion(arr));
    }
}
