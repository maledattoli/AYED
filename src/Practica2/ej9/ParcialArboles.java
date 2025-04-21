package Practica2.ej9;

import Practica2.ej2.BinaryTree;

public class ParcialArboles {
	public BinaryTree<SumaDiferencia> sumAndDif(BinaryTree<Integer> arbol){
		BinaryTree<SumaDiferencia> arb= new BinaryTree<>();
		if(!arbol.isEmpty())
			sumAndDif(arbol,arb,0,0);//0 para el nodo de arriba y el otro para el nodo actual
		return arb;
	}
	public void sumAndDif(BinaryTree<Integer> arbol,BinaryTree<SumaDiferencia>arb,int suma ,int datoPadre){
		int datoActual= arbol.getData();//guardo el nodo actual
		SumaDiferencia aux = new SumaDiferencia(datoActual+ suma, datoActual-datoPadre);
		//lo pongo en el tipo de dato con 2 var 
		if(arbol.hasLeftChild()) {
			arb.addLeftChild(new BinaryTree<SumaDiferencia>(aux));//si tiene izq lo guardo ahi
			sumAndDif(arbol.getLeftChild(),arb.getLeftChild(), suma+datoActual, datoActual);
		}	
		if(arbol.hasRightChild()) {
			arb.addRightChild(new BinaryTree<SumaDiferencia>(aux));//y si tiene derecho lo guardo ahi
			sumAndDif(arbol.getRightChild(), arb.getRightChild(), suma+ datoActual, datoActual);
		}
			
	}
}
