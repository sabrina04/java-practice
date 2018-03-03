package org.test.binarysearchtree;

class BinarySearchTreeNode{
	private int data;
	private BinarySearchTreeNode left;
	private BinarySearchTreeNode right;
	
	public BinarySearchTreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public BinarySearchTreeNode() {
		
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public BinarySearchTreeNode getLeft() {
		return left;
	}

	public void setLeft(BinarySearchTreeNode left) {
		this.left = left;
	}

	public BinarySearchTreeNode getRight() {
		return right;
	}

	public void setRight(BinarySearchTreeNode right) {
		this.right = right;
	}
	
}

public class BinarySearchTree {
	
	public static BinarySearchTreeNode Insert(BinarySearchTreeNode root, int data) {
		
		if(root == null) {
			root = new BinarySearchTreeNode(data);
			root.setLeft(null);
			root.setRight(null);
		}
		else {
			BinarySearchTreeNode temp;
			
			if(data < root.getData()) {
				temp = Insert(root.getLeft(), data);
				root.setLeft(temp);
			}
			else if(data > root.getData()) {
				temp = Insert(root.getRight(), data);
				root.setRight(temp);
			}
		}
		
		return root;
	}
	
	public static boolean Find(BinarySearchTreeNode root, int data) {
		
		if(root == null)
			return false;
		if(data == root.getData())
			return true;
		else if(data < root.getData())
			return Find(root.getLeft(), data);
		else return Find(root.getRight(), data);
	}
	
	public static int FindMin(BinarySearchTreeNode root) {
		if(root == null)
			return -1;
		while(root.getLeft() != null) {
			root = root.getLeft();
		}
		
		return root.getData();
	}
	
	public static BinarySearchTreeNode FindMax(BinarySearchTreeNode root) {
		if(root == null)
			System.out.println("The tree is empty");;
		while(root.getRight() != null) {
			root = root.getRight();
		}
		
		return root;
	}
	
	public static BinarySearchTreeNode Delete(BinarySearchTreeNode root, int data) {
		
		BinarySearchTreeNode temp;
		
		if(root == null)
			System.out.println("Element not present in the tree");
		else if(data < root.getData())
			return Delete(root.getLeft(), data);
		else if(data > root.getData())
			return Delete(root.getRight(), data);
		else { // node associated with data found
			// node has two children
			if(root.getLeft()!=null && root.getRight()!=null) {
				temp = FindMax(root.getLeft());
				root.setData(temp.getData());
				BinarySearchTreeNode temp2 = Delete(root.getLeft(), root.getData());
				root.setLeft(temp2);
			}
			else { // node has one child
				temp = root;
				if(root.getLeft() == null)
					root = root.getRight();
				if(root.getLeft() == null)
					root = root.getLeft();
				temp = null;
			}
		}
		return root;
	}
	
	public static BinarySearchTreeNode FindLCA(BinarySearchTreeNode root, BinarySearchTreeNode a, BinarySearchTreeNode b) {
		
		while(true) {
			if((a.getData()<root.getData() && b.getData()>root.getData()) || (a.getData()>root.getData() && b.getData()<root.getData()))
				return root;
			if(a.getData()<root.getData())
				root = root.getLeft();
			else
				root = root.getRight();
		}
	}
	
	public static boolean IsBST(BinarySearchTreeNode root) {
		if(root == null)
			return true;
		if(root.getLeft()!=null && root.getData()<root.getLeft().getData())
			return false;
		if(root.getRight()!=null && root.getData()>root.getRight().getData())
			return false;
		if(!IsBST(root.getLeft()) || !IsBST(root.getRight()))
			return false;
		return true;
	}
	
	public static BinarySearchTreeNode BuildBSTfromSortedArray(int A[], int left, int right) {
		BinarySearchTreeNode newnode;
		if(left>right)
			return null;
		newnode = new BinarySearchTreeNode();
		if(left == right) {
			newnode.setData(A[left]);
			newnode.setLeft(null);
			newnode.setRight(null);
		}
		else {
			int mid = left + (right-left)/2;
			newnode.setData(A[mid]);
			newnode.setLeft(BuildBSTfromSortedArray(A, left, mid-1));
			newnode.setRight(BuildBSTfromSortedArray(A, mid+1, right));
		}
		return newnode;
	}
	
	public static BinarySearchTreeNode kthSmallestInBST(BinarySearchTreeNode root, int k, int count) {
		if(root == null)
			return null;
		BinarySearchTreeNode left = kthSmallestInBST(root.getLeft(), k, count);
		if(left != null)
			return left;
		count++;
		if(count == k)
			return root;
		BinarySearchTreeNode right = kthSmallestInBST(root.getRight(), k, count);
		return right;
	}
	
	public static BinarySearchTreeNode PruneBST(BinarySearchTreeNode root, int a, int b) {
		if(root == null)
			return null;
		root.setLeft(PruneBST(root.getLeft(), a, b));
		root.setRight(PruneBST(root.getRight(), a, b));
		
		BinarySearchTreeNode temp = null;
		if(root.getData()>=a && root.getData()<=b)
			temp = root;
		if(root.getData()<a)
			temp = root.getRight();
		if(root.getData()>b)
			temp = root.getLeft();
		return temp;
	}
	
	public static void main(String args[]) {
		BinarySearchTreeNode root = null;
		
		for(int i=0; i<10; i++) {
			if(i%2==0)
				root = Insert(root, 5*i);
			else
				root = Insert(root, 3*i);
		}
	}

}
