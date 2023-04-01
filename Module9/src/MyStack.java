import java.util.Arrays;

public class MyStack<T> {
    private T[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyStack() {
        elements = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    void push(T value) { // добавляет элемент в конец
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, (int) (elements.length * 1.5));
        }
        elements[size++] = value;
    }

    int size() { // возвращает размер коллекции
        return size;
    }

    void clear() { // очищает коллекцию
        size = 0;
        elements = (T[]) new Object[DEFAULT_CAPACITY];
    }

    void remove(int index) { // удаляет элемент под индексом
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
    }

    T pop() { // возвращает первый элемент в стеке и удаляет его из коллекции
        if (size == 0) {
            return null;
        }
        T temp = elements[--size];
        elements[size] = null;
        return temp;
    }

    T peek() { // возвращает первый элемент в стеке (LIFO)
        if (size == 0) {
            return null;
        }
        return elements[size - 1];
    }

    @Override
    public String toString() {
        return GetString.getString(elements, size);
    }
}