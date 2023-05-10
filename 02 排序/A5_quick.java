/* title: 快速排序
 * complexity: O(nlgn)
 * description:
 *  1. 选择一个元素作为切分元素，将数组分成两个子数组，小于切分元素的在左边，大于切分元素的在右边
 *  2. 类似归并排序，但是不需要合并。
 * remember:
 *  想象成坑位
 * partition
 */

public class A5_quick {
    public static void sort(Comparable[] a) {
        quickSort(a, 0, a.length - 1);

    }

    public static void quickSort(Comparable[] a, int lo, int hi) {
        // 递归判断条件
        if (lo >= hi) {
            return;
        }
        int s = partition(a, lo, hi);
        quickSort(a, lo, s - 1);
        quickSort(a, s + 1, hi);

    }

    // 返回切分元素的位置， 左边小于切分，右边都大于切分
    public static int partition(Comparable[] a, int lo, int hi) {
        // 选择切分元素
        Comparable v = a[lo];
        // 切分序号
        int s = lo;
        // 从左到右遍历
        for (int i = lo + 1; i <= hi; i++) {
            if (less(a[i], v)) {
                // 填充到坑位，坑位右移, 新坑位原先的值填充到当前位置 i
                a[s++] = a[i];
                a[i] = a[s];
            }
        }
        a[s] = v;
        return s;

    }

    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
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
