package com.abraheem;

public class Hourglass {

    // Complete the hourglassSum function below.
    public int largestSum(int[][] arr) {
        int offset = 2;
        int sum = 0, tmpSum = 0;
        int RSIZE = arr.length;
        int CSIZE = arr[0].length;

        int i=0, j=0;
        sum += arr[i][j]+arr[i][j+1]+arr[i][j+2];
        sum += arr[i+1][j+1];
        sum += arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
        while(i+offset < RSIZE){
            j=0;
            while(j+offset < CSIZE){
                tmpSum=0;
                tmpSum += arr[i][j]+arr[i][j+1]+arr[i][j+2];
                tmpSum += arr[i+1][j+1];
                tmpSum += arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];

                if(sum < tmpSum)
                    sum = tmpSum;
                j++;
            }
            i++;
        }
        return sum;
    }

}
