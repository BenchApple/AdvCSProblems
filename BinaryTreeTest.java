//Benjamin Chappell

import java.util.Queue;
import java.util.LinkedList;

public class BinaryTreeTest
{
    public static void main(String args[])
    {
        System.out.println("You've been gnomed");
        Object[] test = new Object[10];
        
        for (int i = 0; i < 10; i++)
        {
            (BinaryTreeNode<Integer>)(test[i]) = new BinaryTreeNode<Integer>(i);
        }
       
        /*
        test[0].setRightChild(test[1]);     test[0].setLeftChild(test[2]);
        test[1].setRightChild(test[3]);     test[1].setLeftChild(test[4]);
        test[2].setRightChild(null);        test[2].setLeftChild(test[5]);
        test[3].setRightChild(null);        test[3].setLeftChild(null);
        test[4].setRightChild(test[6]);     test[4].setLeftChild(test[7]);
        test[5].setRightChild(test[8]);     test[5].setLeftChild(test[9]);
        test[6].setRightChild(null);        test[6].setLeftChild(null);
        test[7].setRightChild(null);        test[7].setLeftChild(null);
        test[8].setRightChild(null);        test[8].setLeftChild(null);
        test[9].setRightChild(null);        test[9].setLeftChild(null);
        */
    }
}
