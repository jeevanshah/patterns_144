package neet150.SlidingWindow;

public class Neet10Palimdrome {
    public static boolean isPalindrome(String s) {
        int f = 0;
        int l = s.length()-1;
        for(int i = 0; i< s.length()/2;i++) {
            while (!Character.isLetterOrDigit(s.charAt(l)) || Character.isSpaceChar(s.charAt(l))){
                l--;
                if (l == 0)
                    return true;
            }
            while (!Character.isLetterOrDigit(s.charAt(f)) || Character.isSpaceChar(s.charAt(f))){
                f++;
                if (f == s.length())
                    return true;
            }
            if (!(s.substring(f,f+1).equalsIgnoreCase(s.substring(l,l+1)))){
                return false;
            } else {
                l--;
                f++;
            }
        }
        return true;
    }

    public static boolean checkAlphabet(char c){
        if ((c >= 65 && c <= 90) || (c <= 122 && c >= 97)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("isPalindrome(\"Was it a car or a cat I saw?\") = " + isPalindrome("0p"));
        System.out.println("isPalindrome(\"Was it a car or a cat I saw?\") = " + isPalindrome("tab a cat"));
        System.out.println("isPalindrome(\"Was it a car or a cat I saw?\") = " + isPalindrome("Was it a car or a cat I saw?"));
    }
}
