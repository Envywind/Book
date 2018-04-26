package book.core.utils;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Pattern;

public class StringUtil {

    public static final int GEN_UPPERCASE = 0;
    public static final int GEN_LOWERCASE = 1;
    public static final int GEN_CHINESE = 2;
    public static final int GEN_NUMBER = 3;

    public static boolean isNull(String str) {
        if (str == null) {
            return true;
        }
        return str.trim().length() == 0;
    }

    public static String valueOf(Object obj) {
        if (obj == null) {
            return "";
        }
        if ((obj instanceof String))
            return (String) obj;
        if ((obj instanceof Object[]))
            return join((Object[]) obj, ",");
        if ((obj instanceof String[]))
            return join((String[]) obj, ",");
        if ((obj instanceof double[]))
            return join((double[]) obj, ",");
        if ((obj instanceof long[]))
            return join((long[]) obj, ",");
        if ((obj instanceof float[]))
            return join((float[]) obj, ",");
        if ((obj instanceof int[]))
            return join((int[]) obj, ",");
        if ((obj instanceof short[]))
            return join((short[]) obj, ",");
        if ((obj instanceof byte[])) {
            return join((byte[]) obj, ",");
        }
        return String.valueOf(obj);
    }

    public static Integer getInt(String str) {
        try {
            return Integer.valueOf(Integer.parseInt(str.trim()));
        } catch (Exception localException) {
        }
        return null;
    }

    public static Integer[] getIntArray(String str, String spliter) {
        if (isNull(str)) {
            return new Integer[0];
        }
        String[] strs = str.split(spliter);
        List<Integer> tmp = new ArrayList<Integer>();
        for (int i = 0; i < strs.length; i++) {
            Integer val = getInt(strs[i]);
            if (val != null)
                tmp.add(val);
        }
        return tmp.toArray(new Integer[tmp.size()]);
    }

    public static Long getLong(String str) {
        try {
            return Long.valueOf(Long.parseLong(str.trim()));
        } catch (Exception localException) {
        }
        return null;
    }

    public static Long[] getLongArray(String str, String spliter) {
        if (isNull(str)) {
            return new Long[0];
        }
        String[] strs = str.split(spliter);
        List<Long> tmp = new ArrayList<Long>();
        for (int i = 0; i < strs.length; i++) {
            Long val = getLong(strs[i]);
            if (val != null)
                tmp.add(val);
        }
        return tmp.toArray(new Long[tmp.size()]);
    }

    public static Boolean getBoolean(String str) {
        try {
            return Boolean.valueOf(Boolean.parseBoolean(str.trim()));
        } catch (Exception localException) {
        }
        return null;
    }

    public static Boolean[] getBooleanArray(String str, String spliter) {
        if (isNull(str)) {
            return new Boolean[0];
        }
        String[] strs = str.split(spliter);
        List<Boolean> tmp = new ArrayList<Boolean>();
        for (int i = 0; i < strs.length; i++) {
            Boolean val = getBoolean(strs[i]);
            if (val != null)
                tmp.add(val);
        }
        return tmp.toArray(new Boolean[tmp.size()]);
    }

    public static Float getFloat(String str) {
        try {
            return Float.valueOf(Float.parseFloat(str.trim()));
        } catch (Exception localException) {
        }
        return null;
    }

    public static Float[] getFloatArray(String str, String spliter) {
        if (isNull(str)) {
            return new Float[0];
        }
        String[] strs = str.split(spliter);
        List<Float> tmp = new ArrayList<Float>();
        for (int i = 0; i < strs.length; i++) {
            Float val = getFloat(strs[i]);
            if (val != null)
                tmp.add(val);
        }
        return tmp.toArray(new Float[tmp.size()]);
    }

    public static Double getDouble(String str) {
        try {
            return Double.valueOf(Double.parseDouble(str.trim()));
        } catch (Exception localException) {
        }
        return null;
    }

    public static Double[] getDouble(String str, String spliter) {
        if (isNull(str)) {
            return new Double[0];
        }
        String[] strs = str.split(spliter);
        List<Double> tmp = new ArrayList<Double>();
        for (int i = 0; i < strs.length; i++) {
            Double val = getDouble(strs[i]);
            if (val != null)
                tmp.add(val);
        }
        return tmp.toArray(new Double[tmp.size()]);
    }

    public static Date getDate(String str, String format) {
        try {
            return new SimpleDateFormat(format).parse(str.trim());
        } catch (Exception localException) {
        }
        return null;
    }

