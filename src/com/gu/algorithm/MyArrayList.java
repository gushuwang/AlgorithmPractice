package com.gu.algorithm;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<AnyType> implements Iterable<AnyType> {

	private static final int DEFAULT_CAPACITY = 10;
	
	private int theSize;
	private AnyType[] theItems;
	
	public MyArrayList() {
		clear();
	}
	
	public void clear() {
		theSize = 0;
		ensureCapacity(DEFAULT_CAPACITY);
	}
	
	public int size() {
		return theSize;
	}
	
	public boolean isEmpty() {
		return theSize == 0;
	}
	
	public void trimToSize() {
		ensureCapacity(theSize);
	}
	
	public AnyType get(int idx) {
		if (idx < 0 || idx > theSize) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		return theItems[idx];
	}
	
	public AnyType set(int idx, AnyType newVal) {
		if (idx < 0 || idx >= theSize) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		AnyType old = theItems[idx];
		theItems[idx] = newVal;
		return old;
	}
	
	public boolean add(AnyType x) {
		add(theSize, x);
		return true;
	}
	
	public void add(int idx, AnyType x) {
		if (theSize == theItems.length) {
			ensureCapacity(theSize * 2 + 1);
		}
		
		for (int i = theSize; i > idx; --i) {
			theItems[i] = theItems[i - 1];
		}
		
		theItems[idx] = x;
		
		++theSize;
	}
	
	public AnyType remove(int idx) {
		AnyType removedItem = theItems[idx];
		for (int i = idx; i < theSize - 1; ++i) {
			theItems[i] = theItems[i + 1];
		}
		
		--theSize;
		
		return removedItem;
	}
	
	public void ensureCapacity(int newCapacity) {
		if (newCapacity < theSize) {
			return;
		}
		
		AnyType[] oldItems = theItems;
		theItems = (AnyType[]) new Object[newCapacity];
		
		for (int i = 0; i < theSize; ++i) {
			theItems[i] = oldItems[i];
		}
	}
	
	@Override
	public Iterator<AnyType> iterator() {
		return new ArrayListIterator();
	}
	
	private class ArrayListIterator implements Iterator<AnyType> {

		private int current = 0;
		
		@Override
		public boolean hasNext() {
			return current < theSize;
		}

		@Override
		public AnyType next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return theItems[current++];
		}

		@Override
		public void remove() {
			MyArrayList.this.remove(--current);
		}
	}
}
