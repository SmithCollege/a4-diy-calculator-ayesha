package a4;

import java.util.ArrayDeque;

/**
 * Writes an Infix notataion by using PEDMAS and gives a result by calling postfix 
 */
public class Infix {

    /**
     * Converts an infix expression that includes parentheses and opertaors and converts it into a postfix expression
     * Gives a result that follows the rules of PEDMAS and by calling postfix class.
     * @param tokens
     * @return the result as a Double
     */
    public static Double infixToPostfix(ArrayDeque<Object> tokens) {
        
        ArrayDeque<Object> output = new ArrayDeque<>();
        ArrayDeque<Character> stackOperator = new ArrayDeque<>();

        while(!tokens.isEmpty()){

            Object token = tokens.pop();

        if (token instanceof Double){
            output.addLast(token);
        }else if (token instanceof Character){
            char x = (Character) token;
            
            if (x == '('){
                stackOperator.push(x);
            }else if  (x == ')'){
                while (!stackOperator.isEmpty() && stackOperator.peek()!= '('){
                output.addLast(stackOperator.pop());
                }
                if (stackOperator.isEmpty()){
                    throw new IllegalArgumentException("Missing closing paranthese");
                }
                stackOperator.pop();
            }else if (x == '+' || x == '-' || x == '*' || x == '/' || x == '^'){
                while(!stackOperator.isEmpty() &&  highPrecedence(stackOperator.peek(), x)){
                    output.addLast(stackOperator.pop());}

                stackOperator.push(x);}
             }
            }

        while(!stackOperator.isEmpty()){
        char op = stackOperator.pop();
            if (op == '(' || op == ')'){
                throw new IllegalArgumentException("Improper Parantheses ");
            }
        output.addLast(op);}

        Double result = Postfix.postfix(output);
        return (result);}

        /**
         * Returns the precendence of an operator based on the rules of PEDMAS.
         * @param op
         * @return
         */
        private static int PEMDAS(char op) {
            if (op == '+' || op == '-') {
                return 1;
            } else if (op == '*' || op == '/') {
                return 2;
            } else if (op == '^') {
                return 3;
            } else {
                return 0;
            }
        }

        /**
         * Compares the precedence of 2 operators to determine if the first operator should be solved first or the second.
         * @param op1
         * @param op2
         * @return
         */
        private static boolean highPrecedence(char op1 , char op2){
            if(op1=='^'&& op2 =='^') {return false;}
            return PEMDAS(op1)>= PEMDAS(op2);
        }

}

    
