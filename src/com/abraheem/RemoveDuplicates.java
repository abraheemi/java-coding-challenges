package com.abraheem;

import java.util.HashMap;

public class RemoveDuplicates {

    public static String removeDuplicateChars(String str){
        char[] chars = str.toCharArray();
        HashMap<Character, Boolean> map = new HashMap<>();
        int len = chars.length;

        //while(i < chars.length)
        for(int i=0; i < len; ++i){
            char c = Character.toLowerCase(chars[i]);
            // Check if char exists before
            if(map.containsKey(c)){
                chars[i] = ' ';
                chars[i+1] = chars[i];
            }
            else {
                map.put(c, true);

            }
        }

        return null;
    }

}
