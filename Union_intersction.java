// "The goal of this code is to find the union of two arrays, 
// which means creating an array that contains all unique elements from both arrays. 
// To achieve this, we're using a HashSet, a data structure that automatically maintains
//  uniqueness of elements, ensuring that each element appears only once in the resulting union."

// Algorithm Explanation:

// "We have a method union that takes two arrays, arr1 and arr2, 
// as input and returns an array containing the union of their elements. 
// Here's a step-by-step breakdown of the algorithm:

// Initialization: 
// We start by creating a HashSet<Integer> named unionSet. 
// This set will automatically keep track of unique elements from both arrays.

// Adding Elements from the First Array:

// We loop through each element in arr1.
// For each element num, we add it to the unionSet. 
// The HashSet's uniqueness property ensures that duplicates are automatically removed.
// Adding Elements from the Second Array:

// We then loop through each element in arr2.
// Again, for each element num, we add it to the unionSet. 
// If it's already in the set, it won't be duplicated due to the HashSet's behavior.

// Converting HashSet to Array:

// We create an int array named unionArray with a size equal to the size of the unionSet. 
// This will be the final union of elements.
// We loop through the elements in the unionSet.
// For each element num, we add it to the unionArray at the current index and increment the index.
// Returning the Union Array:

// After processing all unique elements from both arrays, we return the unionArray as the result."

import java.util.*;

public class Union_intersction {
    public static int[] union(int[] arr1, int[] arr2) {
        Set<Integer> unionSet = new HashSet<>();

        // Add elements from the first array to the set
        for (int num : arr1) {
            unionSet.add(num);
        }

        // Add elements from the second array to the set
        for (int num : arr2) {
            unionSet.add(num);
        }

        // Convert the set to an array
        int[] unionArray = new int[unionSet.size()];
        int index = 0;
        for (int num : unionSet) {
            unionArray[index++] = num;
        }

        return unionArray;
    }

    // Introduction:

    // "The objective of this code is to find the intersection of two arrays, which
    // means identifying elements that are common to both arrays.
    // To achieve this, we're using two HashSets: one to store unique elements from
    // the first array,
    // and another to store the elements that are common between both arrays."

    // Algorithm Explanation:

    // "We have a method named intersection that takes two arrays, arr1 and arr2,
    // as input, and returns an array containing the intersection of their elements.
    // Here's a step-by-step explanation of the algorithm:

    // Initialization: We start by creating two HashSets: set and intersect.

    // set will store unique elements from the first array.
    // intersect will store elements that are common between both arrays.
    // Adding Elements from the First Array:

    // We loop through each element in arr1.
    // For each element num, we add it to the set. The HashSet's uniqueness property
    // ensures duplicates are automatically removed.
    // Finding Intersection:

    // We then loop through each element in arr2.
    // If the set contains the current element num, it means it's a common element.
    // In such cases, we add the element num to the intersect set.
    // Converting HashSet to Array:

    // After identifying common elements, we create an int array named
    // intersectArray with a size equal to the size of the intersect set. This will
    // be the final intersection of elements.
    // We loop through the elements in the intersect set.
    // For each element num, we add it to the intersectArray at the current index
    // and increment the index.
    // Returning the Intersection Array:

    // After processing all common elements, we return the intersectArray as the
    // result."

    public static int[] intesection(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();

        // Add elements from the first array to the set
        for (int num : arr1) {
            set.add(num);
        }

        // Add elements from the second array to the interset if intersect contains set
        for (int num : arr2) {
            if (set.contains(num)) {
                intersect.add(num);
            }
        }

        // Convert the set to an array
        int[] intersectArray = new int[intersect.size()];
        int index = 0;
        for (int num : intersect) {
            intersectArray[index++] = num;
        }

        return intersectArray;
    }


    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 2, 0, 0, 0 };
        int[] arr2 = { 4, 5, 6 };

        int[] unionArray = intesection(arr1, arr2);

        System.out.println("Union of arrays: " + Arrays.toString(unionArray));
    }
}
