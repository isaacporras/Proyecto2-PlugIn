package Listas;

import Listas.Nodo_product_abstract;
import Listas.Nodo_product_concrete;
/**
 * Esta clase lo que hace es implementar la los abstact factory y crear un objeto concreto del nodo
 * @author IsaacPorras
 *
 */
public class ConcreteFactory_Nodo {
	public Nodo_product_concrete crear_nodo(Object nombre, Lista dato, String tipo) {
	Nodo_product_concrete nodo = new Nodo_product_concrete(nombre, dato, tipo);
	
	return nodo;
	}
}