package ua.ithillel.homeworks.homework7.linkedList;

public interface IntList{

    void add(int value);

    boolean add(int index, int value); // return true, if value by index was replaced

    void clear();

    int get(int index);

    boolean isEmpty();

    boolean remove(int index); // return true if element was removed

    boolean removeByValue(int value); // return true if element was removed

    int size();

    IntList subList(int fromIndex, int toIndex);

    int[] toArray();
}
