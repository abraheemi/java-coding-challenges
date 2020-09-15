package com.abraheem;

public abstract class MergeSort {

    private static void merge(int[] arr, int l, int m, int r){
        // The sizes of the two sub-arrays
        int lenL = m - l + 1;
        int lenR = r - m;

        int[] left = new int[lenL];
        int[] right = new int[lenR];

        // Copy the data to the new temp arrays
        for(int i=0; i<lenL; ++i)
            left[i] = arr[l + i];
        for(int i=0; i<lenR; ++i)
            right[i] = arr[m + 1 + i];

        // Now merge the two temp arrays
        int i = 0;
        int j = 0;
        int k = l; // Index of merged sub-array

        while (i < lenL && j < lenR){
            if(left[i] <= right[j]){
                arr[k] = left[i];
                i++;
            }
            else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        // Copy the remaining elements of left[] if any
        while (i < lenL){
            arr[k] = left[i];
            i++;
            k++;
        }
        // Copy the remaining elements of right[] if any
        while (j < lenR){
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    private static void sort(int[] arr, int l, int r){
        if(l < r){
            // Find the middle point of current array/sub-array
            int m = (l+r)/2;

            // Sort left half
            sort(arr, l, m);
            // Sort right half
            sort(arr, m+1, r);

            // Merge the two sorted halves
            merge(arr, l, m, r);
        }
    }

    public static void sort(int[] arr){
        sort(arr, 0, arr.length - 1);
        System.out.println("Merge Sort:");
    }
}
