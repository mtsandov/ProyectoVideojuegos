/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

import java.io.Serializable;
import java.util.Iterator;
import java.util.function.Consumer;



/**
 *
 * @author MelnieSandoval
 * @param <E>
 */
public class ArrayListTDA<E> implements Iterable<E> , Serializable {
    
    private int ultimo, capacidad;
    private E arreglo[];
    
       public ArrayListTDA(int cap){
        this.capacidad = cap;
        arreglo = (E[]) (new Object[cap]);
        ultimo = -1;
    }

    public ArrayListTDA() {
        arreglo= (E[]) new Object[2];
        capacidad=2;
        ultimo=-1;
       
        
    }
  
    private boolean estaVacio(){
        return ultimo==-1;
    }
 

    private boolean estaLleno(){
        return (ultimo+1)==capacidad;
    }
    
    
    
    public boolean add(E elemento){
        if(this.estaVacio()){
            arreglo[0]=elemento;
            ultimo+=1;
            return true;
        }else if(estaLleno()){
            crecerArreglo();
            arreglo[ultimo+1]= elemento;
            ultimo+=1;
            return true;
        }else if(!estaLleno()){
            arreglo[ultimo+1]=elemento;
            ultimo+=1;
            return true;
        }
        return false;
       

    }
    //add(int indice, E e) // añade el elemento en la posición indicada por el indice
    public boolean add(int indice, E e){
        if(indice>ultimo+1){
            System.out.println("ERROR EL INDICE EXCEDE LA CANTIDAD DE ELEMENTOS");
        }else if(this.estaVacio()){
            System.out.println("NO EXISTE ELEMENTOS DONDE INSERTAR");
        }else if(estaLleno()){
            crecerArreglo();
        }
        E[] copia= (E[]) new Object[capacidad];
        for(int i=0; i<ultimo+1; i++){
            if(i==indice){
                copia[i]=e;
                i++;
            }
            copia[i]=this.arreglo[i];
        }

        this.arreglo=copia;
        ultimo++;
        return true;
  
    }
    
    
    
    
       public void crecerArreglo(){
      capacidad += capacidad/2;
	E[] arr = (E[]) (new Object[capacidad]);
	System.arraycopy(arreglo, 0, arr, 0, ultimo+1);
	arreglo=arr;
    }
    public int size(){
        return ultimo;
    }
    
     public E get(int indice) {
        if(indice>ultimo){
            System.out.println("EL INDICE EXCEDE LOS ELEMENTOS");
            return null;
        }
        return arreglo[indice];
    }
     //remove(int indice) // remueve el elemento que se encuentra en la posición indicada por el indice
     public boolean remove(int index) {
        if(index>ultimo+1){
            System.out.println("ERROR EL INDICE EXCEDE LA CANTIDAD DE ELEMENTOS");
            return false;
        }else if(estaVacio()){
            System.out.println("NO EXISTE ELEMENTOS QUE REMOVER");
            return false;
        }
        arreglo[index]=null;
        for(int i= index; i< ultimo; i++){
            arreglo[index]=arreglo[i+1];
        }
        ultimo--;
        return  true;
      
    }

    @Override
    public Iterator<E> iterator() {
                Iterator<E> it = new Iterator<E>(){
            
            int cursor = 0;
            
            @Override
            public boolean hasNext(){
                return cursor<capacidad;
            }
            
            @Override
            public E next(){
                return arreglo[cursor++];
            }
            
        };
        return it;
    }
    
    public void recorrer(){
        for(int i = 0 ; i < capacidad; i++){
            System.out.println(arreglo[i]);
        }
    }
   
}
