package io.github.facecavity.util;

public class ChatUtils {
    public static String noTongueSend(String original) {
        String unableCharacters = "tdngkqjc";
        char[] charList = original.toCharArray();
        char[] charListLower = original.toLowerCase().toCharArray();
        for (int i = 0; i < charListLower.length; i++) {
            char c = charListLower[i];
            String s = String.valueOf(c);
            if (unableCharacters.contains(s)) {
                charList[i] = '-';
            } else if (c == 'l') {
                charList[i] = charList[i] == 'l' ? 'w' : 'W';
            }
        }
        StringBuilder b = new StringBuilder();
        for (char c : charList) {
            b.append(c);
        }
        original = b.toString();
        //original = original.replaceAll("th", "--");
        return original;
    }
}
