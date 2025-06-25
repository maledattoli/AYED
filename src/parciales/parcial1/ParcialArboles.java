package parciales.parcial1;

import Practica2.ej2.BinaryTree;


public class ParcialArboles {
	public BinaryTree<DosNumeros> sumAndDif(BinaryTree<Integer>arbol){
		BinaryTree<DosNumeros> a2 = new BinaryTree<DosNumeros>();
		if(!arbol.isEmpty()) {
			return sumAndDifHelper(arbol,a2,0,0);
		}
		else
			return a2;
		
	}
	private static void sumAndDifhelper(BinaryTree<Integer>a,BinaryTree<DosNumeros>a2,int suma, int datoPadre ){
		
		if(a.hasLeftChild()) {
			sumAndDif(a.getLeftChild(),a2,this.);
		}
		if(a.hasRightChild()) {
			sumAndDif(a.getRightChild()a2);
		}
	}
}
