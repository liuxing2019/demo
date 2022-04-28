package com;

import java.util.ArrayList;
import java.util.List;

public class CryptUtil {
    private static final char[] HEX_CHAR_ARRAY = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final List HEX_CHAR_LIST = new ArrayList();

    static {
        HEX_CHAR_LIST.add(new Character('0'));
        HEX_CHAR_LIST.add(new Character('1'));
        HEX_CHAR_LIST.add(new Character('2'));
        HEX_CHAR_LIST.add(new Character('3'));
        HEX_CHAR_LIST.add(new Character('4'));
        HEX_CHAR_LIST.add(new Character('5'));
        HEX_CHAR_LIST.add(new Character('6'));
        HEX_CHAR_LIST.add(new Character('7'));
        HEX_CHAR_LIST.add(new Character('8'));
        HEX_CHAR_LIST.add(new Character('9'));
        HEX_CHAR_LIST.add(new Character('A'));
        HEX_CHAR_LIST.add(new Character('B'));
        HEX_CHAR_LIST.add(new Character('C'));
        HEX_CHAR_LIST.add(new Character('D'));
        HEX_CHAR_LIST.add(new Character('E'));
        HEX_CHAR_LIST.add(new Character('F'));
    }

    public CryptUtil() {
    }

    public static String DBPasswordDecrypt(String s) {
        String sDest = new String(toByteArray(s));
        return StringDecrypt(sDest);
    }
    public static String DBPasswordEncrypt(String s) {
        byte b = hex2byte(s);
        return toHexString(b);
    }

    /*private static String StringDecrypt(String s) {
        char[] ac = new char[s.length()];
        s.getChars(0, s.length(), ac, 0);
        char c = 0;

        for(int i = 0; i < ac.length; ++i) {
            int j = 28 ^ c;
            ac[i] -= (char)(1 ^ c++);
        }

        return new String(ac);
    }*/

    private String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";

        for(int n = 0; n < b.length; ++n) {
            stmp = Integer.toHexString(b[n] & 255);
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }

            if (n < b.length - 1) {
                hs = hs + "_";
            }
        }

        return hs.toUpperCase();
    }

    private static String toHexString(byte[] block) {
        StringBuffer buf = new StringBuffer();
        int len = block.length;

        for(int i = 0; i < len; ++i) {
            byte2hex(block[i], buf);
            if (i < len - 1) {
                buf.append("_");
            }
        }

        return buf.toString();
    }

    /*private static byte[] toByteArray(String hex) {
        int len = (hex.length() + 1) / 3;
        byte[] rtn = new byte[len];

        for(int i = 0; i < len; ++i) {
            rtn[i] = hex2byte(hex.substring(i * 3, i * 3 + 2));
        }

        return rtn;
    }*/

    private static void byte2hex(byte b, StringBuffer buf) {
        int high = (b & 240) >> 4;
        int low = b & 15;
        buf.append(HEX_CHAR_ARRAY[high]);
        buf.append(HEX_CHAR_ARRAY[low]);
    }

    private static byte hex2byte(String s) {
        int high = HEX_CHAR_LIST.indexOf(new Character(s.charAt(0))) << 4;
        int low = HEX_CHAR_LIST.indexOf(new Character(s.charAt(1)));
        return (byte)(high + low);
    }
}
