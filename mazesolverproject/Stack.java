/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazesolverproject;

/**
 *
 * @author acely
 */
public class Stack<T> {
    private Node<T> top;
    
    public Stack() {
        top = null;
    }
    
    public boolean isEmpty() {
        if (top==null)
            return true;
        return false;
    }
    
    public void push(T n) {
        Node<T> newNode = new Node<>(n);
        newNode.next = top;
        top = newNode;        
    }
    
    public T pop() {
        Node<T> t = top;
        if(!isEmpty())
            top = top.next;
        return t.data;
    }
      
      public T getTop() {
        if (!isEmpty()) {
            return top.data;
        } else {
           return null;
        }
    }

    private static class Node<T>{
        Node<T> next = null;
        T data;

        Node(T data){
            this.data = data;
        }

    }
}
