package demo;

/**
 * @author Prongs
 * @date 2019/12/7 15:13
 */
public class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
        //查询是否平衡
        //右旋转
        if (leftHeight() - rightHeight() >= 2) {
            rightRotate();
        }
        //左旋转
        if (leftHeight() - rightHeight() <= -2) {
            leftRotate();
        }
    }

    /**
     * 右旋转
     */
    private void rightRotate() {
        //创建一个新节点，值等于当前节点值
        Node newRight = new Node(value);
        //新节点右子树设置为当前节点右子树
        newRight.right = right;
        //新节点左子树设置为当前节点左子树的右子树
        newRight.left = left.right;
        //当前节点的值换为左子节点的值
        value = left.value;
        //当前节点的左子树设置为左子树的左子树
        left = left.left;
        //当前节点的右子树设置为新节点
        right = newRight;
    }

    /**
     * 左旋转
     */
    private void leftRotate() {
        Node newLeft = new Node(value);
        newLeft.left = left;
        newLeft.right = right.left;
        value = right.value;
        right = right.right;
        left = newLeft;
    }

    public void midShow(Node node) {
        if (node == null) {
            return;
        }
        node.midShow(node.left);
        System.out.println(node.value);
        node.midShow(node.right);
    }

    public Node search(int value) {
        if (value == this.value) {
            return this;
        } else if (value < this.value) {
            if (left == null) {
                return null;
            }
            return left.search(value);
        } else {
            if (right == null) {
                return null;
            }
            return right.search(value);
        }
    }

    public Node searchParent(int value) {
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        } else {
            if (this.value > value && this.left != null) {
                return this.left.searchParent(value);
            } else if (this.value < value && this.right != null) {
                return this.right.searchParent(value);
            }
        }
        return null;
    }

    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }
}
