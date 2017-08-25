package actors.messages;

import actors.Actor;

/**
 * Base class for all messages for actors.
 */
public abstract class ActorMessage {
    private final Actor sender;

    /**
     * Constructor.
     * @param sender Sender of this message.
     */
    public ActorMessage(Actor sender) {
        this.sender = sender;
    }

    public Actor getSender() {
        return sender;
    }
}
