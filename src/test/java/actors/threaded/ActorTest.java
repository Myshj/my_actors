package actors.threaded;

import actors.messages.ActorMessage;

public abstract class ActorTest {
    public class TestActor extends ThreadActor{
        synchronized public boolean isMessageReceived() {
            return messageReceived;
        }

        boolean messageReceived = false;
        protected void onMessage(ActorMessage message) {
            messageReceived = true;
        }
    }
}
