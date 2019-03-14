import java.util.*;

// Benjamin Chappell

public class HuffmanDecoder
{
    public static void main(String[] args) throws java.io.IOException
    {
        BinaryTreeNode tree = buildTree();

        decode(tree);
    }

    private static BinaryTreeNode<Character> buildTree() throws java.io.IOException
    {
        BinaryTreeNode current = new BinaryTreeNode<Character>();

	int next = System.in.read();
        if ((char)next == '0')
        {
            current.setLeftChild(buildTree());
            current.setRightChild(buildTree());
        }
        else if ((char)next == '1')
        {
            current.setData((char)(System.in.read()));
        }

        return current;
    }

    private static void decode(BinaryTreeNode<Character> root) throws java.io.IOException
    {
        int next = System.in.read();
        BinaryTreeNode<Character> currentNode = root;

        while (next != -1)
        {
            if ((char)next == '0')
            {
                currentNode = currentNode.getLeftChild();
            }
            else if ((char)next == '1')
            {
                currentNode = currentNode.getRightChild();
            }

	    if (currentNode.getLeftChild() == null)
	    {
		System.out.print(currentNode.getData());
		currentNode = root;
	    }
	    next = System.in.read();
        }
    }
}
