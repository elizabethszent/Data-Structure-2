public class Stack<T> implements StackInterface<T> {
	private class Node<T> {
		private T value;
		private Node<T> next;
	}

	private Node<T> top = null;

	@Override
	public void push(T item) throws OverflowException {
		Node<T> nn = new Node<T>();
		nn.value = item;
		nn.next = top;
		top = nn;
	}

	@Override
	public T pop() throws UnderflowException {
		if (!isEmpty()) {
			T tmp = top.value;
			top = top.next;
			return tmp;
		} else
			throw new UnderflowException("Cannot pop from an empty stack.");

	}

	@Override
	public T peek() throws UnderflowException {
		if (!isEmpty())
			return top.value;
		else
			throw new UnderflowException("Cannot peek into an empty stack.");
	}

	@Override
	public boolean isEmpty() {
		return (top == null);
	}

	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("[");

		if (top != null) {
			result.append(top.value);
			Node<T> x = top.next;
			while (x != null) {
				result.append(", ");
				result.append(x.value);
				x = x.next;
			}
		}

		result.append("]");
		return result.toString();
	}
}