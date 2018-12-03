//Benjamin Chappell

import java.util.ArrayList

public class BinaryTreeNode<E>
{
    private E data;
    private BinaryTreeNode<E> leftChlld;
    private BinaryTreeNode<E> rightChild;

    public BinaryTreeNode() 
    {
        data = null
        leftChild = null
        rightChild = null
    }
    
    public BinaryTreeNode(E d)
    {
        data = d
        leftChild = null
        rightChild = null
    }
    
    public BinaryTreeNode(E d, BinaryTreeNode<E> rChild, BinaryTreeNode<E> lChild)
    {
        data = d
        rightChild = rChild
        liftChild = lChild
    }
    
    public static getData()
    {
        return data
    }
    
    public static setData(E d)
    {
        data = d
    }
    
    public static getLeftChild()
    {
        return leftChild
    }
