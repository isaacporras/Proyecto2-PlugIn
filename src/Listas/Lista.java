package Listas;

import Listas.Nodo_product_concrete;
import Logic.Parser;

/**
 * Esta clase agarra es la encargada de enlazar los nodos 
 * utilizando e instanciarlos utilizando una fabrica concreta
 * @author IsaacPorras
 */
public class Lista {

	public Lista lista_analizada;
	private Object dato;
	private Nodo_product_concrete fin;
	public Nodo_product_concrete inicio;
	public int largo = 0;

	   /**
	    * inicia la lista
	    */
	   public Lista() {
	        inicio =  null;
	        fin = null;
	    }
	   
	   /**
	    * ingresa un dato a la lista
	    * @param statement el statement del nodo
	    * @param dato el dato que contiene el nodo
	    * @param tipo e tipo de statement
	    */
	   
	    public void ingresarDato(Object statement, Lista dato, String tipo) {
	        if (inicio == null) {
	        		Cliente client = new Cliente();
	        		ConcreteFactory_Nodo Factory = new ConcreteFactory_Nodo();
	            inicio = Factory.crear_nodo(statement , dato, tipo);
	            fin = inicio;

	        }
	        else {
	        		Cliente client = new Cliente();
	        		ConcreteFactory_Nodo Factory = new ConcreteFactory_Nodo();
	        		Nodo_product_concrete nuevo = Factory.crear_nodo(statement,dato, tipo);
	            fin.setSiguiente(nuevo);
	            fin = nuevo;
	        }
	    }
	    
	    /**
	     * imprime los objetos que contiene la lista de clases
	     */
	    public void imprimirClass(){
	        Nodo_product_concrete actual = inicio;

	        while(actual!= null){
	        	
	            System.out.println("En la clase de nombre : " + actual.statement + actual.getDato());
	            actual = actual.getSiguiente();
	        }
	    }
	    /**
	     * imprime la lista que contiene los metodos
	     */
	    public void imprimirMetodos(){
	        Nodo_product_concrete actual = inicio;

	        while(actual!= null){
	        	
	        		largo = largo + 1;
	            System.out.println("El nombre del metodo es: " + actual.statement  + " y contiene la siguiente lista :" + actual.getDato());
	            System.out.println("Y esa misma lista contiene :");
	            actual.getDato().imprimirStatements();
	            
	            actual = actual.getSiguiente();
	        }
	    }
	    
	    /**
	     * imprime los statements que hay dentro de un metodo
	     */
	    public void imprimirStatements(){
	        Nodo_product_concrete actual = inicio;

	        while(actual!= null){
	        	
	            System.out.println("Los statements son de tipo: " + actual.tipo + " y el statement es :"+ actual.statement + " y tienen la siguiente lista : "+actual.getDato());
	            actual.getDato().imprimirAnidados();
	            actual = actual.getSiguiente();
	        }
	    }
	    /**
	     * imprime los objetos que estan dentro de los statements
	     */
	    public void imprimirAnidados() {
	    	
	    	Nodo_product_concrete actual = inicio;

	        while ( actual!= null ){
	        	
	            System.out.println("Los anidados son de tipo: "+ actual.tipo + " y el statement anidado es :" + actual.statement.toString().replace("[", "") + " y tienen la siguiente lista : "+ actual.getDato());
	            actual = actual.getSiguiente();
	        }
	        System.out.println("--------------------------------------------------------------------------------------");
	    }
	    public Nodo_product_concrete dar_inicio(Lista lista) {
	    		return lista.inicio;
	    }
	   
	   public int dar_largo() {
		   return this.largo;
	   }
	    
}
