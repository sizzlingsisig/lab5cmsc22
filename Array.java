public class Array {
    // declare the variables to be used in array.java
    private int size;
    private int capacity;
    //declare contents as an array of elements
    private Element[] contents;

    public Array(int capacity) {
    	//constructor for the variables
    	// size=0 because array is empty, 10 is default capacity
        this.size = 0;
        this.capacity = 10;
        this.contents = new Element[capacity];
    }

    public int getSize() {
        // returns the size of the array
        return this.size;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public Element[] getContents() {
        // returns the value of the array
        return this.contents;
    }

    public boolean isEmpty() {
        // returns true if array is empty
        return this.size == 0;
    }

    public void addElement(String value) {
        // adds element if array is not full
        if (this.size< this.capacity) {
            // checks if there's a null element in the array
            for (int index = 0; index < this.capacity; index++) {
                if (this.contents[index] == null) {
                    // adds new element given based on the value and size
                    this.contents[index] = new Element(value, this.size);
                    break;
                }
            }
            this.size++;
        }
    }

    public void incrementSize(){
        this.size++;
    }

    public String removeElement(int index) {
        // gets value of element at given index
        String value = this.contents[index].getValue();
        // Set the element at the index to null
        this.contents[index] = null;
        //decrement size
        this.size--;
        //return the value of the removed element
        return value;
    }

	public void expand() {
		this.capacity+=5;
		Element[] tempArray=new Element[capacity];
		for(int i=0; i<size; i++) {
			tempArray[i]=this.contents[i];
		}
		this.contents=tempArray;
	}
}
