package java;

import java.util.Iterator;

public class DoublyLL <T> implements Iterable <T> {

    private int size = 0;
    private Node <T> head = null;
    private Node <T> tail = null;

    // Internal node class to represent data
    private class Node <T> {
        T data;
        Node <T> prev, next;
        public Node(T data, Node <T> prev, Node <T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
        @Override
        public String toString() {
            return data.toString();
        }
    }

    // Empty this linked list, O(n)
    public void clear() {
        // Starts tracker at beginning
        Node <T> tracker = head;
        while(tracker != null) {
            // Temporarily holds next value
            Node <T> next = tracker.next;
            // Erases variables for current node
            tracker.prev = tracker.next = null;
            tracker.data = null;
            // Moves tracker to next node
            tracker = next;
        }
        // Resets variables
        head = tail = tracker = null;
        size = 0;
    }

    // Return size of linked list
    public int size() {
        return size;
    }

    // Is the linked list empty?
    public boolean isEmpty() {
        return size() == 0;
    }

    // Add an element to the tail of the linked list, O(1)
    public void add(T elem) {
        addLast(elem);
    }

    // Add an element to the beginning of this linked list, O(1)
    public void addFirst(T elem) {

        // The linked list is empty
        if (isEmpty()) {
            head = tail = new Node <T> (elem, null, null);
        }
        else {
            head.prev = new Node <T> (elem, null, head);
            head = head.prev;
        }
        size++;
    }

    // Add a node to the tail of the linked list, O(1)
    public void addLast(T elem) {

        // The linked list is empty
        if (isEmpty()) {
            head = tail = new Node <T> (elem, null, null);
        }
        else {
            tail.next = new Node <T> (elem, tail, null);
            tail = tail.next;
        }
        size++;
    }

    // Check the value of the first node if it exists, O(1)
    public T peekFirst() {
        if (isEmpty()) throw new RuntimeException("Empty list");
        return head.data;
    }

    // Check the value of the last node if it exists, O(1)
    public T peekLast() {
        if (isEmpty()) throw new RuntimeException("Empty list");
        return tail.data;
    }

    // Remove the first value at the head of the linked list, O(1)
    public T removeFirst() {

        // Can't remove data from an empty list
        if (isEmpty()) throw new RuntimeException("Empty list");

        // Extract the data at the head and move
        // the head pointer forwards one node
        T data = head.data;
        head = head.next;
        --size;

        // If the list is empty set the tail to null as well
        if (isEmpty()) tail = null;

        // Do a memory clean of the previous node
        else head.prev = null;

        // Return the data that was at the first node we just removed
        return data;
    }

    // Remove the last value at the tail of the linked list, O(1)
    public T removeLast() {

        // Can't remove data from an empty list
        if (isEmpty()) throw new RuntimeException("Empty list");

        // Extract the data at the tail and move
        // the tail pointer backwards one node
        T data = tail.data;
        tail = tail.prev;
        --size;

        // If the list is now empty set the head to null as well
        if (isEmpty()) head = null;

        // Do a memory clean of the node that was just removed
        else tail.next = null;

        // Return the data that was at the first node we just removed
        return data;
    }

    // Remove an arbitrary node from the linked list, O(1)
    private T remove(Node <T> node) {

        // If the node to remove is somewhere either at the
        // head or tail handle those independently
        if (node.prev == null) return removeFirst();
        if (node.next == null) return removeLast();

        // Make the pointers of adjacent nodes skip over 'node'
        node.next.prev = node.prev;
        node.prev.next = node.next;

        // Temporary store the data we want to return
        T data = node.data;

        // Memory cleanup
        node.data = null;
        node = node.prev = node.next = null;

        --size;

        // Return the data at the node we just removed
        return data;
    }

    // Remove a node at a particular index, O(n)
    public T removeAt(int index) {

        // Make sure the index provided is valid
        if (index < 0 || index >= size) throw new IllegalArgumentException();

        int i;
        Node <T> tracker;

        // Search from the front of the list
        if (index < size/2) {
            for (i = 0, tracker = head; i != index; i++) {
                tracker = tracker.next;
            }
        }
        // Search from the back of the list
        else {
            for(i = size-1, tracker = tail; i != index; i--) {
                tracker = tracker.prev;
            }
        }
        return remove(tracker);
    }

    public boolean remove(Object obj) {

        Node <T> tracker = head;

        // Support searching for null
        if (obj == null) {
            for(tracker = head; tracker != null; tracker = tracker.next) {
                if (tracker.data == null) {
                    remove(tracker);
                    return true;
                }
            }
        }
        // Search for non null object
        else {
            for(tracker = head; tracker != null; tracker = tracker.next) {
                if (obj.equals(tracker.data)) {
                    remove(tracker);
                    return true;
                }
            }
        }
        return false;
    }

    // Find the index of a particular value in the linked list, O(n)
    public int indexOf(Object obj) {

        int index = 0;
        Node <T> tracker = head;

        // Support searching for null
        if (obj == null) {
            for(tracker = head; tracker != null; tracker = tracker.next, index++) {
                if (tracker.data == null) return index;
            }
        }
        // Search for non null object
        else {
            for(tracker = head; tracker != null; tracker = tracker.next, index++) {
                if (obj.equals(tracker.data)) return index;
            }
        }

        return -1;
    }

    // Check if a value is contained within the linked list
    public boolean conatins(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator <T> () {
            private Node<T> tracker = head;
            @Override
            public boolean hasNext() {
                return tracker != null;
            }
            @Override public T next() {
                T data = tracker.data;
                tracker = tracker.next;
                return data;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node<T> tracker = head;
        while(tracker != null) {
            sb.append(tracker.data + ", ");
            tracker = tracker.next;
        }
        sb.append(" ]");
        return sb.toString();
    }
}