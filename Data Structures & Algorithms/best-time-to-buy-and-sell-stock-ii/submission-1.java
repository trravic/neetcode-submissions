class Solution {
    public int maxProfit(int[] prices) {
        int i = 0, buyValue, sellValue, profit = 0, len = prices.length - 1;
        while(i < len){
            while(i < len && prices[i] >= prices[i+1]) i++;

            // at the day it breaks out of above loop is the day stock price is minimal compared to next day. so that you can make a transaction. 

            buyValue = prices[i];

            // sell case 
            // compare with next day if its greater, it means more room to make profit, slide the pointer
            while(i < len && prices[i] < prices[i+1]) i++;
            sellValue = prices[i];

            profit += sellValue - buyValue;
        }
        return profit;
    }
}
/**
[7,1,5,3,6,4]

At first you dont hold any stock - try to buy it first. 


*/