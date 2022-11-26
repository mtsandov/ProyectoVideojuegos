/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;


import java.util.Objects;

/**
 *
 * @author Melanie
 * @param <E>
 */
public class CircularNode<E> {
    
    private E content;
    private CircularNode<E> nextNode;
    private CircularNode<E> prevNode;
    
    public CircularNode (E content) {
        this.content = content;
        this.nextNode = this;
        this.prevNode = this;
    }

    public E getContent() {
        return this.content;
    }

    public void setContent(E content) {
        this.content = content;
    }

    public CircularNode<E> getNextNode() {
        return this.nextNode;
    }
    
    public CircularNode<E> getPrevNode() {
        return this.prevNode;
    }
    
    public void setPrevNode(CircularNode<E> prevNode) {
        this.prevNode = prevNode;
    }
    
    public void setNextNode(CircularNode<E> nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CircularNode<?> other = (CircularNode<?>) obj;
        if (!Objects.equals(this.content, other.content)) {
            return false;
        }
        if (!Objects.equals(this.nextNode, other.nextNode)) {
            return false;
        }
        if (!Objects.equals(this.prevNode, other.prevNode)) {
            return false;
        }
        return true;
    }
    
    
}