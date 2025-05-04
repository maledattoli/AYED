package Practica3.ej10;

import java.util.LinkedList;
import java.util.List;

import Practica3.ej1yej3yej5.GeneralTree;

public class ParcialArboles {
	public static List<Integer> resolver(GeneralTree<Integer> arbol){
		int nivel=0;
		List<Integer> l = new LinkedList<Integer>();
		List<Integer> lCamino = new LinkedList<Integer>();
		if(!arbol.isEmpty()) {
			resolver(arbol,l,lCamino,0,0,-1);
		}
		return lCamino;
	}
	private static void resolver(GeneralTree<Integer>a, List<Integer>lActual, List<Integer>lCamino, int nivel, int total, int max) {
		int dato =a.getData();
		if(dato == 1) {//solo si es uno se agrega
			lActual.add(dato);
			total += dato*nivel;
		}
		if(!a.isLeaf()) {// sigo recorriendo
			for (GeneralTree<Integer> child : a.getChildren()) {
				resolver(child,lActual,lCamino,nivel+1, total,max);
			}
		}
		else
		if(total>max) {// si este camino es mejor
			lCamino.removeAll(lCamino);
			max = total;
			total=0;
			lCamino.addAll(lActual);
		}
		if(dato == 1) {
			lActual.remove(lActual.size() - 1);// para seguir recorriendo el camino del arbol 
		}
	}
}
