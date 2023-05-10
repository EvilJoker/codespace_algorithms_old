/* title: 归并排序
 * complexity: O(nlgn)
 * description:
 *  将数组分成两个子数组，分别进行归并排序，最后合并两个有序数组
 *  merge: 原地排序， 借用一个辅助数组，将两个有序数组合并
 *  merge: 模拟插入排序，将两个有序数组合并
 * remember:
 * 2 个函数： merge 合并数组， sort 进行递归
 */

public class A4_merge {
    public static void sort(Comparable[] a) {
        merage_sort(a, 0, a.length - 1);
    }

    public static void merage_sort(Comparable[] a, int lo, int hi) {
        // 递归判断条件
        if (hi <= lo) {
            return;
        }
        // 递归
        int mid = lo + (hi - lo) / 2;
        merage_sort(a, lo, mid);
        merage_sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    // 数组1： a[lo] ~ a[mid]； 数组2： a[mid+1] ~ a[hi]
    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        // // 原地
        // merge_aux(a, lo, mid, hi);
        // 本地排序
        merge_local(a, lo, mid, hi);
    }

    public static void merge_aux(Comparable[] a, int lo, int mid, int hi) {
        int n = hi - lo + 1;
        Comparable[] aux = new Comparable[n];
        // aux 赋值
        for (int i = 0; i < aux.length; i++) {
            aux[i] = a[lo + i];
        }

        // merge 左平移 lo
        for (int i = 0, j = mid + 1 - lo, k = lo; k <= hi; k++) {
            if (i > mid - lo) {
                a[k] = aux[j++];
            } else if (j > hi - lo) {
                a[k] = aux[i++];
            } else if (less(aux[i], aux[j])) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
            }
        }

    }

    public static void merge_local(Comparable[] a, int lo, int mid, int hi) {
        // 插入排序
        for (int i = mid + 1; i <= hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }

        }
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
