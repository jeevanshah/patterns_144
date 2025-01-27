package neet150.SlidingWindow;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Neet12Arrays {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> retrunList = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            System.out.println("nums[i] = " + nums[i]);
            if (nums[i]>0) break;
            if (i > 0 && (nums[i] == nums[i-1]))
                continue;
            int l = i+1, r = nums.length - 1;
            List<Integer> integerList = new ArrayList<>();
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > 0 ){
                    r--;
                } else if (sum < 0){
                    l++;
                } else {
                    integerList.add(nums[i]);
                    integerList.add(nums[l]);
                    integerList.add(nums[r]);
                    l++;
                    r--;
                    retrunList.add(integerList);
                }
            }
        }
        return retrunList;
    }

    public static void main(String[] args) {
//        [-2,0,0,2,2]
        System.out.println("args = " + threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}
