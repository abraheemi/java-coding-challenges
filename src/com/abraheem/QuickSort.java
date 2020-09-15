package com.abraheem;

public abstract class QuickSort {

    static int partition(int[] arr, int start, int end){
        int pivot = arr[end];
        int i = (start-1); // Smaller element index
        for(int j=start; j<end; ++j){
            // If current element is smaller than
            // or equal to pivot, then swap
            if(arr[j] <= pivot){
                i++;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }

        int tmp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = tmp;

        return i+1;
    }

    static void sort(int[] arr, int start, int end){
        if(start < end){
            int p = partition(arr, start, end);
            sort(arr, start, p-1);
            sort(arr, p+1, end);
        }
    }

    static void sort(int[] arr){
        sort(arr, 0, arr.length - 1);
        System.out.println("Quick Sort:");
    }
}
