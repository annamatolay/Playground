package com.palmatolay.collections;

@SuppressWarnings("WeakerAccess")
public class ArrayList<Type> {

    private Object[] array;
    private int size;

    public ArrayList() {
        createEmptyArray();
    }


    public int size() { return this.size; }

    public void add(Type value) {
        increaseSize();
        this.array[this.size] = value;
        this.size++;
    }

    @SuppressWarnings("unchecked")
    public Type get(int index) { return (Type) array[index];}

    //public Type set() {}

    public void set(Type newValue, int index) { array[index] = newValue; }


    public void remove(int index) {}

    public void clear() { createEmptyArray(); }

    private void createEmptyArray() {
        this.size = 0;
        this.array = new Object[size];
    }

    private void increaseSize() {
        if (this.size == 0) { this.array = new Object[1]; }
        else if (this.size == this.array.length) {
            copyArray(true);
        }
    }

    @SuppressWarnings("SameParameterValue")
    private void copyArray(boolean increaseSize) {
        Object[] tmpArray = this.array;
        if (increaseSize) this.array = new Object[this.size * 2];
        else this.array = new Object[this.size];
        System.arraycopy(tmpArray, 0, this.array, 0, tmpArray.length);
    }

}
