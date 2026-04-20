package main;

/**
 * @author Pstyga Stas
 * @created 20.04.2026
 */
public class CustomArrayList<T> {

    private static final int DEFAULT_SIZE = 10;
    private Object[] array;
    private int size;

    public CustomArrayList() {
        this.array = new Object[DEFAULT_SIZE];
        this.size = 0;
    }

    public CustomArrayList(int initialSize) {
        this.array = new Object[initialSize];
        this.size = 0;
    }

    public void add(T element) {
        if (size == array.length) {
            Object[] newArray = new Object[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[size] = element;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size--;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) array[index];
    }

    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (array[i] == null && element == null) {
                return true;
            }
            if (array[i] != null && array[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder str = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            str.append(array[i]);
            if (i < size - 1) {
                str.append(", ");
            }
        }
        str.append("]");
        return str.toString();
    }
}
