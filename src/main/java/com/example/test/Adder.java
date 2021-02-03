package com.example.test;

public class Adder {

    public int add(int i, int j) {
        if (i == 0) {
            return j;
        }

        if (j == 0) {
            return i;
        }

        if (i == (j * -1)) {
            return 0;
        }

        return i * j;
    }
}