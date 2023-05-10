/* title: 二分查找
 * complexity: O(lgn)
 * description:

 * remember:
 * 
 */

public class A1_BS {

    // 返回目标值的下标，如果不存在，返回 -1
    public static int rank(Comparable[] sorted, Comparable v){
        int lo = 0;
        int hi = sorted.length - 1;

        while (lo <= hi){
            int mid = lo + (hi - lo) / 2;
            int cmp = v.compareTo(sorted[mid]);
            if (cmp < 0){
                hi = mid - 1;
            } else if (cmp > 0){
                lo = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Integer[] a = {1, 3, 5, 7, 9};
        assert rank(a, 5) == 2: "find error";
        assert rank(a, 10) == -1: "find error when not exist";
    }
}
