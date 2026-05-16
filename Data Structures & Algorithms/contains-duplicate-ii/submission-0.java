class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> hashset = new HashSet<>();
        int l = 0;

        for(int r = 0 ; r < nums.length ; r++){
            if(r - l > k){
                hashset.remove(nums[l]);
                l++;
            }

            if(hashset.contains(nums[r])){
                return true;
            }

            hashset.add(nums[r]);
        }

        return false;
    }
}