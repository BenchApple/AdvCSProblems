//Benjamin Chappell

import java.util.ArrayList<E>

public class BinaryTreeNode<E>
{
    private E data;
    private BinaryTreeNode<E> leftChlld;
    private BinaryTreeNode<E> rightChild;

    public BinaryTreeNode() 
    {
        data = null;
        leftChild = null;
        rightChild = null;
    }
    
    public BinaryTreeNode(E d)
    {
        data = d;
        leftChild = null;
        rightChild = null;
    }
    
    public BinaryTreeNode(E d, BinaryTreeNode<E> rChild, BinaryTreeNode<E> lChild)
    {
        data = d;
        rightChild = rChild;
        liftChild = lChild;
    }
    
    public E getData()
    {
        return data;
    }
    
    public void setData(E d)
    {
        data = d;
    }
    
    public BinaryTreeNode<E> getLeftChild()
    {
        return leftChild;
    }
    
    public void setLeftChild(BinaryTreeNode<E> newChild)
    {
        leftChild = newChild;
    }
    
    public BinaryTreeNode<E> getRightChild()
    {
        return rightChild;
    }
    
    public void setRightChild(BinaryTreeNode<E> newChild)
    {
        rightChild = newChild;
    }
    
    public boolean isLeaf()
    {
        if (rightChild == null && leftChild == null)
            return true;
        return false;
    }
    
    public int height()
    {
        if (this.data == null or this.isLeaf())
        {
            return 0;
        }
        else
        {
            int rightHeight = this.rightChild.height();
            int leftChild = this.leftChild.height();
            
            if (rightHeight > leftHeight)
                return 1 + rightHeight
            else
                return 1 + leftHeight
        }
    }   
    
    
    
    public ArrayList<E> preorder()
    {
        ArrayList<E> preordered = new ArrayList<E>;
        
        if (this != null)
        {
            preordered.add(data);
            preordered.addAll(rightChild.preorder());
            preordered.addAll(leftChild.preorder());
        }
        
        return preordered;
    }
    
    public ArrayList<E> postorder()
    {
        
    }
}
