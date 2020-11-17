package exercises.chapter6genericprogramming.exercise3;

import java.util.ArrayList;

class Table<K, V> {
    private ArrayList<Entry<K, V>> elements;

    public Table() { elements = new ArrayList<>(); }

    public void put(K key, V value) {
        for(Entry entry : elements) {
            if(entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }

        elements.add(new Entry<>(key, value));
    }

    @SuppressWarnings("unchecked")
    public V get(K key) {
        for(Entry entry : elements) {
            if(entry.getKey().equals(key)) {
                return (V) entry.getValue();
            }
        }

        return null;
    }

    public void remove(K key) {
        for(Entry entry : elements) {
            if(entry.getKey().equals(key)) {
                elements.remove(entry);
            }
        } 
    }

}
