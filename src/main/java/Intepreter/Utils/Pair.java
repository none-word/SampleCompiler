package Intepreter.Utils;

import java.io.Serializable;

public class Pair<K,V> implements Serializable{
    private K key;

    public K getKey() { return key; }

    private V value;

    public V getValue() { return value; }

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void setPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return key + "=" + value;
    }
}

