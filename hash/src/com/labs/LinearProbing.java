package com.labs;

class LinearProbingTable<KeyType, ValueType> {
    private KeyType[] keys;
    private ValueType[] values;
    private int size;
    private int maxSize;

    public LinearProbingTable() {
        maxSize = 3;
        keys = (KeyType[])new Object[maxSize];
        values = (ValueType[])new Object[maxSize];
        size = 0;
        for (int i = 0; i < maxSize; i++){
            keys[i] = null;
            values[i] = null;
        }
    }

    public int getSize() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public float getFillFactor() {
        return (float)size / maxSize;
    }

    private int getIndex(KeyType key) {
        int hashCode = key.hashCode();
        return hashCode % maxSize;
    }

    public ValueType get(KeyType key) {
        int index = getIndex(key);
        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                return values[index];
            }
            index = (index + 1) % maxSize;
        }
        return null;
    }

    public void insert(KeyType key, ValueType value) {
        int index = getIndex(key);
        for (int forward = 0; forward < maxSize; index = (index + 1) % maxSize, forward++){
            if (keys[index] == null) {
                keys[index] = key;
                values[index] = value;
                size++;
                return;
            }
            if (keys[index].equals(key)) {
                values[index] = value;
                return;
            }
        }
        rehash();
        insert(key, value);

    }

    public ValueType remove(KeyType key) {
        int index = getIndex(key);
        for (int forward = 0; forward < maxSize; index = (index + 1) % maxSize, forward++){
            if (keys[index] == null){
                continue;
            }
            if (keys[index].equals(key)) {
                ValueType removedValue = values[index];
                values[index] = null;
                keys[index] = null;
                size--;
                return removedValue;
            }
        }
        return null;
    }

    private void rehash(){
        System.out.println("REHASH!");
        maxSize = 2 * maxSize;
        KeyType[] temp_keys = keys;
        ValueType[] temp_values = values;
        this.keys = (KeyType[])new Object[maxSize];
        this.values = (ValueType[])new Object[maxSize];
        int old_size = size;
        size = 0;
        for (int i = 0; i < maxSize; i++) {
            keys[i] = null;
            values[i] = null;
        }
        for (int i = 0; i < old_size; i++) {
            insert(temp_keys[i], temp_values[i]);
        }
    }
}