package actors.messages;

import actors.Actor;

/**
 * Message for actor to stop itself.
 */
public class StopMessage extends ActorMessage {
    public StopMessage(Actor sender) {
        super(sender);
    }
}
