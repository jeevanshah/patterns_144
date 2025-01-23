package neet150;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Neet3TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numbers = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numbers.containsKey(nums[i])){
                if (nums[i]+nums[i] == target){
                    return new int[]{numbers.get(nums[i]), i};
                }
            }
            numbers.put(nums[i], i);
        }
        for (Map.Entry<Integer, Integer> entry : numbers.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if (numbers.containsKey(target-key)){
                if (val < numbers.get(target-key))
                return new int[]{val, numbers.get(target-key)};
                else
                    return new int[]{numbers.get(target-key), val};
            }
        }
        return null;
    }
    public static void main(String[] args){
        Neet3TwoSum neet3TwoSum = new Neet3TwoSum();
        long startTime = System.currentTimeMillis();
        System.out.println("neet3TwoSum = " + (Arrays.toString(neet3TwoSum.twoSum(new int[]{5, 75, 25}, 100))));
        // Record the end time
        long endTime = System.currentTimeMillis();

        // Calculate elapsed time
        long elapsedTime = endTime - startTime;
        System.out.println("Execution time in milliseconds: " + elapsedTime);
   Solution solution = new Solution();
        long startTime2 = System.currentTimeMillis();
        System.out.println("neet3TwoSum = " + (Arrays.toString(solution.twoSum(new int[]{5, 75, 25}, 100))));
        // Record the end time
        long endTime2 = System.currentTimeMillis();

        // Calculate elapsed time
        long elapsedTime2 = endTime2 - startTime2;
        System.out.println("Execution time in milliseconds: " + elapsedTime2);
    }

    public static class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> prevMap = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                int diff = target - num;

                if (prevMap.containsKey(diff)) {
                    return new int[] { prevMap.get(diff), i };
                }

                prevMap.put(num, i);
            }

            return new int[] {};
        }
    }

}


