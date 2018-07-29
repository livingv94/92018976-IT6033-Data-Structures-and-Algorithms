import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class TicketingSystem {

    public static Queue<Integer> customerQueue = new LinkedList<Integer>();

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new SalesAssisstantTask(), 0, 5000);
        timer.schedule(new NewCustomerTask(), 0, 3000);
    }

    public static class SalesAssisstantTask extends TimerTask {

        public void run() {
        	
        	System.out.println("\nSales Assistant is ready to serve the next customer."); 
            if (customerQueue.isEmpty()){
                System.out.println("There are no customers to see\n.");
//                System.exit(0);
            } else if (customerQueue.size() == 1){
                System.out.println("The customer with ticket number " + customerQueue.peek() + " will be seen");
                customerQueue.poll();
                System.out.println("There are no more customers to see.\n");
            } else{
                System.out.println("The customer with ticket number " + customerQueue.peek() + " will be seen");
                customerQueue.poll();
                System.out.println("The customers with the following tickets are in the queue: " + customerQueue.toString() + "\n");
            }
            // remove customers.... poll()

            // queue.isEmpty() ?

//            System.out.println("Removing cutomer");

        }
    }

    public static class NewCustomerTask extends TimerTask {

        public void run() {

            if (customerQueue.isEmpty()) {
            	customerQueue.add(1);
            	System.out.println("The customer with ticket number " + customerQueue.peek() + " is added to the queue");
            	
            } else {
	            int nextTicket = customerQueue.size() + customerQueue.peek();
	            customerQueue.add(nextTicket);
	            System.out.println("The customer with ticket number " + nextTicket + " is added to the queue");
            }
//        	customerQueue.add(1);
//        	System.out.println(customerQueue.size());
        }
    }
}
