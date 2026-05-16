class Solution {
    public int search(int[] nums, int target) {
        int l = 0 , r = nums.length - 1;

        while(l < r){
            int m = l + (r-l)/2;
            if (nums[m] > nums[r]){
                l = m + 1;
            } else {
                r = m;
            }
        }

        int pivot = l;

        int result = bs(nums, target, 0, pivot-1);
        if(result!=-1)
            return result;
        
        return bs(nums, target, pivot, nums.length-1);
    }

    int bs(int[] nums, int target, int l, int r){
        while(l <= r){
            int m = l + (r-l)/2;
            if(nums[m] == target) return m;
            else if(nums[m] < target) l = m + 1;
            else r = m - 1;
        }
        return -1;
    }
}

/**
3,4,5,6,1,2

may be you can find the pivot element ( which is point )

deflection point 

0 , deflectionPoint-1  -> either decreasing  or increasing 

and you can do a 

binary search on nums, 0 , deflectionPt-1
binary search on nums, deflectionPt , nums.length-1


*/