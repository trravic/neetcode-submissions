class Solution {
    public int numRescueBoats(int[] people, int limit) {
       int boatCount = 0;
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length - 1;
        
        while(left <= right){
            int sum = people[left] + people[right];
            if(sum <= limit){
                boatCount++;
                left++;
                right--;
            }
            else{
                boatCount++;
                right--;
            }
        }
        return boatCount;

    }
}

/**
5,1,4,2

sort - 1 2 4 5 

1 + 5 <= 6 -> boat = 1, left++, right--

2 + 4 <= 6 -> boat = 2 

----

if sum >= limit case, it cant carry two person ( left + right ) the number is huge, means you right person is heavy - use specific boat for him and increase the boat count and decrease the right ptr;

*/