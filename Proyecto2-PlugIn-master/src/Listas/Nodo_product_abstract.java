package Listas;


/**
 * Esta clase crea la interfaz oara poder utilizar la lista
 * @author IsaacPorras
 *
 */
public interface Nodo_product_abstract{
	
	  public void setSiguiente(Nodo_product_concrete siguiente);
	  public void setNombre(Object padre_nuevo);
	  public void setDato(Lista dato_nuevo);
	  public Lista getDato();
	  public Nodo_product_concrete getSiguiente();
	  public Object getNombre();
	}



