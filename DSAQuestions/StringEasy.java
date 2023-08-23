import java.util.Stack;

public class StringEasy {

    public static String removeOuterParentheses(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (count != 0) {
                    sb.append(c);
                }
                count++;
            } else {
                count--;
                if (count != 0) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    public static boolean isIsomorphic(String str1, String str2) {
        int map1[] = new int[256];
        int map2[] = new int[256];

        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (map1[str1.charAt(i)] != map2[str2.charAt(i)]) {
                return false;
            }
            map1[str1.charAt(i)] = i + 1;
            map2[str2.charAt(i)] = i + 1;
        }
        return true;
    }

    public static String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            if (num.charAt(i) % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }

    public static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        String rotated = s + s;
        return rotated.contains(goal);
    }

    public static String frequencySort(String s) {
        char arr[] = new char[256];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)]++;
        }
        StringBuilder sb = new StringBuilder();
        int max = -1;
        while (max != 0) {
            max = -1;
            char maxi = 0;
            for (char i = 0; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                    maxi = i;
                }
            }
            System.out.println("hee");
            for (int i = 0; i < max; i++) {
                sb.append(maxi);
            }
            arr[maxi] = 0;
        }
        return sb.toString();
    }

    public static String intToRoman(int num) {
        String s[] = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        int a[] = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            while (num >= a[i]) {
                sb.append(s[i]);
                num -= a[i];
            }

        }
        return sb.toString();
    }

    public static int romanToInt(String s) {
        int num = 0, ans = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case 'I':
                    num = 1;
                    break;
                case 'V':
                    num = 5;
                    break;
                case 'X':
                    num = 10;
                    break;
                case 'L':
                    num = 50;
                    break;
                case 'C':
                    num = 100;
                    break;
                case 'D':
                    num = 500;
                    break;
                case 'M':
                    num = 1000;
                    break;
            }
            if (4 * num < ans) {
                ans -= num;
            } else {
                ans += num;
            }
        }
        return ans;
    }

    public static String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        char str[] = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            } else if (s.charAt(i) == ')') {
                if (!st.isEmpty()) {
                    st.pop();
                } else {
                    str[i] = ' ';
                }
            }
        }
        while (!st.isEmpty()) {
            str[st.pop()] = ' ';
        }
        StringBuilder sb = new StringBuilder();
        for (char c : str) {
            if (c != ' ') {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static int characterReplacement(String s, int k) {
        char[] ch = s.toCharArray();
        int maxLength = 0; // To store the maximum length of repeating character sequence
        int start = 0; // Start of the sliding window
        int maxFrequency = 0; // To store the maximum frequency of any character in the sliding window
        int[] frequency = new int[26]; // To store the frequency of characters

        for (int end = 0; end < ch.length; end++) {
            frequency[ch[end] - 'A']++;
            maxFrequency = Math.max(maxFrequency, frequency[ch[end] - 'A']);

            // Calculate the number of characters that need replacement
            int replacements = (end - start + 1) - maxFrequency;

            // If the number of replacements needed is greater than k, shrink the window
            if (replacements > k) {
                frequency[ch[start] - 'A']--;
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static int repeatedStringMatch(String a, String b) {
        int idx = b.length() / a.length();
        StringBuilder str = new StringBuilder();
        int count = 0;
        for (int i = 0; i < idx + 2; i++) {
            if (str.toString().contains(b)) {
                return count;
            } else {
                str.append(a);
                count++;
            }
        }
        return count;
    }

    public static int maxDepth(String s) {
        int ans = 0;
        int upcount = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                upcount++;
            } else if (ch == ')') {
                upcount--;
            }
            ans = Math.max(ans, upcount);
        }
        return ans;
    }

    public static void main(String[] args) {
        // System.out.println(removeOuterParentheses("(()())()(())()"));
        // System.out.println(isIsomorphic("rabbani", "rmbbani"));
        // System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
        // System.out.println(rotateString("abcde", "cdeab"));
        // System.out.println(frequencySort("tree"));
        // System.out.println(romanToInt("XL"));
        // System.out.println(characterReplacement("AABABBA", 1));
        // System.out.println(repeatedStringMatch("a", "aa"));
        System.out.println(maxDepth("(1)+((2))+(((3)))"));
    }
}
