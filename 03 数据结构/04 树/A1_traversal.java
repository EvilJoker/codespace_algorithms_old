/* title: 树的遍历
 * complexity: O(n)
 * description:
 *  前中后
 * 
 * remember:
 * 树的类， 方法
 */

public class A1_traversal {

    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 前序
    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    // 中序
    public static void midOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        midOrder(root.left);
        System.out.println(root.val);
        midOrder(root.right);
    }

    // 后序
    public static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        preOrder(root);
        midOrder(root);
        postOrder(root);

    }
}
