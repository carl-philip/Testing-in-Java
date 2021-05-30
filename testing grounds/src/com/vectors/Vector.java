package com.vectors;

public class Vector {

    // Attributes

    private double x, y;

    // Constructor

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Setters and getters

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    // Methods

    public double length() {
        return Math.sqrt(dot(this, this));
    }

    public double angle() {
        return Math.atan2(this.y, this.x);
    }

    public Vector rotate(double v) {
        double x2 = this.x * Math.cos(v) - this.y * Math.sin(v);
        double y2 = this.x * Math.sin(v) + this.y * Math.cos(v);
        return new Vector(x2, y2);
    }

    public Vector projectOn(Vector a) {
        return a.scale(dot(this, a) / dot(a, a));
    }

    public Vector scale(double n) {
        return new Vector(this.x * n, this.y * n);
    }

    public Vector normalize() {
        double len = this.length();
        return new Vector(this.x / len, this.y / len);
    }

    public static Vector add(Vector a, Vector b) {
        return new Vector(a.x + b.x, a.y + b.y);
    }

    public static Vector subtract(Vector a, Vector b) {
        return new Vector(a.x - b.x, a.y - b.y);
    }

    public static double dot(Vector a, Vector b) {
        return a.x * b.x + a.y * b.y;
    }
}