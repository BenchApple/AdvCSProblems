import java.util.*;

// Benjamin Chappell

public class HuffmanDecoder
{
    public static void main(String[] args) throws java.io.IOException
    {
        BinaryTreeNode tree = buildTree();

        decode(tree);
    }

    //Build the tree from the read in data.
    private static BinaryTreeNode<Character> buildTree() throws java.io.IOException
    {
        BinaryTreeNode current = new BinaryTreeNode<Character>();

        int next = System.in.read();
        //0 indicates a new node to be made inorder.
        if ((char)next == '0')
        {
            //Recursively build the right and half sides of the trees inorder.
            current.setLeftChild(buildTree());
            current.setRightChild(buildTree());
        }
        // 1 indicates a new leaf to be made with the data being the character following the 1.
        else if ((char)next == '1')
        {
            current.setData((char)(System.in.read()));
        }

        return current;
    }

    // Decode the message using the created tree and the read in data.
    private static void decode(BinaryTreeNode<Character> root) throws java.io.IOException
    {
        //Read in the first character as an integer, and store the current node as the root of the tree.
        int next = System.in.read();
        BinaryTreeNode<Character> currentNode = root;

        // Loop until there is nothing left to read, where the system will read an integer negative 1.
        while (next != -1)
        {
            // Move to the left in the tree when the next read is a 0.
            if ((char)next == '0')
            {
                currentNode = currentNode.getLeftChild();
            }
            // Move to the right in the tree when the next read is 1.
            else if ((char)next == '1')
            {
                currentNode = currentNode.getRightChild();
            }

            // If the current node is a leaf, print the data in the node and reset the current node to be the root.
	        if (currentNode.getLeftChild() == null)
	        {
		        System.out.print(currentNode.getData());
		        currentNode = root;
	        }
	    next = System.in.read();
        }
    }
}
