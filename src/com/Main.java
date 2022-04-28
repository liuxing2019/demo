package com;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String a = StringDecrypt("58_73_26_78_79_44_6B_51_78_74_66_72_54_7C_77_46");
        System.out.println(a);
    }
    private static String StringDecrypt(String s){
        char[] ac = new char[s.length()];
        s.getChars(0,s.length(),ac,0);
        char c = 0;

        for(int i = 0; i< ac.length; ++i){
            int j = 28 ^ c;
            ac[i] -= (char)(1^ c++);
        }
        return new String(ac);
    }
}