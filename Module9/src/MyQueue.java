import java.util.Arrays;

public class MyQueue<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] elements;
    private int size;

    public MyQueue() {
        elements = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    void add(T value) { // добавляет элемент в конец
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, elements.length + 5);
        }
        elements[size++] = value;
    }

    T peek() { // возвращает первый элемент в очереди (FIFO)
        return elements[0];
    }

    T poll() { // возвращает первый элемент в очереди и удаляет его из коллекции
        T temp = peek();
        System.arraycopy(elements, 1, elements, 0, size - 1);
        elements[--size] = null;
        return temp;
    }

    void clear() { // очищает коллекцию
        elements = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    int size() { // возвращает размер коллекции
        return size;
    }

    @Override
    public String toString() {
        return GetString.getString(elements, size);
    }
}