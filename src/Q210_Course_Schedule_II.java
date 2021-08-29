/*
210. Course Schedule II
430. Course Schedule II(lai)

There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

4, [[1,0],[2,0],[3,1],[3,2]]
There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].

Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
 */

import java.lang.reflect.Array;
import java.util.*;

/*
Solution :
schedule 1 是只打印true or false能否选完所有课， 2 是要把课程及顺序也打印出来， BFS2

 */
public class Q210_Course_Schedule_II {
    public int[] findOrder(int numCourses, int[][] prerequisites){
        //the adjacency list representation of prerequisites
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }
        for (int[] dependency : prerequisites){
            int x = dependency[0];
            int y = dependency[1];
            graph.get(y).add(x);
        }
        return topologicalSort(graph);
    }

    private int[] topologicalSort(List<List<Integer>> graph){
        int numCourses = graph.size();
        int[] topologicalOrder = new int[numCourses];
        int[] incomingEdges = new int[numCourses];
        for (int x = 0; x < numCourses; x++){
            for (int y : graph.get(x)){
                incomingEdges[y]++;
            }
        }
        //nodes with no incoming edges
        Queue<Integer> queue = new ArrayDeque<>();
        for (int x = 0; x < numCourses; x++){
            if (incomingEdges[x] == 0){
                queue.offer(x);
            }
        }
        int numExpanded = 0;
        while (!queue.isEmpty()){
            int x = queue.poll();
            topologicalOrder[numExpanded++] = x;
            for (int y : graph.get(x)){
                if (--incomingEdges[y] == 0){
                    queue.offer(y);
                }
            }
        }
        return numExpanded == numCourses ? topologicalOrder : new int[]{};
    }

    public static void main(String[] args){
        Q210_Course_Schedule_II s = new Q210_Course_Schedule_II();
        int numCourses = 4;
        int[][] prerequisites  = {{1,0},{2,0},{3,1},{3,2}};
        int[] result = s.findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(result));
    }

}
