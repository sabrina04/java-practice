package org.test.sll;

class Node {
	
	private int data;
	private Node next;
	
	public Node(int data) {
		this.data = data;
		next = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

}

public class SinglyLinkedList{
	
	private Node head;
	
	public SinglyLinkedList() {
		head = null;
	}

	public int ListLength() {
		int count = 0;
		Node temp = head;
		
		while(temp != null) {
			count++;
			temp = temp.getNext();
		}
		return count;
	}
	
	public void Insert(int data, int position) {
		Node node = new Node(data);
		
		if(head == null) { // the list is empty;
			head = node;
			System.out.println("Inserting at head, data " + data);
			return;
		}
		
		int listlength = ListLength();
		if(position<1 || position>listlength+1) {
			System.out.println("The position is invalid.");
			return;
		}
		
		if(position==1) {
			node.setNext(head);
			head = node;
		}
		else {
			Node previousNode = head;
			int count = 1;
			
			while(count<position-1) {
				count++;
				previousNode = previousNode.getNext();
			}
			
			Node currentNode = previousNode.getNext();
			previousNode.setNext(node);
			node.setNext(currentNode);
		}
		System.out.println("Inserting at position " + position + ", data "+data);
	}
	
	public void Delete(int position) {
		
		int listlength = ListLength();
		
		if(position<1 || position>listlength+1) {
			System.out.println("The position is invalid.");
			return;
		}
		
		if(position == 1) {
			Node currentNode = head;
			head = currentNode.getNext();
			currentNode = null;
		}
		else {
			Node previousNode = head;
			int count = 1;
			
			while(count < position-1) {
				count++;
				previousNode = previousNode.getNext();
			}
			
			Node currentNode = previousNode.getNext();
			previousNode.setNext(currentNode.getNext());
			currentNode = null;		
		}

	}
	
	public void DeleteList() {
		Node temp = head;
		Node tempNext = temp;
		while(temp != null) {
			tempNext = temp.getNext();
			temp = null;
			temp = tempNext;
		}
		head = null;
	}
	
	public void Display() {
		
		Node temp = head;
		System.out.println("\n");
		if(temp == null) {
			System.out.println("The list is empty\n");
			return;
		}
		while(temp != null) {
			System.out.print(temp.getData() + " ");
			temp = temp.getNext();
		}
		
		System.out.println();
	}
	
}
