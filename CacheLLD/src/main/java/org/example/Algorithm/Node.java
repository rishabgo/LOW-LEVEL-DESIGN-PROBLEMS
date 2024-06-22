package org.example.Algorithm;

public class Node<E> {
    protected Node<E> prev;
    protected Node<E> next;
    protected E element;

    public Node(E element) {
        this.element = element;
    }

    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getPrev() {
        return prev;
    }

    public Node<E> getNext() {
        return next;
    }

    public E getElement() {
        return element;
    }
}
