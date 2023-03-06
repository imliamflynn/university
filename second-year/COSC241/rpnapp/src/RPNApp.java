package week10; //comment out package to get it to run on personal device

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

/**.
 * Reverse Polish Notation Calculator.
 * @author James Tucker
 * @author Liam Flynn
 * @author Ben Stacey
 */
 public class RPNApp {
     /** Declaring an instance of rpnStack.*/
    private static Stack<Long> rpnStack;
    /**.
     * Method invoked by main() and is run infinite times.
     * Description:
     * entryPoint() function will contain code for:
     * - Reading user input via readInUserInput()
     * - Determine special cases: brackets,
     * 'c', 'r', repeat operators.
     * - If no special cases, perform compute()
     * @param userInput - This is the line the user enters
     */
    private static void entrypoint(String userInput) {
        // instantiate the static class variable rpnStack
        rpnStack = new Stack<Long>();
        // try catch will allow us to catch errors
        // thrown by our various methods.
        // it allows for one convenient place to handle our errors.
        try {
            // try to print the result of our compute() method.
            System.out.println(compute(userInput));
        }   catch (NumberFormatException e) {
            // verbose code to extract the offending token.
            String exceptionToken =
            e.getMessage().substring(e.getMessage().indexOf('"') + 
            1, e.getMessage().length()-1);
            System.out.println("Error: bad token '" + exceptionToken + "'");
            // catch the ArithmeticException thrown.
        }   catch (ArithmeticException e) {
            System.out.println("Error: division by 0");
            // catch the EmptyStackException thrown.
        } catch (EmptyStackException e) {
            System.out.println("Error: too few operands");
            // catch the IllegalArgumentException thrown.
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("Error: negative copy");
        }
    }

    /**
     * This function will prevent code duplication within our 
     * main switch branch.
     * The interpretation of this operator is that the binary 
     * operator should be repeatedly applied until the stack 
     * contains exactly one item therefore this method keeps
     * popping the exclamation 
     * @param operator -
     */
    private static void handleExclamation(String operator) {
        /*Top element must be set to the first popped element of the stack.*/
        long result = 0L;
        // Get the stack size by calling size() method.
        int stackSize = rpnStack.size();
        // Loop through the whole stack.
        for (int i = 0; i < stackSize; i++) {
            if (i == 0) {
                // Pop the final element
                result = rpnStack.pop();
            } else {
                switch (operator) {
                    case ("+!"): {
                        // plus equals popped stack element
                        result += rpnStack.pop();
                        break;
                    }
                    case ("-!"): {
                        // minus equals popped stack element
                        result -= rpnStack.pop();
                        break;
                    }
                    case ("/!"): {
                        // divided-by equals popped stack element
                        result /= rpnStack.pop();
                        break;
                    }
                    case ("*!"): {
                        // multiplied-equals equals popped stack element
                        result *= rpnStack.pop();
                        break;
                    }
                    case ("%!"): {
                        // modulo-equals equals popped stack element
                        result %= rpnStack.pop();
                        break;
                    }
                }
            }
        }
        rpnStack.push(result);
    }

    /**.
     * If the top element of the stack is k and the
     * k preceding lower elements (from bottom to top)
     * are x1, x2, . . . , xk, then the result of
     * applying r should be to rotate the top element
     * xk down k−1 positions in the stack
     */
    private static void handleRotate() {
        // how many places we will rotate
        long rotateBy = rpnStack.pop() - 1;
        // the "value" which we will rotate.
        long rotateValue = rpnStack.pop();
        // the size of the rpnStack
        int stackSize = rpnStack.size();
        // new temporary stack
        Stack<Long> tStack = new Stack<Long>();
        // remove elements of stack up to our
        // "rotateBy value"
        for (int i = 0; i < rotateBy; i++) {
            tStack.push(rpnStack.pop());
        }
        // push the rotateValue onto the stack
        rpnStack.push(rotateValue);
        int tStackSize = tStack.size();
        // rebuild the stack from the tStack stack.
        for (int i = 0; i < tStackSize; i++) {
            rpnStack.push(tStack.pop());
        }
    }

    /**
     * If the top element of the stack is 
     * y and the second from the top is x, 
     * then the result of applying c should 
     * be to remove both from the stack and 
     * then push y copies of x onto the stack. 
     */
    private static void handleCopy() {
        long copyBy = rpnStack.pop();
        // Cannot negative copy, so throw error.
        if (copyBy < 0){
            throw new IllegalArgumentException();
        }
        long valueToCopy = rpnStack.pop();
        for (int i = 0; i < copyBy; i++) {
            rpnStack.push(valueToCopy);
        }
    }

    /**.
     * The operation is that when a ‘(’ is encountered, 
     * all commands up to the matching ‘)’ are repeated 
     * k times where k is the number on top of the stack 
     * when the ‘(’ is encountered (0 times if k <= 0).
     * 
     * @param topOfStack - repeated k times where k is the 
     * number on top of the stack when the ‘(’ is encountered.
     * @param userInputArray - the formatted string of characters.
     * @param index - current offset.
     * @return offset index.
     */
    private static int handleOpeningParenthesis(
            long topOfStack, String[]
            userInputArray, int index){
        /*
         * Idea is to get all elements after the opening parenthesis 
         * until the closing parenthesis. Then "recursively" 
         * call compute() on the expression. Push result
         * onto stack.
         * 
         * Also we need to remove the characters from "index" to index offset.
         */
        StringBuilder expression = new StringBuilder();
        // Set initial currentParenthesisState to 1
        int currentParenthesisState = 1;
        // Set offsetIndex to the index+1
        int offsetIndex = index + 1;
        // Setting current index to initially.
        int currentIndex = 0;
        for (currentIndex = offsetIndex; currentIndex < 
        userInputArray.length; currentIndex++) {
            if (userInputArray[currentIndex].equals("(")) {
                // increment the current parenthesis state.
                currentParenthesisState++;
                // Statement below will handle the inner brackets.
                if (currentParenthesisState != 0) {
                    // make sure a space is included.
                    expression.append("( ");
                }
            } else if (userInputArray[currentIndex].equals(")")) {
                // decrement the parenthesis state.
                currentParenthesisState--;
                if (currentParenthesisState != 0) {
                    // make sure a space is included.
                    expression.append(") ");
                } else{
                    break;
                }
            } else {
                // no brackets found, append a space.
                expression.append(userInputArray[currentIndex]).append(" ");
            }
        }
        // offset is now set to currentIndex
        // So the NEXT item after the opening parenthesis
        offsetIndex = currentIndex;
        /* If the code above resulted in
        * currentParenthesisState to equal 0
        * Then that means there is an unmatched
        * parenthesis occurring */
        if (currentParenthesisState == 0) {
            // repeated k times where k is the number on top of the stack
            //when the ‘(’ is encountered so compute original expression,
            //get result -> call next expression using the result:
            String result = expression.toString();
            for (int i = 0; i < topOfStack; i++) {
                // recursively call compute...
                compute(result);
            }
        } else {
            // Throw illegal argument exception
            // For the unmatched parenthesis.
            throw new IllegalArgumentException("unmatched parenthesis");
        }
        // Return the offset index.
        return offsetIndex;
    }

    /**.
     * Calculates the result and calls toString to print it.
     *
     * @param userInput - The RPN to compute
     * @throws ArithmeticException    
     * @throws EmptyStackException     
     * @throws NumberFormatException   
     * @return rpnStack.toString()  
     * Handles three errors as described above
     * By their exceptions.
     * By throwing the error, we can handle the error
     * In another method.
     *
     * We are using an index for our loop as opposed to a 
     * for-each loopas we needto retain the index in 
     * order to handle the cases where
     * there is a parenthesis.
     */
    private static String compute(String userInput)
            throws ArithmeticException, EmptyStackException,
            NumberFormatException {
        String userInputArray[] = userInput.split("\\s+");
        for (int index = 0; index < userInputArray.length; index++) {
            String token = userInputArray[index];
            switch (token) { //enhanced switch, no need for break statements
                case "+": { //Addition, pop two items off stack, add them 
                    rpnStack.push(rpnStack.pop() + rpnStack.pop());//together.
                    break; // push the result back onto the stack
                }
                case "-": { //Subtraction. Pop two items off stack, negate 
                    rpnStack.push(-rpnStack.pop() + rpnStack.pop());
                    break;//first number, and add it by the second.
                }
                case "*": { //Multiplication
                    // pop two numbers and multiply
                    // push the result back onto the stack
                    rpnStack.push(rpnStack.pop() * rpnStack.pop());
                    break;
                }
                case "/": { //Division
                    // pop two numbers and divide
                    long divisor = rpnStack.pop();
                    rpnStack.push(rpnStack.pop() / divisor);
                    break;
                }
                case "%": { //Modulo
                    // pop modulo first.
                    long modulo = rpnStack.pop();// pop second number
                    rpnStack.push(rpnStack.pop() % modulo);
                    break;//perform modulo on it.
                }
                case "+!"://Exclamation
                case "*!":
                case "-!":// all expressions with exclamation marks
                case "%!":// handled in handleExclamation() method.
                case "/!": {
                    handleExclamation(token);
                    break;
                }
                case "d": { //Duplication
                    // Peek top item, which means do not remove it
                    // from the stack. Push that "peeked"
                    // element onto the stack.
                    rpnStack.push(rpnStack.peek());
                    break;
                }
                case "o": { //Output top item
                    System.out.print(rpnStack.peek() + " ");//Use peek
                    break;//so as to not remove the item from the stack.
                }// Make sure to space after the output.
                case "c": { //Copy top element method 
                    handleCopy();
                    break;
                }
                case "r": { //Roll-rotate method.
                    handleRotate();
                    break;
                }
                case "(": {
                    index = handleOpeningParenthesis(rpnStack.pop(),
                    userInputArray, index);
                    break;
                }
                default: {
                    rpnStack.push(Long.parseLong(token));
                }
            }
        }
        return rpnStack.toString();
    }

    /**
     * We are using a infinite while loop to keep reading and processing user
     * input via the entrypoint() function.
     * 
     * @param args - command line arguments
     */
    public static void main(String[] args) {
        // Define a new Scanner instance
        Scanner sc = new Scanner(System.in);
        // Setup our infinite while loop.
        while (sc.hasNextLine()) {
            // While we have more input, call entrypoint.
            entrypoint(sc.nextLine());
        }
    }
}
