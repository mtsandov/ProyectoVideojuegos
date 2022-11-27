/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

/**
 *
 * @author sam sung
 * @param <E>
 */
public class RoundList<E> {
    
    //---------- ROUND NODE ----------------
    private class RoundNode<E> {
        private E data;
        private RoundNode<E> next,prev;
        
        RoundNode(E info){
            data = info;
            next = null;
            prev = null;
        }
    }
    //---------- END ROUND NODE ------------
    
    //ATTRIBUTES----------------------------
    private RoundNode<E> first,last;
    private int size;
    
    //CONSTRUCTOR---------------------------
    public RoundList(){
        first = null;
        last = null;
        size = 0;
    }
    private void fillNew(RoundNode<E> n){
        last = first = n;
    }
    private boolean isEmpty(){
        return size==0;
    }
    private void changeLast(RoundNode<E> n){
        n.prev = last;
        n.next = first;
        first.prev = n;
        last.next = n;
        last = n;
    }
    public boolean add (E info){
        if (info==null) return false;
        RoundNode<E> n = new RoundNode(info);
        if(isEmpty()) fillNew(n);
        else changeLast(n);
        size++;
        return true;
    }
    @Override
    public String toString(){
        if(isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        RoundNode<E> n = first;
        for(int i =0; i<size-1; i++)
        {
            sb.append(n.data);
            sb.append(", ");
            n=n.next;
        }
        sb.append(last.data);
        sb.append("]");
        return sb.toString();
    }
}
