public class ArrayStack implements Stack   {
             int top;         // current top of stack
             Object [] stack;   // element array

             /* create a stack with the given initial capacity   */
             public ArrayStack(int initialCapacity) {
                  if (initialCapacity < 1)
                  throw new IllegalArgumentException
                                        ("initialCapacity must be >= 1");
                  stack = new Object [initialCapacity] ;
                  top = -1;
     	       }

			   /** create a stack with initial capacity 10  **/
       public ArrayStack() {
	     this(10);
       }
       /** return true if stack is empty  */
       public boolean isEmpty( ) {
          return top == -1;
       }
        /** return top element of stack
           * throw EmptyStackException when the stack is empty */
        public Object peek() {
               if (isEmpty() )
                     throw new EmptyStackException();
               return stack[top];
        }


	/** add theElement to the top of the stack    */
 	public void push(Object theElement) {
 		 // increase array size if necessary
 		 if (top == stack.length - 1)	ensureCapacity();

            // put theElement at the top of the stack
            stack[++top] = theElement;
      }


	/** remove top element of stack and return it
   * throw EmptyStackException when the stack is empty */
     public Object pop() {
            if  (isEmpty())
                  throw new EmptyStackException();
            Object topElement = stack[top];
             stack[top--] = null;   // enable garbage collection
             return topElement;
      }

	  private void ensureCapacity()  {
      Object[] larger = new Object[stack.length*2];

      for (int index=0; index < stack.length; index++)
         larger[index] = stack[index];

      stack = larger;
   }

   public String toString() {
    if (isEmpty())
      return "<empty stack>";
    String result = "<stack :";
    for (int i = top; i >= 0; i--)
      result += stack[i] + " ";
    return result + ">";
  } // end toString
}
