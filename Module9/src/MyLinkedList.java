import java.util.Objects;

public class MyLinkedList<T> {
    private int size = 0;
    static class Node<T> {
        T value;
        Node<T> next;
        public Node(T value) {
            this.value = value;
        }
    }
    private Node<T> first;
    private Node<T> last;

    void add(T value) { // добавляет элемент в конец
        Node<T> newNode = new Node<>(value);
        if (first == null) {
            first = last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    Object remove(int index) { // удаляет элемент под индексом
        Objects.checkIndex(index, size);
        T removedElement;
        if (index == 0) {
            removedElement = first.value;
            first = first.next;
            if (first == null) {
                last = null;
            }
        } else {
            Node<T> prev = getNodeByIndex(index - 1);
            removedElement = prev.value;
            prev.next = prev.next.next;
            if (index == size - 1) {
                last = prev;
            }
        }
        size--;
        return removedElement;
    }

    void clear() { // очищает коллекцию
        first = last = null;
        size = 0;
    }

    int size() { // возвращает размер коллекции
        return size;
    }

    T get(int index) { // возвращает элемент под индексом
        Objects.checkIndex(index, size);
        return getNodeByIndex(index).value;
    }

    private Node<T> getNodeByIndex(int index) {
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public String toString() {
        StringBuilder line = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            line.append(get(i)).append(", ");
        }
        if (size == 0) return "[]";
        line.append(" ");
        return line.toString().replace(",  ", "]");
    }
}
