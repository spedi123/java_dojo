/**
 * Class to represent a stack using an array to store the stacked items.
 * Follows a LIFO (Last In First Out) order where new items are stacked on
 * top (back of array) and removed items are removed from the top / back.
 */
 class Stack {
  /**
   * The constructor is executed when instantiating a new Stack() to construct
   * a new instance.
   * @returns {Stack} This new Stack instance is returned without having to
   *    explicitly write 'return' (implicit return).
   */
  constructor() {
    this.items = [];
  }

  /**
   * TODO: implement this method
   * Adds a new given item to the top / back of this stack.
   * - Time: O(1) constant.
   * - Space: O(1) constant.
   * @param {any} item The new item to be added to the top / back.
   * @returns {number} The new length of this stack.
   */
  push(item) {
    this.items.push(item);
    return this.size();
  }

  /**
   * TODO: implement this method
   * Removes the top / last item from this stack.
   * - Time: O(1) constant.
   * - Space: O(1) constant.
   * @returns {any} The removed item or undefined if this stack was empty.
   */
  pop() {
    return this.items.pop();
  }

  /**
   * TODO: implement this method
   * Retrieves the top / last item from this stack without removing it.
   * - Time: O(1) constant.
   * - Space: O(1) constant.
   * @returns {any} The top / last item of this stack.
   */
  peek() {
    return this.items[this.size()-1];
  }

  /**
   * TODO: implement this method
   * Returns whether or not this stack is empty.
   * - Time: O(1) constant.
   * - Space: O(1) constant.
   * @returns {boolean}
   */
  isEmpty() {
    if(this.size() == 0){
      return true;
    }
    return false;
  }

  /**
   * TODO: implement this method
   * Returns the size of this stack.
   * - Time: O(1) constant.
   * - Space: O(1) constant.
   * @returns {number} The length.
   */
  size() {
    return this.items.length;
  }
}

class StackNode {
  constructor(data) {
    this.data = data;
    this.next = null;
  }
}

class LinkedListStack {
  constructor() {
    this.head = null;
  }

  /**
   * TODO: implement this method
   * Adds a new given item to the top / back of this stack.
   * - Time: O(1) constant.
   * - Space: O(1) constant.
   * @param {any} item The new item to be added to the top / back.
   * @returns {number} The new length of this stack.
   */
   push(item) {
    const newNode = new StackNode(item);
    newNode.next = this.head;
    this.head = newNode;
    return this.size();
   }

   /**
    * TODO: implement this method
    * Removes the top / last item from this stack.
    * - Time: O(1) constant.
    * - Space: O(1) constant.
    * @returns {any} The removed item or undefined if this stack was empty.
    */
   pop() {
    if(this.isEmpty()){
      return undefined;
    }
    const popNode = this.head.data;
    this.head = this.head.next;
    return popNode;
   }
 
   /**
    * TODO: implement this method
    * Retrieves the top / last item from this stack without removing it.
    * - Time: O(1) constant.
    * - Space: O(1) constant.
    * @returns {any} The top / last item of this stack.
    */
   peek() {
    return this.head.data;
   }
 
   /**
    * TODO: implement this method
    * Returns whether or not this stack is empty.
    * - Time: O(1) constant.
    * - Space: O(1) constant.
    * @returns {boolean}
    */
   isEmpty() {
    if(this.head == null){
      return true;
    }
    return false;
   }
 
   /**
    * TODO: implement this method
    * Returns the size of this stack.
    * - Time: O(1) constant.
    * - Space: O(1) constant.
    * @returns {number} The length.
    */
   size() {
    let counter = 0;
    let runner = this.head;
    while(runner != null){
      runner = runner.next;
      counter++;
    }
    return counter;
   }
}


let firstStack = new LinkedListStack();
console.log(firstStack.isEmpty());
console.log(firstStack.pop());
console.log(firstStack.push(5));
console.log(firstStack.push(0));
console.log(firstStack.push(-3));
console.log(firstStack.push(10));
console.log(firstStack.pop());
console.log(firstStack.pop());
console.log(firstStack.size());
console.log(firstStack.peek());
console.log(firstStack.isEmpty());