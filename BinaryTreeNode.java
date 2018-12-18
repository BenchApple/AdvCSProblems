//Benjamin Chappell

import java.util.*;

public class Reconstructor
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        
        ArrayList<Integer> enteredPreorder = new ArrayList<Integer>();
        ArrayList<Integer> enteredInorder = new ArrayList<Integer>();
        
        String preorderStr = keyboard.nextLine();
        String inorderStr = keyboard.nextLine();
        
        Scanner preorderScan = new Scanner(preorderStr);
        Scanner inorderScan = new Scanner(inorderStr);
        
        while (preorderScan.hasNextInt())
        {
            enteredPreorder.add(preorderScan.nextInt());
        }
        System.out.println(enteredPreorder);
        
        while (inorderScan.hasNextInt())
        {
            enteredInorder.add(inorderScan.nextInt());
        }
        System.out.println(enteredInorder);
        
        BinaryTreeNode<Integer> reconstructedTree = reconstruct(enteredPreorder, enteredInorder);
        System.out.println(enteredPreorder);
        System.out.println(reconstructedTree.preorder());
        System.out.println(enteredInorder);
        System.out.println(reconstructedTree.inorder());
    }
    
    public static BinaryTreeNode<Integer> reconstruct(ArrayList<Integer> preordered, ArrayList<Integer> inordered)
    {
        return reconstruct(preordered, 0, preordered.size() - 1, inordered, 0, inordered.size() - 1);
    }
    
    public static BinaryTreeNode<Integer> reconstruct(ArrayList<Integer> pre, int preStart, int preEnd, ArrayList<Integer> in, int inStart, int inEnd)
    {
        if ((preStart <= preEnd) && (inStart <= inEnd))
        {
            System.out.println(preStart + "-PreStart");
            System.out.println(preEnd + "-PreEnd"); 
            System.out.println(inStart + "-inStart"); 
            System.out.println(inEnd + "-inEnd"); 
            
            System.out.println("Root is " + pre.get(preStart));
            
            int rootInt = pre.get(preStart);
            BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootInt);
            
            int rootIndex = in.indexOf(rootInt);
            System.out.println(rootIndex);
            System.out.println();
            if (rootIndex < 0)
                System.out.println("Item doesn't exist, prepare for error");
                
            root.setLeftChild(reconstruct(pre, preStart + 1, rootIndex, in, inStart, rootIndex - 1));
            root.setRightChild(reconstruct(pre, rootIndex + 1, preEnd, in, rootIndex + 1, inEnd));
            
            return root;
        }
        else
        {
            return null;
        }
    }
}
