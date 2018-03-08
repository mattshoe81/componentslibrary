package stacktest;

import components.stack.Stack;
import components.stack.Stack1L;
import components.stack.StackSL;

public class StackSLTest extends StackTest {

    @Override
    protected Stack<String> constructorTest() {
        return new StackSL<String>();
    }

    @Override
    protected Stack<String> constructorRef() {
        return new Stack1L<String>();
    }

}
