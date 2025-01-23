package SlidingWindow;

import java.util.ArrayList;
import java.util.List;

class Item {
    int value;
    int weight;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

public class SlidingWindowObjects {
    public static int maxValueSubarray(List<Item> items, int maxWeight) {
        int left = 0, currentWeight = 0, maxValue = 0;
        
        for (int right = 0; right < items.size(); right++) {
            currentWeight += items.get(right).weight;
            
            // If the current weight exceeds maxWeight, slide the window
            while (currentWeight > maxWeight) {
                currentWeight -= items.get(left).weight;
                left++;
            }
            
            // Calculate max value within the window
            int currentValue = 0;
            for (int i = left; i <= right; i++) {
                currentValue += items.get(i).value;
            }
            maxValue = Math.max(maxValue, currentValue);
        }
        
        return maxValue;
    }

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item(2, 1));
        items.add(new Item(3, 2));
        items.add(new Item(4, 3));
        items.add(new Item(5, 4));
        
        int maxWeight = 5;
        System.out.println("Max value for subarray with weight less than or equal to " + maxWeight + ": " + maxValueSubarray(items, maxWeight));
    }
}
