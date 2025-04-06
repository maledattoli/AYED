package Practica1.ejercicio8;



public class CircularQueue<T> extends Queue<T>{

	public T shift() {
		T primero = dequeue();
		enqueue(primero);
		return primero;
		
	}
	
}
