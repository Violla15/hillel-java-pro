package ua.ithillel.homeworks.homework7.linkedList;
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
        if (fstItem == null) {
            newItem.next = null;
            newItem.prev = null;
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
            throw new IndexOutOfBoundsException("Incorrect index");
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

    private Item getItemByIndex(int index) {
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
    public int get(int index) {
        return getItemByIndex(index).value;
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
            Item  finedValue = getItemByIndex(index - 1);
            Item  removedValue = getItemByIndex(index);
            finedValue.next =removedValue.next;
        }
        size--;
        return false;
    }

    @Override
    public boolean removeByValue(int value) {
        if (value == 0) {
            value = fstItem.value;
            fstItem = fstItem.next;
            if (fstItem == null) {
                lstItem = null;
            }
        } else {
            Item prev = getItemByIndex(value - 1);
            value = prev.next.value;
            prev.next = prev.next.next;
            if (value == size - 1) {
                lstItem = prev;
            }
        }
        return true;
    }

    @Override
    public IntList subList(int fromIndex, int toIndex) {
        IntList list = new IntLinkedList();
        for (int i = fromIndex; i < toIndex; i++) {
            list.add(get(i));
        }
        return list;
    }

    @Override
    public int[] toArray() {
        if (isEmpty()) {
            return null;
        }
        int length = size(), i = 0;
        int[] myArray = new int[length];
        Item element;
        for (element = fstItem; element != null; element = element.next) {
            myArray[i] = element.value;
            i++;
        }
        return myArray;
    }

    @Override
    public int remove() {
        Item  removedFirstValue = fstItem;
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