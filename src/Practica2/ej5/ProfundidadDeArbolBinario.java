package Practica2.ej5;


import Practica2.ej2.BinaryTree;

public class ProfundidadDeArbolBinario {
	private BinaryTree<Integer> a;

	public ProfundidadDeArbolBinario(BinaryTree<Integer> a) {
		this.a = a;
	}
	public int sumaElementosProfundidad(int p) {
		return a.isEmpty() ? 0 : sumaElementosProfundidad(p,a,0);
	}
	private int sumaElementosProfundidad(int p, BinaryTree<Integer>a,int nivel) {
		if(nivel> p)
			return -1;
		if(p==nivel)
			return a.getData();
		else {
			int suma=0;
			if(a.hasLeftChild())
				suma += sumaElementosProfundidad(p,a.getLeftChild(),nivel+1);
			if(a.hasRightChild())
				suma+= sumaElementosProfundidad(p,a.getRightChild(),nivel+1);
			return suma;
		}
	}
	
}
