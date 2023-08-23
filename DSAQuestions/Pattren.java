// /**
//  * Pattren
//  */
// public class Pattren {

//     public static void main(String[] args) {
//         int n = 6;

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < i; j++) {
//                 System.out.print(" ");
//             }
//             for (int j = 0; j < 2 * n - (2 * i + 1); j++) {
//                 if (i == 0 || j == 0 || j == n - i + 1 || i == n-i && j == n-i) {
//                     System.out.print("*");
//                 } else {
//                     System.out.print(" ");
//                 }
//             }
//             for (int j = 0; j < i; j++) {
//                 System.out.print(" ");
//             }
//             System.out.println();
//         }
//     }
// }

// import java.util.Scanner;

// public class Pattren {
//     public static void countFrequency(int[] arr) {
//         // Write your code here.
//         int n = arr.length;
//         int[] hash = new int[16];

//         for (int i = 0; i < n; i++) {
//             hash[arr[i]]++;
//         }
//         for (int i = 0; i < n; i++) {
//             if (hash[arr[i]] != 0) {
//                 System.out.println(arr[i] + ":" + hash[arr[i]]);
//                 hash[arr[i]] = 0;
//             }
//         }
//     }

//     public static void main(String[] args) {
//         int arr[] = { 10, 5, 10, 15, 10, 5 };
//         countFrequency(arr);
//     }
// }
/**
 * Pattren
 */
// public class Pattren {

// public static void main(String[] args) {
// int arr[] = { 1,1, 2, 3, 1, 2, 7, 1,1,1,1, 3 };
// int count = 0;
// for (int i = 0; i < arr.length; i++) {
// for (int j = i + 1; j < arr.length; j++) {
// if (arr[i] == arr[j]) {
// arr[j] = -1;
// }
// }
// }
// for (int i = 0; i < arr.length; i++) {
// if (arr[i] != -1) {
// count++;
// }
// }
// int ans[] = new int[count];
// int k = 0;
// for (int i = 0; i < arr.length; i++) {
// if (arr[i] != -1) {
// ans[k++] = arr[i];
// }
// }
// for (int i = 0; i < ans.length; i++) {
// System.out.print(ans[i] + " ");
// }
// }
// }
class Pattren {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, -1, 4, 0, 5 };
        int min = arr[0];
        int secMin = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            } else {
                if (arr[i] < secMin) {
                    secMin = arr[i];
                }   
            }
        }
        System.out.println(min);
        System.out.println(secMin);
    }
}