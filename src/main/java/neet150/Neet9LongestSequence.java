package neet150;

import java.util.*;

public class Neet9LongestSequence {

    public static int longestConsecutive(int[] nums) {
//    int i = 0;
//        Map<Integer, Set<Integer>> map= new HashMap<>();
//        int counter = 1;
//        int highest = 1;
//        Arrays.sort(nums);
////        int[] sorted = new int[nums.length];
////        for (int j = 0; j< nums.length;j++){
////            int temp = nums[j];
////
////        }
//        while (i < (nums.length-1)){
//            while (nums[i]+1 == nums[i+1]){
//                counter++;
//                if (counter>highest)
//                    highest = counter;
//            } else {
//                if (counter > 1)
//                    highest = counter;
//                counter = 1;
//            }
//            i++;
//        }
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int longest = 0;

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int length = 1;
                while (numSet.contains(num + length)) {
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("longestConsecutive(new int[]{2,20,3,10,4,5,6}) = " + longestConsecutive(new int[]{2,20,3,10,4,5,6,7,8,9,10,11,12,13,14}));
        // Record the end time
        long endTime = System.currentTimeMillis();

        // Calculate elapsed time
        long elapsedTime = endTime - startTime;
        System.out.println("Execution time in milliseconds: " + elapsedTime);
        long startTime1 = System.currentTimeMillis();
        Solution solution = new Solution();
        System.out.println("longestConsecutive(new int[]{2,20,3,10,4,5,6}) = " + solution.longestConsecutive2(new int[]{2,20,3,10,4,5,6,7,8,9,10,11,12,13,14}));
        // Record the end time
        long endTime1 = System.currentTimeMillis();

        // Calculate elapsed time
        long elapsedTime1 = endTime1 - startTime1;
        System.out.println("Execution time in milliseconds1: " + elapsedTime1);
    }

    public static class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> numSet = new HashSet<>();
            for (int num : nums) {
                numSet.add(num);
            }
            int longest = 0;

            for (int num : numSet) {
                if (!numSet.contains(num - 1)) {
                    int length = 1;
                    while (numSet.contains(num + length)) {
                        length++;
                    }
                    longest = Math.max(longest, length);
                }
            }
            return longest;
        }
        public int longestConsecutive2(int[] nums) {
            int i = 0;
            int counter = 1;
            int highest = 1;
            nums = Arrays.stream(nums).sorted().toArray();
            if(nums.length == 0)
                return 0;
            while (i < (nums.length-1)){
                if(nums[i] != nums[i+1]){
                    if (nums[i]+1 == nums[i+1]){
                        counter++;
                        if (counter>highest)
                            highest = counter;
                    } else {
                        if (counter > 1)
                            highest = counter;
                        counter = 1;
                    }
                }
                i++;
            }
            return highest;
        }
    }
}
