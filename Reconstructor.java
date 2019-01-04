//Benjamin Chappell

import java.util.*;

public class Reconstructor
{
    public static void main(String[] args)
    {
        //Get input from the external file or the keyboard to get the individual lists.
        Scanner keyboard = new Scanner(System.in);
        
        ArrayList<Integer> enteredPreorder = new ArrayList<Integer>();
        ArrayList<Integer> enteredInorder = new ArrayList<Integer>();
        
        //Set both preorder string and inorder string to their respective lines being input from the console.
        String preorderStr = keyboard.nextLine();
        String inorderStr = keyboard.nextLine();
        
        //Set two scanners to the two lines that were read in from the console or the inputted file.
        Scanner preorderScan = new Scanner(preorderStr);
        Scanner inorderScan = new Scanner(inorderStr);
        
        //Get the preorder input.
        while (preorderScan.hasNextInt())
        {
            enteredPreorder.add(preorderScan.nextInt());
        }
        System.out.println(enteredPreorder);
        
        //Get the inorder input.
        while (inorderScan.hasNextInt())
        {
            enteredInorder.add(inorderScan.nextInt());
        }
        System.out.println(enteredInorder);
        
        BinaryTreeNode<Integer> reconstructedTree = reconstruct(enteredPreorder, enteredInorder); //Reconstruct the Tree
        ArrayList<BinaryTreeNode<Integer>> levelOrderedReconTree = reconstructedTree.levelOrder();
        for (BinaryTreeNode<Integer> node : levelOrderedReconTree)
        {
            System.out.print(node.data + " ");
            
            if (
        }
    }
    
    //Shell method for the actual reconstructor.
    public static BinaryTreeNode<Integer> reconstruct(ArrayList<Integer> preordered, ArrayList<Integer> inordered)
    {
        return reconstruct(preordered, 0, preordered.size() - 1, inordered, 0, inordered.size() - 1);
    }
    
    //Reconstructs a binary tree given the preorder and inorder results of a tree, also given starting and ending indices for those two lists.
    public static BinaryTreeNode<Integer> reconstruct(ArrayList<Integer> pre, int preStart, int preEnd, ArrayList<Integer> in, int inStart, int inEnd)
    {
        if ((preStart <= preEnd) || (inStart <= inEnd)) //As long as there is at least one element in the array, execute the code. Second half of or statement is redundant, since the lists should be the same size.
        {
            int rootInt = pre.get(preStart); //The root of the current tree is the first node in the preorder list, get it and store the data of it.
            BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootInt); //Create the root node using the data gained from the previous line.
            
            int inorderRootIndex = in.indexOf(rootInt); //Find the index of the root integer in the inorder list, creating the basis for how to split the list.

            /*
             *Reconstruct the left half of the array. Pass in the entire preorder list and inorder list. The start of the preorder list for this half 
             *of the tree is the previous start plus one. The inorder list starts in the same place as before, and the inorder list ends one below the
             *index of the root in the inorder list. Since the two lists must be the same size, the preorder list ends at the index the same distance away from 
             *the new preorder start as the new inorder end does from the new inorder start.
             */    
            root.setLeftChild(reconstruct(pre, preStart + 1, (preStart + (inorderRootIndex - inStart)), in, inStart, inorderRootIndex - 1));
            
            /*
             *Reconstruct the right half of the array. Pass in the entire preorder list and inorder list. The end of the preorder list for this half 
             *of the tree is the same as the previous ending of the list. The inorder list starts one after the index of the root plus one, and the inorder list ends 
             *in the same place as before. Since the two lists must be the same size, the preorder list begins at the index the same distance away from 
             *the new preorder end as the new inorder end does from the new inorder start.
             */    
            root.setRightChild(reconstruct(pre, (preStart + (inorderRootIndex - inStart)) + 1, preEnd, in, inorderRootIndex + 1, inEnd));
            
            return root;
        }
        else
        {
            return null;
        }
    }
}
