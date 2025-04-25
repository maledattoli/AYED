package Practica1.ejercicio8;

import java.util.ArrayList;
import java.util.List;

public class Queue<T> {
	protected List<T>data;
	public Queue() {
		data = new ArrayList<>();
	}
	public void enqueue(T dato) {
		data.add(dato);
	}
	public T dequeue() {
		if (isEmpty()) throw new IllegalStateException("La cola está vacía");
		else return  data.remove(0);
	}
	public boolean isEmpty() {
		return data.size() ==0;
	}
	public int size() {
		return data.size();
	}
	@Override
    public String toString() {
        return data.toString();
    }
}
