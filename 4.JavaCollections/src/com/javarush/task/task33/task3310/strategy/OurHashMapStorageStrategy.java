package com.javarush.task.task33.task3310.strategy;

public class OurHashMapStorageStrategy  implements StorageStrategy {
    private static final int DEFAULT_INITIAL_CAPACITY = 16; // количество бакетов
    private static final float DEFAULT_LOAD_FACTOR = 0.75f; // коэффициент загрузки массива
    private Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY]; //наш массив
    private int size;
    private int threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR); // параметр для увеличения размера массива
    private float loadFactor = DEFAULT_LOAD_FACTOR;

    public int hash(Long k) { // вычисляем хэш
        int h;
        return (k == null) ? 0 : (h = k.hashCode()) ^ (h >>> 16);
    }

    public int indexFor(int hash, int length) { // индекс корзины для получения элемента
        return hash & (length-1);
    }

    public Entry getEntry(Long key) {
        return table[indexFor(hash(key),table.length)];
    }

    // изменение размера нашей таблицы в том случае если она еще не доросла до MAXIMUM_CAPACITY
    //
    public void resize(int newCapacity) {
        int MAXIMUM_CAPACITY = 1 << 30;
        Entry[] oldTable = table;
        int oldCapacity = oldTable.length;
        if (oldCapacity == (MAXIMUM_CAPACITY)) {
            threshold = Integer.MAX_VALUE;
            return;
        }

        Entry[] newTable = new Entry[newCapacity];
        transfer(newTable); //
        table = newTable;
        threshold = (int)(newCapacity * loadFactor);
    }

    public void transfer(Entry[] newTable){
        Entry[] src = table;
        int newCapacity = newTable.length;
        for (int j = 0; j < src.length; j++) {
            Entry e = src[j]; // сохраняем текущий элемент в ссылке
            if (e != null) { // если он не пустой
                src[j] = null; // очищаем ссылку на него в нашей таблице
                do {
                    Entry next = e.next; // берем следующий элемент в нашем элементе данной ячейки таблицы
                    int i = indexFor(e.hash, newCapacity); // пересчитываем индекс корзины
                    e.next = newTable[i]; // сохраняем следующий элемент в текущей ссылке
                    newTable[i] = e; // кладем элемент в данную ячейку таблицы
                    e = next; // сохраняем следующий элемент в текущий элемент
                } while (e != null); // пока не доберемся до последнего
            }
        }
    }

    public void addEntry(int hash, Long key, String value, int bucketIndex){
        Entry e = table[bucketIndex];
        table[bucketIndex] = new Entry(hash, key, value, e);
        if (size++ >= threshold)
            resize(2 * table.length);
    }

    public void createEntry(int hash, Long key, String value, int bucketIndex){
        Entry e = table[bucketIndex];
        table[bucketIndex] = new Entry(hash, key, value, e);
        size++;
    }

    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
        Entry[] tab = table;

        if (value == null) {
            for (int i = 0; i < tab.length ; i++)
                for (Entry e = tab[i] ; e != null ; e = e.next)
                    if (e.value == null)
                        return true;
            return false;
        }

        for (int i = 0; i < tab.length ; i++)
            for (Entry e = tab[i] ; e != null ; e = e.next)
                if (value.equals(e.value))
                    return true;
        return false;
    }


    @Override
    public void put(Long key, String value) {
        if (key == null) {
            for (Entry e = table[0]; e != null; e = e.next) {
                if (e.key == null) {
                    String oldValue = e.value;
                    e.value = value;
                }
            }
            addEntry(0, null, value, 0);
        } else {
            int hash = hash((long) key.hashCode());
            int i = indexFor(hash, table.length);
            for (Entry e = table[i]; e != null; e = e.next) {
                Object k;
                if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
                    String oldValue = e.value;
                    e.value = value;
                }
            }
            addEntry(hash, key, value, i);
        }
    }

    @Override
    public Long getKey(String value) {
        Entry[] tab = table;

        if (value == null) {
            for (int i = 0; i < tab.length ; i++)
                for (Entry e = tab[i] ; e != null ; e = e.next)
                    if (e.value == null)
                        return e.key;
            return null;
        }

        for (int i = 0; i < tab.length ; i++)
            for (Entry e = tab[i] ; e != null ; e = e.next)
                if (value.equals(e.value))
                    return e.key;
        return null;
    }

    @Override
    public String getValue(Long key) {
        return getEntry(key).value;
    }
}
