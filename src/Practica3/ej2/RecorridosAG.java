package Practica3.ej2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import Practica1.ejercicio8.Queue;
import Practica3.ej1yej3yej5.GeneralTree;

public class RecorridosAG {
	
	public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a,Integer n){
		List<Integer> l = new LinkedList<>();
		if(!a.isEmpty())
			numerosImparesMayoresQuePreOrden(a,n,l);
		return l;
	}
	private void numerosImparesMayoresQuePreOrden(GeneralTree <Integer> a,Integer n, List<Integer >l) {
		int dato = a.getData();
		if((dato>n)&&(dato%2 !=0))
			l.add(dato);
		List<GeneralTree<Integer>> children = a.getChildren();
		Iterator<GeneralTree<Integer>> it = children.iterator();
		while(it.hasNext()) {
			GeneralTree<Integer> child = it.next();
			this.numerosImparesMayoresQuePreOrden(child, n,l);
		}
			
	}
	public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a,Integer n){
		List<Integer> l = new LinkedList<>();
		if(!a.isEmpty())
			numerosImparesMayoresQueInOrden(a,n,l);
		return l;
		
	}
	private void numerosImparesMayoresQueInOrden(GeneralTree <Integer> a,Integer n, List<Integer >l) {
		List<GeneralTree<Integer>> children = a.getChildren();
		if(a.hasChildren())
			this.numerosImparesMayoresQueInOrden(children.get(0), n,l);
		int data = a.getData();
		if((data%2 != 0)&&(data>n)) {
			l.add(data);
		}
		Iterator<GeneralTree<Integer>> it = children.iterator();
		while(it.hasNext()) {
			GeneralTree<Integer> child = it.next();
			this.numerosImparesMayoresQuePreOrden(child, n, l);
		}
	}
	public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a, Integer n){
		List<Integer> l = new LinkedList<>();
		if(!a.isEmpty())
			numerosImparesMayoresQuePostOrden(a,n,l);
		return l;
	}
	private void numerosImparesMayoresQuePostOrden(GeneralTree <Integer> a,Integer n,List<Integer> l) {
		List<GeneralTree<Integer>> children = a.getChildren();
		Iterator<GeneralTree<Integer>> it = children.iterator();
		while(it.hasNext()) {
			GeneralTree<Integer> child = it.next();
			this.numerosImparesMayoresQuePostOrden(child, n, l);
		}
		int data = a.getData();
		if((data>n)&&(data%2 != 0))
			l.add(data);
	}
	public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a, Integer n){
		List<Integer> res = new LinkedList<>();
		GeneralTree<Integer> auxA;
		Queue<GeneralTree<Integer>> queue = new Queue<>();
		queue.enqueue(a);
		while(!queue.isEmpty()) {
			auxA= queue.dequeue();
			if(!auxA.isEmpty()) {
				int data = auxA.getData();
				if((data%2!=0)&&(data>n)) 
					res.add(data);
			}
			List<GeneralTree<Integer>> children = auxA.getChildren();
			for(GeneralTree<Integer> child: children) { 
					queue.enqueue(child);
			}
		}
		return res;
	}
	public static void main(String[] args) {
        GeneralTree<Integer> a1 = new GeneralTree<Integer>(1);
        List<GeneralTree<Integer>> children2 = new LinkedList<GeneralTree<Integer>>();
        children2.add(new GeneralTree<Integer>(21));
        children2.add(new GeneralTree<Integer>(22));
        children2.add(new GeneralTree<Integer>(23));
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(2, children2);
        List<GeneralTree<Integer>> children3 = new LinkedList<GeneralTree<Integer>>();
        children3.add(new GeneralTree<Integer>(31));
        children3.add(new GeneralTree<Integer>(32));
        GeneralTree<Integer> a3 = new GeneralTree<Integer>(3, children3);
        List<GeneralTree<Integer>> childen = new LinkedList<GeneralTree<Integer>>();
        childen.add(a1);childen.add(a2);childen.add(a3);
        GeneralTree<Integer> a = new GeneralTree<Integer>(11, childen);
        
        System.out.println("AlturaMax=" + a.altura());
        System.out.println("En que nivel esta el num 11? Nivel:" + a.nivel(11));
        System.out.println("En que nivel esta el num 3? Nivel:" + a.nivel(3));
        System.out.println("En que nivel esta el num 21? Nivel:" + a.nivel(21));
        System.out.println("Ancho=" + a.ancho());
       // System.out.println("ES ANCESTRO 11 DE 2:" + a.esAncestro(11, 2));
        //System.out.println("ES ANCESTRO 2 DE 11:" + a.esAncestro(2, 11));
        //System.out.println("ES ANCESTRO 11 DE 21:" + a.esAncestro(11, 21));
        //System.out.println("ES ANCESTRO 21 DE 11:" + a.esAncestro(21, 11));
        
        RecorridosAG rec = new RecorridosAG();
        
        System.out.println("PREORDEN:" + rec.numerosImparesMayoresQuePreOrden(a, 0));
        System.out.println("INORDEN:" + rec.numerosImparesMayoresQueInOrden(a, 0));
        System.out.println("POSTORDEN:" + rec.numerosImparesMayoresQuePostOrden(a, 0));
        System.out.println("POR NIVELES:" + rec.numerosImparesMayoresQuePorNiveles(a, 0));        
 }

	
}
