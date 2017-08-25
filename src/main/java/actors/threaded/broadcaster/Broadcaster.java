package actors.threaded.broadcaster;

import actors.Actor;
import actors.messages.ActorMessage;
import actors.threaded.ThreadActor;
import actors.threaded.broadcaster.messages.listener_actions.AddListener;
import actors.threaded.broadcaster.messages.Broadcast;
import actors.threaded.broadcaster.messages.listener_actions.ListenerAction;
import actors.threaded.broadcaster.messages.listener_actions.RemoveListener;

import java.util.WeakHashMap;

/**
 * Broadcasts messages to subscribed listeners.
 */
public class Broadcaster extends ThreadActor {
    private WeakHashMap<Actor, Boolean> listeners = new WeakHashMap<Actor, Boolean>();

    @Override
    protected void onMessage(ActorMessage message) {
        if (message instanceof ListenerAction) {
            onListenerAction((ListenerAction) message);
        } else if (message instanceof Broadcast) {
            onBroadcast((Broadcast) message);
        }
    }

    private void onListenerAction(ListenerAction message) {
        determineListenerAction(message);
    }

    private void determineListenerAction(ListenerAction message) {
        if (message instanceof AddListener) {
            onAddListener((AddListener) message);
        } else if (message instanceof RemoveListener) {
            onRemoveListener((RemoveListener) message);
        }
    }

    private void onAddListener(AddListener message) {
        addListener(message.getListener());
    }

    private void addListener(Actor listener) {
        listeners.put(listener, true);
    }

    private void onRemoveListener(RemoveListener message) {
        removeListener(message.getListener());
    }

    private void removeListener(Actor listener) {
        listeners.remove(listener);
    }

    private void onBroadcast(Broadcast message) {
        broadcast(message.getMessage());
    }

    private void broadcast(ActorMessage message) {
        for (Actor listener : listeners.keySet()) {
            listener.tell(message);
        }
    }
}
