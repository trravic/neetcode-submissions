class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> hset = new HashSet<>();

        int max = 0, l = 0 , r = 0;

        for(char c : s.toCharArray()){
            while(hset.contains(c)){
                hset.remove(s.charAt(l));
                l++;
            }
            hset.add(c);
            max = Math.max(max, r-l+1);
            r++;
        }

        return max;
    }
}

/**
s = "zxyzxyz"

hset = z 
hset = z x 

whnever u encouter repeated characters delete the first pointer using left and slide on. 

*/