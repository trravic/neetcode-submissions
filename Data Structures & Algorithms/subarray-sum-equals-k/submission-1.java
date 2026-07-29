class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0, preSum = 0;
        Map<Integer, Integer> hmap = new HashMap<>();
        hmap.put(0, 1); // 0 - for edgecase // also it means 0 occured 1 time 

        for(int num : nums){
            preSum += num;
            int diff = preSum - k;
            count += hmap.getOrDefault(diff, 0);
            hmap.put(preSum, hmap.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
}

/**

prefix-sum + Hashmap Approach

nums = [3, 4, 7, 2, -3, 1, 4, 2], k = 7 → answer 4

i	num	prefixSum	(prefixSum - k)	found in map?	count so far	map after adding prefixSum
0	3	    3	        3-7=-4	    no	            0	            {0:1, 3:1}
1	4	    7	        7-7=0	    yes (0:1)	    1	            {0:1, 3:1, 7:1}
2	7	    14	        14-7=7	    yes (7:1)	    2	            {0:1, 3:1, 7:1, 14:1}
3	2	    16	        16-7=9	    no	            2	            {..., 16:1}
4	-3	    13	        13-7=6	    no	            2	            {..., 13:1}
5	1	    14	        14-7=7	    yes (7:1)	    3	            {..., 14:2}
6	4	    18	        18-7=11	    no	            3	            {..., 18:1}
7	2	    20	        20-7=13	yes (13:1)	        4	            {..., 20:1}


*/