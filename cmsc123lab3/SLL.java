package cmsc123lab3;

public class SLL{
	// declares variable for SLL
	public int size;
	public SLLNode head;
	public SLLNode tail;
	
	public SLL(){
		// constructor
		//size is 0 because SLL is empty, head and tail are null because they SLL has no nodes yet
		this.size=0;
		this.head=null;
		this.tail=null;
		
	}

	public int getSize(){
		// returns size
		return this.size;
	}

	public boolean isEmpty(){
		// checks if sll is empty 
		return this.size==0;
	}

	public void setHead(SLLNode node){
		// sets the head to the given node
		this.head=node;
	}

	public SLLNode getHead(){
		// returns the head value
		return this.head;
	}

	public void setTail(SLLNode node){
		// sets the tail node
		this.tail=node;
	}

	public SLLNode getTail(){
		// return the value of the tail
		return this.tail;
	}

	public void addNode(String value){
		// adds a new node
        SLLNode tempNode = new SLLNode(value);
		if (this.head == null) {
            this.head = tempNode;
            this.tail = tempNode;
        } else {
            this.tail.setNext(tempNode);
            this.tail = tempNode;
        }
        this.size++;
	}

	public SLLNode removeNode(String value){
	    // removes node	
	    //creates pointers for previous node and the node to be removed of the SLL 
	    SLLNode previous = null;
	    SLLNode remove = this.head;
	    do {
	        // Check if the current node's value matches the given value
	        if (remove.getValue().equals(value)) {
	            //checks if the node is the head by checking the previous node
	            if (previous == null) {
	            	//if it is the head the node after it will be the head 
	                this.head = remove.getNext();
	                //updates the tail to null if the head is null
	                if(this.head == null) {
	                    this.tail = null; // Update tail if the list becomes empty
	                }
	            } 
	            //if the node to be removed is not the head
	            else {
	            	//sets the previous node's next node 
	                previous.setNext(remove.getNext());
	                //updates the tail if the tail is to be removed
	                if(remove == this.tail) {
	                    this.tail = previous; // Update tail if the removed node was the last node
	                }
	            }
	            //the removed node's pointer to be null
	            remove.setNext(null);
	            //decrements size of SLL 
	            this.size--;
	            //returns removed node
	            return remove;
	        }
	        
	        previous = remove;
	        remove = remove.getNext();
	    } while (remove != null);
	    
	    return null;
	}
	
	public void incrementSize() {
		size++;
	}
	
	public void decrementSize() {
		size--;
	}
}