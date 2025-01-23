package SlidingWindow;

import java.util.HashMap;

public class SlidingWindowString {
    public static int longestUniqueSubstring(String str) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        int left = 0, maxLength = 0;
        
        for (int right = 0; right < str.length(); right++) {
            // Expand the window by including the right character
            char rightChar = str.charAt(right);
            if (charMap.containsKey(rightChar)) {
                // Slide the left pointer to the right of the last occurrence of the repeating character
                left = Math.max(left, charMap.get(rightChar) + 1);
            }
            
            // Update the last seen index of the character
            charMap.put(rightChar, right);
            
            // Calculate the max length of substring
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }

    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println("Longest substring with distinct characters: " + longestUniqueSubstring(str));
    }
}
