package com.zcl.somecode.concurrent.thread;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue<T> {

    private Queue<T> queue = new LinkedList<T>();
    private int capacity;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void put(T element) throws InterruptedException {
    	System.out.println(Thread.currentThread().getId()+":put!");
        while(queue.size() == capacity) {
        	System.out.println(Thread.currentThread().getId()+":put-wait!");
            wait();
        }
        System.out.println(Thread.currentThread().getId()+":put-add!");
        queue.add(element);
        notify(); // notifyAll() for multiple producer/consumer threads
    }

    public synchronized T take() throws InterruptedException {
    	System.out.println(Thread.currentThread().getId()+":take!");
        while(queue.isEmpty()) {
        	System.out.println(Thread.currentThread().getId()+":take-wait!");
            wait();
        }
        System.out.println(Thread.currentThread().getId()+":take-remove!");
        T item = queue.remove();
        notify(); // notifyAll() for multiple producer/consumer threads
        return item;
    }
}
