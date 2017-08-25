package actors.threaded.broadcaster.messages;

import actors.Actor;
import actors.messages.ActorMessage;

/**
 * Tells broadcaster to broadcast specified message.
 */
public class Broadcast extends ActorMessage {
    private final ActorMessage message;

    /**
     * Constructor.
     * @param sender Sender of this message.
     * @param message Message to broadcast.
     */
    public Broadcast(Actor sender, ActorMessage message) {
        super(sender);
        this.message = message;
    }

    public ActorMessage getMessage() {
        return message;
    }
}
