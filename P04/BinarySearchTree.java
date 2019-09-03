

import java.io.Serializable;
import java.util.NoSuchElementException;

public class BinarySearchTree extends DSAQueue implements Serializable
{
    private class DSATreeNode
    {
        private String key;
        private Object value;
        private DSATreeNode leftChild;
        private DSATreeNode rightChild;

        public DSATreeNode(String inKey, Object inVal)
        {
            if (inKey == null)
            {
                throw new IllegalArgumentException("Invalid key.");
            }
            this.key = inKey;
            this.value = inVal;
            this.leftChild = null;
            this.rightChild = null;
        }

        public String getKey() {
            return key;
        }

        public Object getValue() {
            return value;
        }

        public DSATreeNode getLeftChild() {
            return leftChild;
        }

        public DSATreeNode getRightChild() {
            return rightChild;
        }

        public void setLeftChild(DSATreeNode newLeft) {
            leftChild = newLeft;
        }

        public void setRightChild(DSATreeNode newRight) {
            rightChild = newRight;
        }
    }

    private DSATreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    public void insertNode(String key, Object value) {
        root = insertRecursion(root, key, value);
    }

    private DSATreeNode insertRecursion(DSATreeNode root, String key, Object value)
    {
        if (root == null)
        {
            root = new DSATreeNode(key, value);
        }
        else if (key.equals(root.getKey()))
        {
            throw new IllegalArgumentException("Duplicates found : " + root.getKey());
        }
        else if (key.compareTo(root.getKey()) < 0)
        {
            root.setLeftChild(insertRecursion(root.getLeftChild(), key, value));
        }
        else
            {
            root.setRightChild(insertRecursion(root.getRightChild(), key, value));
        }
        return root;
    }

    public Object findNode(String key) {
        return findRecursion(key, root);
    }

    private Object findRecursion(String key, DSATreeNode root)
    {
        Object value = null;

        if (root == null)
        {
            throw new NoSuchElementException("Key: " + key + " not found");
        }
        else if (key.equals(root.getKey()))
        {
            value = root.getValue();
        }
        else if (key.compareTo(root.getKey()) < 0) {
            value = findRecursion(key, root.getLeftChild());
        }
        else
            {
            value = findRecursion(key, root.getRightChild());
        }
        return value;
    }

    //SECTION FOR DELETING NODE

    public void deleteNode(String key) {
        deleteRecursion(key, root);
    }

    private DSATreeNode deleteRecursion(String key, DSATreeNode currentNode) {
        DSATreeNode updatedNode = currentNode;

        if (currentNode == null)
        {
            throw new NoSuchElementException("Tree is empty");
        }
        else if (key.equals(currentNode.getKey()))
        {
            updatedNode = delNode(key, currentNode);
        }
        else if (key.compareTo(currentNode.getKey()) < 0)
        {
            currentNode.setLeftChild(deleteRecursion(key, currentNode.getLeftChild()));
        }
        else {
            currentNode.setRightChild(deleteRecursion(key, currentNode.getRightChild()));
        }

        return updatedNode;
    }

    private DSATreeNode delNode(String key, DSATreeNode delNode)
    {
        DSATreeNode updatedNode = null;

        if (delNode.getLeftChild() == null && delNode.getRightChild() == null)
        {
            updatedNode = null;
        }
        else if (delNode.getLeftChild() != null && delNode.getRightChild() == null)
        {
            updatedNode = delNode.getLeftChild();
        }
        else if (delNode.getLeftChild() == null && delNode.getRightChild() != null)
        {
            updatedNode = delNode.getRightChild();
        }
        else
            {
            updatedNode = promoteSuccessor(delNode.getRightChild());
            if (updatedNode != delNode.getRightChild())
            {
                updatedNode.setRightChild(delNode.getRightChild());
            }
            updatedNode.setLeftChild(delNode.getLeftChild());
        }

        return updatedNode;
    }

    private DSATreeNode promoteSuccessor(DSATreeNode currentNode)
    {
        DSATreeNode successor = currentNode;

        if (currentNode.getLeftChild() == null)
        {
            successor = currentNode;
        }
        else
            {
            if (currentNode.getLeftChild() != null)
            {
                successor = promoteSuccessor(currentNode.getLeftChild());
            }
            if (successor == currentNode.getLeftChild())
            {
                currentNode.setLeftChild(successor.getRightChild());
            }
        }
        return successor;
    }

