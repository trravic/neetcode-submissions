class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hm = {}
        for i in range(0, len(nums)):
            findVal = target - nums[i]
            if findVal in hm:
                return [hm[findVal], i]
            hm[nums[i]] = i