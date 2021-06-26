class FullStackException extends RuntimeException{
    public FullStackException(String s){
        super(s);
    }
}

class EmptyStackException extends RuntimeException{
    public EmptyStackException(String s){
        super(s);
    }
}

class myStack{
    private Object[] stack;
    private int pointer = 0;
    private int capacity;
    public myStack(int capacity){
        this.capacity = capacity;
        stack = new Object[capacity];
    }

    @Override
    public String toString(){
        String s = "This Stack Capacity is = " + String.valueOf(capacity);
        return s;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof myStack)) return false;
        if(this.capacity != ((myStack)o).capacity) return false;
        if(this.pointer != ((myStack)o).pointer) return false;
        for(int i = 0; i < pointer; i++){
            if(this.stack[i].equals(((myStack)o).stack[i])) return false;
        }
        return true;
    }

    public boolean isEmpty(){
        if(this.pointer == 0) return true;
        else return false;
    }

    public boolean isFull(){
        if(this.pointer == capacity) return true;
        else return false;
    }

    public void push(Object o) throws FullStackException{
        if(this.pointer == capacity){
            throw new FullStackException("Cannot Insert Another Item, This Stack is Full");
        }
        else{
            stack[pointer++] = o;
        }
    }

    public Object pop() throws EmptyStackException{
        if(this.pointer == 0){
            throw new EmptyStackException("Sorry, This Stack is Already Empty!");
        }
        else{
            return stack[--pointer];
        }
    }

    public Object peek() throws EmptyStackException{
        if(this.pointer == 0){
            throw new EmptyStackException("Sorry, This Stack is Already Empty!");
        }
        else{
            return stack[pointer - 1];
        }
    }
}

public class Q2_18 {
    public static void main(String[] args){
        myStack stack1 = new myStack(5);
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        stack1.push(5);
        //stack1.push(6); //for Testing FullStackException thrown from push()
        System.out.println(stack1.peek()); //for Testing pointer Movement
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        //System.out.println(stack1.peek()); //for Testing EmptyStackException thrown from peek()
        //System.out.println(stack1.pop()); //for Testing EmptyStackException thrown from pop()
    }
}
