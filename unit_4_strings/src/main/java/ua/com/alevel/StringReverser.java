package ua.com.alevel;

public class StringReverser {

    public static String reverse(String src, boolean reverseAll) {
        if(reverseAll) {
            String reversedScr = simpleReverse(src);
            return reversedScr;
        } else {
            String[] words=src.trim().split("\\s");
            String reversedSrc = simpleReverse(words[0]);
            for (int i = 1; i < words.length; i++) {
                reversedSrc += " " + simpleReverse(words[i]);
            }
            reversedSrc = src.replace(src.trim(),reversedSrc);
            return reversedSrc;
        }
    }

    public static String reverse(String src, String dest) {
        String reversedDest = simpleReverse(dest);
        String reversedSrc = src.replaceAll(dest, reversedDest);
        return reversedSrc;
    }

    public static String reverse(String src, int firstIndex, int lastIndex) {
        String userSubStr = src.substring(firstIndex, lastIndex);
        String[] words=userSubStr.trim().split("\\s");
        String reversedSubStr = simpleReverse(words[0]);

        for (int i = 1; i < words.length; i++) {
            reversedSubStr += " " + simpleReverse(words[i]);
        }
        String reversedSrc = src.replace(userSubStr.trim(), reversedSubStr);

        return reversedSrc;
    }

    private static String simpleReverse(String src) {
        char[] srcArray = new char[src.length()];

        for (int i = 0; i < src.length(); i++) {
            srcArray[src.length() - 1 - i] = src.charAt(i);
        }
        return new String(srcArray);
    }
}
