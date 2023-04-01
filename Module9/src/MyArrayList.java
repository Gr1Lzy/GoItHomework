import java.util.Arrays;
import java.util.Objects;

public class MyArrayList<T> {
    private T[] elements;
    private static final int DEFAULT_CAPACITY = 10;
    private int size;

    public MyArrayList() {
        elements = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    //добавляет элемент в конец
    void add(T value) {
        if (elements.length == size) {
            increaseCapacity();
        }
        elements[size++] = value;
    }

    private void increaseCapacity() {
        elements = Arrays.copyOf(elements, elements.length + 5);
    }

    //удаляет элемент под индексом
    void remove(int index) {
        Objects.checkIndex(index, size);
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
    }

    //очищает коллекцию
    void clear() {
        elements = Arrays.copyOf(elements, DEFAULT_CAPACITY);
        size = 0;
    }

    //возвращает размер коллекции
    int size() {
        return size;
    }

    //возвращает элемент под индексом
    T get(int index) {
        Objects.checkIndex(index, size);
        return elements[index];
    }

    @Override
    public String toString() {
        return GetString.getString(elements, size);
    }
}