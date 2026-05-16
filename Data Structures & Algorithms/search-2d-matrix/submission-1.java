class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0 ; i < m ; i++){
            if(target <= matrix[i][n-1]){
                return binarySearch(matrix, i, target) != -1 ? true: false;
            }
        }
        return false;
    }

    public int binarySearch(int[][] arr,int idx, int target){
        int left = 0, right = arr[idx].length-1;
        

        while(left <= right){
            int mid = left + (right-left) / 2;
            if(arr[idx][mid] == target){
                return mid;
            }
            else if(arr[idx][mid] < target) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }   

        return -1;
    }
}
