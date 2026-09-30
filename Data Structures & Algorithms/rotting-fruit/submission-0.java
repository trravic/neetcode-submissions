class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0, time = 0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[i].length ; j++){
                if(grid[i][j] == 1){
                    fresh++;
                }
                else if(grid[i][j] == 2){
                    q.add(new int[]{i, j}); // capture the rotten fruit
                }
            }
        }
        int[][] directions = {{-1,0}, {0,1}, {0,-1} , {1, 0}};
        while(!q.isEmpty() && fresh > 0){
            int len = q.size(); // level by level traversal
            for(int i = 0 ; i < len ; i++){
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                // traverse in four directions 
                for(int[] dir : directions){
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if(nr >= 0 && nr < grid.length &&
                        nc >= 0 && nc < grid[0].length &&
                        grid[nr][nc] == 1)
                        {
                            grid[nr][nc] = 2;
                            q.add(new int[]{nr, nc});
                            fresh--;
                        }
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}
