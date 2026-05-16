class Solution {
    public int findMin(int[] nums) {
        int left = 0 , right = nums.length - 1;
        int res = nums[0];

        while(left <= right){
            if(nums[left] < nums[right]){
                res = Math.min(res, nums[left]);
                break;
            }

            int mid = left + (right-left)/2;

            res = Math.min(res, nums[mid]);

            if(nums[mid] < nums[right]){
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return res;
    }
}
/**
1,2,3,4,5,6

l = 0 
r = 5 m = 3

if l < r return l 

[3,4,5,6,1,2]

l = 0 r = 5 m = 3 

l < r 
m = 3 

min = 5 arr[mid]

if mid < r : r = mid - 1
else : l = mid + 1 

-----

nums = [4, 5, 1, 2, 3]

l=0, r=4, res=4
Check: nums[0]=4 vs nums[4]=3 → not sorted
m=2, res = min(4, 1) = 1
nums[2]=1 < nums[0]=4 → r = 1
Now l=0, r=1
Check: nums[0]=4 vs nums[1]=5 → not sorted (4 < 5 but segment is [4,5])
Continue... m=0, res = min(1, 4) = 1

Eventually when you find a sorted portion, you want to compare nums[l] with the current res because the minimum might be in this final sorted segment.
Could we just return nums[l]?
No, because nums[l] at that point might not be the global minimum. The minimum might have been found in an earlier iteration when checking the middle element.

*/

