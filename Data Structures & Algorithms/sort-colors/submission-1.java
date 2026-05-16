class Solution {
    public void sortColors(int[] nums) {
        int i = 0 , j = 0, k = nums.length - 1;
        // j -> can be used for zero 
        // k --> can be used for two 
        while(i <= k){
            if(nums[i] == 0){
                swap(j, i, nums);
                i++;
                j++;
            } else if(nums[i] == 1){
                i++;
            } else {
                swap(i , k, nums);
                k--;
            }
        }
    }

    void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/**
1,0,1,2

zc, = 0 
oc, = 0 
tc. = len(n)


slide num on oc
case 0:
     swap(zc,oc)
     zc++ oc++
case 1: 
     oc++
case 2:
     swap oc, tc
     tc--
     oc++

*/