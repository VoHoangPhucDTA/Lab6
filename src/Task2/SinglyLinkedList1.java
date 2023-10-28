package Task2;

public class SinglyLinkedList1<E> {
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size;

	private static class Node<E> {
		private E data;
		private Node<E> next;

		public Node(E data) {
			this.data = data;
			this.next = null;
		}
	}

	public int size() {
		Node<E> current = head;
		while (current != null) {
			size++;
			current = current.next;
		}
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E first() {
		if (isEmpty())
			return null;
		return head.data;
	}

	public E last() {
		if (isEmpty())
			return null;
		return tail.data;
	}

	public void addFirst(E e) {
		Node<E> newNode = new Node<>(e);
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			head = newNode;
			++size;
		}
	}

	public void addLast(E e) {
		Node<E> newNode = new Node<>(e);
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
			++size;
		}
	}

	public E removeFirst() {
		if (size() == 1) return null; 		// Có 1 node
		E res = head.data;
		Node<E> newHead = head.next;
		head.next = null;
		head = newHead;
		--size;
		return res;
	}

	// 10 --> 20 --> 30 --> 40
	public E removeLast() {
		if (size() == 1) return null;  // Có 1 node
		Node<E> current = head;
		Node<E> previous = null;
		while (current.next != null) {
			previous = current;
			current = current.next;
		}
		previous.next = null; // cho cái Node kề cuối chỉ tới null
		E res = current.data; // lưu dữ liệu Node cuối vào res
		current = null; // xóa Node cuối
		return res;
	}

	public void display() {
		Node<E> current = head;
		while (current != null) {
			System.out.print(current.data + " --> ");
			current = current.next;
		}
		System.out.print("null");
	}

	public void run() {
		SinglyLinkedList1<Integer> sll = new SinglyLinkedList1<>();
		sll.head = new Node<Integer>(10);
		sll.tail = new Node<Integer>(40);
		Node<Integer> second = new Node<Integer>(20);
		Node<Integer> third = new Node<Integer>(30);

		sll.head.next = second;
		second.next = third;
		third.next = sll.tail;

		System.out.print("Linked List: ");
		sll.display();
		System.out.println("\nSize của Linked List: " + sll.size());

		sll.addFirst(15);
		System.out.print("Khi thêm đầu: ");
		sll.display();

		sll.addLast(56);
		System.out.print("\nKhi thêm cuối: ");
		sll.display();

		System.out.println("\nPhần tử đầu: " + sll.first());

		System.out.println("Phần tử cuối: " + sll.last());

		sll.removeFirst();
		System.out.print("Sau khi loại bỏ phần tử đầu: ");
		sll.display();

		sll.removeLast();
		System.out.print("\nSau khi loại bỏ phần tử cuối: ");
		sll.display();

	}

	public static void main(String[] args) {
		SinglyLinkedList1<Integer> sll = new SinglyLinkedList1<>();
		;
		sll.run();

	}
}
