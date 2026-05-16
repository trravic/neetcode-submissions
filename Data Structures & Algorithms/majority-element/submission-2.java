class Solution {
    public int majorityElement(int[] nums) {
        int winner = 0, count = 0;
        for(int x : nums){
            if(count == 0){
                winner = x;
            }
            count += (x==winner) ? 1 : -1;
        }
        return winner;
    }
}