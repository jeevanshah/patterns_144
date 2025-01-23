package neet150;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Neet1 {
    class Solution {
        public boolean hasDuplicate(int[] nums) {
            Map<Integer, Integer> bucket = new HashMap<>();

            for(int i =  0; i< nums.length; i++){
                if(bucket.containsKey(nums[i])){
                    return true;
                }
                bucket.put(nums[i], nums[i]);
            }
            return false;
        }
    }

    public class Solution2 {
        public boolean hasDuplicate(int[] nums) {
            return Arrays.stream(nums).distinct().count() < nums.length;
        }
    }
}
