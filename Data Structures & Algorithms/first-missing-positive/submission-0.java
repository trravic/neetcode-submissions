class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean[] numsBool = new boolean[n+1];

        for(int num : nums){
            if(num > 0 && num <= n){
                numsBool[num-1] = true;
            }
        }
        int i = 0;
        for(; i <= n ; i++){
            if(!numsBool[i])
                return i+1;
        }
        return i;
    }
}