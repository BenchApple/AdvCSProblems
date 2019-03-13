import java.io.IOException;

import com.sun.source.tree.BinaryTree;

// Benjamin Chappell

public class HuffmanDecoder
{
    public static void main(String[] args) throws java.io.IOException
    {
        BinaryTreeNode root = buildTree();

    }

    private BinaryTreeNode<> buildTree() throws IOException
    {
        BinaryTreeNode current = new BinaryTreeNode<>();

        if (System.in.read() == 0)
        {
            current.setLeftChild(buildTree());
            current.setRightChild(buildTree());
        }
        else if (System.in.read() == 1)
        {
            current.setData((char)System.in.read());
        }

        return current;
    }

    private void decode(BinaryTreeNode<> root)
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
            else if (next == 0)
            {
                currentNode = currentNode.getLeftChild();
                next = System.in.read();
            }
            else if (next == 1)
            {
                currentNode = currentNode.getRightChild();
                next = System.in.read();
            }
        }
    }
}