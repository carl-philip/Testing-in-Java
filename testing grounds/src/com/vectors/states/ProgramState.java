package com.vectors.states;

import com.vectors.Vector;

public class ProgramState extends State {

    Vector v;
    double sum;

    Vector p;
    double square;
    double circle;

    public ProgramState() {
        this.v = new Vector(1, 1);
        this.p = new Vector(0, 0);
        square = 0;
        circle = 0;
    }

    @Override
    public void update() {
        sum = v.getX() + v.getY();
        v.setX(v.getY());
        v.setY(sum);

        p.setX(Math.random() * 2 - 1);
        p.setY(Math.random() * 2 - 1);
        square++;
        if(p.length() <= 1)
            circle++;
    }

    @Override
    public void render() {
        System.out.println(v.getY() / v.getX()); // Phi
        System.out.println(circle / square * 4.0); // Pi
    }
}
