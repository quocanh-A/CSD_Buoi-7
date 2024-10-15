public class BSTree {
    private TreeNode root;

    public void insert(int data) {
        root = insert(root, data);
    }

    public TreeNode insert(TreeNode root, int data) {
        if (root == null) {
            root = new TreeNode(data);
            return root;
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        return root;
    }

    public TreeNode search(int key) {
        return searchNode(root, key);
    }

    public TreeNode searchNode(TreeNode root, int key) {
        if (root == null || root.data == key) {
            return root;
        }

        if (key < root.data) {
            return searchNode(root.left, key);
        } else if (key > root.data) {
            return searchNode(root.right, key);
        }
        return null;
    }

    private int maxValue(TreeNode root) {
        int maxValue = root.data;
        while (root.right != null) {
            maxValue = root.right.data;
            root = root.right;
        }
        return maxValue;
    }

    public TreeNode delete(TreeNode root, int key) {
        // TH0: Neu cay rong
        if (root == null) {
            return root;
        }

        if (key < root.data) {
            root.left = delete(root.left, key);
        } else if (key > root.data) {
            root.right = delete(root.right, key);
        } else if (key == root.data) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.data = maxValue(root.left);
            root.left = delete(root.left, root.data);
        }
        return root;
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.data + " ");
        inOrder(root.right);
    }

    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data + " ");
        inOrder(root.left);
        inOrder(root.right);
    }

    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        inOrder(root.right);
        System.out.println(root.data + " ");

    }

}