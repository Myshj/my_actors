package actors.threaded;

import actors.Actor;
import actors.messages.ActorMessage;
import actors.messages.StopMessage;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Actor that lives in a separate thread.
 */
public abstract class ThreadActor extends Thread implements Actor {
    private LinkedBlockingQueue<ActorMessage> inbox = new LinkedBlockingQueue<ActorMessage>();
    private boolean working = true;

    private boolean isWorking() {
        return working;
    }

    /**
     * Called when actor receives new message.
     * @param message Received message.
     */
    protected abstract void onMessage(ActorMessage message);

    public void tell(ActorMessage message) {
        try {
            inbox.put(message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Main cycle.
     * Actor lives until it receives a StopMessage() message.
     */
    private void waitForMessages() {
        while (isWorking()) {
            try {
                ActorMessage message = inbox.take();
                if (message instanceof StopMessage) {
                    working = false;
                }
                onMessage(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        waitForMessages();
    }
}
