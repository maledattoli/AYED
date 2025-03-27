package ej3;

public class Test {
	public static void main(String[] args) {
		Estudiante estudiantes[] = new Estudiante[2];
		Profesor profesores[] = new Profesor[3];
		estudiantes[0]= new Estudiante("yo","yo","yo@", 1,"22");
		estudiantes[1]= new Estudiante("yo1","y1o","yo@1", 3,"222");
		
		profesores[1]= new Profesor("yo12","y1o2","y2o@1", "3","2222"); 
		profesores[2]= new Profesor("yo13","y1o3","yo@13", "3","2322"); 
		profesores[0]= new Profesor("yo11","y11o","yo@12", "4","3222"); 
		
		for (int i =0;i<3;i++) {
			System.out.println(estudiantes[i].tusDatos());
		}
		for (int i =0;i<2;i++) {
			System.out.println(profesores[i].tusDatos());
		}
	}
}
