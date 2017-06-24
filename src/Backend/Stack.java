/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

/**
 *
 * @author Phillz Mike
 */
public class Stack {
    protected Card[] element;
    private int size;
    /**
     * Creates a Stack object
     */
    public Stack(){
        this(0);
    }
    /**
     *Create a new Stack with Elements in another 
     * @param s The other STack to copy
     */
    public Stack(Stack s){
         this(0);
        for(Card i:s.element){
            this.push(i);
        }
    }
    private Stack(int size){
        this.size = size;
        element = new Card[size];
    }
    
    /**
     * 
     * @return true if stack is empty, false otherwise 
     */
    public boolean isEmpty(){
        return size == 0;
    }
    
    /**
     * 
     * @return The Card at top of stack without removing it 
     */
    public Card peek(){
       return element[size-1];
        
    }
    
    /**
     * 
     * @param x Card to be pushed to stack
     */
    public void push(Card x){
        if(size >= element.length){
            size++;
            Card[] newElement = new Card[size];
            System.arraycopy(element,0, newElement, 0, element.length);
            newElement[size-1] = x;
            element = newElement;
        }else{
            element[size++] = x;
        }
    }
    
    /**
     * 
     * @return Card at top of stack and remove it 
     */
    public Card pop(){
        Card x = element[size-1];
        size--;
        Card[] newElement = new Card[size];
        System.arraycopy(element,0, newElement, 0, element.length-1);
        element = newElement;
        return x; 
    }
    
    /**
     * 
     * @return size of stack 
     */
    public int size(){
        return size;
    }
}
