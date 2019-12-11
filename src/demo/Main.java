package demo;

/**
 * @author Prongs
 * @date 2019/12/7 15:22
 * 二叉排序树
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{2,1,4,3,5,6};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i : arr) {
            binarySortTree.add(new Node(i));
        }
        System.out.println(binarySortTree.root.height());
        System.out.println(binarySortTree.root.value);
//        binarySortTree.midShow();
//        System.out.println("------------");
//        binarySortTree.delete(1);
//        binarySortTree.midShow();
    }
}
