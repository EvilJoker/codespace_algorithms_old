/* title: 二叉搜索树
 * complexity: O(lgn)
 * description:
 * 性质 左小于根，右大于根
 *  基本的 api
 * 1. size 树的节点数量
 * 2. get 查询
 * 3. put 插入
 * 4. delete 删除
 * > 有个重要的性质： 右子树最小的节点，一定大于左子树最大的节点。 所以删除的时候，可以用右子树最小的节点，替换要删除的节点。
 * remember:
 * 口诀： 删除取右最小
 */

public class A3_BST {

    // 左右节点，且包含键值对
    public static class TreeNode {
        int key;
        int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    // 当前树的节点数量
    public static int size(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return size(root.left) + size(root.right) + 1;
    }

    // 查询树的节点,返回 val
    public static int get(TreeNode root, int key) {
        if (root == null) {
            return -1;
        }
        if (root.key == key) {
            return root.val;
        }

        if (key < root.key) {
            return get(root.left, key);
        } else {
            return get(root.right, key);
        }
    }

    // 查询树的节点,返回 val。
    public static void put(TreeNode root, TreeNode node) {
        if (root == null) {
            return;
        }
        if (node.key == root.key) {
            root.val = node.val;
            return;
        }

        if (node.key < root.key) {
            // 1. 左子树为空，直接插入
            if (root.left == null) {
                root.left = node;
                return;
            }
            // 2. 左子树不为空，递归
            put(root.left, node);
        } else {
            // 1. 右子树为空，直接插入
            if (root.right == null) {
                root.right = node;
                return;
            }
            // 2. 右子树不为空，递归
            put(root.right, node);
        }
    }

    // 删除, 返回删除后的树
    public static TreeNode del(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.key) {
            root.left = del(root.left, key);
        } else if (key > root.key) {
            root.right = del(root.right, key);
        } else {
            // 找到了要删除的节点
            if (root.left == null && root.right == null) {
                // 1. 左右子树都为空，直接删除
                return null;
            }
            if (root.left == null) {
                // 2. 左空，右不为空
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode minNode = min(root);
            root.val = minNode.val;
            root.right = del(root.right, minNode.key);
        }
        return root;

    }

    // 获取最小的节点
    public static TreeNode min(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root;
        }

        return min(root.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, 1);
        put(root, new TreeNode(2, 2));
        put(root, new TreeNode(3, 3));
        put(root, new TreeNode(4, 4));
        put(root, new TreeNode(5, 5));
        put(root, new TreeNode(6, 6));

        assert size(root) == 6: "size error";
        del(root, 3);
        assert get(root, 3) == -1: "del error";
    }
}
