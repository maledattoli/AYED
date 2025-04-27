package Practica3.ej6;

import java.util.LinkedList;
import java.util.List;

import Practica3.ej1yej3yej5.GeneralTree;

public class RedDeAguaPotable {
	private  GeneralTree<Character> a;
	
	public RedDeAguaPotable(GeneralTree<Character> a) {
		this.a = a;
	}
	
	public RedDeAguaPotable() {
		
	}
	public double minimoCaudal(double caudal) {
		if(!a.isEmpty()) {
			return (!a.isLeaf())? minimoCaudalHelper(a,caudal):caudal;			
		}
		else
			return 0;
	}
	private double minimoCaudalHelper(GeneralTree<Character> arb, double caudal) {
		if(arb.isLeaf()) {
			return caudal;
		}
		double caudalParaSubHijos = caudal/arb.getChildren().size();
		double caudalMinimo = Double.MAX_VALUE;
		for(GeneralTree<Character> child:arb.getChildren()) {
			double caudalHijos = minimoCaudalHelper(child,caudalParaSubHijos);
			if(caudalMinimo > caudalHijos)
				caudalMinimo = caudalHijos;
		}
		return caudalMinimo;
	}
	public static void main(String args[]) {
		
		GeneralTree<Character>a1 = new GeneralTree<>('B');
		
		List<GeneralTree<Character>> subChildren1 = new LinkedList<GeneralTree<Character>>();
		subChildren1.add(new GeneralTree<Character>('L'));
		GeneralTree<Character> subAb1 = new GeneralTree<Character>('G', subChildren1);
        List<GeneralTree<Character>> subChildren2 = new LinkedList<GeneralTree<Character>>();
        subChildren2.add(new GeneralTree<Character>('F'));
        subChildren2.add(subAb1);
        GeneralTree<Character> a2 = new GeneralTree<Character>('C', subChildren2);
        
        List<GeneralTree<Character>> subChildren3 = new LinkedList<GeneralTree<Character>>();
        subChildren3.add(new GeneralTree<Character>('M'));
        subChildren3.add(new GeneralTree<Character>('N'));
        GeneralTree<Character> subAb2 = new GeneralTree<Character>('J', subChildren3);
        List<GeneralTree<Character>> subChildren4 = new LinkedList<GeneralTree<Character>>();
        subChildren4.add(new GeneralTree<Character>('H'));
        subChildren4.add(new GeneralTree<Character>('I'));
        subChildren4.add(subAb2);
        subChildren4.add(new GeneralTree<Character>('K'));
        subChildren4.add(new GeneralTree<Character>('P'));
        GeneralTree<Character> a3 = new GeneralTree<Character>('D', subChildren4);
        
        GeneralTree<Character> a4 = new GeneralTree<Character>('E');
        
        List<GeneralTree<Character>> arbol = new LinkedList<GeneralTree<Character>>();
        arbol.add(a1);
        arbol.add(a2);
        arbol.add(a3);
        arbol.add(a4);
        GeneralTree<Character> ab = new GeneralTree<Character>('A', arbol);
        
        RedDeAguaPotable red = new RedDeAguaPotable(ab);
        System.out.println("El caudal minimo de una casa es "+ red.minimoCaudal(1000));
	}
}
