package eg.edu.alexu.csd.filestructure.sort;

public class Node <T extends Comparable<T>> implements INode<T> {
	int index;
	T value;
	INode<T> arr[];
	Node(int index,T value,INode<T> arr[]){
		this.index=index;
		this.value=value;
		this.arr=arr;
	}
	public void setindex(int index) {
		this.index=index;
	}
	@Override
	public INode<T> getLeftChild() {
		// TODO Auto-generated method stub
		if((2*index+1)>=arr.length)return null;
		return arr[2*index+1];
	}

	@Override
	public INode<T> getRightChild() {
		// TODO Auto-generated method stub
        if((2*index+2)>=arr.length)return null;
		return arr[2*index+2];
	}

	@Override
	public INode<T> getParent() {
		// TODO Auto-generated method stub
		if(index==0)return null;
		return arr[(index-1)/2];
	}

	@Override
	public T getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public void setValue(T value) {
		// TODO Auto-generated method stub
		this.value=value;
	}

}
