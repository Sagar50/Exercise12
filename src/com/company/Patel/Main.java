//Sagar Patel, CSCI1660, 4/1/2020

package com.company.Patel;

class StackFullException extends Exception {}

class StackEmptyException extends Exception {}

class QueueFullException extends Exception {}
class QueueEmptyException extends Exception {}



class Stack<E> {
    private E[] elements;
    private int index = 0;
    private int size;

    Stack(int size) {
        elements = (E[]) new Object[size];
        this.size = size;
    }

    void push(E element ) throws StackFullException {
        if (index >= size) {
            throw new StackFullException();
        }

        elements[index] = element;
        index++;
    }

    E pop () throws StackEmptyException {
        if (index == 0) {
            throw new StackEmptyException();
        }

        E returnElement = elements[index - 1];
        index--;
        return returnElement;
    }
}
class Queue<E> {
    private E[] elements;
    private int index = 0;
    private int size;

    Queue(int size) {
        elements = (E[]) new Object[size];
        this.size = size;
    }

    void enqueue(E element ) throws QueueFullException {
        if (index >= size) {
            throw new QueueFullException();
        }

        elements[index] = element;
        index++;
    }

    E dequeue () throws QueueEmptyException {
        if (index == 0) {
            throw new QueueEmptyException();
        }

        E returnElement = elements[index - 1];
        index--;
        return returnElement;
    }
}


public class Main {
    public static void main(String[] agrs) {
        Queue<String> strings = new Queue<>(2);
        try {
            strings.enqueue("World");
            strings.enqueue("Hello");
            System.out.println(strings.dequeue());
            System.out.println(strings.dequeue());
        } catch (QueueFullException | QueueEmptyException e) {
            e.printStackTrace();
        }

    }
}