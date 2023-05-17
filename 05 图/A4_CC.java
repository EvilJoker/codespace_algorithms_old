import java.util.Stack;

/* title: 连通分量
 * complexity: 
 * description:
 * 1. 基于深度遍历 ： 构造一个 edgeTo[] 数组，下表是顶点，值是父节点，edgeTo[w] = v 表示 v->w 
 * remember:
 * 1. edgeTo 路径记录器
 * 2. 访问过就是有路径
 */
public class A4_CC {
    // 深度优先遍历
    public class DFS {
        private boolean[] marked;// 这个顶点上调用过 dfs() 了吗？
        private int[] id; // 下标是顶点，值是连通分量的序号
        private int count; // 连通分量序号

        // 遍历
        public DFS(A1_graph G) {
            marked = new boolean[G.V()];
            id = new int[G.V()];
            for (int i = 0; i < G.V(); i++) {
                if (!marked[i]) {
                    dfs(G, i);
                    count++;
                }
            }

        }

        public void dfs(A1_graph G, int v) {
            marked[v] = true;
            id[v] = count;
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    dfs(G, w);
                }
            }
        }
        // 在同一个连通分量就算连通
        public boolean connected(int v, int w) {
            return id[v] == id[w];
        }

    }

}
