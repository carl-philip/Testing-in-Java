package com.vectors.program;

import com.vectors.states.ProgramState;
import com.vectors.states.State;

public class Program implements Runnable {

    private Thread thread;
    private boolean running = false;

    // States
    private State programState;

    public Program() {

    }

    private void init() {
        programState = new ProgramState();
        State.setState(programState);
    }

    private void update() {
        if(State.getState() != null)
            State.getState().update();
    }

    private void render() {
        if(State.getState() != null)
            State.getState().render();
    }

    public void run() {
        this.init();

        int fps = 100;
        double timePerUpdate = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();

        while(running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerUpdate;
            lastTime = now;

            if(delta >= 1) {
                this.update();
                this.render();
                delta--;
            }
        }

        this.stop();
    }

    public synchronized void start() {
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop () {
        if(!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
