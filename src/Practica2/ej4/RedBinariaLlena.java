package Practica2.ej4;

import Practica2.ej2.BinaryTree;

public class RedBinariaLlena {
	private BinaryTree<Integer> a;

	public RedBinariaLlena(BinaryTree<Integer> a) {
		this.a = a;
	}
	public int retardoReenvio() {
		return a.isEmpty() ? 0 : retardoReenvio(a);// si esta vacio el arbol no se debe procesasr
	}
	public int retardoReenvio(BinaryTree<Integer> a) {
		int hijoIz=0;
		int hijoDer = 0;
		if(a.hasLeftChild())
			hijoIz = retardoReenvio(a.getLeftChild());
		if(a.hasRightChild())
			hijoDer = this.retardoReenvio(a.getRightChild());
		return Math.max(hijoIz, hijoDer) + a.getData();//en cada iteracion retorno el maximo y como hay un retardo se suma tambine
	}//En cada paso de la recursión retorno el retardo total del camino más largo hacia una hoja, y como cada nodo introduce su propio retardo, se lo sumo al máximo de sus hijos.
	
}
