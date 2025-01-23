package neet150;

import java.util.*;

public class Neet4GroupAnagram {
//    Input: strs = ["act","pots","tops","cat","stop","hat"]
//
//    Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]
        public List<List<String>> groupAnagrams(String[] strs)
        {
            Map<String, List<String>> integerListMap= new HashMap<>();
            for (int i=0; i<strs.length;i++){
                int[] count = new int[26];
                for (int j = 0; j < strs[i].length();j++){
                    count[strs[i].charAt(j) - 'a']++;
                }
                String valueKey = Arrays.toString(count);
                if (integerListMap.containsKey(valueKey)){
                    integerListMap.get(valueKey).add(strs[i]);
                } else {
                    integerListMap.put(valueKey, new ArrayList<>(Arrays.asList(strs[i])));
                }
            }
        return integerListMap.values().stream().toList();
        }
        public boolean isAnagram(String a, String b){
            if (a.length()!=b.length()){
                return false;
            }
            System.out.println("a.charAt(2) = " + a.charAt(2));
            int[] counter = new int[26];
            for (int j=0; j < a.length(); j++){
                counter[a.charAt(j) - 'a']++;
                counter[b.charAt(j) - 'a']--;
            }
            for (int c: counter){
                if (c != 0){
                    return false;
                }
            }
            return true;
        }

        public static void main(String[] args) {
        String[] input = new String[]{"act","pots","tops","cat","stop","hat"};
        Neet4GroupAnagram neet4GroupAnagram = new Neet4GroupAnagram();
            System.out.println("neet4GroupAnagram = " + neet4GroupAnagram.groupAnagrams(input));
    }

}
