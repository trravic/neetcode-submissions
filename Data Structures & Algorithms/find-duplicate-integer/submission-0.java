class Solution {
    public int findDuplicate(int[] nums) {
        for(int num : nums){
            int idx = Math.abs(num) - 1;
            if(nums[idx] < 0)
                return Math.abs(num);
            
            nums[idx] *= -1;
        }
        return -1;
    }
}

/**
[1,2,3,2,2]

for 1 -> (val - 1) => index ==> 0 and mark it negative 

for 2 -> index = 1 => mark it negative ( -1, -2, 3, 2 , 2)

for 3 -> (-1, -2, -3 , 2 , 2)

jst before markin see if its already -ve, if so -it is visited and duplicate
*/