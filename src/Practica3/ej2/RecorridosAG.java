package Practica3.ej2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import Practica1.ejercicio8.Queue;
import Practica3.ej1yej3.GeneralTree;

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


	
}
