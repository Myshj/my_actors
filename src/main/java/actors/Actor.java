package actors;

import actors.messages.ActorMessage;

/**
 * Base interface for all actors.
 */
public interface Actor {
    /**
     * Tell actor something.
     * @param message Message to tell.
     */
    void tell(ActorMessage message);
}
