package actors.threaded;

import actors.messages.ActorMessage;
import actors.messages.StopMessage;
import org.junit.Test;

import static org.junit.Assert.*;

public class ThreadActorTest extends ActorTest {

    protected TestActor actor;

    @org.junit.Before
    public void setUp() throws Exception {
        actor = new TestActor();
        actor.start();
    }

    @Test
    public void tell() throws Exception {
        actor.tell(new StopMessage(null));
        Thread.sleep(100);
        assertEquals(true, actor.isMessageReceived());
    }

}