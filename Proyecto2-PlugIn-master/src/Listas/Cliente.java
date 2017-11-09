package Listas;

import Listas.Abstract_Factory;;
/**
 * Esta clase utiliza los metodos de los Abstract Factory para crear los nodos 
 * @author IsaacPorras
 *
 */
public class Cliente {
	/**
	 * Crea el nodo
	 * @param factory_widget abstract factory
	 * @param statement stateent
	 * @param dato dato del nodo
	 * @return Nodo retorna el nodo
	 */
	public Nodo_product_abstract crear_nodo (Abstract_Factory factory_widget, Object statement, Object dato){
	    Nodo_product_abstract Nodo = factory_widget.crear_nodo();
	    return Nodo;
	  }

}