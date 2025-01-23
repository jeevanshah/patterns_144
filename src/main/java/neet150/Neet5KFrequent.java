package neet150;

import java.util.*;

public class Neet5KFrequent {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> groupMap = new HashMap<>();
        for(int i = 0; i< nums.length; i++) {
                groupMap.put(nums[i], groupMap.getOrDefault(nums[i], 0)+1);
        }
        List<List<Integer>> counter = new ArrayList<>(nums.length+1);
        for (int i = 0; i <= nums.length; i++) {
            counter.add(new ArrayList<>());
        }
        for (Map.Entry<Integer, Integer> entry : groupMap.entrySet()) {
            int val= entry.getValue();
            counter.get(val).add(entry.getKey());
        }

        int[] returnVal = new int[k];
        for (int j = counter.size()-1 ; j>0;j--){
            if (k==0)
                break;
            if (counter.get(j).size()>0) {
                for (int val: counter.get(j)) {
                    if (k==0)
                        break;
                    returnVal[k - 1]=val;
                    k--;
                }
            }
        }

        System.out.println("groupMap = " + groupMap);
        return returnVal;
    }
    public static void main(String[] args){
        System.out.println("topKFrequent(new int[]{1,2,2,3,3,3}, 2) = " + Arrays.toString(topKFrequent(new int[]{1,2}, 2)));
    }
}
