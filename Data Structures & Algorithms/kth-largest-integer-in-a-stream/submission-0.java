class KthLargest {

    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }

    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}

/**
kth largest 

KthLargest kthLargest = new KthLargest(3, [1, 2, 3, 3]);    1
                                                          2   3 

                                                          2
                                                        3.  3 

MIN - HEAP IMPL 

kthLargest.add(3);   // return 3      whenever new element comes you can remove the min and insert the ele - and return the maximum - which is top element
kthLargest.add(5);   // return 3
kthLargest.add(6);   // return 3
kthLargest.add(7);   // return 5
kthLargest.add(8);   // return 6




*/