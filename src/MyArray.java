import java.util.Arrays;

public class MyArray <E> {
private static final int INITIAL_SIZE = 16;
private Object[]array;
private int size=0;
public MyArray(int initialSize) {
	array=new Object[initialSize];
}
public MyArray() {
	this(INITIAL_SIZE);
}
public boolean add(E obj) {
	if(size==array.length)
		allocateArray();
	array[size++]=obj;
	return true;
	
	
}
private void allocateArray() {
	array=Arrays.copyOf(array, array.length*2);
	
}

@SuppressWarnings("unchecked")
public E get(int index) {
	Object res=null;
	if(index>=0&&index<size) {
		res=array[index];
	}
	return (E)res;
	
}
public int size() {
	return size;
}
/**
 * removes object at the given index
 * @param index
 * @return reference to removed object or null
 *  (in the case of wrong index)
 */
@SuppressWarnings("unchecked")
public E remove(int index) {
	if(index<0 || index>=size)
		return null;
	Object res=array[index];
	if(index<size-1) {
		System.arraycopy(array, index+1, array,
				index, size-index-1);
	}
	size--;
	return (E)res;
}
/**
 * adds object at the given index
 * if the index equals size it adds at the end
 * @param index
 * @param obj
 * @return true if the given index >=0 && index <= size otherwise false
 */
public boolean add(int index,E obj) {
	if(index<0||index>size)
		return false;
	
	
	if (index==size)
		return add(obj);
	if(size==array.length) {
		allocateArray();
	}
	System.arraycopy(array, index, array, index+1, size-index);
	
	array[index]=obj;
	size++;
	return true;
}
public int indexOf(Object obj) {
	for(int i=0;i<size;i++) {
		if(array[i].equals(obj))
			return i;
	}
	return -1;
}
public int lastIndexOf(Object obj) {
	for(int i=size-1;i>=0;i--) {
		if(array[i].equals(obj))
			return i;
	}
	return -1;
}
/**
 * removes first occurrence of a given object-pattern
 * @param obj
 * @return true if array was updated, otherwise - false
 */
public boolean remove(Object obj) {
	int index=indexOf(obj);
	
	
	return remove(index)!=null;
}
/**
 * check if a given object-pattern exists in array
 * @param obj
 * @return true if exists otherwise false
 */
public boolean contains(Object obj) {
	
	return indexOf(obj)>=0;
}
/**
 * creates array of objects and copies all objects
 * @return created array
 */
public Object[]toArray(){
	
	return Arrays.copyOf(array, size);
}
public void sort(MyComparator comp) {
	boolean flSorted=true;
	int n=size;
	do {
		n--;
		flSorted=true;
		for(int i=0;i<n;i++) {
			if(comp.compare(array[i+1],array[i])<0) {
				swap(i,i+1);
				flSorted=false;
			}
		}
		
	}while(flSorted==false);
}
private void swap(int i, int j) {
	
	Object tmp=array[i];
	array[i]=array[j];
	array[j]=tmp;
	
}
// adding all elements from other MyArray
// @param other
public void addAll(MyArray<E> other) {
	int tmpSize = other.size;
	for(int i=0;i<tmpSize;i++) {
		add(other.get(i));
	}
}
//adding all elements from other MyArray at the given index
//if index < 0 index > size does nothing
//if index == size the same as addAll at end of the curent array
//@param index
//@param other
public void addAll(int index, MyArray<E> other) {
	if (array.length < size + other.array.length) allocateArray();
	System.arraycopy(array, index, array, index + other.size, other.size);
	System.arraycopy(other.toArray(), 0, array, index, other.size);
	size = size + other.size;
	
}
// removes all elements from MyArray that exists in other
//@param other
// returns true if the current array has been updated
public boolean removeAll(MyArray<E> other) {
	boolean flag = false;
	for(Object each : other.toArray()) {
		if(remove(each)) flag = true;
	}
	return flag;
}
//  removes all elements from MyArray that not exists in other
public boolean retainsAll(MyArray<E> other) {
	boolean flag = false;
	for(int i=0;i<size;i++) {
		if(!other.contains(array[i])) {
			remove(i);
			flag = true;
		}
	}
	return flag;
}





}
