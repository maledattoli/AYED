package practica5.ej3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import practica5.ej1.Edge;
import practica5.ej1.Graph;
import practica5.ej1.Vertex;
import practica5.ej1.adjList.AdjListGraph;

public class Mapa {
	private Graph<String> mapaCiudades;

    
    public Mapa(Graph<String> mapa) {
        this.setMapaCiudades(mapa);
    }

    public Graph<String> getMapaCiudades() {
        return mapaCiudades;
    }

    public void setMapaCiudades(Graph<String> mapaCiudades) {
        this.mapaCiudades = mapaCiudades;
    }
	//1111111111111111111111111111111111111111111111111111
	
	public List<String>devolverCamino(String ciudad1, String ciudad2) {
		List<String> list =new LinkedList<>();//variable para guardar la info
		if(!this.mapaCiudades.isEmpty()) {
			Vertex<String> origen = this.mapaCiudades.search(ciudad1);
			Vertex<String> destino = this.mapaCiudades.search(ciudad2);
			if(origen!=null && destino!=null ) {
				devolverCamino(origen,destino,list, new boolean[this.mapaCiudades.getSize()]);
			}
		}
		return list;
	}
	private boolean devolverCamino(Vertex<String> origen, Vertex<String> destino, List<String> list, boolean[] marcas) {
		 boolean encontre = false;//boolean a ver si existe el camino
		 marcas[origen.getPosition()] = true;//marco donde empieza x visitado
		 list.add(origen.getData());
		 if(origen==destino) {
			 return true;
		 }
		 else {
			 List<Edge<String>> ady = mapaCiudades.getEdges(origen);//agarro la lista de adyacentes
			 Iterator<Edge<String>> it =  ady.iterator();
			 while(it.hasNext() && !encontre) {
				 Vertex<String>v = it.next().getTarget();//guardo el siguiente
				 int i = v.getPosition();//agarro la posicion del siguiente vertice
				 if(!marcas[i]) {//si no esta marcado
					 encontre = devolverCamino(v,destino,list,marcas);
				 }
			 }
		 }
		 if(!encontre) {
			 list.remove(list.size()-1);//si no se encontro se saca la ciudad de la lista, si no sirve este camino, lo deshago para poder probar otros caminos
		 }
		 return encontre;
	}
	
	//////////////////////////////// 222222222222222222222222222222222222222222222222
	
