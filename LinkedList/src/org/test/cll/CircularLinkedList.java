package org.test.cll;

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

public class CircularLinkedList {
	
	private Node head;

	public CircularLinkedList() {
		head = null;
	}
	
	public int ListLength() {
		int count = 0;
		Node temp = head;
		
		while(temp != null) {
			count++;
			temp = temp.getNext();
			
			if(temp == head)
				break;
		}
		return count;
	}
	
	public void InsertEnd(int data) {
		Node node = new Node(data);
		Node currentNode = head;
		
		while(currentNode.getNext() != head)
			currentNode = currentNode.getNext();
		
		node.setNext(node);
		
		if(head == null)
			head = node;
		else {
			node.setNext(head);
			currentNode.setNext(node);
		}
	}
	
	public void InsertFront(int data) {
		Node node = new Node(data);
		Node currentNode = head;
		
		while(currentNode.getNext() != head)
			currentNode = currentNode.getNext();
		
		node.setNext(node);
		
		if(head == null)
			head = node;
		else {
			node.setNext(head);
			currentNode.setNext(node);
			head = node;
		}
	}
	
	public void DeleteLast() {
		Node previousNode = head;
		Node currentNode = head;
		
		if(head == null) {
			System.out.println("List is empty");
			return;
		}
		
		while(currentNode.getNext() != head) {
			previousNode = currentNode;
			currentNode = currentNode.getNext();
		}
		
		previousNode.setNext(head);
		currentNode = null;
	}
	
	public void DeleteFront() {
		Node frontNode = head;
		Node currentNode = head;
		
		if(head == null) {
			System.out.println("List is empty");
			return;
		}
		
		while(currentNode.getNext() != head) {
			currentNode = currentNode.getNext();
		}
		
		currentNode.setNext(head.getNext());
		head = head.getNext();
		frontNode = null;
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
			
			if(temp == head)
				break;
		}
		
		System.out.println();
	}

}
