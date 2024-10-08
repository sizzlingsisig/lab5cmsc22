package cmsc123lab2;

public class SLLNode{
	// declares value and next variables
	public String value; 
	public SLLNode next;

	public SLLNode(String value){
		// constructor
		this.value=value;
		this.next=null;
	}

	public void setValue(String value){
		// sets value
		this.value=value;
	}

	public String getValue(){
		// gets value
		return this.value;
	}

	public void setNext(SLLNode node){
		// sets next node
		this.next=node;
	}

	public SLLNode getNext(){
		// gets next node
		return this.next;
	}
}