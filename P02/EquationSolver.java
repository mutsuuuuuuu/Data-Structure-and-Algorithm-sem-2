package p02;

public class EquationSolver
{
    public void solve(String equation)
    {
        //calling parseInfixtoPosfix then evaluatePostfix method

        DSAQueue queue = new DSAQueue();
        double result;

        queue = parseInfixtoPostFix(equation);
    }

    private DSAQueue parseInfixtoPostFix(String equation)
    {
        DSAStack opStack = new DSAStack();
        DSAQueue postFix = new DSAQueue();

        //basically splitting the string assuming there is a space between each operators
        String [] inFix = equation.split(" ");

        int x=0;
        while (inFix.length != x)
        {
            //checking if infix is open bracket
            if (inFix[x].equals("("))
            {
                //true then push it
                System.out.println("Pushing : "+inFix[x]);
                opStack.pushStack(inFix[x]);
            }
            //check if the infix is close bracket
            else if (inFix[x].equals(")"))
            {
                //if its true then, find the corresponding open bracket. pop everything between those two operators and enqueue it
                while(!opStack.top().equals("("))
                {
                    System.out.println("Popping " +opStack.top()+ " from the stack and queue");
                    postFix.enqueue(opStack.top());
                    opStack.popStack();
                }
                //pop the open bracket outta the stack dont enqueue it
                System.out.println("Popping : " +opStack.top());
                opStack.popStack();
            }
            //check if it is + - / or *
            else if (checkOp(inFix[x])==1)
            {
               while (!opStack.isEmpty() && !opStack.top().equals("(") && (precedenceOf((String)opStack.top()) >= precedenceOf(inFix[x])))
               {
                   System.out.println("Popping " +opStack.top()+ " from the stack and queue");
                   postFix.enqueue(opStack.top());
                   opStack.popStack();
               }
               System.out.println("Pushing : " +inFix[x]);
               opStack.pushStack(inFix[x]);
            }
            else
            {
                System.out.println("Enqueue: " +inFix[x]);
                postFix.enqueue(inFix[x]);
            }
            x++;
        }
        while (!opStack.isEmpty())
        {
            System.out.println("Popping the remaining " +opStack.top()+ " from the stack and queue");
            postFix.enqueue(opStack.top());
            opStack.popStack();
        }
        toString(postFix);
        return postFix;

    }

    private int checkOp(String operator) {
        int value = 0;
        switch (operator)
        {
            case "+": case "-": case "*": case "/":
                value = 1;
                break;
        }

        return value;
    }


    private double evaluatePostfix(DSAQueue postfixQueue)
    {

        return 1;

    }



    private int precedenceOf(String theOp)
    {
        int valOperator = 0;

        switch (theOp)
        {
            case "-": case"+":
                valOperator = 1;
                break;

            case "*": case "/":
                valOperator = 2;
                break;

            case "(":
                valOperator = 5;
                break;

        }

        return valOperator;

    }

    /*private double executeOperation(char op, double op1, double op2)
    {

    }
    */

    //testing
    private void toString(DSAQueue dsaQueue)
    {
        System.out.println(dsaQueue.toString());
    }
}
