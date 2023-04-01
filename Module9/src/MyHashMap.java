class MyHashMap<K, V> {

    private Hash<K, V>[] table;
    private int capacity = 4;
    private int size = 0;

    static class Hash<K, V> {
        K key;
        V value;
        Hash<K, V> next;

        public Hash(K key, V value, Hash<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public MyHashMap() {
        table = new Hash[capacity];
    }

    public void put(K newKey, V data) { // добавляет пару ключ + значение
        if (newKey == null)
            return;
        int hash = hash(newKey);
        size++;
        Hash<K, V> newEntry = new Hash<K, V>(newKey, data, null);

        if (table[hash] == null) {
            table[hash] = newEntry;
        } else {
            Hash<K, V> previous = null;
            Hash<K, V> current = table[hash];

            while (current != null) {
                if (current.key.equals(newKey)) {
                    if (previous == null) {
                        newEntry.next = current.next;
                        table[hash] = newEntry;
                        return;
                    } else {

                        newEntry.next = current.next;
                        previous.next = newEntry;
                        return;
                    }
                }
                previous = current;
                current = current.next;

            }
            previous.next = newEntry;

        }
    }

    public V get(K key) { // возвращает значение(Object value) по ключу
        int hash = hash(key);
        if (table[hash] == null) {
            return null;
        } else {
            Hash<K, V> temp = table[hash];
            while (temp != null) {
                if (temp.key.equals(key))
                    return temp.value;
                temp = temp.next;
            }
            return null;
        }
    }

    int size() {
        return size;
    }

    void clear() {
        size = 0;
        table = new Hash[capacity];
    }

    public boolean remove(K deleteKey) { // удаляет пару по ключу
        size--;
        int hash = hash(deleteKey);

        if (table[hash] == null) {
            return false;
        } else {
            Hash<K, V> previous = null;
            Hash<K, V> current = table[hash];

            while (current != null) {
                if (current.key.equals(deleteKey)) {
                    if (previous == null) {
                        table[hash] = table[hash].next;
                        return true;
                    } else {
                        previous.next = current.next;
                        return true;
                    }
                }
                previous = current;
                current = current.next;
            }
            return false;
        }
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }
}