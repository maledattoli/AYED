package Practica2.ej6;

import Practica2.ej2.BinaryTree;

public class Transformacion {
	private BinaryTree<Integer> a;
	public BinaryTree<Integer> suma(){
		if(a.isEmpty())
			return null;
		else {
			suma(a);
			return a;// devuelvo el arbol ya transformado
		}
	}
	

	public Transformacion(BinaryTree<Integer> a) {
		super();
		this.a = a;
	}


	private int suma (BinaryTree<Integer> a){
		int auxSuma = 0;
		if(a.isLeaf()) {// ni no tiene nodos abajo debe ser 0
			auxSuma = a.getData(); // guardo los dats para poder sumarlos a los otros
			a.setData(0);// no tiebne nodos abajo entonces debe ser 0
			return auxSuma;//devuelve el valor del nodo para q el padre lo sume
		}
		if(a.hasLeftChild())// si tiene izquierdo
			auxSuma += suma(a.getLeftChild());// sigo la iteracion para los otros
		if(a.hasRightChild())//si tiene derecho 
			auxSuma += suma(a.getRightChild());// ssigo la it con el der
		int esteNodo = a.getData();// guarda el valor del nodo
		a.setData(auxSuma);//le da al nodo la suma de sus hijos
		return auxSuma + esteNodo;//devuelve la suma para q el padre los sume
	}
}
