package neet150.SlidingWindow;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Neet11Target {
    public static int[] twoSum(int[] numbers, int target) {

        int[] retrun = new int[2];
        for (int i = 0; i<numbers.length;i++){
            int j = i+1;
//            while (j < numbers.length){
//                if (numbers[i]+numbers[j]==target && numbers[i]!=numbers[j]){
//                    retrun[0] = i;
//                    retrun[1] = j;
//                    break;
//                }
//                j++;
//            }

        }
        return retrun;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{1 , 2, 4, 5}, 3)));
    }
}
