class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();

        //int[] --> going to be 2 items - (idx,height)
        stack.push(new int[]{0, heights[0]});

        //stack is going to be monotonic increasing 
        
        int startIdx = 0;
        int maxArea = 0;
        for(int i = 1 ; i < heights.length ; i++){
            startIdx = i;
            while(!stack.isEmpty() && stack.peek()[1] > heights[i]){
                int[] curr = stack.pop();
                int index = curr[0], height = curr[1];
                maxArea = Math.max(maxArea, height * (i - index));
                startIdx = index;
            }
            stack.push(new int[]{startIdx, heights[i]});
        }

        while(!stack.isEmpty()){
            int[] curr = stack.pop();
            maxArea = Math.max(maxArea, curr[1] * (heights.length - curr[0]));
        }

        return maxArea;
    }
}
/**
  
  Nice intutive problem 

  O(n) approach 

  2 1 5 6 2 3 

  stack 
  idx height
  0   2.    (POPPED)
  1.  1     we popped 0 because height 2 cant be extended since we encountered curr ele as the smallest - but compare the heights and calc it.
  2.  5
  3.  6.    (so far good - since the height is increasing order - meaning it can be extended to any far in right - possibility)
  4.  2     (its lesser - meaning the previous element cant be extended - so pop off - height 6 * its position(3) -  index (4) --> 6 * 1 = maxArea = 6
  
  
  (you have popped off 3,6)  
  
  now (2,5) compare with (4,2) -- you cant extend 5 - pop off it. 

  5 * (4-2) = 10 --> maxArea - 10 

  now next ele (1,1) <= (4,2)

  meaning 1 can be extended to right 

  instead of (4,2) --> insert (2,2) you have popped till index 2 - meaning 

  2,3,4 --> 2 height can be formed - so insert (2,2)
   
  
 */