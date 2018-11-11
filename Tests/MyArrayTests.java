
import org.junit.*;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import org.junit.*;
//import org.junit.Test;
//
//import src.telran.util.MyArray;
//import src.telran.util.MyComparator;


public class MyArrayTests {
MyArray <Integer> numbers;
MyArray <String> strings;
Integer[]arNumbers= {
		10,7,11,-2,13,10,2000
};
String[]arStrings= {"abc","lmnr","fg","abc"};
@Before
public void setUp() {
	numbers=new MyArray<>(1);//call constructor by default
	//filling array object (numbers)
	for(int i=0;i<arNumbers.length;i++) {
		numbers.add(arNumbers[i]);
	}
	strings=new MyArray();
	//filling array object (strings)
	for(int i=0;i<arStrings.length;i++) {
		strings.add(arStrings[i]);
	}
	// numbers.add("WWW");
	
}
	@Test
	public void setUpTest() {
		int sizeNumbers=numbers.size();
		int sizeStrings=strings.size();
		assertEquals(arNumbers.length,sizeNumbers);
		assertEquals(arStrings.length,sizeStrings);
		//testing array object (numbers) content
		for(int i=0;i<sizeNumbers;i++) {
			assertEquals(arNumbers[i],numbers.get(i));
		}
		//testing array object (strings) content
		for(int i=0;i<sizeStrings;i++) {
			assertEquals(arStrings[i],strings.get(i));
		}
		
		
	}
	@Test
	public void removeAtIndex() {
		Integer[]arNumbersNo_2= {
				10,7,11,13,10,2000
		};
		assertEquals(null,numbers.remove(60));
//		int sizeNumbers=numbers.size();
//		for(int i=0;i<sizeNumbers;i++) {
//			assertEquals(arNumbersNo_2[i],numbers.get(i));
//		}
		assertEquals((Integer)(-2),numbers.remove(3));
		Integer[]actual=new Integer[numbers.size()];
		for(int i=0;i<actual.length;i++) {
			actual[i]=(Integer) numbers.get(i);
		}
		assertArrayEquals(arNumbersNo_2,actual);
		
	}
	@Test
	public void addAtIndex() {
		Integer[]arNumbers5= {
				10,7,11,5,-2,13,10,2000
		};
		assertTrue(numbers.add(3,5));
		int sizeNumbers=numbers.size();
		for(int i=0;i<sizeNumbers;i++) {
			assertEquals(arNumbers5[i],numbers.get(i));
		}
		assertFalse(numbers.add(numbers.size()+1,100));
	}
	@Test
	public void indexOf() {
		assertEquals(0,numbers.indexOf(10));
		assertEquals(-1,numbers.indexOf(1000));
		String abc=new String("abc");
		assertEquals(0,strings.indexOf(abc));
		assertEquals(-1,strings.indexOf("kuku"));
		assertEquals(6,numbers.indexOf(2000));
	}
	@Test
	public void lastIndexOf() {
		assertEquals(5,numbers.lastIndexOf(10));
		assertEquals(-1,numbers.lastIndexOf(1000));
		assertEquals(3,strings.lastIndexOf("abc"));
		assertEquals(-1,strings.lastIndexOf("kuku"));
		assertEquals(6,numbers.indexOf(2000));
	}
	@Test
	public void equals() {
		Integer a=1000;
		Integer b=1000;
		assertTrue(a.equals(b));
		String str1="Hello";
		String str2=new String("Hello");
		assertTrue(str1.equals(str2));
	}
	@Test
	public void removeObject() {
		Integer[]arNumbersNo_2= {
				10,7,11,13,10,2000
		};//10,7,11,-2,13,10,2000
		assertTrue(numbers.remove((Integer)(-2)));
		assertFalse(numbers.remove((Integer)(-20)));
		
		assertArrayEquals(arNumbersNo_2,numbers.toArray());
	}
	@Test
	public void contains() {
		assertTrue(numbers.contains(2000));
		assertFalse(numbers.contains(100));
	}
	@Test
	public void sort() {
		//10,7,11,-2,13,10,2000
		Integer[]expected= {-2,7,10,10,11,13,2000};
		MyComparator comp=new SimpleNumberComp();;
		numbers.sort(comp);
		assertArrayEquals(expected,numbers.toArray());
		//"abc","lmnr","fg","abc"
		String[]expectedStr= {"fg","abc","abc","lmnr"};
		MyComparator compStrLength=new StringsLengthComp();
		strings.sort(compStrLength);
		assertArrayEquals(expectedStr,strings.toArray());
	}
	@Test
	public void testForLesson11() {
		//odd numbers should go before even numbers
		// odd numbers in the ascending order
		// even numbers in the descending order
		Integer[]expectedNum = {7,11,13,2000,10,10,-2};
		MyComparator compOddEven=new OddEvenComparator();
		numbers.sort(compOddEven);
		
		assertArrayEquals(expectedNum,numbers.toArray());
		/*********************/
		//Alphabet strings sorting
		String []expectedStr= {"abc","abc","fg","lmnr"};
		MyComparator compStr=new StringsComparator();
		strings.sort(compStr);
		assertArrayEquals(expectedStr,strings.toArray());
	}
	@Test
	public void testForHomeWork12() {
		Integer[]expected= {10,7,11,-2,13,10,2000,10,7,11,-2,13,10,2000};
		numbers.addAll(numbers);
		assertArrayEquals(expected,numbers.toArray());
		String []expectedStr= {"abc","lmnr","fg","abc","abc","lmnr","fg","abc"};
		strings.addAll(strings);
		assertArrayEquals(expectedStr,strings.toArray());
		Integer[]expectedAdd= {10,7,10,7,11,-2,13,10,2000,10,7,11,-2,13,10,2000,11,-2,13,10,2000,10,7,11,-2,13,10,2000};
		numbers.addAll(2,numbers);
		assertArrayEquals(expectedAdd,numbers.toArray());
		String []expectedAddStr= {"abc","abc","lmnr","fg","abc","abc","lmnr","fg","abc","lmnr","fg","abc","abc","lmnr","fg","abc"};
		strings.addAll(1,strings);
		assertArrayEquals(expectedAddStr,strings.toArray());
		Integer[]expectedRemove= {};
		assertEquals(true,numbers.removeAll(numbers));
		assertArrayEquals(expectedRemove,numbers.toArray());
		String []expectedRemoveStr= {};
		assertEquals(true,strings.removeAll(strings));
		assertArrayEquals(expectedRemoveStr,strings.toArray());
		Integer[]expectedRetains= {2000};
		numbers.add(2000);
		assertEquals(false,numbers.retainsAll(numbers));
		assertArrayEquals(expectedRetains,numbers.toArray());
		
	}

}
