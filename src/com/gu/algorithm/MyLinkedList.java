package com.gu.algorithm;

import java.util.Iterator;

public class MyLinkedList<AnyType> implements Iterable<AnyType> {
	
	private int theSize;
	private int modCount = 0;
	private Node<AnyType> beginMarker;
	private Node<AnyType> endMarker;

	private static class Node<AnyType> {
		public AnyType data;
		public Node<AnyType> prev;
		public Node<AnyType> next;
		
		public Node(AnyType d, Node<AnyType> p, Node<AnyType> n) {
			data = d;
			prev = p;
			next = n;
		}
	}
	
	public MyLinkedList() {
		clear();
	}
	
	public void clear() {
		beginMarker = new Node<AnyType>(null, null, null);
		endMarker = new Node<AnyType>(null, beginMarker, null);
		beginMarker.next = endMarker;
		
		theSize = 0;
		
		++modCount;
	}
	
	public int size() {
		return theSize;
	}
	
	public boolean isEmpty() {
		return theSize == 0;
	}
	
	public AnyType get(int idx) {
		return getNode(idx).data;
	}
	
	public AnyType set(int idx, AnyType newVal) {
		Node<AnyType> p = getNode(idx);
		AnyType oldVal = p.data;
		p.data = newVal;
		return oldVal;
	}
	
	public void add(int idx, AnyType x) {
		addBefore(getNode(idx), x);
	}
	
	public AnyType remove(int idx) {
		return remove(getNode(idx));
	}
	
	private AnyType remove(Node<AnyType> p) {
		return null;
	}
	
	private Node<AnyType> getNode(int idx) {
		return null;
	}
	
	private void addBefore(Node<AnyType> p, AnyType x) {
		
	}
	
	@Override
	public Iterator<AnyType> iterator() {
		return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements Iterator<AnyType> {

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public AnyType next() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}

}
