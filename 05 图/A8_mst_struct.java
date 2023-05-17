import java.util.LinkedList;
import java.util.Queue;
import java.util.PriorityQueue;

/* title: 最小生成数的数据结构
 * complexity: O(lgn)
 * description:
   1. Edge 边
   2. edgeWeightedGraph 图
   3. mst 的数据结构
 * remember:
 *  
 */
public class A8_mst_struct {
    // 边的数据结构
    public static class Edge implements Comparable<Edge> {
        private final int v; // 顶点之一
        private final int w; // 另一个顶点
        private final double weight; // 边的权重

        public Edge(int v, int w, double weight) {
            this.v = v;
            this.w = w;
            this.weight = weight;

        }

        public double weight() {
            return weight;
        }

        public int either() {
            return v;
        }

        public int other(int vertex) {
            if (vertex == v)
                return w;
            else if (vertex == w)
                return v;
            else
                throw new RuntimeException("Inconsistent edge");
        }

        @Override
        public int compareTo(Edge that) {
            if (this.weight() < that.weight())
                return -1;
            else if (this.weight() > that.weight())
                return 1;
            else
                return 0;
        }

        public String toString() {
            return String.format("%d-%d %.2f", v, w, weight);
        }
    }

    // 带权重的无向图 数据结构
    public static class EdgeWeightedGraph {
        private final int V; // 顶点总数
        private int E; // 边的总数
        private LinkedList<Queue<Edge>> adj; // 邻接表

        public EdgeWeightedGraph(int V) {
            this.V = V;
            this.E = 0;
            adj =  new LinkedList<>();
            for (int v = 0; v < V; v++) {
                adj.add(new LinkedList<Edge>());
            }
        }

        public int V() {
            return V;
        }

        public int E() {
            return E;
        }

        public void addEdge(Edge e) {
            int v = e.either(), w = e.other(v);
            adj.get(v).add(e);
            adj.get(w).add(e);
            E++;
        }

        public Iterable<Edge> adj(int v) {
            return adj.get(v);
        }
        // 返回所有的边
        public Iterable<Edge> edges() {
            Queue<Edge> b = new LinkedList<Edge>();
            for (int v = 0; v < V; v++) {
                for (Edge e : adj.get(v)) {
                    // 不存在 v -> v 的边
                    if (e.other(v) > v)
                        b.add(e);
                }
            }
            return b;
        }
    }
    // 加权有向图的数据结构
    public static class DirectedEdge {
        private final int v; // 边的起点
        private final int w; // 边的终点
        private final double weight; // 边的权重

        public DirectedEdge(int v, int w, double weight) {
            this.v = v;
            this.w = w;
            this.weight = weight;

        }

        public double weight() {
            return weight;
        }

        public int from() {
            return v;
        }

        public int to() {
            return w;
        }

        public String toString() {
            return String.format("%d->%d %.2f", v, w, weight);
        }
    }

    // 加权有向图的数据结构
    public static class EdgeWeightedDigraph {
        private final int V; // 顶点总数
        private int E; // 边的总数
        private LinkedList<Queue<DirectedEdge>> adj; // 邻接表

        public EdgeWeightedDigraph(int V) {
            this.V = V;
            this.E = 0;
            adj =  new LinkedList<>();
            for (int v = 0; v < V; v++) {
                adj.add(new LinkedList<DirectedEdge>());
            }
        }

        public int V() {
            return V;
        }

        public int E() {
            return E;
        }

        public void addEdge(DirectedEdge e) {
            int v = e.from();
            adj.get(v).add(e);
            E++;
        }

        public Iterable<DirectedEdge> adj(int v) {
            return adj.get(v);
        }
        // 返回所有的边
        public Iterable<DirectedEdge> edges() {
            Queue<DirectedEdge> b = new LinkedList<DirectedEdge>();
            for (int v = 0; v < V; v++) {
                for (DirectedEdge e : adj.get(v)) {
                    b.add(e);
                }
            }
            return b;
        }
    }

    // 工具数组
    public static class Pair{
        public int toVertrix; // 目标顶点
        public double sumDist; // 举例
        public Pair(int toVertrix, double sumDist) {
            this.toVertrix = toVertrix;
            this.sumDist = sumDist;
        }
        
        public boolean equals(Object obj) {
            if(!(obj instanceof Pair)) return false;
            return ((Pair)obj).toVertrix == toVertrix;
        }

    }
}
