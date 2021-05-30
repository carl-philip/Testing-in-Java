package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // initializes a tree with root as user input

        //Node n = new Node(30, new Node(2), new Node(15, new Node(3), new Node(5)));
        Scanner scanner = new Scanner(System.in);
        int num;
        while (true) {
            System.out.print("Enter a whole number: ");
            num = scanner.nextInt();
            if (num >= 2)
                break;
        }
        Node n = new Node(num);

        // fills tree with factors and output

        n.factorize();
        //n.outputLeavesStructured();
        //n.outputLeaves();
        //System.out.println();
        //System.out.println(n.leafSum());
        System.out.println("Prime factors of " + n.getV() + ": " + n.getLeavesVec());
        System.out.println("Product of leaf nodes are: " + n.leafProd());
    }
}
