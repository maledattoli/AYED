package Practica2.ej4;

import Practica2.ej2.BinaryTree;

public class TestRedBinaria {
	public static void main (String[] args) {
		
		BinaryTree<Integer> a =new BinaryTree<>(10);
		
		a.addLeftChild(new BinaryTree<Integer>(5));
		a.addRightChild(new BinaryTree<Integer>(3));
		a.getLeftChild().addLeftChild(new BinaryTree<Integer>(7));
		a.getRightChild().addLeftChild(new BinaryTree<Integer>(1));
		
		RedBinariaLlena red = new RedBinariaLlena(a);
		
		System.out.println("el retardo es: "+ red.retardoReenvio());//deberia decir 22
	}
}
