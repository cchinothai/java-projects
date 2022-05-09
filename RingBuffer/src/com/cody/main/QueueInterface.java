package com.cody.main;
/**
 * Generic Queue Interface
 * CS 108 Fall 2020
 * @author Cody Chinothai
 */

public interface QueueInterface<E> {

    /**
     * The enQueue method inserts an element
     * in the Queue and return true, if successful
     * The element is always entered at the end
     * of the queue.
     *
     * @param E value to be inserted
     * @return boolean true, if successful, false otherwise
     */
    boolean enQueue(E input);

    /**
     * The deQueue deletes an element in the
     * Queue, and returns the element.
     * The element is always removed from the
     * front of the queue.
     *
     * @return E value of the removed element
     */
     E deQueue();

    /**
     * The peek method returns the head (or the
     * first element) of the Queue
     *
     * @return E value of the first element
     */
     E peek();

    /**
     * The isEmpty() method returns true if the
     * Queue is empty, false otherwise
     *
     * @return boolean true, if empty, false otherwise
     */
     boolean isEmpty();
}

