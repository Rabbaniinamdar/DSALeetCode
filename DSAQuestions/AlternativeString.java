public class AlternativeString {
    public static String alternativeOfString(String str1, String str2) {
        String str = "";
        int maxLen = Math.max(str1.length(), str2.length());
        for (int i = 0; i < maxLen; i++) {
            if (i < str1.length()) {
                str += str1.charAt(i);
            }
            if (i < str2.length()) {
                str += str2.charAt(i);
            }
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(alternativeOfString("rabbani", "inamdar"));
    }
}
