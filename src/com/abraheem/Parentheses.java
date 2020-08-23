package com.abraheem;

import java.util.Stack;

public class Parentheses {

    public Parentheses(){

    }

    public boolean isMatch(String str){
        Stack<Character> stack = new Stack<Character>();
        int len = str.length();

        for(int i=0; i<len; i++){
            char c = str.charAt(i);
            if(c == '(')
                stack.push(c);
            else if(c == ')'){
                if(stack.isEmpty())
                    return false;
                else
                    stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public int depth(String str){
        Stack<Character> stack = new Stack<Character>();
        int len = str.length();
        int count = 0;
        int max = 0;

        for(int i=0; i<len; i++){
            if(count > max)
                max = count;
            if(str.charAt(i) == '(')
                count++;
            else if(str.charAt(i) == ')')
                count--;
        }
        return max;
    }
}
