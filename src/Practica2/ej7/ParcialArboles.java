package Practica2.ej7;

import Practica2.ej2.BinaryTree;

public class ParcialArboles {
	BinaryTree<Integer> a;
	public boolean isLeftTree(int num) {
		BinaryTree<Integer> aAux = esta(a,num);
		return (!aAux.isEmpty()) ? isLeftTree(aAux) : false;
	}
	
	public BinaryTree<Integer> esta (BinaryTree<Integer> arb, int num){
		if(arb.getData()==num)
			return arb;//si esta el nodo devuelvo el arbol en ese nodo
		BinaryTree<Integer> aux = new BinaryTree<>();
		if(arb.hasLeftChild())
			aux = esta(arb.getLeftChild(), num);
		if(arb.hasRightChild())
			aux = esta(arb.getRightChild(),num);
		return aux;//ni no esta voy a terminar devolviendo una arbol vacio		
	}
	public boolean isLeftTree(BinaryTree<Integer> arb) {
		int contLeft=-1;//ni esta vacio queda ene -1
		int contRight=-1;
		if(arb.hasLeftChild())
			contLeft = cuentoUnico(arb.getLeftChild());

		if(arb.hasRightChild())
			contRight = cuentoUnico(arb.getRightChild());
		return contLeft>contRight;		
	}
	public int cuentoUnico(BinaryTree<Integer> arb) {
		int cant =0;
		if(arb.hasLeftChild())
			cant += cuentoUnico(arb.getLeftChild());
		if(arb.hasRightChild())
			cant+= cuentoUnico(arb.getRightChild());
		if((arb.hasLeftChild() && !arb.hasRightChild())|| (!arb.hasLeftChild() && arb.hasRightChild()))//si hay uno en iz y ninguno en der o viceversa suma uno
			cant++;
		return cant;
	}
	
	public ParcialArboles(BinaryTree<Integer> a) {
		this.a = a;
	}


	
	
}
