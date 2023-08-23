import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Strings {
    public static void main(String[] args) {
        // String str[] = { "flower" };
        String str = "aabbccc";
        // System.out.println(myAtoi("345 rabbani"));
        System.out.println(compress(str.toCharArray()));
    }

    public static int compress(char[] chars) {
        StringBuilder ans = new StringBuilder();
        int count = 1;
        for (int i = 1; i <= chars.length; i++) {
            char curr = (i == chars.length ? ' ' : chars[i]);
            char prev = chars[i - 1];
            if (prev == curr) {
                count++;
            } else {
                ans.append(prev);
                if (count > 1) {
                    ans.append(count);
                }
                count = 1;
            }
        }
        return ans.length();
    }

    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if (m > n) {
            return false;
        }
        int data[] = new int[26];
        int test[] = new int[26];

        for (int i = 0; i < m; i++) {
            data[s1.charAt(i) - 'a']++;
            test[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(data, test)) {
            return true;
        }
        for (int i = m; i < n; i++) {
            test[s2.charAt(i) - 'a']++;
            test[s2.charAt(i - m) - 'a']--;
        }
        if (Arrays.equals(data, test)) {
            return true;
        }
        return false;
    }

    public static int myAtoi(String s) {
        s = s.trim();
        int sign = 1;
        int i = 0;
        int ans = 0;
        char str[] = s.toCharArray();
        if (i < str.length && str[i] == '-') {
            sign = -1;
            i++;
        } else if (i < str.length && str[i] == '+') {
            i++;
        }
        while (i < str.length && str[i] >= '0' && str[i] <= '9') {
            int digit = str[i] - '0';
            if (ans > Integer.MAX_VALUE / 10 || ans == Integer.MAX_VALUE && digit > 7) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans = ans * 10 + digit;
            i++;
        }
        return ans * sign;
    }

    public static String longestCommonPrefix(String[] str) {
        Arrays.sort(str);
        String str1 = str[0];
        String str2 = str[str.length - 1];
        int idx = 0;
        while (idx < str1.length() && idx < str2.length()) {
            if (str1.charAt(idx) == str2.charAt(idx)) {
                idx++;
            } else {
                break;
            }
        }
        return str1.substring(0, idx);
    }

    public static String longestPalindrome(String s) {
        int n = s.length();
        int start = 0, maxLength = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(s, i, j) && j - i + 1 > maxLength) {
                    start = i;
                    maxLength = j - i + 1;
                }
            }
        }

        return s.substring(start, start + maxLength);
    }

    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                max = Math.max(max, set.size());
                j++;
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }

    public static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
