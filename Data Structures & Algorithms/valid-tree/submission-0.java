class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        int count = 1;
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int thisNode:adj.get(node)){
                if(!visited[thisNode]){
                    visited[thisNode] = true;
                    count++;
                    queue.offer(thisNode);
                }
            }
        }

        return count == n;
    }
}
