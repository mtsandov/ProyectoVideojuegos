/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

import estructuras.CircularNode;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 *
 * @author Melanie
 * @param <E>
 */
public class CircularLinkedList<E> implements Iterable<E> {

    private CircularNode<E> tail;
    private int size = 0;

    public CircularLinkedList(CircularNode<E> tail, int size) {
        this.tail = tail;
    }

    public CircularLinkedList() {
        this.tail = null;
        this.size = 0;
    }

    public CircularNode<E> getLast() {
        return this.tail;
    }

    public CircularNode<E> getFirst() {
        return this.tail.getNextNode();
    }

    public void setLast(CircularNode<E> last) {
        tail.setContent(last.getContent());
    }

    public void setFirst(CircularNode<E> first) {
        tail.getNextNode().setContent(first.getContent());
    }

    public void desplazarDer() {
        tail = tail.getPrevNode();
    }

    public void desplazarIzq() {
        tail = tail.getNextNode();
    }

    public boolean isEmpty() {
        return (this.size() == 0);
    }

    public boolean addFirst(E e) {
        if (e != null) {
            if (size() == 0) {
                tail = new CircularNode(e);
            } else {
                CircularNode<E> newFirst = new CircularNode(e);
                newFirst.setNextNode(tail.getNextNode());
                newFirst.setPrevNode(tail);
                tail.getNextNode().setPrevNode(newFirst);
                tail.setNextNode(newFirst);
            }
            return true;
        }
        return false;
    }

    
    public boolean addLast(E e) {
        if (addFirst(e)) {
            tail = tail.getNextNode();
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        int c = 0; // Contador para el size
        if (tail != null) {
            c = 1;
        } else {
            return c;
        }

        CircularNode<E> cursor = tail.getNextNode();
        while (cursor != tail) {
            cursor = cursor.getNextNode();
            c++;
        }
        return c;
    }

    public int indexOf(E e) {
        if (e == null || isEmpty()) {
            return -1;
        }

        if (e == tail.getContent()) {
            return size() - 1;
        }

        CircularNode<E> cursor = tail.getNextNode();
        int index = 0;
        while (cursor != tail) {
            if (cursor.getContent() == e) {
                return index;
            }
            index++;
            cursor = cursor.getNextNode();
        }

        return -1;
    }

    public boolean contains(E e) {
        if (isEmpty()) {
            return false;
        }
        CircularNode<E> cursor = tail.getNextNode();
        if (e.equals(cursor.getContent())) {
            return true;
        }
        while (cursor != tail) {
            cursor = cursor.getNextNode();
            if (e.equals(cursor.getContent())) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        this.tail = null;
        this.size = 0;
    }

    private E removethelast() throws NullPointerException {
        E tmp = tail.getContent();
        tail = null;
        return tmp;
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        if (size() == 1) {
            return removethelast();
        }
        CircularNode<E> head = tail.getNextNode();
        tail.setNextNode(head.getNextNode());
        head.getNextNode().setPrevNode(tail);

        return head.getContent();
    }

    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        if (size() == 1) {
            return removethelast();
        }
        CircularNode<E> currentLast = tail;
        tail.getPrevNode().setNextNode(tail.getNextNode());
        tail.getNextNode().setPrevNode(tail.getPrevNode());

        tail = tail.getPrevNode();
        return currentLast.getContent();
    }

    public boolean add(int index, E element) {
        if (element == null) {
            return false;
        }
        if (index > size() || index < 0) {
            return false;
        }
        if (index == 0) {
            return addFirst(element);
        }
        if (index == size() - 1) {
            return addLast(element);
        }
        CircularNode<E> new_node = new CircularNode(element);
        CircularNode<E> current = tail.getNextNode();
        for (int i = 0; i < index; i++) {
            current = current.getNextNode();
        }
        new_node.setPrevNode(current.getPrevNode());
        current.getPrevNode().setNextNode(new_node);
        new_node.setNextNode(current);
        current.setPrevNode(new_node);
        return true;
    }

    public E remove(int index) {
        System.out.println("index en remove" + index);
        if (isEmpty() || index > size() || index < -1) {
            return null;
        }
        if (index == 0) {
            return removeFirst();
        }
        if (index == size() - 1) {
            return removeLast();
        }

        CircularNode<E> current = tail.getNextNode();
        for (int i = 0; i < index; i++) {
            current = current.getNextNode();
        }
        current.getPrevNode().setNextNode(current.getNextNode());
        current.getNextNode().setPrevNode(current.getPrevNode());

        return current.getContent();
    }
    
    public E removerNodo(CircularNode<E> current) {
        System.out.println("remove" + current.getContent());
        if (isEmpty()) {
            return null;
        }
        if (current == getFirst()) {
            return removeFirst();
        }
        if (current ==getLast()) {
            return removeLast();
        }
        current.getPrevNode().setNextNode(current.getNextNode());
        current.getNextNode().setPrevNode(current.getPrevNode());

        return current.getContent();
    }
    public E get(int index) {
        if (isEmpty() || index > size() - 1 || index < 0) {
            return null;
        }
        if (index == 0) {
            return getFirst().getContent();
        }
        if (index == -1) {
            return getLast().getContent();
        }

        CircularNode<E> cursor = tail.getNextNode();
        for (int i = 0; i < index; i++) {
            cursor = cursor.getNextNode();
        }

        return cursor.getContent();
    }
    
    public CircularNode<E> getNode(int index){
        if (isEmpty() || index > size() - 1 || index < 0) {
            return null;
        }
        if (index == 0) {
            return getFirst();
        }
        if (index == -1) {
            return getLast();
        }

        CircularNode<E> cursor = tail.getNextNode();
        for (int i = 0; i < index; i++) {
            cursor = cursor.getNextNode();
        }

        return cursor;
    }
    public E set(int index, E element) {
        if (isEmpty() || index > size() || index < 0) {
            return null;
        }
        CircularNode<E> current = tail.getNextNode();
        for (int i = 0; i < index; i++) {
            current = current.getNextNode();
        }
        E tmp = current.getContent();
        current.setContent(element);
        return tmp;
    }

    @Override
    public String toString() {
        String mensaje = "";
        if (isEmpty()) {
            return mensaje;
        }
        CircularNode<E> cursor = tail.getNextNode();
        if (cursor.getContent().toString() == null) {
            return mensaje;
        }

        String result = cursor.getContent().toString() + " ";

        while (cursor != tail) {
            cursor = cursor.getNextNode();
            result += cursor.getContent().toString() + " ";
        }
        return result;
    }

    
    
    @Override
    public Iterator<E> iterator() {
        return new Iteradorxd<E>(tail.getNextNode());
    }
    
    class Iteradorxd<E> implements Iterator{
        int count=0;
        CircularNode<E> i;
        
        public Iteradorxd(CircularNode<E> n){
            i=n;
        }
        
        @Override
        public boolean hasNext() {
            if(i.getContent()!=null && size==count){
                i.getNextNode();
                count++;
                return true;
            }return false;
        }

        @Override
        public E next() {
                E content = i.getContent();
                i = i.getNextNode();
                return content;
        }
        
    }
    
    
    /*
    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator() {
            CircularNode<E> cursor = tail.getNextNode();

            @Override
            public boolean hasNext() {
                return (cursor != null);
            }

            @Override
            public E next() {
                if (cursor == tail) {
                    cursor = null;
                    return tail.getContent();
                }
                E content = cursor.getContent();
                cursor = cursor.getNextNode();
                return content;
            }
        };
        return it;
    }*/

    

    

}