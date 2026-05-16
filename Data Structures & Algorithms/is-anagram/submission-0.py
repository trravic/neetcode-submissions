class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        count = [0] * 26
        if(len(s) != len(t)):
            return False

        for i in range(len(s)):
            idx = ord(s[i]) - ord('a')
            idx2 = ord(t[i]) - ord('a')
            count[idx] = count[idx] + 1
            count[idx2] = count[idx2] - 1

        for i in count:
            if i!=0:
                return False

        return True
        
        
       
            