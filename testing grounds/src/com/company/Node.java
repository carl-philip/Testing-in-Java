package com.company;
import java.util.Vector;

public class Node {

    // attributes

    private int v;
    private Node l, r;

    // initializers

    public Node(int v, Node l, Node r) {
        this.v = v;
        this.l = l;
        this.r = r;
    }
    public Node(int v) {
        this.v = v;
        this.l = null;
        this.r = null;
    }

    // functions

    public int getFact(int n) {
        if(n % 2 == 0)
            return 2;
        for(int i = 3;i <= i*n;i +=2) {
            if(n % i == 0)
                return i;
        }
        return n;
    }
    public void factorize() {
        if(getFact(this.v) == this.v) {
            this.l = null;
            this.r = null;
            return;
        } else {
            this.l = new Node(getFact(this.v));
            this.r = new Node(this.v / getFact(this.v));
            this.r.factorize();
            return;
        }
    }
    public void outputLeavesStructured()
    {
        if(this.l == null || this.r == null) {
            System.out.print(this.v);
        } else {
            System.out.print("( ");
            this.l.outputLeavesStructured();
            System.out.print(", ");
            this.r.outputLeavesStructured();
            System.out.print(" )");
        }
    }
    public Vector<Integer> getLeavesVec() {
        Vector<Integer> temp = new Vector<Integer>();
        if(this.l == null || this.r == null) {
            temp.add(this.v);
        } else {
            Vector<Integer> lv = this.l.getLeavesVec();
            Vector<Integer> rv = this.r.getLeavesVec();
            for (int i = 0; i < lv.size(); i++)
                temp.add(lv.get(i));
            for (int i = 0; i < rv.size(); i++)
                temp.add(rv.get(i));
        }
        return temp;
    }
    public void outputLeaves() {
        if(this.l == null || this.r == null) {
            System.out.print(this.v);
        } else {
            this.l.outputLeaves();
            System.out.print(", ");
            this.r.outputLeaves();
        }
    }
    public int treeSum() {
        if(this.l == null || this.r == null) {
            return this.v;
        } else {
            return this.v + this.l.treeSum() + this.r.treeSum();
        }
    }
    public int leafSum() {
        if(this.l == null || this.r == null) {
            return this.v;
        } else {
            return this.l.leafSum() + this.r.leafSum();
        }
    }
    public int leafProd() {
        if(this.l == null || this.r == null) {
            return this.v;
        } else {
            return this.l.leafProd() * this.r.leafProd();
        }
    }

    // setters & getters

    public int getV() {
        return v;
    }
    public void setV(int v) {
        this.v = v;
    }
    public Node getL() {
        return l;
    }
    public void setL(Node l) {
        this.l = l;
    }
    public Node getR() {
        return r;
    }
    public void setR(Node r) {
        this.r = r;
    }
}
