package actors.threaded.broadcaster.messages.listener_actions;

import actors.Actor;

/**
 * Subscribe listener for notifications.
 */
public class AddListener extends ListenerAction {
    public AddListener(Actor sender, Actor listener) {
        super(sender, listener);
    }
}
