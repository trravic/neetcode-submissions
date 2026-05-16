class Solution {
    public int maxProfit(int[] prices) {
        int left = 0 , right = 1;
        int maxProfit = 0;

        while(right < prices.length){
            if(prices[left] < prices[right]){
                int profit = prices[right] - prices[left];
                maxProfit = Math.max(maxProfit, profit);
            } else {
                left = right;
            }
            right++;
        } 

        return maxProfit;
    }
}
/**

prices = [10,1,5,6,7,1]

left = 0, right = 1

*/