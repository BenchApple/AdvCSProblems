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
    
    //Return the data of the node.
    public E getData()
    {
        return data;
    }
    
    //Set the data of the node.
    public void setData(E d)
    {
        data = d;
    }
    
    //Return the left child.
    public BinaryTreeNode<E> getLeftChild()
    {
        return leftChild;
    }
    
    //Set the left child.
    public void setLeftChild(BinaryTreeNode<E> newChild)
    {
        leftChild = newChild;
    }
    
    //Return the right child.
    public BinaryTreeNode<E> getRightChild()
    {
        return rightChild;
    }
    
    //Set the right child.
    public void setRightChild(BinaryTreeNode<E> newChild)
    {
        rightChild = newChild;
    }
    
    //Check if the node is a leaf or not. Return true if it is a leaf.
    //Not really needed for the Node as a whole, just nice to make methods like height a little more readable.
    public boolean isLeaf()
    {
        if (rightChild == null && leftChild == null) //Node is a leaf if it does not have any children at all.
            return true;
        return false;
    }
    
    //Check if the node is Empty or not. Return True if it is empty.
    public boolean isEmpty()
    {
        if (data == null) //Node is empty if it does not contain any data.
            return true;
        return false;
    }
    
    //Gets the height of this node. Height is defined as the largest amount of edges between the node and the furthest leaf.
    public int height()
    {
        if (this.data == null || this.isLeaf()) //If the node is a leaf or does not have any data, there are no edges between the node and a leaf, thus height is 0
        {
            return 0;
        }
        else
        {
            int leftHeight = 0; //Set the left height and right height for simple assignment in the case that one child does not exist but the other does.
            int rightHeight = 0;
            
            if (leftChild != null) //Checks to make sure that a left child exists.
                leftHeight = leftChild.height(); //Recursively find the height of the left child.
            
            if (rightChild != null) //Checks to make sure that a right child exists.
                rightHeight = rightChild.height(); //Recursively find the height of the right child.
            
            if (rightHeight > leftHeight) //Return one plus the greater of the two children's heights.
                return 1 + rightHeight; 
            else
                return 1 + leftHeight;
        }
    }
    
    //Convert the data of the node to a string.
    public String toString()
    {
        if (data != null)
            return data.toString();
        return null;
    }
    
    //Returns a list of all of the data in the tree preordered.
    public ArrayList<BinaryTreeNode<E>> preorder() //TODO Test all of the newest changes.
    {
        ArrayList<BinaryTreeNode<E>> preordered = new ArrayList<BinaryTreeNode<E>>(); 
        
         //Make sure that the current node exists.
        
        preordered.add(this); //Add the data of the current node to the arraylist.
            
        if (leftChild != null)
            preordered.addAll(leftChild.preorder()); //Recursively preorder the left half of the tree, then add it all to the arraylist.
                
        if (rightChild != null)
            preordered.addAll(rightChild.preorder()); //Recursively preorder the right half of the tree, then add it to the all arraylist.
        
        
        return preordered;
    }
    
    //Returns a list of all of the data in the tree postordered.
    public ArrayList<BinaryTreeNode<E>> postorder()
    {
        ArrayList<BinaryTreeNode<E>> postordered = new ArrayList<E>()BinaryTreeNode<E>
        
        if (leftChild != null) //Prevent access to nonexitent nodes.
            postordered.addAll(leftChild.postorder()); //Recursively postorder the left half of the tree, then add it all to the arraylist.
                
        if (rightChild != null)
            postordered.addAll(rightChild.postorder()); //Recursively postorder the right half of the tree, then add it all to the arraylist.
                
        postordered.add(this); //Add the data of the current node to the arraylist.            
        
        return postordered;
    }
    
    //Returns a list of all of the data in the tree inordered.
    public ArrayList<BinaryTreeNode<E>> inorder()
    {
        ArrayList<BinaryTreeNode<E>> inordered = new ArrayList<BinaryTreeNode<E>>();     
        if (leftChild != null) //Prevent access to nonexitent nodes.
            inordered.addAll(leftChild.inorder()); //Recursively inorder the left half of the tree, then add it all to the arraylist.
                
        inordered.add(this); //Add the data of the current node to the arraylist.
            
        if (rightChild != null)
            inordered.addAll(rightChild.inorder()); //Recursively inorder the right half of the tree, then add it all to the arraylist.
                
        return inordered;
    }
    
    //Returns a list of all the data in the tree level ordered.
    public ArrayList<BinaryTreeNode<E>> levelOrder()
    {
        ArrayList<BinaryTreeNode<E>> levelOrdered = new ArrayList<E>()BinaryTreeNode<E>
        Queue<BinaryTreeNode<E>> levelQueue = new LinkedList<BinaryTreeNode<E>>(); //Queue used to store the nodes that need to be added into the arraylist.
        
        levelQueue.add(this);
        
        while (!levelQueue.isEmpty()) //If there are no elements in the queue, we have gone through each of the elements. Otherwise continue iterating through the queue.
        {
            BinaryTreeNode<E> currentNode = levelQueue.poll(); //Get the current node in the queue and remove it from the queue.
            levelOrdered.add(currentNode); //Add the data from the current node to the arraylist.
            
            if (currentNode.leftChild != null)
                levelQueue.add(currentNode.leftChild); //Add the left child of the current node to the queue.
                
            if (currentNode.rightChild != null)
                levelQueue.add(currentNode.rightChild); //Add the right child of the current node to the queue.
        }
        return levelOrdered;
    }
}
