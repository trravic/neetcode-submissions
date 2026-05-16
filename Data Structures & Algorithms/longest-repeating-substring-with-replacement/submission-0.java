class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> hmap = new HashMap<>();
        int res = 0; 
        int l = 0 , maxF = 0;
        for(int r = 0; r < s.length(); r++){
            hmap.put(s.charAt(r), hmap.getOrDefault(s.charAt(r), 0) + 1);
            maxF = Math.max(maxF,hmap.get(s.charAt(r)));
            while((r-l+1) - maxF > k){
                hmap.put(s.charAt(l) , hmap.get(s.charAt(l))-1);
                l++;
            }
            res = Math.max(res, r-l+1);
        }
        return res;
    }
}

/**
AAABABB k = 1

at window [l..r] --> only k characters disntict can be allowed 

find the len of such window which can be maximum 

count the maximum of unique characters - use hashmap 

for evry index i, 
get the maxF = max(max, s[i])
(r-l+1) - maxF > k

*/