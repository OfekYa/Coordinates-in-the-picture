public class Main
{
    public static void preOrder(AVLNode node)
   {
        if (node != null)
        {
            System.out.print(node.getKey() + " ");
            preOrder(node.getLeftChild());
            preOrder(node.getRightChild());
        }
    }

    public static void Main(String[] args) {
        AVLNode node =new AVLNode(140,48,null,null,null);
        AVL tree = new AVL(node);
        /* Constructing tree given in the above figure */
        tree.insert(246, 107);
        tree.insert(295, 50);
        tree.insert(455, 51);
        tree.insert(546, 98);
        tree.insert(506, 202);
        tree.insert(252, 172);
        System.out.println("Preorder traversal" +
                " of constructed tree is : ");
        preOrder(tree.getRoot());



    }



}
