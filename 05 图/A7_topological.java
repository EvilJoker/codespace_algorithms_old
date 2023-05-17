import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/* title: 拓扑排序
 * complexity: O(lgn)
 * description:
    所有的任务都有优先级关系，如何合理的安排任务的执行顺序
    1. 不能有环
    2 三种遍历 
    > 前序：在递归调用之前将顶点加入队列
    > 后序: 在递归调用之后将顶点加入队列
    > 逆后序: 在递归调用之后将顶点压入栈
    3. 逆后序就是拓扑排序，打印栈得出优先关系
 * remember:
 *  
 */

public class A7_topological {

    private Iterable<Integer> order; // 顶点的拓扑排序

    public A7_topological(A5_digraph G) {
        A6_directedCycle cyclefinder = new A6_directedCycle(G);
        if (!cyclefinder.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }

    public Iterable<Integer> order() {
        return order;
    }

    public boolean isDAG() {
        return order == null;
    }

    // 遍历
    public static class DepthFirstOrder {
        private boolean[] marked;
        private Queue<Integer> pre; // 所有顶点的前序排列
        private Queue<Integer> post; // 所有顶点的后序排列
        private Stack<Integer> reversePost; // 所有顶点的逆后序排列

        public DepthFirstOrder(A5_digraph G) {
            pre = new LinkedList<>();
            post = new LinkedList<>(); //
            reversePost = new Stack<Integer>();
            marked = new boolean[G.V()];

            for (int v = 0; v < G.V(); v++) {
                if (!marked[v])
                    dfs(G, v);
            }
        }

        private void dfs(A5_digraph G, int v) {
            pre.add(v);

            marked[v] = true;
            for (int w : G.adj(v)) {
                if (!marked[w])
                    dfs(G, w);
            }

            post.add(v);
            reversePost.push(v);
        }

        public Iterable<Integer> pre() {
            return pre;
        }

        public Iterable<Integer> post() {
            return post;
        }

        public Iterable<Integer> reversePost() {
            return reversePost;
        }
    }
}
