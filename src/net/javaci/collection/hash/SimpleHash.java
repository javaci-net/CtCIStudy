package net.javaci.collection.hash;

import java.util.LinkedList;

public class SimpleHash<E> implements Hash<E> {

	private int size;

	@SuppressWarnings("unchecked")
	private LinkedList<E>[] hashTable = new LinkedList[2];

	private double loadFactorThreshold = 0.75;

	@Override
	public void clear() {
		size = 0;
		hashTable = new LinkedList[100];
	}

	@Override
	public boolean contains(E e) {
		int bucket = findBucket(e);

		if (hashTable[bucket] == null || !hashTable[bucket].contains(e))
			return false;

		return true;
	}

	private int findBucket(E e) {
		return Math.abs(e.hashCode()) % hashTable.length;
	}

	@Override
	public boolean add(E e) {
		if (contains(e))
			return false;

		if (size + 1 > hashTable.length * loadFactorThreshold) {
			rehash();
		}

		int bucket = findBucket(e);

		if (hashTable[bucket] == null) {
			hashTable[bucket] = new LinkedList<>();
		}

		hashTable[bucket].add(e);
		size++;

		return true;
	}

	@SuppressWarnings("unchecked")
	private void rehash() {
		LinkedList<E>[] oldTable = hashTable;
		hashTable = new LinkedList[hashTable.length * 2];
		size = 0;

		for (LinkedList<E> list : oldTable)
			if (list != null)
				for (E e : list)
					add(e);
	}

	@Override
	public boolean remove(E e) {
		if (!contains(e))
			return false;

		int bucket = findBucket(e);

		hashTable[bucket].remove(e);

		size--;

		return true;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}

}
