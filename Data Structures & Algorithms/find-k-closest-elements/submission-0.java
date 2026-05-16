class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0 , r = arr.length-1;
        while(r-l >= k){
            if(Math.abs(x - arr[l]) <= Math.abs(x - arr[r])){
                r--;
            } else {
                l++;
            }
        }

        List<Integer> result = new ArrayList<>();

        for(int i = l ; i <= r ; i++){
            result.add(arr[i]);
        }
        return result;
    }
}
 
/**

2,4,5,8
k = 2, x = 6 

o/p : 4,5 

not why 5,8 

8-6 = 2 
5-6 = 1

4-6 = 2 
5-6 = 1 

k = 3 

x-
*/