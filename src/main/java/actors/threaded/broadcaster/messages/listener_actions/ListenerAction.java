package actors.threaded.broadcaster.messages.listener_actions;

import actors.Actor;
import actors.messages.ActorMessage;

/**
 * Base class for all messages about listener actions.
 */
public abstract class ListenerAction extends ActorMessage {
    private final Actor listener;

    /**
     * Constructor.
     * @param sender Sender of this message.
     * @param listener Listener to act with.
     */
    public ListenerAction(Actor sender, Actor listener) {
        super(sender);
        this.listener = listener;
    }

    public Actor getListener() {
        return listener;
    }
}
