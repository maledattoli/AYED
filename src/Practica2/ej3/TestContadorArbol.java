package Practica2.ej3;

import Practica2.ej2.BinaryTree;
import java.util.*;
public class TestContadorArbol {
	public static void main(String[]args) {
		BinaryTree<Integer> a1 = new BinaryTree<Integer>(2);
		BinaryTree<Integer> a2 = new BinaryTree<Integer>(7);
		BinaryTree<Integer> a3 = new BinaryTree<Integer>(21);
		BinaryTree<Integer> a4 = new BinaryTree<Integer>(24);
		BinaryTree<Integer> a5 = new BinaryTree<Integer>(6);
		a1.addLeftChild(a2);
		a1.addRightChild(a3);
		a2.addLeftChild(a4);
		a2.addRightChild(a5);
		ContadorArbol t= new ContadorArbol(a1);
		List<Integer> l = t.numerosPares();
		System.out.println(l.toString());
}	
}
