class FreqStack {
    int maxFreq ;
    Map<Integer, Integer> freqHashMap;
    Map<Integer, Stack<Integer>> maxFreqHashMap;

    public FreqStack() {
        maxFreq = 0;
        freqHashMap = new HashMap<>();
        maxFreqHashMap = new HashMap<>();
    }
    
    public void push(int val) {
        int freq = freqHashMap.getOrDefault(val, 0) + 1;
        freqHashMap.put(val, freq);
        maxFreq = Math.max(freq, maxFreq);

        // update maxFreqHashMap 
        maxFreqHashMap.computeIfAbsent(freq, k -> new Stack<>()).push(val);
    }
    
    public int pop() {
        Stack<Integer> st = maxFreqHashMap.get(maxFreq);
        int ele = st.pop();
        freqHashMap.put(ele, freqHashMap.get(ele) - 1);
        if(st.isEmpty())
            maxFreq--;

        return ele;
    }
}
/**
   
   1 1 2 1 2 1 3   --> (times of encountered)
   5 4 5 3 4 2 5

   have 2 hashmaps 

   freqHashmap of element - update it and get the maxFreq

   have a times of occured 

   <Integer, Stack<integer>> stack would preserver the order of insertion 

   if times of occured -- aka -- maxFreq's stack doesnt hold anything - delete it and update the maxFreq-- so that next pop the maxFreq's hashmap.get(maxFreq).pop();

   At the same time - you need to update freqHashmap - decrement by 1 

  */

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */