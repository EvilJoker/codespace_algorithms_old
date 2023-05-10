/* title: 求树的高度/深度
 * complexity: O(n)
 * description:
 *  前中后
 * 
 * remember:
 * 递归
 */

public class A2_deep_height {

    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 前序
    public static int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
    }

 

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        int deep = treeDepth(root);

        System.out.println(deep);
    }
}
