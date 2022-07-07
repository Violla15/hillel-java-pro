package ua.ithillel.homeworks.homework7.list;

public interface IntList{

    void add(int value);

    boolean add(int index, int value);

    void clear();

    int get(int index);

    boolean isEmpty();

    boolean remove(int index);

    boolean removeByValue(int value);

    int size();

    IntList subList(int fromIndex, int toIndex);

    int[] toArray();
}
