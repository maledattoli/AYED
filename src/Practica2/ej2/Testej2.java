package Practica2.ej2;

public class Testej2 {
	public static void imprimirArbol (BinaryTree<Integer> arbol) {
		System.out.println(arbol.getData());
		if (arbol.hasLeftChild()) {
			imprimirArbol(arbol.getLeftChild());
		}
		if (arbol.hasRightChild()) {
			imprimirArbol(arbol.getRightChild());
		}
	}
	public static void main(String[] args) {
		//arbol
				BinaryTree<Integer> arbolitin = new BinaryTree<Integer>();
	
				//despues lo termino
				System.out.println("hojas " + arbolitin.contarHojas() );

	}

}
