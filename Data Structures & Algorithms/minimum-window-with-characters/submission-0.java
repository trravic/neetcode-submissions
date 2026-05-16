class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tmap = new HashMap<>();
        int haveT = 0;
        for(char c : t.toCharArray()){
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);
        }
        haveT = tmap.size();

        int needS = 0, l = 0;
        Map<Character, Integer> smap = new HashMap<>();

        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;

        for(int r = 0; r < s.length() ; r++){
            char c = s.charAt(r);
            smap.put(c, smap.getOrDefault(c, 0) + 1);
            if(tmap.containsKey(c)){
                if(tmap.get(c) == smap.get(c)){
                    needS++;
                }
            }
            while(needS == haveT){
                //valid window problem asks t minimize the window 
                //move the left ptr 

                if(r-l+1 < resLen) {
                    resLen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }
                
                char leftC = s.charAt(l);
                smap.put(leftC, smap.get(leftC) - 1);

                if(tmap.containsKey(leftC)) {
                    if(smap.get(leftC) < tmap.get(leftC)){
                        needS--;
                    }
                }
                    
                // move the left ptr 
                l++;
            }
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
         
    }
}
