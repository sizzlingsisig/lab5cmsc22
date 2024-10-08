package cmsc123lab2;
public class ArrayStack extends Array{
	public ArrayStack (int capacity){
		// constructor
		super(capacity);
	}
	public Element top(){
		// The top() operation returns a reference value to the top element of the stack, but doesn’t remove it
		//if the stack is empty return the first element of the array
		if(isEmpty()) {
			System.out.println("Stack is empty");
			return null;
		}
		return this.contents[0];
	}

	public void push(String value){
	    // The push() operation inserts an item at the top of the stack
	    // You are not allowed to push() an item to the stack when full
	    // if the capacity is hit expands the array
	    if(size==capacity) {
	        System.out.println("Stack is full");
	        expand();
	    }
	    //creates tempArray that uses capacity
	    Element[] tempArray = new Element[capacity]; 
	    // Add the new element to the first index
	    tempArray[0] = new Element(value,size);
	    // Shift all the elements to the right
	    for(int i=0;i<size;i++) {
	        tempArray[i+1] = contents[i]; 
	    }
	    //sets the array into the temparray with larger capacity
	    contents=tempArray;
	    size++; // Increment the size
	}

	public Element pop(){
		// The pop() operation removes the item at the top of the stack
		// This should also return the 'Element' that was removed
		//if empty the return null
		if(isEmpty()) {
			System.out.println("Stack is empty");
			return null;
		}
		//makes a variable removed which is the variable that is removed
		Element removed=this.contents[0];
		//removes first element
		removeElement(0);
		//returns the removed element
		return removed;
	}
}