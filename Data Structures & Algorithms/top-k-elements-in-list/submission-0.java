
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hmap = new HashMap<>();

        for(int x : nums){
            hmap.put(x, hmap.getOrDefault(x,0)+1);
        }

        List<Integer>[] freq = new List[nums.length+1];

        for(int i = 0 ; i < nums.length+1 ; i++){
            freq[i] = new ArrayList<>();
         }

        for(Map.Entry<Integer,Integer> entry : hmap.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];

        int index = 0;
        
        for(int i = freq.length-1 ; i > 0 && index < k ; i--){
            for(int n : freq[i]){
                res[index++] = n;
                if(index == k)
                    return res;
            }
        }

        return res;
    }
}

/**

[1,2,2,3,3,3]

1 -> 1
2 -> 2 
3 -> 3 

0 1 2 3 
0 1 2 3 



*/