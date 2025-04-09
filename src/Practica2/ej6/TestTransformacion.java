package Practica2.ej6;

import Practica2.ej2.BinaryTree;

public class TestTransformacion {
	
	public static void informar(BinaryTree<Integer>a) {//recorrido inorder
		
		if(a.hasLeftChild())
			informar(a.getLeftChild());
		System.out.println(a.getData() );
		if(a.hasRightChild())
			informar(a.getRightChild());
		
	}
	public static void main (String[]args) {
		BinaryTree<Integer> a =new BinaryTree<>(10);
		
		a.addLeftChild(new BinaryTree<Integer>(5));
		a.addRightChild(new BinaryTree<Integer>(3));
		a.getLeftChild().addLeftChild(new BinaryTree<Integer>(7));
		a.getRightChild().addRightChild(new BinaryTree<Integer>(1));
		
		Transformacion test = new Transformacion(a);
		informar(test.suma());
		
	}
}
