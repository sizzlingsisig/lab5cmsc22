package cmsc123lab3;

public class Element{
    // declares variables
    public String value;
    public int index;
    
    public Element(String value, int index){
        // constructor
        this.value = value;
        this.index = index;
    }

    public void setValue(String value){
        // sets value
        this.value = value;
    }

    public String getValue(){
        // gets value
        return this.value;
    }
    
    public void setIndex(int index) {
        this.index = index;
    }
    
    public int getIndex() {
        return this.index;
    }
}