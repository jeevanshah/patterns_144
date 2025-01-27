package neet150.SlidingWindow;

public class Neet13ContainerWithMostWater {

        public static int maxArea(int[] heights) {
            int maxArea = 0;

            int lindex = 0, rindex = heights.length -1;

            while(lindex < rindex){
                int currArea = 0;
                if(heights[lindex] < heights[rindex]){
                    currArea = heights[lindex]*(rindex -lindex);
                    lindex++;
                } else if(heights[lindex] > heights[rindex]) {
                    currArea = heights[rindex]*(rindex -lindex);
                    rindex--;
                } else {
                    currArea = heights[rindex]*(rindex -lindex);
                    rindex--;
                }
                if(currArea > maxArea)
                    maxArea = currArea;

            }

            return maxArea;
        }


    public static void main(String[] args) {
        System.out.println("maxArea(new int[]{1,7,2,5,4,7,3,6}) = " + maxArea(new int[]{1,7,2,5,4,7,3,6}));
    }
}
