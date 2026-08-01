class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k%n-1);
        reverse(nums, k%n, n-1);
        // k%n -> modulo cancels repetitive swap. for ex: 16%8 = 0 / 64%8 = 0 
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

reverse(0, n)    -> 8 7 6 5 4 3 2 1 
reverse(0, k%n-1)-> 5 6 7 8 4 3 2 1 
reverse(k%n-1, n)-> 5 6 7 8 1 2 3 4
*/