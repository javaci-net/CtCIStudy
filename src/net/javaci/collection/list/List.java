package net.javaci.collection.list;

public interface List<E> {
	
	int size();

	boolean isEmpty();

	void clear();

	String toString();

	void addFirst(E e);

	void addLast(E e);

	void add(int index, E element);
	
	E set(int index, E element);

	E remove(int index);

	E remove(E e);

	E removeFirst();

	E removeLast();

	E get(int index);

	boolean contains(E e);

	boolean equals(Object o);

	int indexOf(E e);

	int lastIndexOf(E e);

	E[] toArray();

}
