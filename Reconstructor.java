//Benjamin Chappell

import java.util.*;

public class Reconstructor
{
    public void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        
        ArrayList<Integer> enteredPreorder = enterPreorder(keyboard);
        ArrayList<Integer> enteredInorder = enterInorder(keyboard, enteredPreorder.size());
        
        
    }
    
    public ArrayList<Integer> enterPreorder(Scanner keyboard)
    {
        ArrayList<Integer> enteredPreorder = new ArrayList<Integer>();
        
        System.out.println("How many elements would you like in your preorder tree?");
        int length = keyboard.nextInt();
        
        for (int i = 0; i < length; i++)
        {
            System.out.println("What element would you like next in your preorder list?");
            enteredPreorder.add(keyboard.nextInt());
        }
        
        return enteredPreorder;
    }    
    
    public ArrayList<Integer> enterInorder(Scanner keyboard, int length)
    {
        ArrayList<Integer> enteredInorder = new ArrayList<Integer>();
        
        for (int i = 0; i < length; i++)
        {
            System.out.println("What element would you like next in your inorder list?");
            enteredInorder.add(keyboard.nextInt());
        }
        
        return enteredInorder;
    }
    
    public BinaryTreeNode<Integer> reconstruct(ArrayList<Integer> preordered, ArrayList<Integer> inordered)
    {
        return reconstruct(preordered, 0, preordered.size(), inordered, 0, inordered.size());
    }
    
    public BinaryTreeNode<Integer> reconstruct(ArrayList<Integer> pre, int preStart, int preEnd, ArrayList<Integer> in, int inStart, int inEnd)
    {
        if ((preStart < preEnd) || (inStart < inEnd))
        {
            int rootInt = pre.get(0);
            BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootInt);
            
            int rootIndex = in.indexOf(rootInt);
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
