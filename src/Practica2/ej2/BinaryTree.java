package Practica2.ej2;

import java.util.LinkedList;
import java.util.Queue;

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
    //Preguntar antes de invocar si hasLeftChild()
    public boolean hasLeftChild() {
    	return this.leftChild==null;
    }
  //Preguntar antes de invocar si hasRightChild()
    public boolean hasRightChild() {
    	return this.rightChild== null;
    }
    
    public int contarHojas() {
    	int cantidadHojas=0;
    	if(this.isLeaf()) {// si no tiene hijos no sigo la recursividad
    		return 1;
    	}
    	//sino si sigo 
    	else {
    		if(this.hasLeftChild()) {//si tiene hijo izquierdo sigo con la recursividad para el hijo izquierdo
    			return cantidadHojas + this.getLeftChild().contarHojas();
    		}
    		//si tiene hijo derecho sigo con la recursividad para el hijo derecho
    		if(this.hasRightChild()) {
    			return cantidadHojas + this.getRightChild().contarHojas();
    		}
    	}
    	return cantidadHojas;
    }
    public BinaryTree<T> espejo(){
    	BinaryTree<T>arbolitoEspejo = new BinaryTree<T>(this.getData());
    	if(this.hasLeftChild()) {//si tiene hijo izquierdo
    		//agrego un hijo derechi y ahi le agrego el izquierdo siguiendo con la recursividad
    		arbolitoEspejo.addRightChild(this.getLeftChild().espejo());
    	}
    	if(this.hasRightChild()) {//si tiene hijo derecho
    		//agrego un hijo iz y ahi le agrego el derecho siguiendo con la recursividad
    		arbolitoEspejo.addLeftChild(this.getRightChild().espejo());
    	}
    	return arbolitoEspejo;
    }
    public void entreNiveles(int n, int m) {
    	if(this.isEmpty() || n<0 || m<n)return; // si ponen algo q causa fallo termina
    	Queue<BinaryTree<T>> colita = new LinkedList();
    	colita.add(this);
    	int nivel=0;
    	while(!colita.isEmpty()) {
    		
    	}
    	
    }
    
}
