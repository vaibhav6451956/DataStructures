package com.vaibhav.hashTables;


//Every row in a Hashtable is a BUCKET which can be any DS here we take it as Linked list.
//Every row can have 1 or more ENTRIES depending on their hash value

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*1 or more blocks in a bucket is an ENTRY with a K,V pair stored on the index same as its has value
 * */
class Entry<K, V> {
    int hash; //will be calculated for each entry based on the key
    K key;
    V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
        this.hash = key.hashCode();
    }

    public boolean equals(Entry<K, V> other) {
        if (hash != other.hash) return false; //If hash code isn't equal, entries or Keys can't be equal
        return key.equals(other.key);
    }

    @Override
    public String toString() {
        return key + "=>" + value;
    }
}

public class HashTableSeparateChaining<K, V> implements Iterable<K> {
    private static final int DEFAULT_CAPACITY = 3;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;

    private double maxLoadFactor;
    private int capacity, threshold, size = 0;
    private LinkedList<Entry<K, V>>[] table; //HT is an array of Linked lists containing K,V pair\

    public HashTableSeparateChaining() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);//calls 3rd constructor to set initial values
    }

    public HashTableSeparateChaining(int capacity) {
        this(capacity, DEFAULT_LOAD_FACTOR);//calls 3rd constructor to set initial values per user input
    }

    // Designated constructor
    public HashTableSeparateChaining(int capacity, double maxLoadFactor) {
        if (capacity < 0) throw new IllegalArgumentException("Illegal capacity");
        if (maxLoadFactor <= 0 || Double.isNaN(maxLoadFactor) || Double.isInfinite(maxLoadFactor))
            throw new IllegalArgumentException("Illegal maxLoadFactor");
        this.maxLoadFactor = maxLoadFactor;
        this.capacity = Math.max(capacity, DEFAULT_CAPACITY);//Set whatever is maximum
        threshold = (int) (this.capacity * maxLoadFactor); //U can't store more than threshold. Also LF = threshold i.e. no of items present / capacity i.e. max items tht cn be stored
        table = new LinkedList[this.capacity]; // Initializing the array. Eg: int[] arr = new int[5]
    }

    // Returns the number of elements currently inside the hash-table
    public int size() {
        return size;
    }

    // Returns true/false depending on whether the hash-table is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Converts a hash value to an index. Essentially, this strips the
    // negative sign and places the hash value in the domain [0, capacity).
    //This method used only internally, hence private
    //(hash & 0x7FFFFFFF) will result in a positive integer. It sets first bit to 0, hence making it
    //a positive number. 0x7FFFFFFF is 0111 1111 1111 1111 1111 1111 1111 1111 : all 1 except the sign bit.
    private int normalizeIndex(int keyHash) {
        return (keyHash & 0x7FFFFFFF) % capacity;//Doing and AND operation
    }

    // Clears all the contents of the hash-table
    private void clear() {
        Arrays.fill(table, null);
        size = 0;
    }

    public boolean containsKey(K key) {
        return hasKey(key);
    }

    // Returns true/false depending on whether a key is in the hash table
    public boolean hasKey(K key) {
        int bucketIndex = normalizeIndex(key.hashCode());//find hash of the key to get the index it will be at
        return bucketSeekEntry(bucketIndex, key) != null;
    }

    // Finds and returns a particular Entry<K,V> in a given bucket if it exists, returns null otherwise
    private Entry<K, V> bucketSeekEntry(int bucketIndex, K key) {
        if (key == null) return null;
        LinkedList<Entry<K, V>> bucket = table[bucketIndex];// Fetch the bucket at index or hash of the key
        if (bucket == null) return null;
        for (Entry<K, V> entry : bucket) { //Iterate over all entries/items in designated bucket's linked list
            if (entry.key.equals(key)) return entry; //If you find the required entry return it
        }
        return null;
    }

    // Insert, put and add all place a value in the hash-table
    public V put(K key, V value) {
        return insert(key, value);
    }

    public V add(K key, V value) {
        return insert(key, value);
    }

    public V insert(K key, V value) {
        if (key == null) throw new IllegalArgumentException("Null key");
        Entry<K, V> newEntry = new Entry<>(key, value); //Create new entry object to insert with provided key and value
        int bucketIndex = normalizeIndex(newEntry.hash);
        return bucketInsertEntry(bucketIndex, newEntry);
    }

    // Inserts an entry in a given bucket only if the entry does not already
    // exist in the given bucket, but if it does then update the entry value
    private V bucketInsertEntry(int bucketIndex, Entry<K, V> entry) {
        LinkedList<Entry<K, V>> bucket = table[bucketIndex];
        if (bucket == null)
            table[bucketIndex] = bucket = new LinkedList<>();//if no entry on that index, create a new one

        Entry<K, V> existentEntry = bucketSeekEntry(bucketIndex, entry.key);//if an entry already exists with the key, get it and update the value
        if (existentEntry == null) {//Since entry does not exist for tht key, create one
            bucket.add(entry);
            if (++size > threshold) resizeTable();
            return null;// Use null to indicate that there was no previous entry
        } else {//Entry with key already exists, just update the value in it
            V oldVal = existentEntry.value;
            existentEntry.value = entry.value;
            return oldVal;
        }
    }

    // Resizes the internal table holding buckets of entries
    private void resizeTable() {
        capacity *= 2; //Increase the total capacity by 2
        threshold = (int) (capacity * maxLoadFactor); //Calculate new allowed threshold

        LinkedList<Entry<K, V>>[] newTable = new LinkedList[capacity];//Create a new HT with new capacity

        //Copy all entries in old HT to new HT
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                for (Entry<K, V> entry : table[i]) {
                    int bucketIndex = normalizeIndex(entry.hash);//Again calculate hash or index
                    LinkedList<Entry<K, V>> bucket = newTable[bucketIndex];//Create a new bucket at index
                    if (bucket == null)
                        newTable[bucketIndex] = bucket = new LinkedList<>(); //if bucket at that index is uninitialised, initialise it
                    bucket.add(entry);//if bucket already exists at tht index, just add the entry
                }

                // Avoid memory leak. Help the GC
                table[i].clear();//clearing the linked list at that index in old table
                table[i] = null;
            }
        }
    }

    // Gets a key's values from the map and returns the value.
    // NOTE: returns null if the value is null AND also returns
    // null if the key does not exists, so watch out..
    public V get(K key) {
        if (key == null) return null;
        int bucketIndex = normalizeIndex(key.hashCode());
        Entry<K, V> entry = bucketSeekEntry(bucketIndex, key);
        if (entry != null)
            return entry.value;
        return null;
    }

    // Removes a key from the map and returns the value.
    // NOTE: returns null if the value is null AND also returns
    // null if the key does not exists.
    public V remote(K key) {
        if (key == null) return null;
        int bucketIndex = normalizeIndex(key.hashCode());
        return bucketRemoveEntry(bucketIndex, key);
    }

    // Removes an entry from a given bucket if it exists
    private V bucketRemoveEntry(int bucketIndex, K key) {
        Entry<K, V> entry = bucketSeekEntry(bucketIndex, key);//find the entry to remove in given bucket
        if (entry != null) {
            LinkedList<Entry<K, V>> links = table[bucketIndex];
            links.remove(entry);//Removes the passed element in the linked list
            --size;
            return entry.value;
        } else return null;
    }

    // Returns the list of keys found within the hash table
    public List<K> keys() {
        List<K> keys = new ArrayList<K>(size());
        for (LinkedList<Entry<K, V>> bucket : table)
            if (bucket != null) for (Entry<K, V> entry : bucket) keys.add(entry.key);
        return keys;
    }

    // Returns the list of values found within the hash table
    public List<V> values() {
        List<V> values = new ArrayList<>(size());
        for (LinkedList<Entry<K, V>> bucket : table)
            if (bucket != null) for (Entry<K, V> entry : bucket) values.add(entry.value);
        return values;
    }

    // Return an iterator to iterate over all the keys in this map
    @Override
    public java.util.Iterator<K> iterator() {
        final int elementCount = size();
        return new java.util.Iterator<K>() {

            int bucketIndex = 0;
            java.util.Iterator<Entry<K, V>> bucketIter = (table[0] == null) ? null : table[0].iterator();

            @Override
            public boolean hasNext() {

                // An item was added or removed while iterating
                if (elementCount != size) throw new java.util.ConcurrentModificationException();

                // No iterator or the current iterator is empty
                if (bucketIter == null || !bucketIter.hasNext()) {

                    // Search next buckets until a valid iterator is found
                    while (++bucketIndex < capacity) {
                        if (table[bucketIndex] != null) {

                            // Make sure this iterator actually has elements -_-
                            java.util.Iterator<Entry<K, V>> nextIter = table[bucketIndex].iterator();
                            if (nextIter.hasNext()) {
                                bucketIter = nextIter;
                                break;
                            }
                        }
                    }
                }
                return bucketIndex < capacity;
            }

            @Override
            public K next() {
                return bucketIter.next().key;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
