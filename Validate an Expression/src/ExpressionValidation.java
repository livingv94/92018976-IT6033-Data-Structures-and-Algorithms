import java.util.LinkedList;
import java.util.Stack;
import java.util.Scanner;
import java.util.EmptyStackException;

public class ExpressionValidation {

    public static Stack<Character> bracketStack = new Stack<Character>();

    public static String expression;
    public static Character openChar;
    public static Character closeChar;

    public static void main(String[] args) {

    	System.out.println("Welcome to the expression validating program.");
        expression = getStringFromUser("Enter your expression:");
        openChar = getStringFromUser("Enter the opening character to validate:").charAt(0);
        closeChar = getStringFromUser("Enter the closing character to validate:").charAt(0);

        
        for (int i = 0; i < expression.length(); i++) {
            Character currentChar = expression.charAt(i);
            if (currentChar == openChar) {
//            	System.out.println("1 item Pushed to stack");
                bracketStack.push(openChar);
                
            } else if (currentChar == closeChar) {
            	if (bracketStack.isEmpty()) {
//                  System.out.println("First stack check is empty");
                  bracketStack.push(closeChar);
//                  break;
            	} else {
//	            	System.out.println("1 Item poped off stack");
	                bracketStack.pop();
            	}
                
            }

        }


        if (bracketStack.isEmpty()) {
            System.out.println("The expression is validated.");
        } else {
            System.out.println("Incorrect Too many opening/closing brackets"); // More close brackets?
        }

    }

    public static String getStringFromUser(String msg) {
        System.out.println(msg);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
