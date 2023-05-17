import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import A8_mst_struct.DirectedEdge;

/* title: 最短路径 dijkstra算法
 * complexity: O(lgn)
 * description:
    prim 算法是 从一个顶点出发， 每次找最小的边，加入到最小生成树中。
    dijkstra 也是类似的，算法是 从一个顶点出发， 每次找最小的边，加入到最短路径中。
    区别： prim 是 无向加权图， dijkstra 是 有向加权图。
 * remember:
 *  relax 松弛。就是判断是否需要更新最短路径。
 */

public class A9_dijkstra {
    private A8_mst_struct.DirectedEdge[] edgeTo; // 最短路径的边
    private double[] distTo; // 最短路径的距离
    private PriorityQueue<A8_mst_struct.Pair> pq; // 包含最小的边

    public A9_dijkstra(A8_mst_struct.EdgeWeightedDigraph G, int s) {
        edgeTo = new A8_mst_struct.DirectedEdge[G.V()];
        distTo = new double[G.V()];
        pq = new PriorityQueue<>();
        // 节点不可达，初始化为无穷大
        for (int i = 0; i < G.V(); i++)
            distTo[i] = Double.POSITIVE_INFINITY;

        // 起点： 源节点到自己的距离为0
        distTo[s] = 0.0;

        A8_mst_struct.Pair tohead = new A8_mst_struct.Pair(s, 0.0);
        pq.add(tohead);

        while (!pq.isEmpty()) {
            A8_mst_struct.Pair p = pq.poll();// 取最小pir
            relax(G, p.toVertrix);
        }

    }

    public void relax(A8_mst_struct.EdgeWeightedDigraph G, int v) {

        for (A8_mst_struct.DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;

                A8_mst_struct.Pair p = new A8_mst_struct.Pair(w, distTo[w]);
                // 遍历pq，如果有这个边，就更新，如果没有，就加入
                if (pq.contains(p)) {
                    pq.remove(p);

                }
                pq.add(p);
            }
        }
    }

  
}
