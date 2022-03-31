class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][] adjMatrix = new int[numCourses][numCourses];
        int[] inDegree = new int[numCourses];
        for(int[] row : prerequisites) {
            int next = row[0];
            int pre = row[1];
            adjMatrix[pre][next] = 1;
            inDegree[next]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int course = 0 ; course < numCourses ; course++) {
            if(inDegree[course] == 0) {
                queue.add(course);
            }
        }

        int count = 0;
        List<Integer> result = new ArrayList<>();
        while(! queue.isEmpty()) {
            count++;
            int course = queue.poll();
            result.add(course);
            for(int i = 0 ; i < numCourses ; i++) {
                if(adjMatrix[course][i] == 1) {
                    if(--inDegree[i] == 0)
                        queue.add(i);
                }
            }
        }

        if (count != numCourses) return new int[0];
        int[] resArr = new int[result.size()];
        for(int i = 0 ; i < result.size() ; i++)
            resArr[i] = result.get(i);
        return resArr;
    }
}
