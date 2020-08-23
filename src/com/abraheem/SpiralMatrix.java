package com.abraheem;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix){
        List<Integer> printArray = new ArrayList<Integer>();
        int r = 0, c = 0; // Current row and col
        int nr = 0, nc = 0; // Next row and col
        int directionIndex = 0;
        int[] rDirection = {0, 1, 0, -1};
        int[] cDirection = {1, 0, -1, 0};

        if(matrix.length == 0)
            return printArray;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int numOfCells = rows*cols;
        boolean[][] visited = new boolean[rows][cols];

        for(int i=0; i<numOfCells; i++){
            printArray.add(matrix[r][c]);
            visited[r][c] = true;
            nr = r + rDirection[directionIndex];
            nc = c + cDirection[directionIndex];
            if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && !visited[nr][nc]){
                r = nr;
                c = nc;
            }
            else{
                directionIndex = (directionIndex + 1) % 4;
                r = r + rDirection[directionIndex];
                c = c + cDirection[directionIndex];
            }
        }
        return printArray;
    }
}
