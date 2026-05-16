class Solution {
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length()-1;
        while(l <= r){
            if(s.charAt(l) != s.charAt(r)){
                return checkPal(s, l+1, r) || checkPal(s, l, r-1);
            }
            l++;
            r--;
        }
        return true;
    }

    public boolean checkPal(String s, int left, int right){

        while(left <= right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}