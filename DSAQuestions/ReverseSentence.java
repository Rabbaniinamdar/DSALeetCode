public class ReverseSentence {
    public static String reverseSentenceString(String sent) {
        String removeextraspace = sent.replaceAll("\\s+", " ").trim();
        String word[] = removeextraspace.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = word.length - 1; i >= 0; --i) {
            sb.append(reverseString(word[i]));
            if (i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static String reverseString(String str) {
        String removeextraspace = str.replaceAll("\\s+", " ").trim();
        char charstr[] = removeextraspace.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = charstr.length - 1; i >= 0; --i) {
            sb.append(charstr[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseSentenceString("  rabbani    inamdar warawtt"));
    }
}
