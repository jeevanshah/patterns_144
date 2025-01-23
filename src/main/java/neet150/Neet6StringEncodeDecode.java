package neet150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Neet6StringEncodeDecode {
//    Check the time big o

    public static String encode(List<String> strs) {
        String returnString = new String();
        for(String string: strs){
            returnString = returnString + string.length() + '#' + string;
        }
        return returnString;

    }

    public static List<String> decode(String str) {
        List<String> returnList = new LinkedList<>();
        System.out.println(str);
        int i =0;
        while(i<str.length()){
            int j = i;
            while(str.charAt(j)!='#'){
                j++;
            }
            if(isInteger(str.substring(i,j))){
                int test = Integer.parseInt(str.substring(i,j));
               returnList.add(str.substring(j+1, j+test+1));
                i=j+test+1;
            } else {
                i++;
            }
        }
        return returnList;
    }

    public static boolean isInteger(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String encode = encode(new ArrayList<>(Arrays.asList("neet","code","love","you")));
        System.out.println("encode = " + decode(encode));

    }
}
