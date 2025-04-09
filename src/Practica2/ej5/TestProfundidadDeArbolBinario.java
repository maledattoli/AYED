package Practica2.ej5;

import Practica2.ej2.BinaryTree;


public class TestProfundidadDeArbolBinario {
	public static void main  (String[]args) {
		
		BinaryTree<Integer> a =new BinaryTree<>(10);
		
		a.addLeftChild(new BinaryTree<Integer>(5));
		a.addRightChild(new BinaryTree<Integer>(3));
		a.getLeftChild().addLeftChild(new BinaryTree<Integer>(7));
		a.getRightChild().addRightChild(new BinaryTree<Integer>(1));
		
		ProfundidadDeArbolBinario test = new ProfundidadDeArbolBinario(a);
		
		System.out.println("el la suma es: "+ test.sumaElementosProfundidad(2));// deberia dar 8
	}
}
