class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k%n-1);
        reverse(nums, k%n, n-1);
        
    }

    void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
/**

input       :  1,2,3,4,5,6,7,8 --> k = 4
expected op : [5,6,7,8,1,2,3,4]

reverse(n%4, n ) -> 1 2 3 4 8 7 6 5
reverse(0, n%4-1)-> 4 3 2 1 8 7 6 5 
reverse(0, n)    -> 5 6 7 8 1 2 3 4

*/