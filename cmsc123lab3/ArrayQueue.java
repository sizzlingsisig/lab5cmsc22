package cmsc123lab3;
public class ArrayQueue extends Array{
	// Note that class "ArrayQueue" inherits the class "Array" attributes and methods
	// Insert Attributes (if any) - must be private
	public ArrayQueue (int capacity){
		//constructor for attributes of Array class
		super(capacity);
	}
	public Element front(){
		// The front() operation returns a reference value to the front element of the queue, but doesn’t remove it
		//if empty return null
		if(isEmpty()) {
			return null;
		}
		//returns the front of the queue
		return this.contents[0];
	}
	public void enqueue(String value) {
		//expands array if capacity is hit
	    if (size == capacity) {
	        expand();
	    }
	    //adds element to the end of the queue
	    addElement(value);
	}
	public Element dequeue(){
		// The dequeue() operation removes the 'Element' at the front of the queue
		// This should also return the 'Element' that was removed
		//if empty return null
		if(isEmpty()) {
			System.out.println("Stack is empty");
			return null;
		}
		//makes a variable removed that is the dequeued element
		Element removed=this.contents[0];
		//remove element
		removeElement(0);
		//return the removed value
		return removed;
	}
}