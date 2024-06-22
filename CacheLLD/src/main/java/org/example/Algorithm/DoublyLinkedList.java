package org.example.Algorithm;

public class DoublyLinkedList<E> {
    private Node<E> head= null;
    private Node<E> tail = null;
    public DoublyLinkedList() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }

    /**
     * Method to add a new node to doubly linked list.
     * @param node
     */
    public void insertNode(Node<E> node) {
       node.next = head.next;
       node.next.prev = node;
       node.prev = head;
       head.next = node;
    }

    /**
    Method to delete a node from doubly linked list.
    Remove links of this node from existing nodes.
     */
    public void deleteNode(Node<E> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.next = null;
        node.prev = null;
    }

    /**
     * Method to retrieve last node from the linked list.
     * @return
     */
    public Node<E> getLastNode() {
        return tail.prev;
    }
}
