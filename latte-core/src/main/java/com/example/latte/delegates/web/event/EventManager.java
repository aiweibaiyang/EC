package com.example.latte.delegates.web.event;

import androidx.annotation.NonNull;

import java.util.HashMap;

public class EventManager {

    private static final HashMap<String,Event> EVENTS = new HashMap<>();

    public EventManager() {
    }

    private static class Holder{
        private static final EventManager INSTANCE = new EventManager();
    }

    public static EventManager getInstance(){
        return Holder.INSTANCE;
    }

    public EventManager addEvent(@NonNull String name, @NonNull Event event){
        EVENTS.put(name, event);
        return this;
    }

    public Event createEvent(@NonNull String action){
        final Event event = EVENTS.get(action);
        if (event == null){
            return new UndefineEvent();
        }
        return event;
    }
}
