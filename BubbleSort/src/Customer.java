
public class Customer {

    public String name;
    public int rating;
    public String address;

    public Customer(String name, int rating, String address) {
        this.name = name;
        this.rating = rating;
        this.address = address;
    }
    
    public String toString() {
    	return this.name + " : " + this.rating; 
    }
	
}
