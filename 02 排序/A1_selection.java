import java.util.ArrayList;

/* title: 选择排序
 * complexity: O(n^2)
 * description:
 *  遍历选择数据中最小的元素，将其与第一个元素交换位置。
 * 
 * remember:
 * 3 个函数： sort, less, exch
 */

public class A1_selection {

    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i; j < a.length; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.println(a[i] + " ");
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1]))
                return false;
        return true;
    }

    public static void main(String[] args) {
        Integer[] A = { 1, 3, 0, 7, 9, 5 };

        sort(A);

        assert isSorted(A) : "Not Sorted";

    }

}