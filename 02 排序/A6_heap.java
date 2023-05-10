
/* title: 堆排序
 * complexity: O(nlgn)
 * description:
 * 1. 维护一个最大堆结构（父节点大于子节点）
 * 2. 将堆顶元素与最后一个元素交换，然后将剩下的元素维护成最大堆
 * 3. 不断缩小最大堆的范围，直到堆的大小为 1
 * remember:
 * 3 个函数： sort, less, exch
 */

public class A6_heap {
    public static void sort(Comparable[] a) {
        // 将整个数组变成最大堆， 自底向上 
        for(int i = a.length/2; i >=0; i--){
            heapify(a, i, a.length);
        }
        // 将堆顶元素与最后一个元素交换，然后将剩下的元素维护成最大堆
        for(int i = a.length-1; i>0;i--){
            exch(a, 0, i);
            heapify(a, 0, i-1);
        }
    }
    // 维护最大堆, 从 i 开始，到 n 结束
    public static void heapify(Comparable[] a, int i, int n) {
        
        // 从 i 开始，到 n 结束
        // n 是堆的大小
        // i 是堆顶元素
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < n && less(a[largest], a[left])) {
            largest = left;
        }

        if (right < n && less(a[largest], a[right])) {
            largest = right;
        }
        if (i != largest) {
            exch(a, i, largest);
            heapify(a, largest, n);
        }
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[j] = a[i];
        a[i] = t;
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i] + " ");
        }
    }

    public static boolean isSorted(Comparable[] a) {

        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {

        Integer[] A = { 1, 3, 0, 7, 9, 5 };

        sort(A);

        assert isSorted(A) : "Not Sorted";
    }

}
