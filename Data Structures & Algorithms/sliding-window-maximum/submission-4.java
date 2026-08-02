class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>(); // monotonic decreasing queue
        int[] res = new int[nums.length - k + 1];

        for(int i = 0 ; i < nums.length ; i++){
            //remove out of bounds
            if(!dq.isEmpty() && dq.peekFirst() <= i-k){
                dq.pollFirst();
            }

            while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()])
                dq.pollLast();

            dq.offerLast(i);

            if(i+1 >= k)
                res[i-k+1] = nums[dq.peekFirst()]; //always maximum element
        }
        return res;
    }
}
/**

nums = [4, 2, 12, 3, 8, 9],  k = 3
index:   0  1   2  3  4  5

i = 0, val = 4

Back: deque empty, nothing to pop
Insert index 0
deque = [0] (values: [4])
Window not full yet (need i ≥ k-1 = 2)

i = 1, val = 2

Back: nums[0]=4 is NOT smaller than 2, so don't pop
Insert index 1
deque = [0, 1] (values: [4, 2])
Window not full yet

i = 2, val = 12

Back: nums[1]=2 < 12 → pop index 1
Back: nums[0]=4 < 12 → pop index 0
deque now empty → insert index 2
deque = [2] (values: [12])
Front check: dq.front() = 2, window is [0,2], 2 is valid
Window full! Max = nums[front] = nums[2] = 12

i = 3, val = 3

Back: nums[2]=12 is NOT smaller than 3, don't pop
Insert index 3
deque = [2, 3] (values: [12, 3])
Front check: front = 2, window is [1,3], is index 2 ≥ 1? Yes, valid
Max = nums[2] = 12

i = 4, val = 8

Back: nums[3]=3 < 8 → pop index 3
Back: nums[2]=12 NOT < 8, stop popping
Insert index 4
deque = [2, 4] (values: [12, 8])
Front check: front = 2, window is [2,4], valid
Max = nums[2] = 12

i = 5, val = 9

Back: nums[4]=8 < 9 → pop index 4
Back: nums[2]=12 NOT < 9, stop popping
Insert index 5
deque = [2, 5] (values: [12, 9])
Front check: front = 2, window is [3,5]. Is index 2 ≥ 3? No — expired! Pop from front.
deque = [5] (values: [9])
New front = 5, is it within [3,5]? Yes.
Max = nums[5] = 9

Final output: [12, 12, 12, 9] ✅ matches what we computed by hand earlier.

*/