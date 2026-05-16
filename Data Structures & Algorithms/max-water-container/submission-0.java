class Solution {
    public int maxArea(int[] heights) {
        int leftMaxIndex = 0, rightMaxIndex = heights.length-1, area = 0, res = 0 ;

        while(leftMaxIndex < rightMaxIndex){
            area = Math.min(heights[leftMaxIndex], heights[rightMaxIndex]) * (rightMaxIndex - leftMaxIndex);
            res = Math.max(res, area);
            if(heights[leftMaxIndex] <= heights[rightMaxIndex]){
                leftMaxIndex++;
            } else {
                rightMaxIndex--;
            }
        }
        return res;
    }
}
/**
[1,7,2,5,4,7,3,6]

leftMax = 7 , leftMaxIndex = 1 
rightMax = 6 , rightMaxIndex = 7 

waterHold = min(leftMax,rightMax)
totalCap = waterHold * (rightMaxIndex - leftMaxIndex)


if rightMax is smaller, move it closer -> rightMax--;
repeat the process 

*/