class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // Boye Moore Voting Algorithm approach 
        int n = nums.length;
        int num1 = -1, num2 = -2, cnt1 = 0, cnt2 = 0;

        for(int num : nums){
            if(num == num1)
            {
                cnt1++;
            } else if (num == num2){
                cnt2++;
            } else if(cnt1 == 0){
                cnt1 = 1;
                num1 = num;
            } else if(cnt2 == 0){
                cnt2 = 1;
                num2 = num;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = cnt2 = 0;
        for(int num : nums){
            if(num == num1){
                cnt1++;
            } else if( num == num2){
                cnt2++;
            }
        }

        List<Integer> res = new ArrayList<>();
        if(cnt1 > n/3) res.add(num1);
        if(cnt2 > n/3) res.add(num2);

        return res;
    }
}

/**
Good problem 

Brute approach - O(n^2)

better appraoch - frequency sort - count in hashmap and iterate the key set of hashmap - and if value is more thn n/3 - return it. O(n) + O(n) approah

optimal appraoch - Apply boye moore voting algorithm 


Question says - find all elements that appear more than ⌊ n/3 ⌋ times

lets say if you have array of length - 10

appear more than n/3 times. 

have 2 candidates 

*/