    public Object inOrderTranversal()
    {
        DSAQueue dsaQueue = new DSAQueue();
        return inorderRecursion(root, dsaQueue);
    }

    private DSAQueue inorderRecursion(DSATreeNode node, DSAQueue inOrderQueue)
    {
        if (node != null)
        {
            inorderRecursion(node.getLeftChild(), inOrderQueue);
            inOrderQueue.enqueue(node.getKey());
            System.out.println("Enqueue : " + node.getKey());
            inorderRecursion(node.getRightChild(), inOrderQueue);
        }

        return inOrderQueue;
    }

    public Object preOrderTranversal()
    {
        DSAQueue preOrderQueue = new DSAQueue();
        return preOrderRecursion(root, preOrderQueue);
    }

    private DSAQueue preOrderRecursion(DSATreeNode node, DSAQueue preOrderQueue)
    {
        if (node != null)
        {
            //visit the root
            preOrderQueue.enqueue(node.getKey());
            System.out.println("Enqueue : " + node.getKey());
            //transverse on left
            preOrderRecursion(node.getLeftChild(), preOrderQueue);
            //transverse on right
            preOrderRecursion(node.getRightChild(), preOrderQueue);
        }
        return preOrderQueue;
    }

    public Object postOrderTranversal()
    {
        DSAQueue postOrderQueue = new DSAQueue();
        return postOrderRecursion(root, postOrderQueue);

    }

    private DSAQueue postOrderRecursion(DSATreeNode node, DSAQueue postOrderQueue)
    {
        if (node != null)
        {
            //tranverse on left
            postOrderRecursion(node.getLeftChild(), postOrderQueue);
            //tranverse on right
            postOrderRecursion(node.getRightChild(), postOrderQueue);
            // visit the root
            postOrderQueue.enqueue(node.getKey());
            System.out.println("Enqueue : " + node.getKey());
        }

        return postOrderQueue;
    }

    public int findMin()
    {
        int min;
        min = minRec(root);
        return min;
    }

    private int minRec(DSATreeNode currentNode)
    {
        int minimumkey;

        if (currentNode.getLeftChild() != null)
        {
            minimumkey = minRec(currentNode.getLeftChild());
        }
        else
            {
            minimumkey = Integer.parseInt(currentNode.getKey());
            }

        return minimumkey;
    }

    public int findMax()
    {
        int max;
        max = maxRec(root);

        return max;
    }

    private int maxRec(DSATreeNode currentNode)
    {
        int maximumkey;
        if (currentNode.getRightChild() != null)
        {
            maximumkey = maxRec(currentNode.getRightChild());
        }
        else
            {
            maximumkey = Integer.parseInt(currentNode.getKey());
            }

        return maximumkey;
    }

    public int getHeight()
    {
        int height;
        height = heightRec(root);
        return height;
    }

    private int heightRec(DSATreeNode startNode)
    {
        int LeftSide, RightSide, height;

        if (startNode == null)
        {
            height = -1;
        } else
            {
            LeftSide = heightRec(startNode.getLeftChild());
            RightSide = heightRec(startNode.getRightChild());

            if (LeftSide > RightSide)
            {
                height = LeftSide + 1;
            }
            else
                {
                height = RightSide + 1;
            }
        }
        return height;
    }

    public boolean balance()
    {
        return isBalance(root);
    }

    private boolean isBalance(DSATreeNode treeNode)
    {
        boolean balance = false;
        int left, right;


        left = countLeftside(treeNode,treeNode.getRightChild()) - 1;
        System.out.println(left);
        right = countRightSide(treeNode,treeNode.getLeftChild()) - 1;
        System.out.println(right);


        if(treeNode ==  null)
        {
            balance = true;
        }
        else
        {
            if (Math.abs(left-right) <= 1)
            {
                balance = true;
            }
        }

        return balance;
    }

    private int countLeftside(DSATreeNode node, Object curseNode)
    {
        int count=0;
        if (node!=null && node != curseNode)
        {
            count += 1+countLeftside(node.getLeftChild(),curseNode);
            count += countLeftside(node.getRightChild(),curseNode);
        }
        return count;
    }

    private int countRightSide(DSATreeNode node, Object curseNode)
    {
        int count = 0;
        if (node != null && node != curseNode)
        {
            count += 1+countRightSide(node.getRightChild(),curseNode);
            count += countRightSide(node.getLeftChild(),curseNode);
        }

        return count;

    }
}