/**
 * Class to represent a queue using an array to store the queued items.
 * Follows a FIFO (First In First Out) order where new items are added to the
 * back and items are removed from the front.
 */
 class Queue {
    constructor() {
      this.items = [];
    }
  
    /**
     * TODO: implement this method
     * Adds a new given item to the back of this queue.
     * - Time: O(1) constant.
     * - Space: O(1) constant.
     * @param {any} item The new item to add to the back.
     * @returns {number} The new size of this queue.
     */
    enqueue(item) {}
  
    /**
     * TODO: implement this method
     * Removes and returns the first item of this queue.
     * - Time: O(n) linear, due to having to shift all the remaining items to
     *    the left after removing first elem.
     * - Space: O(1) constant.
     * @returns {any} The first item or undefined if empty.
     */
    dequeue() {}
  
    /**
     * TODO: implement this method
     * Retrieves the first item without removing it.
     * - Time: O(1) constant.
     * - Space: O(1) constant.
     * @returns {any} The first item or undefined if empty.
     */
    front() {}
  
    /**
     * TODO: implement this method
     * Returns whether or not this queue is empty.
     * - Time: O(1) constant.
     * - Space: O(1) constant.
     * @returns {boolean}
     */
    isEmpty() {}
  
    /**
     * TODO: implement this method
     * Retrieves the size of this queue.
     * - Time: O(1) constant.
     * - Space: O(1) constant.
     * @returns {number} The length.
     */
    size() {}
    
  }
  
  
  class QueueNode {
    constructor(data) {
      this.data = data;
      this.next = null;
    }
  }
  
  class LinkedListQueue {
    constructor() {
      // In order to maintain an O(1) enqueue time complexity like .push with an array
      // We add a tail to our linked list so we can go directly to the last node
      this.head = null;
      this.tail = null;
      this.size = 0;
    }
  
    /**
     * TODO: implement this method
     * Adds a new given item to the back of this queue.
     * - Time: O(1) constant.
     * - Space: O(1) constant.
     * @param {any} item The new item to add to the back.
     * @returns {number} The new size of this queue.
     */
     enqueue(item) {}
  
     /**
      * TODO: implement this method
      * Notice how this Time Complexity of this algo is O(1) not O(n) like the array version
      * Removes and returns the first item of this queue.
      * - Time: O(1) constant.
     * - Space: O(1) constant.
     * @returns {any} The removed item.
     */
     dequeue() {}
   
     /**
      * TODO: implement this method
      * Retrieves the first item without removing it.
      * - Time: O(1) constant.
      * - Space: O(1) constant.
      * @returns {any} The first item or undefined if empty.
      */
     front() {}
   
     /**
      * TODO: implement this method
      * Returns whether or not this queue is empty.
      * - Time: O(1) constant.
      * - Space: O(1) constant.
      * @returns {boolean}
      */
     isEmpty() {}
   
     /**
      * TODO: implement this method
      * Retrieves the size of this queue.
      * - Time: O(1) constant.
      * - Space: O(1) constant.
      * @returns {number} The length.
      */
     size() {}
  
  }