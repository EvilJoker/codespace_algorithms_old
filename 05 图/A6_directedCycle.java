import java.util.ArrayList;
// import java.util.Iterator;
// // import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/* title: 有向图
 * complexity: O(lgn)
 * description:
    从所有的节点出发，找到环就退出
 * remember:
 *  邻接表（顶点是链表）
 * marked 是标记是否访问过，访问过，就不在递归
 * onStack 记忆递归调用栈上的所有顶点
 */

public class A6_directedCycle {

    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle; // 有向环中的所有顶点（如果存在）
    private boolean[] onStack; // 递归调用的栈上的所有顶点

    public A6_directedCycle(A5_digraph G) {
        onStack = new boolean[G.V()];
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];

        for (int v = 0; v < G.V(); v++) {
            if (!marked[v])
                dfs(G, v);
        }
    }

    public void dfs(A5_digraph G, int v) {
        onStack[v] = true;// 假设在环上
        marked[v] = true;

        for (int w : G.adj(v)) {
            if (this.hasCycle())
                return;
            else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
            // 先在onStack 存入当前节点，如何又遇到了，就说明有环
            else if (onStack[w]) {
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        // 一直没有找到环
        onStack[v] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

}
