import java.util.ArrayList;
// import java.util.Iterator;
// // import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* title: 有向图
 * complexity: O(lgn)
 * description:
    基本的数据结构,
 * remember:
 *  邻接表（顶点是链表）
 * 区别 addEdge
 */

public class A5_digraph {

    private final int V; // 顶点数
    private int E; // 边的数目
    private List<LinkedList<Integer>> adj; // 邻接表


    public A5_digraph(int v){
        this.V = v;
        this.E = 0;
        adj = new ArrayList<LinkedList<Integer>>();
        for (int i = 0; i < V; i++){
            adj.add(new LinkedList<Integer>());
        }
    }
    // 添加 Edge
    public void addEdge(int v, int w){
        adj.get(v).add(w);
        E++;
    }
    // 删除 Edge
    public void deleteEdge(int v, int w){
        adj.get(v).remove(w);
        E--;
    }



    // 顶点数
    public int V() {
        return V;
    }

    // 边的数目
    public int E() {
        return E;
    }

    // 和 v 相邻的所有顶点

    public Iterable<Integer> adj(int v) {
        return adj.get(v);
    }
}
