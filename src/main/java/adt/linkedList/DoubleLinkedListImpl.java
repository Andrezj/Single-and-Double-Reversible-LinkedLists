package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	@Override
	public void insert(T element) {
		if (element != null) {
			DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>(element, new DoubleLinkedListNode<>(),
					this.getLast());
			if (this.isEmpty()) {
				this.setHead(newNode);
				this.setLast(newNode);
			} else {
				this.getLast().setNext(newNode);
				this.setLast(newNode);
			}
		}
	}

	@Override
	public void insertFirst(T element) {
		if (element != null) {
			if (!this.isEmpty()) {
				if (this.head instanceof DoubleLinkedListNode) {
					DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>(element,
							(DoubleLinkedListNode<T>) this.getHead(), new DoubleLinkedListNode<>());
					((DoubleLinkedListNode<T>) this.getHead()).setPrevious(newNode);
					this.setHead(newNode);
				}
			}
			else {
				this.insert(element);
			}
		}
	}

	@Override
	public void removeFirst() {
		if(!this.isEmpty()) {
			this.setHead(this.getHead().getNext());;
			((DoubleLinkedListNode<T>) this.getHead()).setPrevious(new DoubleLinkedListNode<>());
		}
	}

	@Override
	public void removeLast() {
		if(!this.isEmpty()) {
			this.setLast(this.getLast().getPrevious());
			this.getLast().setNext(new DoubleLinkedListNode<>());
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

	@Override
	public void invert() {
		DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>) this.getHead();
		DoubleLinkedListNode<T> formerNext = (DoubleLinkedListNode<T>) this.getHead();
		while(!aux.isNIL()) {
			formerNext = (DoubleLinkedListNode<T>) aux.getNext();
			aux.setNext(aux.getPrevious());
			aux.setPrevious(formerNext);
			this.setHead(aux);
			aux = formerNext;
		}
	}

}
