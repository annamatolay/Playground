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
        increaseArrayCapacity();
        this.array[this.size] = value;
        this.size++;
    }

    @SuppressWarnings("unchecked")
    public Type get(int index) { return (Type) array[index];}

    public void set(Type newValue, int index) { array[index] = newValue; }


    public void remove(int index) {
        switch (array.length) {
            case 0:
                throw new ArrayIndexOutOfBoundsException();
            case 1:
                if (index != 1) throw new ArrayIndexOutOfBoundsException();
                clear();
                return;
            default:
                copyArray(index);
        }
        this.size--;
    }

    public void clear() { createEmptyArray(); }

    private void createEmptyArray() {
        this.size = 0;
        this.array = new Object[size];
    }

    private void increaseArrayCapacity() {
        if (this.size == 0) { this.array = new Object[1]; }
        else if (this.size == this.array.length) {
            copyArray();
        }
    }

    private void copyArray() {
        Object[] tmpArray = this.array;
        setNewEmptyArray();
        System.arraycopy(tmpArray, 0, this.array, 0, tmpArray.length);
    }

    private void copyArray(int index) {
        Object[] tmpArray = this.array;
        setNewEmptyArray();
        System.arraycopy(tmpArray, 0, this.array, 0, index);
        System.arraycopy(tmpArray, index + 1, this.array, index, size - index - 1);
    }

    private void setNewEmptyArray() {
        if (this.size == this.array.length) this.array = new Object[this.size * 2];
        else this.array = new Object[this.size];
    }
}
