import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;




/* title: 最小生成树 prim算法
 * complexity: O(lgn)
 * description:
    核心思想：一个顶点邻接边中， 最小的边，一定是属于最小生成树的。
    思路： 将顶点所有边，放到最小堆中，每次取出最小的边，如果这条边的两个顶点都已经在最小生成树中，就不要这条边，否则，就将这条边加入到最小生成树中。
 * remember:
 *  有优化空间，可以使用索引优先队列。 可以不把所有边加入 pq 中，而是只把和最小生成树相邻的边加入 pq 中。
 */

public class A8_primMST {
    private boolean[] marked; // 最小生成树的顶点
    private Queue<A8_mst_struct.Edge> mst; // 最小生成树的边
    private PriorityQueue<A8_mst_struct.Edge> pq; // 横切边（包括失效的边）

    public A8_primMST(A8_mst_struct.EdgeWeightedGraph G){
        pq = new PriorityQueue<>();
        marked = new boolean[G.V()];
        mst = new LinkedList<>();
        
        visit(G, 0);
        while(!pq.isEmpty()){
            A8_mst_struct.Edge e = pq.poll();// 取最小的边
            int v = e.either(), w = e.other(v);
            if (marked[v] && marked[w]) continue; // 如果这条边的两个顶点都已经在最小生成树中，就不要这条边
            mst.add(e); // 将这条边加入到最小生成树中
            if(!marked[v]) visit(G, v);
            if(!marked[w]) visit(G, w);
        }
        


    }

    // 访问顶点v， 并加入队列
    private void visit(A8_mst_struct.EdgeWeightedGraph G, int v){
        marked[v] = true;
        for(A8_mst_struct.Edge e: G.adj(v)){
            if(!marked[e.other(v)])
                pq.add(e);
        }
    }

    public Iterable<A8_mst_struct.Edge> edges(){
        return mst;
    }

}
