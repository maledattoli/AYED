package Practica3.ej8;

import java.util.LinkedList;
import java.util.List;

import Practica3.ej1yej3yej5.GeneralTree;

public class Navidad {
	private GeneralTree<Integer> arbol;
	
	public Navidad(GeneralTree<Integer> arbol) {
		this.arbol = arbol;
	}
	public String esAbetoNavidenio() {
		boolean res = isAbeto(arbol);
		return res ? "Yes" : "No";
	}
	private boolean isAbeto(GeneralTree<Integer> a) {
		int abetitos=0;
		for(GeneralTree<Integer> child : a.getChildren()) {
			if(child.isLeaf()) {// es hoja lo sumo al contador
				abetitos++;
			}
			else {
				if(!isAbeto(child)){// si cuando entro en la recursividad me devuelve falso retrorno falso
					return false;
				}
			}
		}
		return abetitos>=3;
	}
	public static void main(String[] args) {
		
        List<GeneralTree<Integer>> subArb1 = new LinkedList<GeneralTree<Integer>>();
        subArb1.add(new GeneralTree<Integer>(5));
        subArb1.add(new GeneralTree<Integer>(8));
        subArb1.add(new GeneralTree<Integer>(9));
        GeneralTree<Integer> a1 = new GeneralTree<Integer>(1, subArb1);
        
        Navidad navi1 = new Navidad(a1);
        System.out.println("es abeto????? "+navi1.esAbetoNavidenio());//deberia decir si
	}

}
