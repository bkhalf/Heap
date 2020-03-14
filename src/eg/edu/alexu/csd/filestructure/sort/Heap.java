package eg.edu.alexu.csd.filestructure.sort;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class Heap <T extends Comparable<T>> implements IHeap<T> {
	INode<T> arr[];
	int index;
	int sizeArray;
	boolean max=false;
	int sizeHeap;
	Heap(){
		sizeArray=1000000;
		arr=new INode[sizeArray];
		sizeHeap=0;
	}

	@Override
	public INode<T> getRoot() {
		// TODO Auto-generated method stub
		if(sizeHeap==0) {
			return null;
		}
		return arr[0];
	}

	@Override
	public int size() {
		return sizeHeap;
	}

	public Node compChilds(Node node) {
		Node nd = node;
		if(node.index*2+1>sizeHeap-1 && (node.index)*2+2>sizeHeap-1) {
			return null;
		}
		if(node.index*2+1<=sizeHeap-1 && (node.index)*2+2>sizeHeap-1) {
			nd = (Node) node.getLeftChild();
		}
		else {
			int comp = node.getRightChild().getValue().compareTo(node.getLeftChild().getValue());
			if (comp <0) {
				nd = (Node) node.getLeftChild();
			} else {
				nd = (Node) node.getRightChild();
			}
		}

		return nd;
	}
	@Override
	public void heapify(INode<T> node) {
		// TODO Auto-generated method stub
		if(max) {
			Node<T> nd= compChilds((Node<T>) node);
			if(nd!=null) {
				int comp = nd.getValue().compareTo(node.getValue());
				while (comp>0) {
					T temp = (T) nd.getValue();
					nd.setValue(node.getValue());
					node.setValue(temp);
					node = nd;
					nd = compChilds((Node<T>) node);
					if(nd==null)break;
					comp = nd.getValue().compareTo(node.getValue());
				}
			}
		}else {
			if(sizeHeap==1 || sizeHeap==0) {
				return;
			}
			int comp=node.getParent().getValue().compareTo(node.getValue());
			while(comp<0) {
//			  System.out.println("Sdasdasd");
				T temp=node.getParent().getValue();
				node.getParent().setValue(node.getValue());
				node.setValue(temp);
				node=node.getParent();
				if(node.getParent()==null)break;
				comp=node.getParent().getValue().compareTo(node.getValue());
			}
		}

	}

	@Override
	public T extract() {
		max=true;
		if(sizeHeap==0)return null;
		T node=  arr[0].getValue();
		arr[0].setValue(arr[sizeHeap-1].getValue());
		sizeHeap--;
		heapify(arr[0]);
		return (T) node;
	}

	@Override
	public void insert(T element) {
		if(element==null)return;
		if(sizeArray==sizeHeap) {
			arr=Arrays.copyOf(arr, sizeArray*2);
			sizeArray*=2;
		}
		Node temp=new Node(sizeHeap, element, arr);
		arr[sizeHeap]=temp;
		sizeHeap++;
		max=false;
		heapify(arr[sizeHeap-1]);
		for(int i=0;i<sizeHeap;i++){
//			System.out.print(arr[i].getValue() + " ");

		}
//		System.out.println("-------------------");
	}
	@Override
	public void build(Collection<T> unordered) {
		if(unordered==null || unordered.isEmpty()) return;
		Iterator<T> iterator = unordered.iterator();
		while (iterator.hasNext()) {
			insert(iterator.next());
		}
	}

	public void print() {
		for(int i=0;i<sizeHeap;i++){
			System.out.print(arr[i].getValue() + " ");

		}
		System.out.println();
	}

}
