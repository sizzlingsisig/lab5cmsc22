package cmsc123lab2;
public class SLLStack extends SLL {
    private SLLNode topNode;
    public SLLStack() {
    	//constructor
    	super();
        topNode = null;
    }
    public SLLNode top() {
        // if stack is empty returns null
        if (isEmpty()) {
            return null;
        }
        // Return top of stack
        return topNode;
    }
    public void push(String value) {
        // Create a new node with the given value
        SLLNode newNode = new SLLNode(value);
        // sets the next newNode to be before the topNode
        newNode.setNext(topNode);
	    //sets the top as the added node
        topNode = newNode;
        // Increment the size of the stack
        incrementSize();
    }
    public SLLNode pop() {
    	//return null if array is empty
        if (isEmpty()) {
        	return null;
        }
        //create variable that is the node to b removed 
        SLLNode nodeToBeRemoved = topNode;
        //sets the top node to the node after the top node
        topNode = topNode.getNext();
        // garbage collector 
        if (topNode == null) {
            setTail(null);
        }
        // Decrement the size of the stack
        decrementSize();
        // Set the next pointer of the removed node to null
        nodeToBeRemoved.setNext(null); // Set the next pointer of the removed node to null
        // Return the removed node
        return nodeToBeRemoved;
    }
}