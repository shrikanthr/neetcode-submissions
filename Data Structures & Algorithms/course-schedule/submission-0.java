class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> prereq = new HashMap<>();
        for(int i=0;i<prerequisites.length;i++){
            List<Integer> list = prereq.getOrDefault(prerequisites[i][0], new ArrayList<Integer>());
            list.add(prerequisites[i][1]);
            prereq.put(prerequisites[i][0], list);
        }
        
        for(int i=0;i<numCourses;i++){
            if(!dfs(i, prereq, new HashSet<>())){
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> prereq, Set<Integer> path){
        if(path.contains(course)){
            return false;
        }

        if(!prereq.containsKey(course)){
            return true;
        }

        path.add(course);
        List<Integer> prereqCourses = prereq.get(course);
        for(Integer c:prereqCourses){
            if(!dfs(c, prereq, path)){
                return false;
            }
        }

        path.remove(course);
        return true;
    }
}
