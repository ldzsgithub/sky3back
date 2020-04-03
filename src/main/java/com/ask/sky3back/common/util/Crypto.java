package com.ask.sky3back.common.util;

import java.security.MessageDigest;

public class Crypto {

    public final static String getmd5(String s) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        try {
            s = s + "ask@ldz";
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final static String stringToUnicode(String s) {
        s = (s == null ? "" : s);
        String tmp;
        StringBuffer sb = new StringBuffer(1000);
        char c;
        int i, j;
        sb.setLength(0);
        for (i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            sb.append("\\u");
            j = (c >>> 8); //取出高8位 
            tmp = Integer.toHexString(j);
            if (tmp.length() == 1)
            sb.append("0");
            sb.append(tmp);
            j = (c & 0xFF); //取出低8位 
            tmp = Integer.toHexString(j);
            if (tmp.length() == 1)
            sb.append("0");
            sb.append(tmp);
        }
        return (new String(sb));
    }

    public final static String unicodeToString(String u) {
        StringBuffer string = new StringBuffer();
        String[] hex = u.split("\\\\u");
        for (int i = 1; i < hex.length; i++) {
            // 转换出每一个代码点
            int data = Integer.parseInt(hex[i], 16);
            // 追加成string
            string.append((char) data);
        }
        return string.toString();
    }

}
