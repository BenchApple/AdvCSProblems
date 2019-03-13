import java.util.*;

// Benjamin Chappell

public class HuffmanDecoder
{
    public static void main(String[] args) throws java.io.IOException
    {
        BinaryTreeNode tree = buildTree();
        ArrayList<BinaryTreeNode<Character>> traversal = tree.levelOrderTraversal();
        
        for (BinaryTreeNode i : traversal)
        {
            System.out.println(i.getData());
        }

        //decode(tree);
    }

    private static BinaryTreeNode buildTree() throws java.io.IOException
    {
        BinaryTreeNode current = new BinaryTreeNode<Character>();

        if ((char)System.in.read() == '0')
        {
            current.setLeftChild(buildTree());
            current.setRightChild(buildTree());
        }
        else if ((char)System.in.read() == '1')
        {
            current.setData((char)System.in.read());
        }

        return current;
    }

    private static void decode(BinaryTreeNode root) throws java.io.IOException
    {
        int next = System.in.read();
        BinaryTreeNode currentNode = root;

        while (next != -1)
        {
            if (currentNode.getLeftChild() == null)
            {
                System.out.println(currentNode.getData());
                currentNode = root;
            }
            else if ((char)next == '0')
            {
                currentNode = currentNode.getLeftChild();
                next = System.in.read();
            }
            else if ((char)next == '1')
            {
                currentNode = currentNode.getRightChild();
                next = System.in.read();
            }
        }
    }
}