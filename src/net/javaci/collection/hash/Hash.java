package net.javaci.collection.hash;

public interface Hash<E> {
	
	  public void clear();
	  
	  public boolean contains(E e);
	  
	  public boolean add(E e);

	  public boolean remove(E e);

	  public boolean isEmpty();

	  public int size();
}
