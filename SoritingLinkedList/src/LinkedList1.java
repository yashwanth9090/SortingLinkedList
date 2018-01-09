import java.util.ArrayList;

class LinkedList1 implements MergeSortLinkedList{
	private Node head;
	
	public Node getHead(){
		return head;
	}
	
	// insert elements into linkedlist
	public void insert(int value) {
		Node newNode = new Node(value);
		if(head == null){
			head = newNode;
			newNode.setNext(null); 
			return; 
		}else{
			Node temp = head;
			while(temp.getNext()!=null){
				temp = temp.getNext();
			}
			temp.setNext(newNode);
			newNode.setNext(null);
		}
		return;
	}
	
	// prints linked list elements
	public void print() {
		Node temp =  mergeSortLinkedList(head);
		if(head == null){
			System.out.println("Empty list");
		}
		
		while(temp!=null){
			System.out.print(temp.getData()+" ");
			temp = temp.getNext();
		}
		System.out.println();
		
	}
	
	// returns linked list elements as a collection
	public ArrayList<Integer> getAsList(){
		Node temp = mergeSortLinkedList(head);
		if(head == null){
			throw new NullPointerException();
		}
		ArrayList<Integer> testList = new ArrayList<>();
		while(temp!=null){
			testList.add(temp.getData());
			temp = temp.getNext();
		}
		return testList;
	}
	
	/**
	Sorts the LinkedList in ascending order using MergeSort.
	 **/
	private Node mergeSortLinkedList(Node head) {
		if(head == null || head.getNext()==null){
			return head;
		}
		
		Node middle = getMiddle(head);
		Node nextMiddle = middle.getNext();
		middle.setNext(null);
		
		Node left = mergeSortLinkedList(head);
		Node right = mergeSortLinkedList(nextMiddle);
		
		Node sortedList = mergeTwoSubLinkedLists(left,right);
		return sortedList;
	}
	
	private Node mergeTwoSubLinkedLists(Node left, Node right) {
		if(left==null){
			return right;
		}
		if(right == null){
			return left;
		}
		Node temp = null;
		if(left.getData()<right.getData()){
			temp = left;
			temp.setNext(mergeTwoSubLinkedLists(left.getNext(),right)); 
			
		}else{
			temp = right;
			temp.setNext(mergeTwoSubLinkedLists(left,right.getNext()));
		}
		return temp;
	}
	
	// return middle node of linked list
	private Node getMiddle(Node head2) {
		if(head2 == null){
			return head2;
		}
		Node slow = head2;
		Node fast = head2;
		while(fast.getNext()!=null){
			fast = fast.getNext();
			if(fast.getNext()!=null){
				slow = slow.getNext();
				fast = fast.getNext();
			}
		}
		return slow;
	}
	
}

