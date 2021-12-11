import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] a;
    private int n;

    public RandomizedQueue() {
        a = (Item[]) new Object[2];
        n = 0;
    }



    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void enqueue(Item item) {
        if (item == null) throw new NullPointerException();
        if (n == a.length) resize(2 * a.length);
        a[n++] = item;
    }

    private void resize(int length) {
        Item[] temp = (Item[]) new Object[length];
        for (int i = 0; i < n; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        if (n == a.length / 4) resize(a.length / 2);
        int index = StdRandom.uniform(n);
        Item item = a[index];
        if(index != n-1) {
            a[index] = a[n-1];
        }
        a[n] = null;
        return item;
    }

    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException();
        int index = StdRandom.uniform(n);
        return a[index];
    }

    @Override
    public Iterator<Item> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<Item> {

        private int i;

        public ArrayListIterator() {

        }

        @Override
        public boolean hasNext() {
            return i < n;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            } else{
                return a[i++];
            }

        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    public static void main(String[] args) {
    }

}