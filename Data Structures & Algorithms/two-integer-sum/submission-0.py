class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        mapp = {}

        for i in range(len(nums)):
            val = target - nums[i]
            if(val in mapp):
                return [mapp[val], i]
            mapp[nums[i]] = i
        
        return []