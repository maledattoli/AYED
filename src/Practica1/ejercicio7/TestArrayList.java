package Practica1.ejercicio7;

import java.util.ArrayList;

public class TestArrayList {
	public static ArrayList<Estudiante> crearLista() {
		ArrayList<Estudiante>estudiantes = new ArrayList<>();
		Estudiante est= new Estudiante("","","",0,"");
		Estudiante est1= new Estudiante("","","",0,"");
		Estudiante est2= new Estudiante("","","",0,"");
		estudiantes.add(est2);
		estudiantes.add(est1);
		estudiantes.add(est);
		return estudiantes;
	}
	public boolean esCapicua(ArrayList<Integer> lista) {
		return lista.isEmpty() ? true : false;
	}//me re re re re re re canse sory
	
	public static void main(String[] args) {
		ArrayList<Integer> lista= new ArrayList<>();
		//a
		for(int i =1; i<20;i++) {
			lista.add(i*2);
		}
		for (int i:lista) {
			System.out.println(i);
		}
		//b Si se requiere acceso frecuente a elementos por índice → ArrayList es mejor.
		//Si se realizan muchas inserciones/eliminaciones en el medio → LinkedList es mejor.
		//c 
		ArrayList<Estudiante>est = new ArrayList<>(crearLista());
		ArrayList<Estudiante>est2 = new ArrayList<>(est);
		for (int i =0; i<est.size();i++) {
			System.out.println(est.toString());
			System.out.println(est2.toString());
		}
		Estudiante estu= new Estudiante("","","",0,"");
		if(est.contains(estu)) {
			System.out.println("no se pudo agregar porque ya existe");
		}
		else est.add(estu);
	}

}
