import java.io.IOException;

import com.sun.source.tree.BinaryTree;

// Benjamin Chappell

public class HuffmanDecoder
{
    public static void main(String[] args) throws java.io.IOException
    {
        BinaryTreeNode root = new BinaryTreeNode<>();
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
}