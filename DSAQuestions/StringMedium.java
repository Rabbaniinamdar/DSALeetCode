import java.util.ArrayList;
import java.util.List;

public class StringMedium {
    public static String zigZag(String str, int numRow) {
        if (numRow == 1) {
            return str;
        }
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRow; i++) {
            list.add(new StringBuilder());
        }
        int row = 0;
        boolean direction = true;
        int i = 0;
        while (true) {
            if (direction) {
                while (row < numRow && i < str.length()) {
                    list.get(row++).append(str.charAt(i++));
                }
                row = numRow - 2;
            } else {
                while (row >= 0 && i < str.length()) {
                    list.get(row--).append(str.charAt(i++));
                }
                row = 1;
            }
            if (i >= str.length()) {
                break;
            }
            direction = !direction;
        }
        StringBuilder ans = new StringBuilder();
        for (StringBuilder sb : list) {
            ans.append(sb);
        }
        return ans.toString();
    }

    public static int countSubStrings(String str, int k) {
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            char count[] = new char[26];
            int distinctCount = 0;
            for (int j = i; j < str.length(); j++) {
                int idx = str.charAt(j) - 'a';
                if (count[idx] == 0) {
                    distinctCount++;
                }
                count[idx]++;
                if (distinctCount == k) {
                    result++;
                } else if (distinctCount > k) {
                    break;
                }
            }
        }
        return result;
    }

    public static String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (i >= 0 || j >= 0 || carry == 1) {
            if (i >= 0) {
                carry += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                carry += b.charAt(j--) - '0';
            }
            sb.append(carry % 2);
            carry /= 2;
        }
        return sb.reverse().toString();
    }

    public static int beautyString(String str) {
        int ans = 0;
        int n = str.length();
        for (int i = 0; i < n; i++) {
            int count[] = new int[26];
            for (int j = i; j < n; j++) {
                count[str.charAt(j) - 'a']++;
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                for (int k = 0; k < count.length; k++) {
                    max = Math.max(max, count[k]);
                    if (count[k] != 0) {
                        min = Math.min(min, count[k]);
                    }
                }
                ans += max - min;
            }
        }
        return ans;
    }

    public static String frequencySort(String str) {
        char arr[] = new char[256];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i)]++;
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
            for (int i = 0; i < max; i++) {
                sb.append(maxi);
            }
            arr[maxi] = 0;
        }
        return sb.toString();
    }

    public static String reArrangeString(String str) {
        int hash[] = new int[26];
        int max_num = Integer.MIN_VALUE;
        char max_char = 'a';
        for (int i = 0; i < str.length(); i++) {
            hash[str.charAt(i) - 'a']++;
        }
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > max_num) {
                max_num = hash[i];
                max_char = (char) (i + 'a');
            }
        }
        int idx = 0;
        char result[] = new char[str.length()];
        while (max_num > 0 && idx < str.length()) {
            result[idx] = max_char;
            max_num--;
            idx += 2;
        }
        hash[max_char - 'a'] = 0;
        if (max_num != 0) {
            return "not possible";
        }
        for (int i = 0; i < hash.length; i++) {
            while (hash[i] > 0) {
                if (idx >= result.length) {
                    idx = 1;
                }
                result[idx] = (char) (i + 'a');
                hash[i]--;
                idx += 2;
            }
        }
        return new String(result);
    }

    public static int characterReplacement(String s, int k) {
        int start = 0;
        int maxCount = 0;
        int maxLength = 0;
        char count[] = new char[26];

        for (int end = 0; end < s.length(); end++) {
            count[s.charAt(end) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(end) - 'A']);

            int rep = (end - start + 1) - maxCount;
            if (rep > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, (end - start + 1));
        }
        return maxLength;
    }

    public static void main(String[] args) {
        // System.out.println(zigZag("ABCDEF", 3));
        // System.out.println(countSubStrings("abc", 2));
        // System.out.println(addBinary("1010", "1010"));
        // System.out.println(reArrangeString("aabcd"));
        // System.out.println(beautyString("aabcb"));
        // System.out.println(characterReplacement("AABABBA",1));
    }
}
