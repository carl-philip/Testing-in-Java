package com.vectors.states;

public abstract class State {

    private static State currentState = null;

    public static void setState(State state) {
        currentState = state;
    }

    public static State getState() {
        return currentState;
    }

    // class
    public abstract void update();

    public abstract void render();
}
