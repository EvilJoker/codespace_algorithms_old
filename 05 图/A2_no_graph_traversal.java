import java.util.Iterator;
import java.util.LinkedList;

/* title: 无向图的遍历
 * complexity: 
 * description:
    深度优先遍历：
    1. 从起点开始，标记起点，然后递归的访问它的所有没有被标记的邻居顶点。
    广度优先遍历
    2. 从起点开始，标记起点，然后将它的所有邻居顶点加入队列，然后从队列中取出一个顶点，标记它，将它的所有邻居顶点加入队列，重复这个过程，直到队列为空。
 * remember:
 * 
 */
public class A2_no_graph_traversal {
    // 深度优先遍历
    public class DFS {
        private boolean[] marked;// 这个顶点上调用过 dfs() 了吗？
        private int count; // 起点

        public DFS(A1_graph G, int s) {
            marked = new boolean[G.V()];
            count = 0;
            dfs(G, s);
        }
        
        private void dfs(A1_graph G, int v) {
            marked[v] = true;
            count ++;
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    dfs(G, w);
                }
            }
        }
        
        public boolean marked(int w){
            return marked[w];
        }

        public int count(){
            return count;
        }

    }

    // 广度优先遍历
    public class BFS {
        private boolean[] marked;// 这个顶点上调用过 dfs() 了吗？
        private int count; // 起点

        public BFS(A1_graph G, int s) {
            marked = new boolean[G.V()];
            count = 0;
            bfs(G, s);
        }
        
        private void bfs(A1_graph G, int s) {
            LinkedList<Integer> queue = new LinkedList<Integer>();
            marked[s] = true;
            queue.add(s);
            while (!queue.isEmpty()) {
                int v = queue.poll();
                count ++;
                for (int w : G.adj(v)) {
                    if (!marked[w]) {
                        marked[w] = true;
                        queue.add(w);
                    }
                }
            }
        }
        
        public boolean marked(int w){
            return marked[w];
        }

        public int count(){
            return count;
        }

    }
}
