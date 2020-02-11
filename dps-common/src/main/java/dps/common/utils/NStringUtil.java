package dps.common.utils;

import java.util.UUID;


public class NStringUtil {

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static String trim(String str) {
        return str == null ? null : str.trim();
    }

    public static String trimToNull(String str) {
        String ts = trim(str);
        return isEmpty(ts) ? null : ts;
    }

    public static String trimToEmpty(String str) {
        return str == null ? "" : str.trim();
    }

    public static boolean equals(String str1, String str2) {
        return str1 == null ? str2 == null : str1.equals(str2);
    }

    public static boolean equalsIgnoreCase(String str1, String str2) {
        return str1 == null ? str2 == null : str1.equalsIgnoreCase(str2);
    }

    public static Integer stringToInt(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        if (str.matches("\\d+")) {
            return Integer.valueOf(str);
        }
        return null;
    }

    public static Long stringToLong(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        if (str.matches("\\d+")) {
            return Long.valueOf(str);
        }
        return null;
    }

    public static String longToString(Long l) {
        if (l == null) {
            return "";
        }
        return String.valueOf(l);
    }

    public static String intToString(Integer l) {
        if (l == null) {
            return "";
        }
        return String.valueOf(l);
    }

    public static String getUUID() {
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replaceAll("-", "");
        return uuid;
    }

    public static String getNormalUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }

    public static String nullToString(String value, String defaultVal) {
        if (value == null || value.length() == 0) {
            return defaultVal;
        }
        return value;
    }

    public static void main(String[] ags) {
//        String uuid = UUID.randomUUID().toString();
//        System.out.println(uuid);
//
//        String str = "test-定制芒果酱风味新地(鸳��奶茶口味)";
//        try {
//            System.out.println(new String(str.getBytes("ISO-8859-1"), "utf-8"));
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//        String p = "a哈";
//        int len = getUTF8BytesLength(p);
//        System.out.println("【"+nullToString(null," ")+"】");
        String ip = "aaaaaaaaaaaaaaaaaaab1234";
        ip = ip.substring(0, 20);
        System.out.println(ip);

        String str = "";

        System.out.println(getUUID());
    }
}
