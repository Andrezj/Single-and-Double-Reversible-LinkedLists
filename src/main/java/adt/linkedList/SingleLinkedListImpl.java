package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.getHead().isNIL();
	}

	@Override
	public int size() {
		int size = 0;
		if(!this.isEmpty()) {
			SingleLinkedListNode<T> aux = this.getHead();
			while(!aux.isNIL()) {
				size++;
				aux = aux.getNext();
			}
		}
		return size;
	}

	@Override
	public T search(T element) {
		T resp = null;
		if (element != null) {
			if(!this.isEmpty()) {
				SingleLinkedListNode<T> aux = this.getHead();
				while (!aux.isNIL() && !aux.getData().equals(element)) {
					aux = aux.getNext();
				}
				if (!aux.isNIL()) {
					resp = aux.getData();
				}
			}
		}
		return resp;
	}

	@Override
	public void insert(T element) {
		if(element != null) {
			SingleLinkedListNode<T> newNode = new SingleLinkedListNode<T>(element, new SingleLinkedListNode<>());
			if(this.isEmpty()) {
				this.setHead(newNode);
			} else {
				SingleLinkedListNode<T> aux = this.getHead();
				
				while(!aux.getNext().isNIL()) {
					aux = aux.getNext();
				}
				aux.setNext(newNode);
			}
		}
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			if(!this.isEmpty()) {
				SingleLinkedListNode<T> aux = this.getHead();
				SingleLinkedListNode<T> prev = this.getHead();
				
				while(!aux.getNext().isNIL() && !aux.getData().equals(element)) {
					prev = aux;
					aux = aux.getNext();
				}
				
				prev.setNext(aux.getNext());
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] array =  (T[]) new Object[this.size()];
		SingleLinkedListNode<T> aux  = this.getHead();
		for(int i = 0; i < this.size(); i++) {
			array[i] = aux.getData();
			aux = aux.getNext();
		}
		return array;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

	@Override
	public void invert() {
		SingleLinkedListNode<T> aux = this.getHead();
		SingleLinkedListNode<T> formerNext = this.getHead();
		SingleLinkedListNode<T> newNext = new SingleLinkedListNode<T>();
		while(!aux.isNIL()) {
			formerNext =  aux.getNext();
			aux.setNext(newNext);
			newNext = aux;
			this.setHead(aux);
			aux = formerNext;
		}
		
	}

}
