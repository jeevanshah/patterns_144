package SlidingWindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Anagram {
    public static List<Integer> findAnagrams(String s, String p) {
        List<String> stringList = new LinkedList<>();
        if (s.length() < p.length()){
           return null;
        }
        int subLen = p.length();
        int stringLength =s.length();
        stringList.add(s.substring(0, subLen));
        for(int i = 1; i<=s.length()-subLen;i++){
            stringList.add(s.substring(i, i+subLen));
        }
        System.out.println("stringList = " + stringList);
        return (List<Integer>) findIndex(stringList, p);
    }

    public static Object findIndex(List<String> stringList, String p){
        boolean isAnagram = false;
        List<String> dump = new ArrayList<>();

        List<Integer> returnValue = new ArrayList<>();
        int counterIndex = 0;
        for (String s: stringList){
            dump = new ArrayList<>();
            for (int j = 0; j<s.length();j++) {
                boolean matched = false;
                for (int i = 0; i < p.length(); i++) {
                    if (!dump.contains(String.valueOf(p.charAt(i))+i) && p.charAt(i)==s.charAt(j)){
                        matched = true;
                        dump.add(String.valueOf(p.charAt(i))+i);
                        break;
                    }
                }
                if (!matched){
                    isAnagram = false;
                    break;
                } else {
                    isAnagram = true;
                }
            }
            if (isAnagram){
                System.out.println("s = " + s);
                returnValue.add(counterIndex);
            }
            counterIndex++;
        }
        return returnValue;
    }

    public static void main(String[] args) {
        System.out.println("findAnagrams(\"cbaebabacd\", \"abc\") = " + findAnagrams("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaa"));
    }
}
