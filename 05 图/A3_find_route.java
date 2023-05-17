import java.util.Stack;

/* title: 寻找路径
 * complexity: 
 * description:
 * 1. 基于深度遍历 ： 构造一个 edgeTo[] 数组，下表是顶点，值是父节点，edgeTo[w] = v 表示 v->w 
 * remember:
 * 1. edgeTo 路径记录器
 * 2. 访问过就是有路径
 */
public class A3_find_route {
    // 深度优先遍历
    public class DFS {
        private boolean[] marked;// 这个顶点上调用过 dfs() 了吗？
        private int[] edgeTo; // 路劲记录器  edgeTo[w] = v 表示 v->w 
        private final int s; // 起点

        public DFS(A1_graph G, int s) {
            marked = new boolean[G.V()];
            edgeTo = new int[G.V()] ;
            this.s =s ;
            dfs(G, s);
        }
        
        private void dfs(A1_graph G, int v) {
            marked[v] = true;
            
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v ;
                    dfs(G, w);
                }
            }
        }
        // 是否存在路径
        public boolean hasPathTo(int w){
            return marked[w];
        }
        // 返回路径
        public Iterable<Integer> pathTo(int v){
            // 不存在
            if(!hasPathTo(v)) return null;
            // 存在
            Stack<Integer> path = new Stack<Integer>();
            for(int x= v; x!=s; x=edgeTo[x]){
                path.push(x);
            }
            path.push(s);

            return path;
        }

    }

}
