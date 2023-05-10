
/* title: 插入排序
 * complexity: O(n^2)
 * description:
 *  前面的数组想象成一个有序的数组，然后把后面的元素插入到前面的数组中。
 * 
 * remember:
 * 3 个函数： sort, less, exch
 */

public class A2_insertion {
    public static void sort(Comparable[] a) {
        // 插入排序
        for (int i = 1; i < a.length; i++) {
            // 将 a[i] 插入到 a[i-1], a[i-2], a[i-3]...中
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
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
