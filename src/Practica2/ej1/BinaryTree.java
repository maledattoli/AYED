package Practica2.ej1;

public class BinaryTree<T> {
	private T data;
	private BinaryTree<T> leftChild;
	private BinaryTree<T> rightChild;
    public BinaryTree(T data) {
    	this.data = data;
    }
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(BinaryTree<T> leftChild) {
		this.leftChild = leftChild;
	}
	public BinaryTree<T> getRightChild() {
		return rightChild;
	}
	public void setRightChild(BinaryTree<T> rightChild) {
		this.rightChild = rightChild;
	}
    public void  addLeftChild(BinaryTree<T> child) {
    	this.leftChild = child;
    }
    public void  addRightChild(BinaryTree<T> child) {
    	this.rightChild = child;
    }
    public void removeLeftchild() {
    	this.leftChild=null;
    }
    public void removeRightchild() {
    	this.rightChild=null;
    }
    public boolean isEmpty() {
    	return (this.isLeaf() && this.getData() == null);
    }
    public boolean isLeaf() {
    	return (!hasLeftChild() && !hasRightChild());
    }
    public boolean hasLeftChild() {
    	return this.leftChild==null;
    }
    public boolean hasRightChild() {
    	return this.rightChild== null;
    }
    
    
}
