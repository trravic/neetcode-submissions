class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] cnt = new int[26];
        for(char task : tasks)
            cnt[task - 'A']++;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int c : cnt){
            if(c > 0)
                maxHeap.add(c);
        }

        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        // int[] -> int[0,1] -- {cnt, next_available_time}
        while(!maxHeap.isEmpty() || !q.isEmpty()){
            time++;

            if(maxHeap.isEmpty()){
                time = q.peek()[1];
            } else {
                int counter = maxHeap.poll() - 1;
                if(counter > 0)
                    q.add(new int[]{counter, time + n});
            }

            if (!q.isEmpty() && q.peek()[1] == time) {
                maxHeap.add(q.poll()[0]);
            }
        }

        return time;

    }
}