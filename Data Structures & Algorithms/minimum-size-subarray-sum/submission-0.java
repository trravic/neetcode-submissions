class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = 0, res = Integer.MAX_VALUE, sum = 0;

        while(r < nums.length){
            sum += nums[r];
            while(sum >= target){
                res = Math.min(res, r-l+1);
                sum -= nums[l];
                l++;
            }
            r++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}