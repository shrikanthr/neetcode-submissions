class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge:edges){
            List<Integer> list = graph.getOrDefault(edge[0], new ArrayList<>());
            list.add(edge[1]);
            graph.put(edge[0], list);

            list = graph.getOrDefault(edge[1], new ArrayList<>());
            list.add(edge[0]);
            graph.put(edge[1], list);
        }

        int i=0;
        int count = 0;
        Set<Integer> visited = new HashSet<>();
        while(i<n){
            if(!visited.contains(i)){
                count++;
                visited.add(i);
                dfs(graph, visited, i);
            }

            i++;
        }

        return count;
    }

    private void dfs(Map<Integer, List<Integer>> graph, Set<Integer> visited, int node){
        for(int n:graph.getOrDefault(node, new ArrayList<>())){
            if(!visited.contains(n)){
                visited.add(n);
                dfs(graph, visited, n);
            }
        }       
    }
}
