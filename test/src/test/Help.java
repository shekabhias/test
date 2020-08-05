package test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

public class Help {

	public static int minRefuelStops(int target, int tank, int[][] stations) {
		// pq is a maxheap of gas station capacities
		for (int[] is : stations) {
			is[0] = target - is[0];
		}
		Arrays.sort(stations, Comparator.comparingInt(o -> o[0]));
		PriorityQueue pq = new PriorityQueue();
		int ans = 0, curr = 0, i = 0;
		curr += tank;
		
		while(curr < target) {
			ans++;
			while(i < stations.length && stations[i][0] <= curr) {
				pq.addElement(stations[i][1]);
				i++;
			}
			if(pq.isEmpty()) {
				break;
			}
			curr += pq.peek();
			pq.poll();
		}
		return curr >= target ? ans : -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[][] pp = new int[t][2];
		int i = 0;
		while(t-- > 0) {
			int d = sc.nextInt();
			int p = sc.nextInt();
			pp[i][0] = d;
			pp[i][1] = p;
			i++;
		}
		int distance = sc.nextInt();
		int availablePetrol = sc.nextInt();
		System.out.println(minRefuelStops(distance, availablePetrol, pp));
		sc.close();
	}

}

class PriorityQueue{
	private Vector<Integer> A;

	public PriorityQueue() {
		super();
		A = new Vector<>();
	}

	public PriorityQueue(int capacity) {
		super();
		A = new Vector<>(capacity);
	}

	private int parent(int i) {
		if(i == 0) return 0;
		else return (i-1)/2 ;
	}

	private int left(int i) {
		return 2 * i + 1;
	}

	private int right(int i) {
		return 2 * i + 2;
	}

	void swap(int x, int y) {
		int temp = A.get(x);
		A.setElementAt(A.get(y), x);
		A.setElementAt(temp, y);
	}

	public int size() {
		return A.size();
	}


	private void heapifyDown(int i) {
		int left = left(i);
		int right = right(i);

		int largest = i;

		if(left < size() && A.get(i) < A.get(left)) {
			largest = left;
		}

		if(right < size() && A.get(i) < A.get(right)) {
			largest = right;
		}

		if(largest != i) {
			swap(i,largest);
			heapifyDown(largest);
		}
	}

	private void heapifyUp(int i) {
		if(i > 0 && A.get(parent(i)) < A.get(i)) {
			swap(i,parent(i));
			heapifyUp(parent(i));
		}
	}

	public boolean isEmpty() {
		return A.isEmpty();
	}

	public void addElement(int x) {
		A.addElement(x);
		heapifyUp(size()-1);
	}

	public Integer poll() {
		try {
			if(size() == 0) throw new Exception("Index is out of range");
			int root = A.firstElement();
			A.setElementAt(A.lastElement(), 0);
			A.remove(size() - 1);
			heapifyDown(0);
			return root;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	public Integer peek() {
		try {
			if(size() == 0) throw new Exception("Index is out of range");
			return A.firstElement();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	public void clear() {
		while(!A.isEmpty()) {
			poll();
		}
	}

}
