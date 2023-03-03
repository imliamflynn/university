/** Lab 25, Calculator.java
  * Liam Flynn, October 2020
  * A calculator class - for SIMPLE calculations like 5 + 20 =
  * Large inputs will overload int, should convert to long
  */

public class Calculator { 
  
  private long currentInput;          //current input
  private long previousInput;         // previous input
  private long result;            // result of calculation
  private String lastOperator = "";  // keeps track of the last operator entered
  
  
  /** New digit entered as integer value i - moves currentInput 1 decimal place to the left and adds i in "one's column" */
  public void inDigit(int i) {
    currentInput = (currentInput * 10) + i;
  }
  
  
  /** Operator entered  + - or *   */
  public void inOperator(String op){
    if (lastOperator != ""){
      if (lastOperator.equals("-")){
        if (previousInput == 0){
          previousInput = 0 - currentInput;
        }
        else{
          previousInput = previousInput - currentInput;
        }
      }
      else if (lastOperator.equals("+")){
        previousInput = previousInput + currentInput;
      }
      else if (lastOperator.equals("*")){
        previousInput = previousInput * currentInput;
      }
      lastOperator = op;
      currentInput = 0;
    }
    
    else{
      if (previousInput == 0){
        previousInput = currentInput;
        currentInput = 0;
        lastOperator = op;
      }
      else{
        currentInput = 0;
        lastOperator = op;
      }
    }
  }
  
  
  /** Equals operation sets result to previousInput + - or * currentInput (depending on lastOperator) */
  public void inEquals() {
    if (lastOperator.equals("")){
      if (currentInput == 0){
        previousInput = result;
        result = previousInput;
      }
      else{
        result = currentInput;
      }
    }
    else if (lastOperator.equals("+")) {
      result = previousInput + currentInput;
      previousInput = result;
    }
    else if (lastOperator.equals("-")) {
      result = previousInput - currentInput;
      previousInput = result;
    }
    else if (lastOperator.equals("*"))  {
      result = previousInput * currentInput;
      previousInput = result;
    }
    currentInput = 0;
    lastOperator = "";       // reset last operator to "nothing"
  }
  
  
  /** Clear operation */
  public void inClear() {
    currentInput = 0;
    previousInput = 0;
    result = 0;
    lastOperator = "";
  }
  
  /** returns the current result */
  public String getResult() { 
    return Long.toString(result); //converts int to String 
  }
  
  /** returns the previous input value */
  public String getPreviousInput() {
    return Long.toString(previousInput);
  }
  /** returns the current input value */
  public String getCurrentInput() {
    return Long.toString(currentInput);
  }
} 