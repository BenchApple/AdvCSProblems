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
        this(null);
    }
    
    public BinaryTreeNode(E d)
    {
        this(d, null, null);
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
            int rightHeight = this.rightChild.height();
            int leftHeight = this.leftChild.height();
            
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
        
        if (this != null)
        {
            preordered.add(data);
            preordered.addAll(leftChild.preorder());
            preordered.addAll(rightChild.preorder());
        }
        
        return preordered;
    }
    
    public ArrayList<E> postorder()
    {
        ArrayList<E> postordered = new ArrayList<E>();
        
        if (this != null)
        {
            postordered.addAll(leftChild.postorder());
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
            inordered.addAll(leftChild.inorder());
            inordered.add(data);
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
