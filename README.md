# my_actors
Simplest possible actor system.

Each actor runs in a separate thread.

Actors should be started explicitly by invoking their start() method.

Send actor an instance of StopMessage to stop it.

Protected method onMessage() invoked each time actor receives new message.

It is guaranteed that any two messages from one source to one destination would be received in order of their initial sending.
