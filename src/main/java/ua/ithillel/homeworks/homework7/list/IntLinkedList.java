package ua.ithillel.homeworks.homework7.list;

import java.util.Arrays;

public class IntLinkedList implements IntList, IntStack, IntQueue {
    public static class Item {
        int value;
        Item next;
        Item prev;

        public Item() {
        }

        public Item(int value) {
            this.value = value;
        }
    }

    private Item fstItem;
    private Item lstItem;
    private int size;

    @Override
    public void add(int value) {
        Item newItem = new Item(value);
        if (size == 0) {
            fstItem = newItem;
        } else {
            lstItem.next = newItem;
            newItem.prev = lstItem;
        }
        lstItem = newItem;
        size++;
    }

    @Override
    public boolean add(int index, int value) {
        Item newItem = new Item(value);
        if (index == 0) {
            fstItem.prev = newItem;
            newItem.next = fstItem;
            fstItem = newItem;
            size++;
        } else if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index Out Of Bounds Exception");
        } else if (index == size) {
            add(value);
        } else {
            Item newItem2 = fstItem;
            for (int i = 0; i < index; i++) {
                newItem2 = newItem2.next;
            }
            Item newItemPrev = newItem2.prev;
            newItemPrev.next = newItem2;
            newItem2.prev = newItem2;

            newItem.prev = newItemPrev;
            newItem.next = newItem2;
            size++;
        }
        return true;
    }

    @Override
    public int get(int index) {
        return getItemByIndex(index).value;
    }

    private Item getItemByIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index Out Of Bounds Exception");
        }
        Item current = fstItem;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public void clear() {
        fstItem = lstItem = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index Out Of Bounds Exception");
        } else if (index == 0) {
            fstItem = fstItem.next;
        } else {
            Item finedValue = getItemByIndex(index - 1);
            Item removedValue = getItemByIndex(index);
            finedValue.next = removedValue.next;
        }
        size--;
        return true;
    }

    @Override
    public boolean removeByValue(int value) {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Index Out Of Bounds Exception");
        } else if (size == 1) {
            fstItem = null;
            lstItem = null;
            size = 0;
            return true;
        } else {
            Item newItemPrev = searchingPreviousItem(value);
            assert newItemPrev != null;
            if (newItemPrev.value == 0) {

                fstItem = fstItem.next;
            } else {
                if (lstItem.value == value) {
                    newItemPrev.next = null;
                    lstItem = newItemPrev;
                } else {
                    newItemPrev.next = newItemPrev.next.next;
                }
            }
            size--;
            return true;
        }
    }

    private Item searchingPreviousItem(int element) {
        if (fstItem.value == element) {
            return new Item();
        } else {
            Item newItem = fstItem;
            while (newItem.next != null) {
                if (newItem.next.value == element) {
                    return newItem;
                } else {
                    newItem = newItem.next;
                }
            }
        }
        return null;
    }

    @Override
    public IntList subList(int fromIndex, int toIndex) {
        IntList list = new IntLinkedList();
        if (fromIndex < 0 || toIndex > size) {
            return list;
        }
        for (int i = fromIndex; i < toIndex; i++) {
            list.add(get(i));
        }
        return list;
    }


    @Override
    public int[] toArray() {
        int[] myArray = new int[size];
        Item element = fstItem;
        for (int i = 0; i < size; i++) {
            myArray[i] = element.value;
            element = element.next;
        }
        return myArray;
    }

    @Override
    public int remove() {
        Item removedFirstValue = fstItem;
        remove(0);
        return removedFirstValue.value;
    }

    @Override
    public int element() {
        return fstItem.value;
    }

    @Override
    public int pop() {
        Item removedTopValue = fstItem;
        remove(0);
        return removedTopValue.value;
    }

    @Override
    public int peek() {
        return fstItem.value;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}