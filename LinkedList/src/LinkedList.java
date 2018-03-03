import org.test.dll.DoublyLinkedList;
import org.test.sll.SinglyLinkedList;

public class LinkedList {

	public static void main(String[] args) {
//		// implementation of singly linked list
		SinglyLinkedList slist = new SinglyLinkedList();
		
		for(int i=0; i<10; i++) {
			slist.Insert(i*10, i+1);
		}
		
		slist.Display();
		
		slist.Delete(2);
		slist.Display();
		
		slist.Delete(5);
		slist.Display();
		
		slist.DeleteList();
		slist.Display();
		
		// implementation of doubly linked list
		DoublyLinkedList dlist = new DoublyLinkedList();
		
		for(int i=0; i<10; i++) {
			dlist.Insert(i*20, i+1);
		}
		
		dlist.Display();
		dlist.ReverseDisplay();
		
		dlist.Delete(3);
		dlist.Display();
		
		dlist.Delete(4);
		dlist.Display();
		dlist.ReverseDisplay();
		
		dlist.Delete(7);
		dlist.Display();
		dlist.ReverseDisplay();
		
		dlist.DeleteList();
		dlist.Display();
		dlist.ReverseDisplay();
	}

}
