package demo;

/**
 * @author Prongs
 * @date 2019/12/7 15:22
 * 二叉排序树
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 3, 10, 12, 5, 1, 9};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i : arr) {
            binarySortTree.add(new Node(i));
        }

        binarySortTree.midShow();
        System.out.println("------------");
        binarySortTree.delete(1);
        binarySortTree.midShow();
    }
}
