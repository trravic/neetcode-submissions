class Solution {
    public void reverseString(char[] s) {
        int i = 0, r = s.length-1;
        while(i < r){
            char c = s[i];
            s[i++] = s[r];
            s[r--] = c;
        }
    }
}