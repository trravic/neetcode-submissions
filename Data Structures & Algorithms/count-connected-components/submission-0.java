class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        boolean[] visited = new boolean[n];

        for(int i = 0 ; i < n ; i++)
            adjList.add(new ArrayList<>());
        for(int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        int count = 0;
        for(int i = 0 ; i < n; i++){
            if(!visited[i]){
                dfs(adjList, i, visited);
                count++;
            }
        }
        return count;
    }

    public void dfs(List<List<Integer>> adjList, int currNode,boolean[] vis){

        vis[currNode] = true;

        for(int nbr : adjList.get(currNode)){
            if(!vis[nbr])
                dfs(adjList, nbr, vis);
        }
    }
}
