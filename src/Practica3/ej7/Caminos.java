package Practica3.ej7;

import java.util.LinkedList;
import java.util.List;

import Practica3.ej1yej3yej5.GeneralTree;

public class Caminos {
	private GeneralTree<Integer> a;
	public List<Integer> caminoAHojaMasLejana(){//camino entonces NO por nivel//de arriba hacia abajo entonces PRE
		//hay q recorrer todo el arbol
		//recursivo
		//cada una de las inv metemos al camino el nodo, vcas hasta todos los hojas
		//se termina la rec cuando se llega a al arbol hoja
		//se van guardando caminos, se guarda el primero y cuando terminamos de recorrer el otro se compara con el anternior a ver si es mas largo
		//si es mas largo te quedas con ese
		//primero ves di es vacio, si es hoja ves si lo retornas o no
		List<Integer> lAct = new LinkedList<Integer>();
		List<Integer> lMasLejana = new LinkedList<>();
		if(!a.isEmpty()) {
			this.caminoAHojaMasLejana(lAct, a, lMasLejana);
		}
		return lMasLejana;
	}
	private void caminoAHojaMasLejana(List<Integer> lActual, GeneralTree<Integer> arb, List<Integer> lMasLejana) {
		lActual.add(arb.getData());//guardo el dato actual
		if(arb.isLeaf()) {//si no hay mas hijos para abajo
			if(lActual.size()>lMasLejana.size()) {//si es mas grande el camino q el mas largo
				lMasLejana.removeAll(lMasLejana);//saco lo q hay en el mas largo 
				lMasLejana.addAll(lActual);//y guardo lo de la actual
			}
		}
		else {
			for(GeneralTree<Integer> child : arb.getChildren()) {
				caminoAHojaMasLejana(lActual, child, lMasLejana);//sigo recorriendo
			}

		}
		lActual.remove(lActual.size()-1);	// cuando volvemos de la rec se debe sacar el nodo de recien para seguir 	
	}
	
	public Caminos(GeneralTree<Integer> a) {
		this.a = a;
	}
	public static void main(String args[]) {
		List<GeneralTree<Integer>> subHijo1 = new LinkedList<>();
		subHijo1.add(new GeneralTree<Integer>(1));
		GeneralTree<Integer> aChiq = new GeneralTree<>(6, subHijo1);
		List<GeneralTree<Integer>> subHijo2 = new LinkedList<>();
		subHijo2.add(new GeneralTree<Integer>(10));
		subHijo2.add(aChiq);
		GeneralTree<Integer> aSuper= new GeneralTree<>(17, subHijo2);
		
		List<GeneralTree<Integer>> subChildren4 = new LinkedList<GeneralTree<Integer>>();
        subChildren4.add(new GeneralTree<Integer>(16));
        subChildren4.add(aSuper);
        
		
		GeneralTree<Integer> a = new GeneralTree<>(12, subChildren4);
		Caminos camino = new Caminos(a);
		System.out.println("el camino mas largo es "+ camino.caminoAHojaMasLejana());//debe decir [12, 17, 6, 1]
	}
}
