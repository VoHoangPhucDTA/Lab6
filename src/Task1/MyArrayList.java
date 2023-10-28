package Task1;

import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<E> {
	public static final int DEFAULT_CAPACITY = 10;
	private E[] elements;
	private int size;

	public MyArrayList() {
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];
	}

	// creates an array of double-size if the array of
	// elements is full

	public void growSize() {
		if (this.elements.length == size) {
			int newSize = size * 2;
			E[] newEles = (E[]) new Object[newSize];
			System.arraycopy(elements, 0, newEles, 0, size);
			elements = newEles;
		}
	}

	// Returns the number of elements in this list.
	public int size() {
		return size;
	}

	// Returns whether the list is empty.
	public boolean isEmpty() {
		return size == 0;
	}

	// Returns (but does not remove) the element at index i.
	public E get(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) throw new IndexOutOfBoundsException();
		return elements[i];
	}

	public E set(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) throw new IndexOutOfBoundsException();
		E oldEle = elements[i];
		elements[i] = e;
		return oldEle;
	}

	public boolean add(E e) {
		if (size == elements.length) growSize();
		elements[size] = e;
		size++;
		return true;
	}

	public void add(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i > size) throw new IndexOutOfBoundsException();
		if (size == elements.length) growSize();
		for (int j = size; j > i; j--) {
			elements[j] = elements[j-1];
		}
		elements[i] = e;
		size++;
	}

	public E remove(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i > size) throw new IndexOutOfBoundsException();
		E oldValue = elements[i];
		for (int j = i; j < size - 1; j++) {
			elements[j] = elements[j+1];
		}
		size--;
		return oldValue;
	}

	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;
	}

	public int lastIndexOf(Object o) {
		int res = -1;
		for (int i = 0; i < size; i++) {
			if (elements[i].equals(o)) res = i;
		}
		return res;
	}

	public E[] toArray() {
		E[] res = (E[]) new Object[size];
		System.arraycopy(elements, 0, res, 0, size);
		return res;
	}

	// It is used to return a shallow copy of an ArrayList.
	public MyArrayList<E> clone() {
		MyArrayList<E> clone = new MyArrayList<>();
		clone.elements = this.toArray();
		clone.size = this.size;
		return clone;
	}
	

	public boolean contains(E o) {
		return indexOf(o) != -1;
	}

	

	public int indexOf(E o) {
		for (int i = 0; i < size; i++) {
			if (o.equals(elements[i])) {
				return i;
			}
		}
		return -1;
	}

	

	public boolean remove(E e) {
		int index = indexOf(e);
		if (index != -1) {
			remove(index);
			return true;
		}
		return false;
	}

	

	public void sort(Comparator<E> c) {
		Arrays.sort(elements, 0, size, c);
	}
	
	public void run() {
		MyArrayList<Integer> myList = new MyArrayList<>();

        // Thêm các phần tử vào danh sách
        myList.add(5);
        myList.add(10);
        myList.add(20);
        myList.add(32);
        myList.add(30);

        System.out.println("Độ dài của list: " + myList.size());

        System.out.print("Tất cả phần tử trong list: ");
        for (int i = 0; i < myList.size(); i++) {
            System.out.print(myList.get(i) + " ");
        }
        System.out.println();

        System.out.println("List có rỗng hay không: " + myList.isEmpty());

        myList.remove(Integer.valueOf(10));

        System.out.println("Độ dài của list khi xóa: " + myList.size());

        System.out.print("Các phần tử sau khi xóa: ");
        for (int i = 0; i < myList.size(); i++) {
            System.out.print(myList.get(i) + " ");
        }
        System.out.println();
        
        myList.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		});
        
        System.out.print("Các phần tử sau khi được sắp xếp: ");
        for (int i = 0; i < myList.size(); i++) {
            System.out.print(myList.get(i) + " ");
        }
        System.out.println();
    
	
	}
	
	public static void main(String[] args) {
		MyArrayList<Integer> myList = new MyArrayList<>();
		myList.run();
	}
}
