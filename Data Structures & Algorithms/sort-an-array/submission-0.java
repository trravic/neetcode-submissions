class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0 , nums.length-1);
        return nums;
    }

    void mergeSort(int[] arr, int start, int end){
        if( start >= end) return;
        int mid = (start+end) / 2;

        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);
        merge(arr, start, mid, end);
    }

    void merge(int[] arr, int start, int mid, int end){
        ArrayList<Integer> temp = new ArrayList<>();

        int i = start;
        int j = mid + 1;
        int k = 0;
        while(i <= mid && j <= end){
            if(arr[i]<=arr[j]){
               temp.add(arr[i]);
               i++;
            } else {
                temp.add(arr[j]);
                j++;
            }
        }

        while(i <= mid){
            temp.add(arr[i++]);
        }

        while(j <= end){
            temp.add(arr[j++]);
        }

        for(int ii = start; ii <= end ; ii++){
            arr[ii] = temp.get(ii-start);
        }
    }
}