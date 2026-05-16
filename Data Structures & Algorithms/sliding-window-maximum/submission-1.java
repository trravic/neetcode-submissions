class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>(); // monotonic decreasing queue;

        int n = nums.length;
        int[] outp = new int[n-k+1];

        int cnt = 0;
        for(int i = 0 ; i < n; i++){
            
            //remove out of bounds 
            if(!dq.isEmpty() && dq.peekFirst() <= i-k){
                dq.pollFirst();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                dq.pollLast();
            }

            dq.offerLast(i);
            
            if(i+1 >= k){
                outp[cnt++] = nums[dq.peekFirst()];
            }
        }
        return outp;
    }
}
