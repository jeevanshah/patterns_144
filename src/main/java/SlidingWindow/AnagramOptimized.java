package SlidingWindow;

import java.util.ArrayList;
import java.util.List;

class AnagramOptimized {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // Count the frequency of each character in p
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        int pLen = p.length();
        int sLen = s.length();

        // Use a sliding window to count characters in s
        for (int i = 0; i < sLen; i++) {
            sCount[s.charAt(i) - 'a']++; // Add current character to window

            // Remove the character that is out of the window
            if (i >= pLen) {
                sCount[s.charAt(i - pLen) - 'a']--;
            }

            // Compare the frequency arrays
            if (areCountsEqual(pCount, sCount)) {
                result.add(i - pLen + 1);
            }
        }

        return result;
    }

    // Helper function to compare two frequency arrays
    private static boolean areCountsEqual(int[] pCount, int[] sCount) {
        for (int i = 0; i < 26; i++) {
            if (pCount[i] != sCount[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("findAnagrams(\"cbaebabacd\", \"abc\") = " + findAnagrams("fe", "ja"));
        System.out.println("findAnagrams(\"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\", \"aaaaa\") = " + findAnagrams("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaa"));
    }
}
