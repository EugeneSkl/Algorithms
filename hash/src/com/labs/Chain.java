package com.labs;

import java.util.ArrayList;

class Node<KeyType, ValueType> {
    KeyType key;
    ValueType value;

    Node<KeyType, ValueType> next;

    public Node(KeyType key, ValueType value) {
        this.key = key;
        this.value = value;
    }
}

class ChainHashTable<KeyType, ValueType> {
    private ArrayList<Node<KeyType, ValueType>> chains;
    private int size;
    private int chainsAmount;

    public ChainHashTable() {
        chains = new ArrayList<>();
        chainsAmount = 5;
        size = 0;
        for (int i = 0; i < chainsAmount; i++)
            chains.add(null);
    }

    public int getSize() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public float getFillFactor() {
        return (float)size / chainsAmount;
    }

    private int getChainIndex(KeyType key) {
        int hashCode = key.hashCode();
        return hashCode % chainsAmount;
    }

    public ValueType get(KeyType key) {
        int index = getChainIndex(key);
        Node<KeyType, ValueType> head = chains.get(index);
        while (head != null) {
            if (head.key.equals(key))
                return head.value;
            head = head.next;
        }
        return null;
    }

    public void insert(KeyType key, ValueType value) {
        int index = getChainIndex(key);
        Node<KeyType, ValueType> head = chains.get(index);
        Node<KeyType, ValueType> head_insert = head;
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        Node<KeyType, ValueType> tempNode = new Node<>(key, value);
        tempNode.next = head_insert;
        chains.set(index, tempNode);

        if (getFillFactor() >= 0.75) {
            rehash();
        }
    }

    public ValueType remove(KeyType key) {
        int index = getChainIndex(key);
        Node<KeyType, ValueType> head = chains.get(index);
        Node<KeyType, ValueType> prev = null;
        while (head != null) {
            if (head.key.equals(key))
                break;
            prev = head;
            head = head.next;
        }
        if (head == null)
            return null;
        size--;
        if (prev != null)
            prev.next = head.next;
        else
            chains.set(index, head.next);

        return head.value;
    }

    private void rehash(){
        System.out.println("REHASH!");
        ArrayList<Node<KeyType, ValueType>> tempHashTable = chains;
        chains = new ArrayList<>();
        chainsAmount = 2 * chainsAmount;
        size = 0;
        for (int i = 0; i < chainsAmount; i++) {
            chains.add(null);
        }

        for (Node<KeyType, ValueType> headNode : tempHashTable) {
            while (headNode != null) {
                insert(headNode.key, headNode.value);
                headNode = headNode.next;
            }
        }
    }
}