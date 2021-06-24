package com.caching.system.algo;

public class DoublyLinkedListNode<E> {

    DoublyLinkedListNode<E> next;
    DoublyLinkedListNode<E> prev;
    E element;

    public DoublyLinkedListNode(E element) {
        this.element = element;
        this.next = null;
        this.prev = null;
    }
}
