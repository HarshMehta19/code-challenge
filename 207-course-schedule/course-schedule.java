class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> lists = new ArrayList<>();
        for(int i=0;i<numCourses;i++) {
            lists.add(new ArrayList<>());
        }

        for(int[]course : prerequisites) {
            lists.get(course[0]).add(course[1]);
        }

        int[] visited = new int[numCourses];
        for(int i=0;i<numCourses;i++) {
            if(visited[i]==0){
                if(!dfs(i, visited, lists)) return false;
            }
        }
        return true;
    }

    boolean dfs(int courseId, int[] visited, List<List<Integer>> lists) {
        if(visited[courseId] == 2) return false;
        visited[courseId] = 2;
        var list = lists.get(courseId);        
        for(var i : list) {
            if(visited[i] != 1) {
                if(!dfs(i, visited, lists)) return false;
            }
        }
        visited[courseId] = 1;
        return true;
    }
}