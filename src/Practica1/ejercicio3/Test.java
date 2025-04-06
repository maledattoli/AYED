package Practica1.ejercicio3;

public class Test {
	public static void main(String[] args) {
		Estudiante estudiantes[] = new Estudiante[2];
		Profesor profesores[] = new Profesor[3];
		estudiantes[0]= new Estudiante("e1","yo","yo@", 1,"22");
		estudiantes[1]= new Estudiante("e2","y1o","yo@1", 3,"222");
		
		profesores[1]= new Profesor("p2","y1o2","y2o@1", "3","2222"); 
		profesores[2]= new Profesor("p3","y1o3","yo@13", "3","2322"); 
		profesores[0]= new Profesor("p1","y11o","yo@12", "4","3222"); 
		
		for (int i =0;i<2;i++) {
			System.out.println(estudiantes[i].tusDatos());
		}
		for (int i =0;i<3;i++) {
			System.out.println(profesores[i].tusDatos());
		}
	}
}
