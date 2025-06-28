package practica5.ej2;

import java.util.LinkedList;
import java.util.List;

import Practica1.ejercicio8.Queue;
import practica5.ej1.Edge;
import practica5.ej1.Graph;
import practica5.ej1.Vertex;

public class Recorridos<T> {
	public List<T> dfs(Graph<T>grafo) {
		boolean[]marcas = new boolean[grafo.getSize()];//vector de marcas del grafo ya empieza en false
		List<T> list = new LinkedList<T>();//creo la lista que voy a devolver
		for(int i = 0; i<grafo.getSize();i++) {//para cada marca del grafo es decir para cada vertice(nodo) del grafo
			if(!marcas[i]) {//si no fue visitado
				dfs(i,grafo,list,marcas);
			}
			
		}
		return list;
	}
	public void dfs(int i, Graph<T>grafo ,List<T> list, boolean[]marcas){
		marcas[i] = true;//pongo la posicion en visitada
		Vertex<T> v = grafo.getVertex(i);//tomo la posicion
		list.add(v.getData());//agrego a la lista de recorrido el dato actual
	
		for(Edge<T> e: grafo.getEdges(v) ){//recorro los adyacentes
			int j = e.getTarget().getPosition();//guardo la pos del vertice adyacente
			
			if(!marcas[j]) {//si no esta visitado
				dfs(j,grafo,list,marcas);//sigo revisando la lista de adyacentes
			}
		}
	}                                            
	public List<T> bfs(Graph<T>grafo) {
		boolean[]marcas = new boolean[grafo.getSize()];
		List<T>list = new LinkedList<>();//lista a devolver
		for( int i = 0; i<grafo.getSize();i++) {
			if(!marcas[i]) {
				bfs(i, grafo, list, marcas);
			}
		}
		return list;
	}
	public void bfs(int i, Graph<T>grafo, List<T>list, boolean[]marcas) {
		Queue<Vertex<T>> c = new Queue<Vertex<T>>();//dcreo la cola
		
		c.enqueue(grafo.getVertex(i));//apilo el vertice inicial posicion i
		while(!c.isEmpty()) {//mientras la cola no se vacie(haya elementos en el grafo)
			Vertex<T>aux = c.dequeue();//bajo un elemento de la cola, retiro un vertice de la cola
			list.add(aux.getData());//proceso el elemento (Agrego su dato a la lista de visitados)
			for(Edge<T>e: grafo.getEdges(aux)) {//recorro su lista de adyacencia
				int j = e.getTarget().getPosition();//guardo la posicion del vertice adyacente
				if(!marcas[j]) {//si no fue visitado
					marcas[j]=true;//marco como visitado
					c.enqueue(e.getTarget());//lo encolo para visitarlo despues 
				}
			}
		}
	}
}