	public List<String> devolverCaminoExceptuando (String ciudad1, String ciudad2, List<String> ciudades){
		List<String> list = new LinkedList<>();
		if(!mapaCiudades.isEmpty()) {
			Vertex<String> origen = this.mapaCiudades.search(ciudad1);
			Vertex<String> destino = this.mapaCiudades.search(ciudad2);
			if(destino!= null && origen!=null) {
				boolean[]marcas = new boolean[this.mapaCiudades.getSize()];
				marcarRestringidas(ciudades,marcas);
				devolverCamino(origen,destino,list,marcas);
			}
		}
		
		return list;
	}
	private void marcarRestringidas(List<String> restringidos,boolean[]marcas) {
		
		for(String nombre: restringidos) {
			Vertex<String> v = this.mapaCiudades.search(nombre);
			if(v != null) {
				marcas[v.getPosition()] = true;
			}
			
		}	
	}
	//333333333333333333333
	public List<String> caminoMasCorto(String ciudad1, String ciudad2) {
		List<String> caminitin = new LinkedList<>();
		Vertex<String>origen = this.mapaCiudades.search(ciudad1);
		Vertex<String>destino = this.mapaCiudades.search(ciudad2);
		if(origen!=null && destino!=null) {
			caminoMasCorto(origen,destino,caminitin, new LinkedList<String>(), 0, Integer.MAX_VALUE,new boolean[this.mapaCiudades.getSize()]);
		}
		return caminitin;
	}
	private int caminoMasCorto(Vertex<String> origen,Vertex<String>destino, List<String>c, List<String> caminoActual, int total, int menor, boolean[]marcas) {
		marcas[origen.getPosition()]=true;
		caminoActual.add(origen.getData());
		if(origen==destino && total<menor) {// Si llegaste al destino y el camino es más corto
			c.removeAll(c);
			c.addAll(caminoActual);
			menor = total;
		}
		else {
			List<Edge<String>> ady = this.mapaCiudades.getEdges(origen); 
			Iterator<Edge<String>> it = ady.iterator();
			
			while(it.hasNext() && total<menor) {
				Edge<String> v = it.next();
				int i = v.getTarget().getPosition();
				int aux = total + v.getWeight();
				if(!marcas[i]&& total<menor) {
					menor = caminoMasCorto(v.getTarget(),destino,c,caminoActual,total,menor,marcas);
				}
			}
		}
		marcas[origen.getPosition()]=false;
		caminoActual.remove(caminoActual.size()-1);//tengo q volver sobre mis pasos para seguir recorriendo otros caminos
		return menor;	
	}
	///////44444444444444444444444
	public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
		List<String> camini=new LinkedList<>();
		Vertex<String> origen = this.mapaCiudades.search(ciudad1);
		Vertex<String> destino = this.mapaCiudades.search(ciudad2);
		if(origen!=null && destino!=null&&tanqueAuto>0) {//verifico el tanque aca x si ya no tiene nafta
			caminoSinCargarCombustible(origen,destino,new boolean[this.mapaCiudades.getSize()],tanqueAuto,camini);
		}
		return camini;
	}
	private boolean caminoSinCargarCombustible(Vertex<String> origen, Vertex<String> destino, boolean[] marcas, int tanqueAuto, List<String> camini) {
		boolean encontre = false;
		marcas[origen.getPosition()] = true;
		camini.add(origen.getData());
		if(origen==destino) {
			encontre=true;
		}
		else {
			List<Edge<String>> ady = mapaCiudades.getEdges(origen);
			Iterator<Edge<String>> it = ady.iterator();
			while(it.hasNext()&&!encontre) {
				Edge<String> v = it.next();
				int i= v.getTarget().getPosition();
				
				if(!marcas[i]&&tanqueAuto-v.getWeight()>=0) {//chqqueo si en la proxima iteracion va a ser menor el combustible i si es menor a 0 ni entro asumo puede llegar con 0 y para no visitar 2 veces la misma ciudad veo q nbo este visitada
					encontre = caminoSinCargarCombustible(v.getTarget(), destino, marcas,tanqueAuto-v.getWeight(),camini);
				}
			}
		}
		if(!encontre) {
			camini.remove(camini.size()-1);//backtracking
		}
		
		marcas[origen.getPosition()]=false;//para seguir recorriendo y pudiendo pasar por ese mismo vertice para otro recorrido
		return encontre;
	}
	///////555555555555555555555555555555
	public List<String> caminoConMenorCargaCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
		List<String> camini = new LinkedList<>();
		Vertex<String>origen = this.mapaCiudades.search(ciudad1);
		Vertex<String>destino = this.mapaCiudades.search(ciudad2);
		if(origen!=null&&destino!=null && tanqueAuto>0) {
			caminoConMenorCargaCombustible(origen,destino,camini,new LinkedList<String>(),tanqueAuto,tanqueAuto,0,Integer.MAX_VALUE,new boolean[this.mapaCiudades.getSize()]);
		}
		return camini;
	}
	private int caminoConMenorCargaCombustible(Vertex<String> origen,Vertex<String> destino,List<String>caminiMin,List<String>caminiActual,int tanqueActual,int tanque,int cargas, int cargasMin,boolean []marcas) {
		marcas[origen.getPosition()]=true;
		caminiActual.add(origen.getData());
		if(origen==destino && cargas<cargasMin) {
			caminiMin.removeAll(caminiMin);
			caminiMin.addAll(caminiActual);
			cargasMin=cargas;
		}
		else {
			
			List<Edge<String>>ady = this.mapaCiudades.getEdges(origen);
			Iterator<Edge<String>> it = ady.iterator();
			while(it.hasNext() && cargas<cargasMin) {
				Edge<String> v = it.next();
				int i = v.getTarget().getPosition();
				if(!marcas[i]) {
					if(tanqueActual-v.getWeight()>=0) {//JE soy unica y diferente (nadie lo piensa asi)
						cargasMin=caminoConMenorCargaCombustible(v.getTarget(),destino,caminiMin, caminiActual, tanqueActual-v.getWeight(),tanque,cargas,cargasMin,marcas);
					}
					else {
						if(tanque-v.getWeight()>=0) {
							cargasMin=caminoConMenorCargaCombustible(v.getTarget(),destino,caminiMin, caminiActual, tanque-v.getWeight(),tanque,cargas+1,cargasMin,marcas);
						}
					}
				}
				
			}
		}
		marcas[origen.getPosition()]=false;//para seguir recorriendo otro camino pasando x aca
		caminiActual.remove(caminiActual.size()-1);//backtracking
		return cargasMin;
	}
	public static void main(String[] args) {//no tuve ganas de escribirlo yo realmente
        Graph<String> mapaCiudades = new AdjListGraph<String>();
        Vertex<String> v1 = mapaCiudades.createVertex("La Plata"); //Casa Caperucita
        Vertex<String> v2 = mapaCiudades.createVertex("Ensenada"); //Claro 3
        Vertex<String> v3 = mapaCiudades.createVertex("Berisso"); //Claro 1
        Vertex<String> v4 = mapaCiudades.createVertex("Berazategui"); //Claro 2
        Vertex<String> v5 = mapaCiudades.createVertex("Florencio Varela"); //Claro 5
        Vertex<String> v6 = mapaCiudades.createVertex("Presidente Peron"); //Claro 4
        Vertex<String> v7 = mapaCiudades.createVertex("San Vicente"); //Casa Abuelita
        mapaCiudades.connect(v1, v2, 4);
        mapaCiudades.connect(v2, v1, 4);
        mapaCiudades.connect(v1, v3, 3);
        mapaCiudades.connect(v3, v1, 3);
        mapaCiudades.connect(v1, v4, 4);
        mapaCiudades.connect(v4, v1, 4);
        mapaCiudades.connect(v2, v5, 15);
        mapaCiudades.connect(v5, v2, 15);
        mapaCiudades.connect(v3, v5, 3);
        mapaCiudades.connect(v5, v3, 3);
        mapaCiudades.connect(v4, v3, 4);
        mapaCiudades.connect(v3, v4, 4);
        mapaCiudades.connect(v4, v5, 11);
        mapaCiudades.connect(v5, v4, 11);
        mapaCiudades.connect(v4, v6, 10);
        mapaCiudades.connect(v6, v4, 10);
        mapaCiudades.connect(v4, v3, 4);
        mapaCiudades.connect(v3, v4, 4);
        mapaCiudades.connect(v5, v7, 4);
        mapaCiudades.connect(v7, v5, 4);
        mapaCiudades.connect(v6, v7, 9);
        mapaCiudades.connect(v7, v6, 9);
        
        Mapa mapa = new Mapa(mapaCiudades);
        
        System.out.print("LISTA DEVOLVER CAMINO: ");
        System.out.print(mapa.devolverCamino("La Plata", "San Vicente"));
        
        System.out.println("");
        
        System.out.print("LISTA DEVOLVER CAMINO EXCEPTUANDO LUGARES:");
        List<String> restringidos = new LinkedList<String>();
        restringidos.add("Berisso");
        System.out.print(mapa.devolverCaminoExceptuando("La Plata", "San Vicente", restringidos));
        
        System.out.println("");
        
        System.out.print("LISTA CAMINO MAS CORTO (SEGUN DISTANCIA): ");
        System.out.print(mapa.caminoMasCorto("La Plata", "San Vicente"));
        
        System.out.println("");
        
        System.out.print("LISTA CAMINO SIN CARGAR COMBUSTIBLE: ");
        System.out.print(mapa.caminoSinCargarCombustible("La Plata", "San Vicente", 30));
        
        System.out.println("");
        
        System.out.print("LISTA CAMINO CON MENOR CARGAS DE COMBUSTIBLE: ");
        System.out.print(mapa.caminoConMenorCargaCombustible("La Plata", "San Vicente", 10));
        
        System.out.println("");
    }
}
