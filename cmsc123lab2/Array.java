package cmsc123lab2;

public class Array {
    // REQUIRED
    public int size;
    public int capacity;
    public Element[] contents;

    public Array(int i) {
        this.size = 0;
        this.capacity = 10;
        this.contents = new Element[capacity];
    }

    public int getSize() {
        // REQUIRED
        return this.size;
    }

    public Element[] getContents() {
        // REQUIRED
        return this.contents;
    }

    public boolean isEmpty() {
        // REQUIRED
        return this.size == 0;
    }

    public void addElement(String value) {
        if (this.size == this.capacity) {
            this.capacity*=2;
            Element[] tempList = new Element[this.capacity];
            for (int i = 0; i < this.size; i++) {
                tempList[i] = this.contents[i];
            }
            this.contents = tempList;
        }
        this.contents[this.size] = new Element(value,size); // Create a new Element object
        this.size++;
    }

    public String removeElement(int index) {
        // REQUIRED
        if (index < 0 || index >= this.size) {
            System.out.println("Index out of bounds");
            return null;
        }
        String value = this.contents[index].getValue();
        System.arraycopy(this.contents, index + 1, this.contents, index, this.size - index - 1);
        this.size--;
        return value;
    }
 // public void expand() {
 	// 	// The expand() method expands the array by increasing its capacity by 5;
 	// 	// REQUIRED
 	// }
	public void expand() {
		this.capacity+=5;
		Element[] tempArray=new Element[capacity];
		for(int i=0; i<size; i++) {
			tempArray[i]=this.contents[i];
		}
		this.contents=tempArray;
	}
}