import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class TreeNodeTest extends BinarySearchTree
{
    public static void main(String [] args)
    {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insertNode("30","A");
        bst.insertNode("18","B");
        bst.insertNode("50","C");
        bst.insertNode("24","D");
        bst.insertNode("36","E");
        bst.insertNode("51","F");

        System.out.println("Testing inOrder Transversal: ");
        System.out.println(bst.inOrderTranversal());

        System.out.println();

        System.out.println("Testing Pre Order Transversal: ");
        System.out.println(bst.preOrderTranversal());

        System.out.println();

        System.out.println("Testing Post Order Transversal: ");
        System.out.println(bst.postOrderTranversal());

        System.out.println();

        System.out.println("testing Height Tree:");
        System.out.println("Tree Height: " +bst.getHeight());

        System.out.println();

        System.out.println("Testing Finding Min key and Max Key");
        System.out.println("Maximum Key: " + bst.findMax());
        System.out.println("Minimum Key: " + bst.findMin());

        System.out.println();

        System.out.println("Checking if the tree is balance\n" +
                "For a balanced tree, the method will return TRUE and FALSE for unbalance tree");
        System.out.println("Tree Balance ? " +bst.balance());
    }
}