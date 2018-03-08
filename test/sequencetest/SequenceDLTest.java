package sequencetest;

import components.sequence.Sequence;
import components.sequence.Sequence1L;
import components.sequence.SequenceDL;

public class SequenceDLTest extends SequenceTest {

    @Override
    protected Sequence<String> constructorTest() {
        return new SequenceDL<String>();
    }

    @Override
    protected Sequence<String> constructorRef() {
        return new Sequence1L<String>();
    }

}
