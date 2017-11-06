package Listas;


/**
 * define concretamente los metodos del Nodo_product_abstract para poder instanciarlos
 * @author IsaacPorras
 *
 */
public class Nodo_product_concrete implements Nodo_product_abstract{
	Object statement;
	Lista dato;
	Nodo_product_concrete siguiente;
	String tipo;
	/**
	 * 	define los datos principales del nodo
	 * @param nom nombre del nodo
	 * @param dato2 el dato del nodo
	 * @param tip el tipo del nodo
	 */
	public Nodo_product_concrete(Object nom, Lista dato2, String tip) {
		statement = nom;
		dato = dato2;
		tipo = tip;
		
	}
	/**
	 * Este metodo le da el nombre a un nodo
	 */
	@Override
	public void setNombre(Object nom) {
		statement = nom;
		
	}
	/**
	 * le da el dato al nodo
	 */
	@Override
	public void setDato(Lista dato_nuevo) {
		dato = dato_nuevo;
		
	}
	/**
	 * le da el siguiente al nodo
	 */
	@Override
	public void setSiguiente(Nodo_product_concrete siguiente) {
        this.siguiente = siguiente;
    }
	/**
	 * da la lista que contiene un nodo
	 */
	@Override
	public Lista getDato() {
		// TODO Auto-generated method stub
		return this.dato;
	}
	/**
	 * le da el siguiente nodo
	 */
	@Override
	public Nodo_product_concrete getSiguiente() {
		// TODO Auto-generated method stub
		return this.siguiente;
	}
	/**
	 * le da el nombre que contiene el nodo
	 */
	@Override
	public Object getNombre() {
		// TODO Auto-generated method stub
		return statement;
	}
	
}
