package com;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("结果是" + Solution.strStr("mississippi", "issipi"));
    }
}

class Solution {
    public static int strStr(String haystack, String needle) {
        int flag = 0;
        if (needle.equals("")) {
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++) {
            if(haystack.charAt(i) == needle.charAt(0)){
                if((i+needle.length())>haystack.length()){
                    return -1;
                }
                else if(haystack.substring(i,i+needle.length()).equals(needle)){
                    return i;
                }
                else{
                    continue;
                }
            }
            else{
                continue;
            }
        }
        return -1;
    }
}
