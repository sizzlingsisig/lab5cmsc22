package cmsc123lab3;

public class SLLQueue extends SLL {
    private SLLNode frontNode;
    private SLLNode rearNode;

    public SLLQueue() {
        // Constructor for attributes
        super();
        this.frontNode = null;
        this.rearNode = null;
    }

    public SLLNode front() {
        // The front() operation returns a reference value to the front node of the queue, but doesn’t remove it
        if (isEmpty()) {
            return null;
        }
        // Returns frontNode
        return this.frontNode;
    }

    public void enqueue(String value) {
        // Creates newNode
        SLLNode newNode = new SLLNode(value);
        // Sets the newNode as the front and rear if empty
        if (isEmpty()) {
            setHead(newNode);
            this.frontNode = newNode;
            this.rearNode = newNode;
        } else {
            // Adds the newNode after the rearNode
            this.rearNode.setNext(newNode);
            this.rearNode = newNode;
        }
        //increments size of array
        incrementSize();
    }

    public SLLNode dequeue() {
        // Returns null if the SLL queue is empty
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        // Sets a variable the node to be removed as the front
        SLLNode dequeuedNode = this.frontNode;
        // Sets the front node to the node after the original front node
        this.frontNode = this.frontNode.getNext();
        // If the front node is also the rear, set both front and rear to null
        if (this.frontNode == null) {
            this.rearNode = null;
            this.frontNode=null;
        }
        //decrements size of queue
        decrementSize();
        //garbage collection
        dequeuedNode.setNext(null);
        //returns the dequeued node
        return dequeuedNode;
    }
}