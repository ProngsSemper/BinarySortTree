package demo;

/**
 * @author Prongs
 * @date 2019/12/7 15:17
 */
public class BinarySortTree {
    Node root;

    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public void midShow() {
        if (root != null) {
            root.midShow(root);
        }
    }

    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    public int deleteMin(Node node) {
        Node target = node;
        while (target.left != null) {
            target = target.left;
        }
        delete(target.value);
        return target.value;
    }

    public void delete(int value) {
        if (root == null) {
            return;
        }
        Node target = search(value);
        if (target == null) {
            return;
        }

        Node parent = searchParent(value);
        //删除叶子节点
        if (target.left == null && target.right == null) {
            if (parent.left.value == value) {
                parent.left = null;
            } else {
                parent.right = null;
            }
            //删除有两颗子树的节点
        } else if (target.left != null && target.right != null) {
            int min = deleteMin(target.right);
            target.value = min;
            //删除只有一颗子树的节点
        } else {
            if (target.left != null) {
                if (parent.left.value == value) {
                    parent.left = target.left;
                } else {
                    parent.right = target.left;
                }
            } else {
                if (parent.left.value == value) {
                    parent.left = target.right;
                } else {
                    parent.right = target.right;
                }
            }
        }

    }
}
