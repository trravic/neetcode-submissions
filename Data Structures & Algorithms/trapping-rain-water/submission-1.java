class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int l = 0, r = height.length - 1;
        int leftMax = height[l], rightMax = height[r];
        int res = 0;
        while (l < r) {
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, height[l]);
                res += leftMax - height[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                res += rightMax - height[r];
            }
        }
        return res;
    }
}
/**
          0 1 2 3 4 5 6 7 8 9 
height = [0,2,0,3,1,0,1,3,2,1]


leftmax = 0 , rightmax = 1, left = 0 , right = 9

if(leftmax<rightmax)
    slide your left ptr, as your right ptr is max, you can capture most of the trap
    have a resultant var <- capture your current cell balance to be filled with leftmax
else 
    // your left max is greater, 
    now move your right pointer, when you move the right pointer.
    capture the current cell to be filled with rightmax. calculate the difference. 
    add it to your resultant var 

*/