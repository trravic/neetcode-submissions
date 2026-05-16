class StockSpanner {
    private Stack<int[]> spanStack;

    public StockSpanner() {
        spanStack = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        while(!spanStack.isEmpty() && spanStack.peek()[0] <= price){
            span += spanStack.pop()[1];
        }
        spanStack.push(new int[]{price, span});
        return span;
    }
}

/**
[[], [100], [80], [60], [70], [60], [75], [85]]

given input - 100, 80, 60, 70, 60, 75, 85 

next stock day - we insert curr price is going to be lesser than stack's top 
indicating its going to be monotonic decreasing stack. 

for first ele - its always 1 

For 80
(100,0), (80,1) --> 1 

for 60
(100, 0), (80, 1), (60,2) -> ( curr_idx - stack's peek idx )

for 70, pop the stack's peek since curr day price is higher than stack.peek()
repeat the process

(100, 0), (80, 1), (70, 3)

for 60, 
100,0 80,1 70,3 60,4 

for 75 
100,0 80,1 75,5


*/

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */