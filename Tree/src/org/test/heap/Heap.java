package org.test.heap;

public class Heap {
	private int arr[];
	private int count;
	private int capacity;
	private int heap_type;
	
	public Heap(int capacity, int heap_type) {
		this.capacity = capacity;
		this.heap_type = heap_type;
		count = 0;
		arr = new int[capacity];
	}
	
	public int Parent(int node) {
		if(node<=0 || node>=count)
			return -1;
		return (node-1)/2;
	}
	
	public int LeftChild(int parent) {
		int left = 2*parent+1;
		if(left>=count)
			return -1;
		return left;
	}
	
	public int RightChild(int parent) {
		int left = 2*parent+2;
		if(left>=count)
			return -1;
		return left;
	}
	
	public int GetMaximum() {
		if(count==0)
			return -1;
		return arr[0];
	}
	
	public void PercolateDown(int node) {
		int l, r, max, temp;
		
		do {
			l = LeftChild(node);
			r = RightChild(node);
			
			if(l!=-1 && arr[l]>arr[node])
				max = l;
			else
				max = node;
			
			if(r!=-1 && arr[r]>arr[node])
				max = r;
			
			//swap element
			if(max != node) {
				temp = arr[node];
				arr[node] = arr[max];
				arr[max] = temp;
			}
		} while(max > 0);
	}
	
	public int Delete() {
		if(count == 0)
			return -1;
		int data = arr[0];
		arr[0] = arr[count-1];
		count--;
		PercolateDown(0);
		return data;
	}
	
	public void Insert(int data) {
		int i;
		count++;
		i=count-1;
		
		while(i>=0 && data>arr[(i-1)/2]) {
			arr[i] = arr[(i-1)/2];
			i = (i-1)/2;
		}
		arr[i] = data;
	}
	
	public void BuildHeap(Heap h, int A[], int size) {
		for(int i=0; i<size; i++)
			h.arr[i] = A[i];
		count = size;
		for(int i=(size-1)/2; i>=0; i--)
			PercolateDown(i);
	}
	
	public void HeapSort(int A[], int n) {
		Heap h = new Heap(n, 0);
		int old_size, i, temp;
		BuildHeap(h, A, n);
		old_size = h.count;
		
		for(i=n-1; i>0;i--) {
			temp = h.arr[0];
			h.arr[0] = h.arr[h.count-1];
			h.arr[count-1] = temp;
			h.count--;
			h.PercolateDown(i);
		}
		h.count = old_size;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
