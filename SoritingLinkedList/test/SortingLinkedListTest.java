import static org.junit.Assert.*;
import java.util.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
public class SortingLinkedListTest {
	
	private LinkedList1 actualLinkedList;
	private LinkedList<Integer> expectedLinkedList = new LinkedList<>();
	
	@Before
	public void setUp(){
		actualLinkedList = Mockito.spy(new LinkedList1());
		expectedLinkedList = new LinkedList<>();
	}
	
	@Test
	public void testSorting() {
		insertIntoActualLinkedList(2,10,21,12,16,7,4);
		insertIntoExpectedLinkedList(2,10,21,12,16,7,4);
		Collections.sort(expectedLinkedList);
		assertEquals(expectedLinkedList,actualLinkedList.getAsList());
		
		
	}
	
	@Test
	public void testAllDuplicates(){
		insertIntoActualLinkedList(2,2,2,2,2,2);
		insertIntoExpectedLinkedList(2,2,2,2,2,2);
		Collections.sort(expectedLinkedList);
		assertEquals(expectedLinkedList,actualLinkedList.getAsList());
	}

	@Test(expected = NullPointerException.class)
	public void testEmptyList(){
		actualLinkedList.getAsList();
	}
	
	// testing linked list with single element in it
	@Test
	public void testSingleNode(){
		actualLinkedList.insert(3);
		expectedLinkedList.add(3);
		assertEquals(expectedLinkedList,actualLinkedList.getAsList());
		
	}
	
	@Test
	public void testDuplicatesInMiddle(){
		insertIntoActualLinkedList(2,10,21,21,21,7,4);
		insertIntoExpectedLinkedList(2,10,21,21,21,7,4);
		Collections.sort(expectedLinkedList);
		assertEquals(expectedLinkedList,actualLinkedList.getAsList());
		
	}
	
	@Test
	public void testDuplicatesAtHead(){
		insertIntoActualLinkedList(2,2,2,21,21,7,4);
		insertIntoExpectedLinkedList(2,2,2,21,21,7,4);
		Collections.sort(expectedLinkedList);
		assertEquals(expectedLinkedList,actualLinkedList.getAsList());
		
	}
	
	@Test
	public void testDuplicatesAtTail(){
		insertIntoActualLinkedList(3,4,19,13,2,2,2);
		insertIntoExpectedLinkedList(3,4,19,13,2,2,2);
		Collections.sort(expectedLinkedList);
		assertEquals(expectedLinkedList,actualLinkedList.getAsList());
		
	}
	@Test
	public void testDuplicateAtEveryNode(){
		insertIntoActualLinkedList(3,2,19,2,7,2,9);
		insertIntoExpectedLinkedList(3,2,19,2,7,2,9);
		Collections.sort(expectedLinkedList);
		assertEquals(expectedLinkedList,actualLinkedList.getAsList());
		
	}
	
	private void insertIntoActualLinkedList(int ...value){
		for(int i = 0;i<value.length;i++){
			actualLinkedList.insert(value[i]);
		}
	}
	
	private void insertIntoExpectedLinkedList(int ...value){
		for(int i=0;i<value.length;i++){
			expectedLinkedList.add(value[i]);
		}
	}

}
