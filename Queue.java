package in.mocktest3;

public class Queue {
    private Node front; 
    private Node rear; 

    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Queue() {
        front = null;
        rear = null;
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        System.out.println("Enqueued element: " + value);
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue element.");
            return -1;
        }

        int dequeuedElement = front.data;
        front = front.next;

        if (front == null) {
            rear = null; // Update rear to null if the queue becomes empty after dequeueing
        }

        return dequeuedElement;
    }

    public boolean isEmpty() {
        return (front == null);
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("Is queue empty? " + queue.isEmpty());
        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Is queue empty? " + queue.isEmpty());
    }
}