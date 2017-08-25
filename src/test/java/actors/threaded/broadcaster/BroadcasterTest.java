package actors.threaded.broadcaster;

import actors.messages.StopMessage;
import actors.threaded.ActorTest;
import actors.threaded.ThreadActorTest;
import actors.threaded.broadcaster.messages.Broadcast;
import actors.threaded.broadcaster.messages.listener_actions.AddListener;
import actors.threaded.broadcaster.messages.listener_actions.RemoveListener;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BroadcasterTest extends ActorTest {

    private Broadcaster broadcaster;
    private TestActor firstActor;
    private TestActor secondActor;

    @Before
    public void setUp() throws Exception {
        broadcaster = new Broadcaster();
        broadcaster.start();
        firstActor = new TestActor();
        firstActor.start();
        secondActor = new TestActor();
        secondActor.start();
    }

    @Test
    public void testBroadcast() throws Exception {
        broadcaster.tell(new AddListener(null, firstActor));
        broadcaster.tell(new AddListener(null, secondActor));
        broadcaster.tell(new Broadcast(null, new StopMessage(null)));

        Thread.sleep(100);
        assertEquals(true, firstActor.isMessageReceived());
        assertEquals(true, secondActor.isMessageReceived());
    }

    @Test
    public void testRemove() throws Exception {
        broadcaster.tell(new AddListener(null, firstActor));
        broadcaster.tell(new AddListener(null, secondActor));
        broadcaster.tell(new RemoveListener(null, secondActor));
        broadcaster.tell(new Broadcast(null, new StopMessage(null)));

        Thread.sleep(100);
        assertEquals(true, firstActor.isMessageReceived());
        assertEquals(false, secondActor.isMessageReceived());
    }

}