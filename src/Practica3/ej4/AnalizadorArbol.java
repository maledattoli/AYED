package Practica3.ej4;



import Practica1.ejercicio8.Queue;
import Practica3.ej1yej3yej5.GeneralTree;

public class AnalizadorArbol {

	public double devolverMaximoPromedio(GeneralTree<AreaEmpresa>arbol) {
		if(arbol.isEmpty())
			return 0;
		
		GeneralTree<AreaEmpresa>aAux;
		Queue<GeneralTree<AreaEmpresa>> q = new Queue<>();
		
		double cantH=0;
		double acumulador=0;
		double max = -1;
		double promedio=0;
		
		q.enqueue(arbol);
		q.enqueue(null);//marcador para indicar el nivel actual
		
		while(!q.isEmpty()) {
			aAux= q.dequeue();
			
			if(aAux!=null) {
				cantH++;
				acumulador+= aAux.getData().getTiempo();
	
				for(GeneralTree<AreaEmpresa> child:aAux.getChildren()) {
					q.enqueue(child);
				}
			}
			else {
				if(cantH>0){//terminamos un nivel ((es null)) puede ser el final o q quede mas
					promedio=acumulador/cantH;
				}
				if(promedio>max) {
					max=promedio;	
				}
				
				if(!q.isEmpty()) { //paso al siguiente nivel si queda info en la cola
					q.enqueue(null);
					acumulador=0;
					cantH=0;
					promedio=0;
				}
			}
		}
		return max;		
	}
	
	public static void main(String[] args) {
		// Nivel 2
		GeneralTree<AreaEmpresa> ventas = new GeneralTree<>(new AreaEmpresa("titi", 8));
		GeneralTree<AreaEmpresa> marketing = new GeneralTree<>(new AreaEmpresa("pipi", 12));

		// Nivel 1
		GeneralTree<AreaEmpresa> rrhh = new GeneralTree<>(new AreaEmpresa("lulu", 12));
		GeneralTree<AreaEmpresa> comercial = new GeneralTree<>(new AreaEmpresa("lele", 18));
		GeneralTree<AreaEmpresa> it = new GeneralTree<>(new AreaEmpresa("Io", 18));
		comercial.addChild(ventas);
		comercial.addChild(marketing);

		// Nivel 0 (raíz)
		GeneralTree<AreaEmpresa> gerencia = new GeneralTree<>(new AreaEmpresa("mimi", 14));
		gerencia.addChild(rrhh);
		gerencia.addChild(comercial);
		gerencia.addChild(it);

		// Analizador
		AnalizadorArbol analizador = new AnalizadorArbol();
		double maxProm = analizador.devolverMaximoPromedio(gerencia);
		System.out.println("El mayor promedio por nivel es: " + maxProm); // Debería imprimir 16.0

	}//deberia dar 16
	

}
