package p02;

import java.util.EmptyStackException;

public class DSAStack_testHarness
{
    public static void main(String [] args)
    {
        DSAStack stack = new DSAStack();
        System.out.println("Empty Stack: " + stack);

        //stack length
        System.out.println("Stack length: " +testingLength(stack));

        //push element into a stack
        testingPush(stack, 64);
        testingPush(stack, 24);
        testingPush(stack, 34);
        testingPush(stack, 14);

        //stack length
        System.out.println("Stack length: " + testingLength(stack));

        //poping element from the stack
        try
        {
            testingPop(stack);
        }
        catch (EmptyStackException e)
        {
            System.out.println("Empty stack");
        }
        //stack length
        System.out.println("Stack length: " +testingLength(stack));

    }

    public static int testingLength(DSAStack stack)
    {
        return stack.getCount();
    }

    public static void testingPush(DSAStack stack, Object test)
    {
        stack.pushStack(test);
        System.out.println("push " + test);
        System.out.println("Stack " +stack);
    }

    public static void testingPop(DSAStack stack)
    {
        System.out.print("Pop -> ");
        stack.popStack();
        System.out.println("Stack" +stack);

    }

}
