//Benjamin Chappell

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;

public class BinaryTreeNode<E>
{
    private E data;
    private BinaryTreeNode<E> leftChild;
    private BinaryTreeNode<E> rightChild;

    public BinaryTreeNode() 
    {
        this(null); //Calls the constructor with one argument, passing null in for data.
    }
    
    public BinaryTreeNode(E d)
    {
        this(d, null, null); //Calls the constructor with all three arguments, passing null in for the two children.
    }
    
    public BinaryTreeNode(E d, BinaryTreeNode<E> rChild, BinaryTreeNode<E> lChild)
    {
        data = d;
        rightChild = rChild;
        leftChild = lChild;
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
    
    public boolean isEmpty()
    {
        if (data == null)
            return true;
        return false;
    }
    
    public int height()
    {
        if (this.data == null || this.isLeaf())
        {
            return 0;
        }
        else
        {
            int leftHeight = 0;
            int rightHeight = 0;
            
            if (leftChild != null)
                leftHeight = this.leftChild.height();
            
            if (rightChild != null)   
                rightHeight = this.rightChild.height();
            
            if (rightHeight > leftHeight)
                return 1 + rightHeight;
            return 1 + leftHeight;
        }
    }
    
    public String toString()
    {
        return data.toString();
    }
    
    public ArrayList<E> preorder()
    {
        ArrayList<E> preordered = new ArrayList<E>();
        
        if (data != null)
        {
            preordered.add(data);
            
            if (leftChild != null)
                preordered.addAll(leftChild.preorder());
                
            if (rightChild != null)
                preordered.addAll(rightChild.preorder());
        }
        
        return preordered;
    }
    
    public ArrayList<E> postorder()
    {
        ArrayList<E> postordered = new ArrayList<E>();
        
        if (data != null)
        {
            if (leftChild != null)
                postordered.addAll(leftChild.postorder());
                
            if (rightChild != null)
                postordered.addAll(rightChild.postorder());
                
            postordered.add(data);
        }    
        return postordered;
    }
    
    public ArrayList<E> inorder()
    {
        ArrayList<E> inordered = new ArrayList<E>();
        
        if (this != null)
        {
            if (leftChild != null)
                inordered.addAll(leftChild.inorder());
                
            inordered.add(data);
            
            if (rightChild != null)
                inordered.addAll(rightChild.inorder());
        }
        return inordered;
    }
    
    public ArrayList<E> levelOrder()
    {
        ArrayList<E> levelOrdered = new ArrayList<E>();
        Queue<BinaryTreeNode<E>> levelQueue = new LinkedList<BinaryTreeNode<E>>();
        
        levelQueue.add(this);
        
        while (levelQueue.peek() != null)
        {
            BinaryTreeNode<E> currentNode = levelQueue.poll();
            levelOrdered.add(currentNode.data);
            
            if (currentNode.leftChild != null)
                levelQueue.add(currentNode.leftChild);
                
            if (currentNode.rightChild != null)
                levelQueue.add(currentNode.rightChild);
        }
        return levelOrdered;
    }
}
