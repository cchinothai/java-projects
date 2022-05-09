package com.cody.main;

import java.util.Arrays;

/**
 * Program 7
 * Create a Ringbuffer (circular queue) by implementing the queue interface and it's methods, utilizing a generic array
 * along with queue related reference points to store elements. Modify enqueue and dequeue methods to account for the
 * circulation of the queue and how that affects the reference points. Then print out elements within queue.
 * CS108-3
 * @author Cody Chinothai
 */
//aim O(1) enqueue and dequeue execution within a FIFO structure
public class RingBuffer<E> implements QueueInterface<E> {
    private E[] buffer;
    private int size, front, rear;

    @SuppressWarnings("unchecked")
    public RingBuffer() {
        buffer = (E[]) new Object[10];
        size = 0;
        front = -1;
        rear = -1;
    }

    @SuppressWarnings("unchecked")
    public RingBuffer(int cap) {
        buffer = (E[]) new Object[cap];
        size = 0;
        front = -1;
        rear = -1;
    }

    //If capacity is full, return false. Else, add element to rear, increase size of list
    //adjust rear value and return true
    public boolean enQueue(E input) {
        //is it full?
        if (size == buffer.length)
            return false;
        else {
            if (isEmpty()) {
                front = 0;
            }
            //wrapping scenario ex) null,2,3,4,5
            if (rear == buffer.length - 1) {
                buffer[(rear + 1) % size] = input;
                size++;
            } else {
                rear++;
                buffer[rear] = input;
                size++;
            }
        }
        return true;

    }

    public E deQueue() {
        E element = null;
        //Is it empty?
        if (size == 0)
            return null;
        else {
            //removing element at last index
            if (front == buffer.length - 1) {
                element = buffer[front];
                buffer[front] = null;
                front = (front + 1) % size;
                return element;

            } else if (front == rear)//last element removed
            {
                front = -1;
                rear = -1;
                size = 0;
            } else {
                element = buffer[front];
                buffer[front] = null;
                front++;
            }
            size--;
        }
        return element;
    }

    public E peek() {
        if (size == 0)
            return null;
        return buffer[front];
    }

    public boolean isEmpty() {
        if (front == -1 && rear == -1)
            return true;
        return false;
    }

    //Hint: You store the number of elements in your data structure and Java stores the capacity of the array.
    public boolean isFull() {
        if (size == buffer.length)
            return true;
        return false;
    }

    public E last() {
        if (size == 0)
            return null;
        else
            return buffer[rear];
    }

    public Object[] getArray() {
        Object[] tmp = Arrays.copyOf(buffer, buffer.length);
        return tmp;
    }

    public int getSize() {
        return size;
    }

    ;

    public int getCapacity() {
        return buffer.length;
    }

    //Hint: The elements are between two pointers you already have implemented.
    public String toString() {
        String format = "";
        if (front != 0) {
            for (int i = front; i <= rear; i++) {
                if(buffer[i]!=null)
                    format += buffer[i] + ", ";
            }
            for (int i = 0; i < front - 1; i++) {
                if(buffer[i]!=null)
                    format += buffer[i] + ", ";
            }
            format += buffer[front - 1];
        } else {
            for (int i = front; i < rear; i++) {
                if(buffer[i]!=null)
                format += buffer[i] + ", ";
            }
            format += buffer[rear];

        }

        return format;
    }
}

