package com.abraheem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Boggle {
    private final char[][] boggle;
    private final int rows;
    private final int cols;
    private final List<String> dictionary;

    public Boggle(char[][] boggle, String[] dictionaryArray){
        this.boggle = boggle;
        this.rows = this.boggle.length;
        this.cols = this.boggle[0].length;
        this.dictionary = Arrays.asList(dictionaryArray);
    }

    public void solve(){
        boolean[][] visited = new boolean[rows][cols];
        StringBuffer buff = new StringBuffer();
        Set<String> words = new HashSet<String>();
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                dfs(visited, i, j, buff, words);
            }
        }
    }

    private void dfs(boolean[][] visited, int cr, int cc, StringBuffer buff, Set<String> words){
        visited[cr][cc] = true;
        buff.append(boggle[cr][cc]);
        if(dictionary.contains(buff.toString())){
            System.out.println(buff.toString());
            words.add(buff.toString());
        }

        // Traverse the 8 adjacent cells
        for(int i = cr-1; i <= cr+1; i++){
            for(int j = cc-1; j <= cc+1; j++){
                if(i>=0 && j>=0 && i<rows && j<cols && !visited[i][j])
                    dfs(visited, i, j, buff, words);
            }
        }

        buff.deleteCharAt(buff.length()-1);
        visited[cr][cc] = false;
    }
}
