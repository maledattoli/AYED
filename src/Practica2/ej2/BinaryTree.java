package Practica2.ej2;
import Practica1.ejercicio8.*;

public class BinaryTree<T> {
	
	public BinaryTree() {
		super();
	}
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
    	return !(this.leftChild==null);
    }
  //Preguntar antes de invocar si hasRightChild()
    public boolean hasRightChild() {
    	return !(this.rightChild== null);
    }
    
    public int contarHojas() {
    	int cantidadHojas=0;
    	if(this.isLeaf()) {// si no tiene hijos no sigo la recursividad
    		cantidadHojas = 1;
    	}
    	//sino si sigo 
    	else {
    		if(this.hasLeftChild()) {//si tiene hijo izquierdo sigo con la recursividad para el hijo izquierdo
    			cantidadHojas += this.getLeftChild().contarHojas();
    		}
    		//si tiene hijo derecho sigo con la recursividad para el hijo derecho
    		if(this.hasRightChild()) {
    			cantidadHojas += this.getRightChild().contarHojas();
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
    	Queue<BinaryTree<T>> colita = new Queue<BinaryTree<T>>();
    	BinaryTree<T> arbAux;//arbolito auxiliar
    	
    	colita.enqueue(this);//encolo el arbol completo
    	colita.enqueue(null);
    	int nivel=0;
    	while(!colita.isEmpty()&&(nivel<=m)) { //pra que no se recorra si no hay nada y si termino el nivel no siga
    		arbAux = colita.dequeue();
    		if(arbAux!= null) {
    			if(nivel>=n)
    				System.out.println(arbAux.getData());
    			if(arbAux.hasLeftChild()) 
    				colita.enqueue(arbAux.getLeftChild());
    			if(arbAux.hasRightChild()) 
    				colita.enqueue(arbAux.getRightChild());
    		}
    		else {
    			if(!colita.isEmpty()) {//si es null y todavia quedan elementos en la cola es que se termino el nivel
    				colita.enqueue(null);
    				nivel++;
    			}
    		}
    	}
    	
    }
    
}
