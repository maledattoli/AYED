package Practica2.ej3;
import java.util.*;
import Practica2.ej2.BinaryTree;
import Practica1.ejercicio8.Queue;
public class ContadorArbol {
	private BinaryTree<Integer> ar;

	public ContadorArbol(BinaryTree<Integer> ar) {
		this.ar = ar;
	}
	public List<Integer> numerosPares(){
		List<Integer> l = new LinkedList<Integer>();
		if(!ar.isEmpty())recorrerArbolInOrder(l,ar);
		
		return l;
	}
	public void recorrerArbolInOrder(List<Integer> l, BinaryTree<Integer> a) {
		if(a.hasLeftChild())
			recorrerArbolInOrder(l, a.getLeftChild());
		if(a.getData() % 2 == 0)
			l.addLast(a.getData());
		if(a.hasRightChild())
			recorrerArbolInOrder(l,a.getRightChild());
	}
	public void recorrerArbolPreOrden(List<Integer> l, BinaryTree<Integer> a) {
		if(a.getData()%2 == 0)
			l.addLast(a.getData());
		if(a.hasLeftChild())
			this.recorrerArbolPreOrden(l, a.getLeftChild());
		if(a.hasRightChild())
			this.recorrerArbolPreOrden(l, a.getRightChild());
	}
	//hago estos para practicar
	public void recorrerArbolPostOrden(List<Integer> l, BinaryTree<Integer> a) {
		if(a.hasLeftChild())
			this.recorrerArbolPostOrden(l, a.getLeftChild());
		if(a.hasRightChild())
			this.recorrerArbolPostOrden(l, a.getRightChild());
		if(a.getData() %2 == 0)
			l.addLast(a.getData());
	}
	public void recorrerPorNiveles(List<Integer> l, BinaryTree<Integer> a) {
		//creo el arbol, la cola , agrego a la cola el arbol
		//agrego null a la cola para el fin
		//mientras la cola no este vacia
		//pongo el arbol que estaba en la cola en una arbol auxiliar
		//si el arbol NO es null 
		//guardo en la pila el valor izquierdo y el derecho si hay y el derecho
		//sino o sea es null pongo null en la cola
		BinaryTree<Integer> aa= new BinaryTree<>();
		Queue<BinaryTree<Integer>> c = new Queue<BinaryTree<Integer>>();
		c.enqueue(a);
		c.enqueue(null);
		while(!c.isEmpty()) {
			aa= c.dequeue();
			if(aa !=null) {
				if(aa.hasLeftChild())
					c.enqueue(aa.getLeftChild());
				if(aa.hasRightChild())
					c.enqueue(aa.getRightChild());
			}
			else if(!c.isEmpty()){
				c.enqueue(null);				
			}
		}
	}
	
	
}
