//Benjamin Chappell

import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class BinaryTreeTest
{
    public static void main(String args[])
    {
        System.out.println("You've been gnomed");
        ArrayList<BinaryTreeNode<Integer>> test = new ArrayList<BinaryTreeNode<Integer>>();
        
        for (int i = 0; i < 10; i++)
        {
            test.add(new BinaryTreeNode<Integer>(i));
        }
       
        
        test.get(0).setLeftChild(test.get(1));     test.get(0).setRightChild(test.get(2));
        test.get(1).setLeftChild(test.get(3));     test.get(1).setRightChild(test.get(4));
        test.get(2).setLeftChild(null);            test.get(2).setRightChild(test.get(5));
        test.get(3).setLeftChild(null);            test.get(3).setRightChild(null);
        test.get(4).setLeftChild(test.get(6));     test.get(4).setRightChild(test.get(7));
        test.get(5).setLeftChild(null);            test.get(5).setRightChild(test.get(9));
        //test.get(6).setLeftChild(null);            test.get(6).setRightChild(null);
        //test.get(7).setLeftChild(null);            test.get(7).setRightChild(null);
        //test.get(8).setLeftChild(null);            test.get(8).setRightChild(null);
        test.get(9).setLeftChild(test.get(8));            test.get(9).setRightChild(null);
        
        
        System.out.println("Preorder " + test.get(0).preorder());
        System.out.println("Inorder " + test.get(0).inorder());
        System.out.println("Postorder " + test.get(0).postorder());
        System.out.println("Level Order " + test.get(0).levelOrder());
        System.out.println("Height of root " + test.get(0).height());
    }
}
