package neet150;

import java.util.ArrayList;
import java.util.Arrays;

public class Neet7Kmultiple {

        public static int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int[] res = new int[n];

            res[0] = 1;
            for (int i = 1; i < n; i++) {
                res[i] = res[i - 1] * nums[i - 1];
            }

            int postfix = 1;
            for (int i = n - 1; i >= 0; i--) {
                res[i] *= postfix;
                postfix *= nums[i];
            }
            return res;
        }

    public static void main(String[] args) {
        int[] encode =  productExceptSelf(new int[]{2,3,4,5});
        System.out.println("encode = " + Arrays.toString(encode));

    }
}
