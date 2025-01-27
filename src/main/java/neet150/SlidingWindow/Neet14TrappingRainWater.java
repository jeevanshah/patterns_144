package neet150.SlidingWindow;

public class Neet14TrappingRainWater {
    public static int trap(int[] height) {

        int l = 0, r= height.length -1;
        int maxLeft = height[l];
        int maxRight = height[r];
        int accumArea = 0;
        while(l<=r){
           if(maxLeft<=maxRight){
               if (height[l]>=maxLeft){
                   maxLeft = height[l];
               } else {
                   accumArea += maxLeft -height[l];
               }
               l++;

           } else {
               if (height[r]>=maxRight){
                   maxRight = height[r];
               } else {
                   accumArea += maxRight -height[r];
               }
               r--;
           }
        }
    return accumArea;
    }

    public static void main(String[] args) {
       System.out.println("maxArea(new int[]{1,7,2,5,4,7,3,6})1 = " + trap(new int[]{0,2,0,3,1,0,1,3,2,1}));
        System.out.println("maxArea(new int[]{1,7,2,5,4,7,3,6})2 = " + trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println("maxArea(new int[]{1,7,2,5,4,7,3,6})3 = " + trap(new int[]{4,2,3}));
    }
}
