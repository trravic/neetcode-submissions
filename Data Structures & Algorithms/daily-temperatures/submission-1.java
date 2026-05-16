class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>(); // store indices only
        
        for(int i = 0; i < n; i++) {
            // While current temp is warmer than stack top
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int prevIdx = stack.pop();
                res[prevIdx] = i - prevIdx; // found the answer for prevIdx
            }
            stack.push(i);
        }
        return res;
    }
}

/**

30,38,30,36,35,40,28

Next greater element problem 

if youre given curr day i, you need to check the next greater day than curr 

meaning you need to know the future dates temperatures for curr day 

curr_day .... curr_day+x


traverse from last 

28 --> last elemenet value would be 0 



*/