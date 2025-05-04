package Practica3.ej9;

import java.util.LinkedList;
import java.util.List;

import Practica1.ejercicio8.Queue;
import Practica3.ej1yej3yej5.GeneralTree;

public class ParcialArboles {
	public static boolean esDeSeleccion (GeneralTree<Integer> arbol) {
		// este algoritmo cuando es falso salta y cambia el true
		Queue<GeneralTree<Integer>> q = new Queue<>();//para ir guardando los valores q voy usando
		boolean esta = true;//si es vacio esta bine
		GeneralTree<Integer>aAux;
		if(!arbol.isEmpty()) {
			q.enqueue(arbol);
			while(!q.isEmpty() && esta) {
				aAux = q.dequeue();
				int minimo = Integer.MAX_VALUE;
				for(GeneralTree<Integer> child : aAux.getChildren()) {
					q.enqueue(child);
					minimo = Math.min(child.getData(), minimo);
				}
				if((!aAux.isLeaf())&& (aAux.getData()!= minimo)) {// si es el padre y no es el minimo entonces salta
					esta = false;
				}
			}					
		}
		return esta;
	}
	public static void main (String args[]) {
		List <GeneralTree<Integer>> subChildren1 = new LinkedList <GeneralTree<Integer>>();
        subChildren1.add(new GeneralTree<Integer>(35));
        GeneralTree<Integer> subAb1 = new GeneralTree<Integer>(35, subChildren1);
        
        List <GeneralTree<Integer>> subChildren2 = new LinkedList <GeneralTree<Integer>>();
        subChildren2.add(subAb1);
        GeneralTree<Integer> subAb2 = new GeneralTree<Integer>(35, subChildren2);
        
        List <GeneralTree<Integer>> subChildren3 = new LinkedList <GeneralTree<Integer>>();
        subChildren3.add(new GeneralTree<Integer>(35));
        subChildren3.add(new GeneralTree<Integer>(83));
        subChildren3.add(new GeneralTree<Integer>(90));
        subChildren3.add(new GeneralTree<Integer>(33));
        GeneralTree<Integer> subAb3 = new GeneralTree<Integer>(33, subChildren3);
        
        List<GeneralTree<Integer>> childs = new LinkedList<GeneralTree<Integer>>();
        childs.add(subAb3);
        childs.add(subAb2);
        childs.add(subAb1);
        //GeneralTree<Integer> a = new GeneralTree<>(33,childs); con este true
        GeneralTree<Integer> a = new GeneralTree<>(30,childs); // con este false
        
        System.out.println("el arbol es de seleccion???" + esDeSeleccion(a));
	}
	
}
