class Solution {
    public int majorityElement(int[] nums) {
        int res = 0, count = 0;

        for (int num : nums) {
            if (count == 0) {
                res = num;
            }
            count += (num == res) ? 1 : -1;
        }
        return res;
    }
}

/**
Observation - 

worst case - O(n + n) - hashmap count insertion - scanning hashmap and calculating the n/2 

best soln - moore voting algo 

[5,5,1,1,1,5,5]

choose a winner arbitrarily when a count is 0 
cnt = 0 
winner = 5 

cnt += (num == winner) ? 1 : -1 ; // maximize the score if matches or penalize it if didnt 

eventually in some case the other might get relected. 

Election done as it sees the new candidates.
*/