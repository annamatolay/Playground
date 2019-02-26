package com.palmatolay.collections;


// TODO: set(Object o, int i), clear(), remove(int i)
public class ArrayList<Type> {

    private Object[] array;
    private int size;

    public ArrayList() {
        this.size = 0;
        this.array = new Object[size];
    }

    public int size() { return this.size; }

    public void add(Type value) {
        increaseSize();
        this.array[this.size] = value;
        this.size++;
    }

    @SuppressWarnings("unchecked")
    public Type get(int index) { return (Type) array[index];}

    private void increaseSize() {
        if (this.size == 0) { this.array = new Object[1]; }
        else if (this.size == this.array.length) {
            Object[] tmpArray = this.array;
            this.array = new Object[this.size * 2];
            System.arraycopy(tmpArray, 0, this.array, 0, tmpArray.length);
        }
    }
}
