package util;

public class StringUtils {
    public static String leftPad(String str, int len) {
        StringBuilder sb = new StringBuilder(str);

        while (sb.length() < len) {
            sb.insert(0,'0');
        }

        return sb.toString();
    }
}
