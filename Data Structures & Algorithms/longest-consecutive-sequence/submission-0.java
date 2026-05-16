class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : nums) {
            if (!map.containsKey(n)) {
                int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
                int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
                // sum: length of the sequence n is in
                int sum = left + right + 1;
                map.put(n, sum);
                
                // keep track of the max length 
                res = Math.max(res, sum);
                
                // extend the length to the boundary(s)
                // of the sequence
                // will do nothing if n has no neighbors
                map.put(n - left, sum);
                map.put(n + right, sum);
            }
            else {
                // duplicates
                continue;
            }
         }
         return res;
    }
}

/**
2 Solns 

HashSet - O(n)

Adding to set and iterating it. 

        for(int i : nums) set.add(i);
        int ans = 0;
        for(int num : nums) {
            int left = num - 1;
            int right = num + 1;
            while(set.remove(left)) left--;
            while(set.remove(right)) right++;
            ans = Math.max(ans,right - left - 1);
            if(set.isEmpty()) return ans; //save time if there are items in nums, but no item in hashset.
        }


Soln-2 HashMap 

Update the boundaries 

case 1 : [4 6]

5 ele comes in 

left = 1 
right = 1 

for num5 = left + right + 1 
5 -> 3 

update the (num - mp.get(left), count_of_curr_num) // left boundary 
update the (num + mp.get(right), count_of_curr_num) // extend the right boundary.

case 2 : [4 5 6]

if 3 comes in 

you dont have left boundary 
but u have right boundary of 4 which length is 3 

left = 0 
right = 3 

3 -> count -> 1 + 3 = 4 

update your right boundary -> 3 + mp.get(3) -> 6 -> 4

[3 4 5 6]

3 -> count 4 
6 -> count 4 

leave the in-between elements remain dirty - as we dont care about we slide forward, 
for any given number we care about num-1 left boundary exists 
and num+1 right boundary exists. 

we update the left and right for any given curr number. if left, right exists. 

 */