    public static String toUtf8String(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= 0) && (c <= 'ÿ')) {
                sb.append(c);
            } else {
                byte[] b;
                try {
                    b = Character.toString(c).getBytes("utf-8");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    b = new byte[0];
                }
                for (int j = 0; j < b.length; j++) {
                    int k = b[j];
                    if (k < 0) {
                        k += 256;
                    }
                    sb.append("%" + Integer.toHexString(k).toUpperCase());
                }
            }
        }

        return sb.toString();
    }

    public static String changeEncoding(String oldString, String oldCharset,
                                        String newCharset) {
        if (isNull(oldString)) {
            return oldString;
        }

        if (isNull(newCharset)) {
            return oldString;
        }
        if (oldCharset == null) {
            oldCharset = "";
        }
        if (newCharset.trim().equalsIgnoreCase(oldCharset.trim())) {
            return oldString;
        }
        try {
            if (isNull(oldCharset)) {
                return new String(oldString.getBytes(), newCharset);
            }
            return new String(oldString.getBytes(oldCharset), newCharset);
        } catch (UnsupportedEncodingException uee) {
            uee.printStackTrace();
        }
        return oldString;
    }

    public static boolean matchPattern(String str, String[] patterns) {
        if ((str == null) || (patterns == null))
            return false;
        for (String p : patterns) {
            if (matchPattern(str, p))
                return true;
        }
        return false;
    }

    public static boolean matchPattern(String str, String pattern) {
        return pattern == null ? false : Pattern.matches(pattern, str);
    }

    public static String toUnicode(String strText) throws Exception {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < strText.length(); i++) {
            char c = strText.charAt(i);
            int intAsc = c;
            if (intAsc > 128) {
                sb.append("\\u" + Integer.toHexString(intAsc));
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static String random(int length, int[] types) {
        return generateRandomString(types, length);
    }

    public static String generateRandomString(int[] stringTypes, int length) {
        int[] startChars = new int[100];
        int[] endChars = new int[100];
        int actLength = 0;

        for (int i = 0; i < stringTypes.length; i++) {
            if (actLength > startChars.length)
                break;
            if (stringTypes[i] == 2) {
                startChars[actLength] = 19968;
                endChars[actLength] = 40880;

                actLength++;
            } else if (stringTypes[i] == 1) {
                startChars[actLength] = 97;
                endChars[actLength] = 122;
                actLength++;
            } else if (stringTypes[i] == 0) {
                startChars[actLength] = 65;
                endChars[actLength] = 90;
                actLength++;
            } else if (stringTypes[i] == 3) {
                startChars[actLength] = 48;
                endChars[actLength] = 57;
                actLength++;
            }
        }
        Random random = new Random();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < length; i++) {
            int idx = Math.abs(random.nextInt()) % actLength;
            int startChar = startChars[idx];
            int endChar = endChars[idx];
            char randChar = (char) (Math.abs(random.nextInt())
                    % (endChar - startChar) + startChar);

            sb.append(randChar);
        }

        return sb.toString();
    }

    public static boolean isEquals(String str1, String str2, boolean trim) {
        str1 = trim(str1);
        str2 = trim(str2);

        if (str1 == null)
            return (str2 == null) || ((str2.length() == 0) && (trim));
        if (str1.length() == 0) {
            if (trim) {
                return isNull(str2);
            }
            return (str2 != null) && (str2.length() == 0);
        }
        if (trim) {
            return str1.equals(str2);
        }
        return str1.equals(str2);
    }

    public static String trim(String str) {
        if (str == null) {
            return str;
        }
        return str.trim();
    }

    public static String toTimeStr(long time, boolean showZero) {
        long seconds = time / 1000L;
        int minutes = 0;
        int hours = 0;
        int days = 0;

        days = (int) seconds / 86400;

        seconds %= 86400L;

        hours = (int) seconds / 3600;
        seconds %= 3600L;
        minutes = (int) seconds / 60;
        seconds %= 60L;
        String str = "";
        if (days > 0)
            str = days
                    + "天"
                    + ((hours == 0) && (!showZero) ? "" : new StringBuilder(
                    String.valueOf(hours)).append("小时").toString())
                    + ((minutes == 0) && (!showZero) ? "" : new StringBuilder(
                    String.valueOf(minutes)).append("分").toString())
                    + ((seconds == 0L) && (!showZero) ? "" : new StringBuilder(
                    String.valueOf(seconds)).append("秒").toString());
        else if (hours > 0)
            str = hours
                    + "小时"
                    + ((minutes == 0) && (!showZero) ? "" : new StringBuilder(
                    String.valueOf(minutes)).append("分").toString())
                    + ((seconds == 0L) && (!showZero) ? "" : new StringBuilder(
                    String.valueOf(seconds)).append("秒").toString());
        else if (minutes > 0)
            str = minutes
                    + "分"
                    + ((seconds == 0L) && (!showZero) ? "" : new StringBuilder(
                    String.valueOf(seconds)).append("秒").toString());
        else {
            str = seconds + "秒";
        }
        return str;
    }

    public static String generateGUID() {
        UUID uid = UUID.randomUUID();

        return uid.toString().replaceAll("-", "").toUpperCase();
    }

    public static String join(byte[] arr, String spliter) {
        StringBuilder sb = new StringBuilder();
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                if (i > 0)
                    sb.append(spliter);
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }

    public static String join(short[] arr, String spliter) {
        StringBuilder sb = new StringBuilder();
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                if (i > 0)
                    sb.append(spliter);
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }

    public static String join(double[] arr, String spliter) {
        StringBuilder sb = new StringBuilder();
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                if (i > 0)
                    sb.append(spliter);
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }

    public static String join(float[] arr, String spliter) {
        StringBuilder sb = new StringBuilder();
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                if (i > 0)
                    sb.append(spliter);
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }

    public static String join(int[] arr, String spliter) {
        StringBuilder sb = new StringBuilder();
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                if (i > 0)
                    sb.append(spliter);
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }

    public static String join(long[] arr, String spliter) {
        StringBuilder sb = new StringBuilder();
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                if (i > 0)
                    sb.append(spliter);
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }

    public static String join(String[] arr, String spliter) {
        StringBuilder sb = new StringBuilder();
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                if (i > 0)
                    sb.append(spliter);
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }

    public static String join(Object[] arr, String spliter) {
        StringBuilder sb = new StringBuilder();
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                if (i > 0)
                    sb.append(spliter);
                sb.append(valueOf(arr[i]));
            }
        }
        return sb.toString();
    }

    public static int length(String str) {
        if (str == null)
            return 0;
        int length = 0;
        char[] chars = str.toCharArray();

        for (char c : chars) {
            if (c >= '')
                length += 2;
            else {
                length++;
            }

        }

        return length;
    }

    public static String escape(String src, String pre) {
        if (src == null) {
            return null;
        }

        StringBuffer tmp = new StringBuffer();
        tmp.ensureCapacity(src.length() * 6);
        for (int i = 0; i < src.length(); i++) {
            char j = src.charAt(i);
            if ((Character.isDigit(j)) || (Character.isLowerCase(j))
                    || (Character.isUpperCase(j))) {
                tmp.append(j);
            } else if (j < 'Ā') {
                tmp.append(pre);
                if (j < '\020')
                    tmp.append("0");
                tmp.append(Integer.toString(j, 16));
            } else {
                tmp.append(pre + "u");
                tmp.append(Integer.toString(j, 16));
            }
        }
        return tmp.toString();
    }

    public static String escape(String src) {
        return escape(src, "%");
    }

    public static String unescape(String src) {
        return unescape(src, "%");
    }

    public static String unescape(String src, String pre) {
        if (src == null)
            return src;
        StringBuffer tmp = new StringBuffer();
        tmp.ensureCapacity(src.length());
        int lastPos = 0;
        int pos = 0;

        while (lastPos < src.length()) {
            pos = src.indexOf(pre, lastPos);
            if (pos == lastPos) {
                if (src.charAt(pos + 1) == 'u') {
                    char ch = (char) Integer.parseInt(
                            src.substring(pos + 2, pos + 6), 16);
                    tmp.append(ch);
                    lastPos = pos + 6;
                } else {
                    char ch = (char) Integer.parseInt(
                            src.substring(pos + 1, pos + 3), 16);
                    tmp.append(ch);
                    lastPos = pos + 3;
                }
            } else if (pos == -1) {
                tmp.append(src.substring(lastPos));
                lastPos = src.length();
            } else {
                tmp.append(src.substring(lastPos, pos));
                lastPos = pos;
            }
        }

        return tmp.toString();
    }

    public static void main(String[] args) throws Exception {
        String[] strs = {"a", "b"};
        System.out.println(valueOf(strs));

        String str = "2015%2d02%2d10%2010%3a06%3a58";

        System.out.println(StringUtil.changeEncoding(str, "gbk", "UTF-8"));

    }

}
