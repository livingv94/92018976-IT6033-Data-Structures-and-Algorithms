import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class BubbleSort{
	
	private static Customer[] customers = new Customer[] {
		new Customer("a", 4, "Auckland"),
		new Customer("b", 2, "Wellington"),
		new Customer("c", 4, "Auckland"),
		new Customer("d", 2, "Christchurch"),
		new Customer("e", 4, "Auckland"),
	};
	    
    public static void main(String[] args) {
    	
    	System.out.print("\nWELCOME! This is an example of BubbleSort\n\n");
    	
    	for (Customer c : customers) {
    		System.out.println(c);
    	}
    	
    	bubble_sort(customers, true);
		System.out.println();
    	for (Customer c : customers) {
    		System.out.println(c);
    	}
    	 	
    }
        
    private static void bubble_sort(Customer[] input, boolean ascending) {

        int inputLength = input.length;
        Customer temp;
        boolean is_sorted;

        for (int i = 0; i < inputLength; i++) {

            is_sorted = true;

            for (int j = 1; j < (inputLength - i); j++) {
            	Customer c1 = input[j - 1];
            	Customer c2 = input[j];

                if (ascending) {

                    if (c1.rating > c2.rating) {
                        temp = input[j - 1];
                        input[j - 1] = input[j];
                        input[j] = temp;
                        is_sorted = false;
                    } else {
                    	if (c1.rating == c2.rating) {
//                    		System.out.println(c1.name + c2.name);
//                    		System.out.println(c1.name.compareTo(c2.name));
                            if (c1.name.compareTo(c2.name) < 0 ) {
                                temp = input[j - 1];
                                input[j - 1] = input[j];
                                input[j] = temp;
                                is_sorted = false;
                            }
                    		
                    	}
                    	
                    }
             
                } else {
                	
                    if (c1.rating < c2.rating) {
                        temp = input[j - 1];
                        input[j - 1] = input[j];
                        input[j] = temp;
                        is_sorted = false;
                    }
                }

            }

            if (is_sorted) break;

        }

    }

    private static void printArray(int[] data) {
        String result = Arrays.stream(data)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(","));
        System.out.println(result);
    }

}
