class Solution {
    static List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        backtrace(0,  new ArrayList<>(),nums);
        return res;
    }

    static void backtrace(int index, List<Integer> subset, int[] nums){
        res.add(new ArrayList<>(subset));
        for(int i = index ; i < nums.length ; i++){
            if(i > index && nums[i] == nums[i-1]){
                continue;
            }
            subset.add(nums[i]);
            backtrace(i+1, subset, nums);
            subset.remove(subset.size()-1);
        }
    }
}
/**
[1 2 2] 

i = 0 --> [1] --> carry on to next iteration -- index 1 -> [1 2] ==> carry on to next iteration i3 -> [1 2 2]
i = 1 --> [2] --> carry on to next iteration - i2 [2 2] -> 
i = 2 --> X (i > index && nums[i] == nums[i-1]) skip it 

*/

/**

[]
├─ pick 1 → [1]
│    ├─ i=1: pick 2 → [1,2]
│    │     └─ i=2: pick 2 → [1,2,2]   (i == index, so allowed)
│    └─ i=2: nums[2]==nums[1] and i>index → SKIP
├─ pick 2 (i=1) → [2]
│    └─ i=2: pick 2 → [2,2]           (i == index, so allowed)
└─ i=2: nums[2]==nums[1] and i>index → SKIP
*/