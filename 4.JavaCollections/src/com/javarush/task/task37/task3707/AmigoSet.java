package com.javarush.task.task37.task3707;

import java.util.*;
import java.io.*;
import java.util.function.Consumer;

public class AmigoSet<E> extends AbstractSet implements Serializable, Cloneable, Set {

    /*public static void main(String[] args) throws Exception {
        AmigoSet<Integer> initialAmigoSet = new AmigoSet<>();

        for (int i = 0; i < 10; i++) {
            initialAmigoSet.add(i);
        }

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(initialAmigoSet);

        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        AmigoSet loadedAmigoSet = (AmigoSet) objectInputStream.readObject();

        System.out.println(initialAmigoSet.size() + " " + loadedAmigoSet.size());
    }*/

    private static final Object PRESENT = new Object();

    private transient HashMap<E, Object> map;

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        int capacity = Math.max(16, (int) Math.floor(collection.size() / .75f) + 1);
        map = new HashMap<>(capacity);

        for (E e : collection) {
            map.put(e, PRESENT);
        }

    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeInt(HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
        out.writeFloat(HashMapReflectionHelper.callHiddenMethod(map, "loadFactor"));
        out.writeInt(map.keySet().size());

        for (E o : map.keySet()) {
            out.writeObject(o);
        }
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {

        ois.defaultReadObject();
        int capacity = ois.readInt();
        float loadFactor = ois.readFloat();
        int size =  ois.readInt();

        map = new HashMap<>(capacity, loadFactor);
        for (int i = 0; i < size; i++) {
            map.put((E) ois.readObject(), PRESENT);
        }
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public Object clone() {
        try {
            AmigoSet copy = (AmigoSet) super.clone();
            copy.map = (HashMap) map.clone();
            return copy;
        } catch (Exception e) {
            throw new InternalError();
        }
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    public void clear() {
        map.clear();
    }

    public boolean remove(Object o) {
        return map.remove(o) != null;
    }


    public Iterator iterator() {
        return map.keySet().iterator();
    }

    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }


    public boolean add(Object e) {
        return map.put((E) e, PRESENT) == null;
    }
}