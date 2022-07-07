package ua.ithillel.homeworks.homework7.intLlinkedList;

import java.util.Arrays;

public class IntLinkedList implements IntList, IntStack, IntQueue {
    public static class Item {
        int value;
        Item next;
        Item prev;

        public Item(int value) {
            this.value = value;
        }
    }

    public Item fstItem;
    public Item lstItem;
    public int size;

    @Override
    public void add(int value) {
        Item newItem = new Item(value);
        if (size == 0) {
            fstItem = newItem;
            lstItem = newItem;
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
        Item preItem = null;
        Item item = fstItem;
        boolean elementFound = false;
        for (int i = 0; i < size; i++) {
            if (item.value == value) {
                if (preItem != null) {
                    preItem.next = item.next;
                }
                item = item.next;
                elementFound = true;
            } else {
                preItem = item;
                item = item.next;
            }
        }
        return elementFound;
    }

    @Override
    public IntList subList(int fromIndex, int toIndex) {
        IntList list = new IntLinkedList();
        for (int i = fromIndex; i < toIndex; i++) {
            list.add(get(i));
            if (fromIndex < 0 || toIndex > size) {
                throw new IndexOutOfBoundsException("Index Out Of Bounds Exception");
            }
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