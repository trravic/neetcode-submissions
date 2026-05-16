class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())
            return false;

        int[] s1State = new int[26];
        int[] s2State = new int[26];

        for(int i = 0 ; i < s1.length(); i++){
            s1State[s1.charAt(i) - 'a']++;
            s2State[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for(int i = 0 ; i < 26 ; i++){
            if(s1State[i] == s2State[i])
                matches++;
        }

        int l = 0;
        for(int r = s1.length(); r < s2.length(); r++){
            if(matches == 26)
                return true;
            
            int index = s2.charAt(r) - 'a';
            s2State[index]++;
            
            if(s1State[index] == s2State[index])
                matches++;
            else if(s1State[index] + 1 == s2State[index])
                matches--;
            
            index = s2.charAt(l) - 'a';
            s2State[index]--;

            if(s1State[index] == s2State[index])
                matches++;
            else if(s1State[index] - 1 == s2State[index])
                matches--;

            l++;
        }
        return matches == 26;
    }
}
// state tracking problem 
// have 2 initial states

// given that s1 will be lesser than s2. 

// iterate till s1.length() and setup the s1State and s2State 

// compare the matches and if there is 26 match, return it. 

