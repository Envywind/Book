package book.core.utils;

import java.security.MessageDigest;

public class MD5Encryptor {

    public static String encrypt(String str) {
        if ((str == null) || (str.trim().length() == 0))
            return "";
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(str.getBytes());
            byte[] buf = digest.digest();
            return bytesToString(buf);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    private static String bytesToString(byte[] md) {
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
        int j = md.length;
        char[] str = new char[j * 2];
        int k = 0;
        for (int i = 0; i < j; i++) {
            byte byte0 = md[i];
            str[(k++)] = hexDigits[(byte0 >>> 4 & 0xF)];
            str[(k++)] = hexDigits[(byte0 & 0xF)];
        }
        return new String(str);
    }

    public static void main(String[] args) {
        String pwd = "123";
        System.out.println(encrypt(pwd));
    }

}
