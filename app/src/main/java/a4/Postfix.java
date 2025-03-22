package a4;

import java.util.ArrayDeque;
/**
 * Evaluates arithemetic expressions by writing the Array in Reverse Polish Notation.
 */
public class Postfix {

    /**
     * Creates a postfix expression by using the data structure of stacks. 
     * @param tokens
     * @return the result as Double
     */

    public static Double postfix(ArrayDeque<Object> tokens){

        ArrayDeque<Double> stack = new ArrayDeque<>();

       while(!tokens.isEmpty()){
            Object token = tokens.pop();
            if ( token instanceof Double){
                stack.push((Double)token);
            }
            else if (token instanceof Character){
                if (stack.size() < 2){
                    throw new IllegalArgumentException("The operator can not act on a single or zero input!");}
                
                double b = stack.pop();
                double a = stack.pop();
                char op = (Character) token;
    
                if (op == '+'){
                        stack.push(a +b);}
                     else if (op == '-'){
                        stack.push(a - b);}
                     else if (op == '*'){
                        stack.push(a * b);}
                     else if (op == '/'){
                        if (b== 0) throw new ArithmeticException("Cannot Divide by zero");
                        stack.push(a/b);
                } 
        }
        }

        if (stack.size() !=1) {
            throw new IllegalArgumentException("The size of the resulting array is greater than 1.");
        }
    return stack.pop();
    }


    public static void main(String[] args) {
        String x = "22 3 + 7 8 - + ";
        ArrayDeque<Object> queue = Tokenizer.readTokens(x);
        Double answer = Postfix.postfix(queue);
        System.out.println(answer);
    }
}