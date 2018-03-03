package org.test.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class BinaryTreeNode{
	private int data;
	private BinaryTreeNode left;
	private BinaryTreeNode right;
	
	public BinaryTreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public BinaryTreeNode() {
		
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public BinaryTreeNode getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}

	public BinaryTreeNode getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}
	
}

public class BinaryTree {
	
	private static final int INT_MIN = 0;

	public static void PreOrderTraversal(BinaryTreeNode root) {
		if(root == null)
			return;
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		while(true) {
			while(root != null) {
				System.out.print(root.getData() + " ");
				s.push(root);
				root = root.getLeft();
			}
			
			if(s.isEmpty())
				break;
			root = (BinaryTreeNode) s.pop();
			root = root.getRight();
		}
		System.out.println();
	}
	
	public static void InOrderTraversal(BinaryTreeNode root) {
		if(root == null)
			return;
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		while(true) {
			while(root != null) {
				s.push(root);
				root = root.getLeft();
			}
			
			if(s.isEmpty())
				break;
			root = (BinaryTreeNode) s.pop();
			System.out.print(root.getData() + " ");
			root = root.getRight();
		}
		System.out.println();
	}
	
	public static void LevelOrderTraversal(BinaryTreeNode root) {
		BinaryTreeNode temp;
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		if(root == null)
			return;
		q.add(root);
		while(!q.isEmpty()) {
			temp = q.remove();
			System.out.print(temp.getData() + " ");
			if(temp.getLeft() != null)
				q.add(temp.getLeft());
			if(temp.getRight() != null)
				q.add(temp.getRight());
		}
	}
	
	public static int FindMax(BinaryTreeNode root) {
		int root_val, left, right, max=INT_MIN;
		if(root != null) {
			root_val = root.getData();
			left = FindMax(root.getLeft());
			right = FindMax(root.getRight());
			
			if(left<right)
				max = right;
			if(root_val > max)
				max = root_val;
		}
		return max;
	}
	
	public static void FindMaxNonRecursive(BinaryTreeNode root) {
		BinaryTreeNode temp;
		int max = INT_MIN;
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.add(root);
		while(!q.isEmpty()) {
			temp = q.remove();
			if(max<temp.getData())
				max = temp.getData();
			if(temp.getLeft() != null)
				q.add(temp.getLeft());
			if(temp.getRight() != null)
				q.add(temp.getRight());
		}
	}
	
	public static boolean Search(BinaryTreeNode root, int data) {
		BinaryTreeNode temp;
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.add(root);
		while(!q.isEmpty()) {
			temp = q.remove();
			if(data == temp.getData())
				return true;
			if(temp.getLeft() != null)
				q.add(temp.getLeft());
			if(temp.getRight() != null)
				q.add(temp.getRight());
		}
		return false;
	}
	
	public static void Insert(BinaryTreeNode root, int data) {
		BinaryTreeNode temp;
		BinaryTreeNode newNode = new BinaryTreeNode(data);
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		
		if(root == null) {
			root = newNode;
			return;
		}
		q.add(root);
		while(!q.isEmpty()) {
			temp = q.remove();
			
			if(temp.getLeft() != null)
				q.add(temp.getLeft());
			else {
				temp.setLeft(newNode);
				return;
			}
			
			if(temp.getRight() != null)
				q.add(temp.getRight());
			else {
				temp.setRight(newNode);
				return;
			}
		}
	}
	
	public static int SizeOfBinaryTree(BinaryTreeNode root) {
		if(root == null)
			return 0;
		return SizeOfBinaryTree(root.getLeft())+SizeOfBinaryTree(root.getRight())+1;
	}
	
	public static int SizeOfBinaryTreeNonRecursive(BinaryTreeNode root) {
		BinaryTreeNode temp;
		if(root == null)
			return 0;
		
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.add(root);
		
		int size = 0;
		while(!q.isEmpty()) {
			temp = q.remove();
			size++;
			if(temp.getLeft() != null)
				q.add(temp.getLeft());
			if(temp.getRight() != null)
				q.add(temp.getRight());
		}
		return size;
	}
	
	public static int HeightTree(BinaryTreeNode root) {
		int left, right;
		if(root == null)
			return 0;
		left = HeightTree(root.getLeft());
		right = HeightTree(root.getRight());
		
		if(left<right)
			return right+1;
		return left+1;
	}
	
	public static int HeightTreeNonRecursive(BinaryTreeNode root) {
		BinaryTreeNode temp;
		if(root == null)
			return 0;
		
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.add(root);
		q.add(null); // put marker indicating end of a level
		
		int height = 0;
		while(!q.isEmpty()) {
			temp = q.remove();
			if(temp == null) {
				q.add(null); // put another marker for the next level
				height++;
			}
			else {
				if(temp.getLeft() != null)
					q.add(temp.getLeft());
				if(temp.getRight() != null)
					q.add(temp.getRight());
			}
		}
		return height;
	}
	
	public static boolean AreMirror(BinaryTreeNode root1, BinaryTreeNode root2) {
		if(root1==null && root2==null)
			return true;
		if(root1==null || root2==null)
			return false;
		if(root1.getData() != root2.getData())
			return false;
		else 
			return (AreMirror(root1.getLeft(), root2.getRight()) && AreMirror(root1.getRight(), root2.getLeft()));
	}
	
	public static void DeleteTree(BinaryTreeNode root) {
		if(root==null)
			return;
		DeleteTree(root.getLeft());
		DeleteTree(root.getRight());
		root = null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
