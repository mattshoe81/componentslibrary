package queuetest;

import components.queue.Queue;
import components.queue.Queue1L;
import components.queue.QueueDL;

public class QueueDLTest extends QueueTest {

    @Override
    protected Queue<String> constructorTest() {
        return new QueueDL<String>();
    }

    @Override
    protected Queue<String> constructorRef() {
        return new Queue1L<String>();
    }

}
