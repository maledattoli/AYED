package Practica3.ej1yej3yej5;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import Practica1.ejercicio8.Queue;

public class GeneralTree<T> {
	private T data;
	private List<GeneralTree<T>>children = new LinkedList<GeneralTree<T>>();
	public GeneralTree() {
	}
	public GeneralTree(T data) {
		this.data= data;
	}
	public GeneralTree(T data,List<GeneralTree<T>>children) {
		this.data= data;
		this.setChildren(children);
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public List<GeneralTree<T>> getChildren() {
		return children;
	}
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null) {
	        this.children = children;
	    }
	}
	public void addChild(GeneralTree<T> nodo) {
	        this.getChildren().add(nodo);	    
	}
	public boolean isLeaf() {
		return !hasChildren();
	}
	public boolean hasChildren() {
		return !children.isEmpty();
	}
	public boolean isEmpty() {
		return data == null && !this.hasChildren();
	}
	public void removeChild(GeneralTree<T> child) {
		if(this.hasChildren())
			children.remove(child);
	}
	/////////////////////////////
	//ej2
	
	public List<Integer> numerosImparesMayoresQuePreOrden (Integer n){
		List<Integer> l = new LinkedList<>();
		if(!this.isEmpty())
			numerosImparesMayoresQuePreOrden(n,l);
		return l;
	}
	private void numerosImparesMayoresQuePreOrden(Integer n, List<Integer >l) {
		int dato = (Integer)this.getData();
		if((dato>n)&&(dato%2 !=0))
			l.add(dato);
		List<GeneralTree<T>> children = this.getChildren();
		for(GeneralTree<T> child: children)
			this.numerosImparesMayoresQuePreOrden(n,l);
		
			
	}
	public List<Integer> numerosImparesMayoresQueInOrden (Integer n){
		List<Integer> l = new LinkedList<>();
		if(!this.isEmpty())
			numerosImparesMayoresQueInOrden(n,l);
		return l;
		
	}
	private void numerosImparesMayoresQueInOrden(Integer n, List<Integer >l) {
		List<GeneralTree<T>> children = this.getChildren();
		if(this.hasChildren())
			this.numerosImparesMayoresQueInOrden( n,l);
		int data = (Integer)this.getData();
		if((data%2 != 0)&&(data>n)) {
			l.add(data);
		}
		for(GeneralTree<T> child : children)
			this.numerosImparesMayoresQuePreOrden(n, l);
		
	}
	public List<Integer> numerosImparesMayoresQuePostOrden (Integer n){
		List<Integer> l = new LinkedList<>();
		if(!this.isEmpty())
			numerosImparesMayoresQuePostOrden(n,l);
		return l;
	}
	private void numerosImparesMayoresQuePostOrden(Integer n,List<Integer> l) {
		List<GeneralTree<T>> children = this.getChildren();
		Iterator<GeneralTree<T>> it = children.iterator();
		while(it.hasNext()) {
			GeneralTree<T> child = it.next();
			this.numerosImparesMayoresQuePostOrden( n, l);
		}
		int data = (Integer)this.getData();
		if((data>n)&&(data%2 != 0))
			l.add(data);
	}
	public List<Integer> numerosImparesMayoresQuePorNiveles(Integer n){
		List<Integer> res = new LinkedList<>();//me pide que guarde en una lista los que coinciden
		GeneralTree<T> auxA;
		Queue<GeneralTree<T>> queue = new Queue<>();
		queue.enqueue(this);//encolo la raiz (el arbol)
		while(!queue.isEmpty()) {
			auxA= queue.dequeue();//saco la instancia actual
			if(!auxA.isEmpty()) {//me fijo q no este vacio 
				int data = (Integer)auxA.getData();//y ahi si comparo
				if((data%2!=0)&&(data>n)) 
					res.add(data);
			}
			List<GeneralTree<T>> children = auxA.getChildren();
			for(GeneralTree<T> child: children) {//para poder encolar los hijos del arbol aux 
					queue.enqueue(child);//encolo un hijo
			}
		}
		return res;
	}
	
	//////////////////////
	//ej 3
	public int altura() {
		return (!this.isEmpty()? alturaHelper():-1);
	}
	private int alturaHelper() {
		if(this.isLeaf())
			return 0;
		else {
			int alturaMax = -1;
			List<GeneralTree<T>> children = this.getChildren();
			for(GeneralTree<T> child : children) {
				alturaMax = Math.max(alturaMax, child.alturaHelper());
			}
			return alturaMax +1;
		}			
	}
	
	public int nivel(T dato) {
		return !this.isEmpty() ? nivelHelper(dato) : -1;
	}
	private int nivelHelper(T dato) {
		int contadorNivel = 0;
		int actual;
		GeneralTree<T> auxA;
		Queue<GeneralTree<T>> queue = new Queue<>();
		queue.enqueue(this);
		while(!queue.isEmpty()) {
			actual = queue.size();//guardo la cantidad actual de nodos
			for (int i=1; i<actual;i++) {
				auxA = queue.dequeue();
				if(auxA.getData().equals(dato))//si es el dato que busco
					return contadorNivel;//devuelvo el nivel
				else//si no es el dato
					for(GeneralTree<T> child : children)//encolamos a los hijos
						queue.enqueue(child);
			}
			contadorNivel++;
		}
		return -1;//si el dato no esta
	}
	public int ancho() {
		GeneralTree<T> auxA;//meter lo que vaya desencolando
		Queue<GeneralTree<T>> q = new Queue<>();
		int contadorNodos = 0;// cuanta la cantidad de nodos (arboles) del nivel
		int ancho = 0;//cuando termine va a terner la cantidad de niveles q haya en el nivel mas alto
		q.enqueue(this);
		q.enqueue(null);
		while(!q.isEmpty()) {
			auxA= q.dequeue();
			//si exs un separador
			if(auxA==null) {
				
				if(contadorNodos>ancho)//si este nivel tiene mas
					ancho= contadorNodos;
				//nuevo nivel resetear el cont nodos
				contadorNodos=0;
				//encolo separador si la cpola no se vacio
				if(!q.isEmpty())
					q.enqueue(null);
			}
			else {
				contadorNodos++;
				for(GeneralTree<T> child: children)
					q.enqueue(child);
			}
		}	
		return ancho;	
	}
	///555555555555
	public boolean esAncestro(T a, T b) {
		return this.isEmpty() ? false : esAncestroBuscar(a,b);
	}
	private boolean esAncestroBuscar(T a, T b) {//a ver si esta a antes de b y si existe
		boolean resultado=false;
		GeneralTree<T>nodoA= null;
		GeneralTree<T>aux;
		Queue<GeneralTree<T>>q= new Queue<>();
		q.enqueue(this);
		
		while(!q.isEmpty()) {
			aux= q.dequeue();
			if(aux.getData().equals(b) && !resultado) {
				return false;
			}
			if(aux.getData().equals(a)) {
				resultado=true;
				nodoA=aux;
			}
			if(!resultado){//si no se encontro el nodo todavia
				for(GeneralTree<T> child : aux.getChildren()) {
					q.enqueue(child);
				}
			}
		}
		return resultado ? buscoB(nodoA,b): false;
	}
	private boolean buscoB(GeneralTree<T> a, T b) {
		GeneralTree<T> aAux;
		Queue<GeneralTree<T>>q = new Queue<>();
		q.enqueue(a);
		while(!q.isEmpty()) {
			aAux= q.dequeue();
			if(aAux.getData().equals(b)) {
				return true;
			}
			else {//si este dato no es sigue recorriendo los otros hijos
				for(GeneralTree<T> child : aAux.getChildren()) {
					q.enqueue(child);
				}
			}
		}
		return false;// recorrio todo y no estaba la b
	}
	
}
