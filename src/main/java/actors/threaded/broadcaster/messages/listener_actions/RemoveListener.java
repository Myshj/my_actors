package actors.threaded.broadcaster.messages.listener_actions;

import actors.Actor;

/**
 * Unsubscribe listener for notifications
 */
public class RemoveListener extends ListenerAction {
    public RemoveListener(Actor sender, Actor listener) {
        super(sender, listener);
    }
}
