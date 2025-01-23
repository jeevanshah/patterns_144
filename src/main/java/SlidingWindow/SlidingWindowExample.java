package SlidingWindow;

public class SlidingWindowExample {
    public static int maxSumSubarray(int[] arr, int k) {
        if (arr == null || arr.length < k) {
            throw new IllegalArgumentException("Invalid array or window size.");
        }
        
        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;
        
        // Initialize the first window
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        
        maxSum = windowSum;
        
        // Slide the window across the array
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];  // Slide the window by removing the element going out of the window and adding the new element
            maxSum = Math.max(maxSum, windowSum);
        }
        
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println("Maximum sum of subarray of size " + k + ": " + maxSumSubarray(arr, k));
    }
}
