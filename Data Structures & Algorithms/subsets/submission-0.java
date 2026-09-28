class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> arrList = new ArrayList<>();
        backtracking(nums, arrList, 0, new ArrayList<>());
        return arrList;
    }

    static void backtracking(int[] nums, List<List<Integer>> arrList, int index, List<Integer> subList){
        int n = nums.length;
        arrList.add(new ArrayList<>(subList));

        for(int i = index ; i < n ; i++){
            subList.add(nums[i]);
            backtracking(nums, arrList, i+1, subList);
            subList.remove(subList.size()-1);
        }
        return ;
    }   
}
