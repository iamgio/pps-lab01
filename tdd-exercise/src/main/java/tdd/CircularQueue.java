package tdd;

/**
 *  Task 3 - TDD for Circular Queue
 *  A simple CircularQueue that stores integers with a **fixed** capacity.
 *  When full, new elements overwrite the oldest ones.
 *  
 *  When removing elements, the oldest ones are removed first.
 *  Therefore, giving [4, 5, 3], the first element to be removed is 4, then 5, and finally 3.
 *  
 *  For the exercise: 
 *   - Think about the test cases you need to write.
 *   - Introduce methods in the interface in order to make the tests pass.
 *   - Refactor
 */
public interface CircularQueue<T> {

    /**
     * @return whether the queue has no elements
     */
    boolean isEmpty();

    /**
     * @return the number of elements present in the queue, in range 0 to max size.
     */
    int size();

    /**
     * Adds a value to the end of the queue.
     * If the queue is filled to its max size, the oldest value is replaced.
     * @param value value to enqueue
     */
    void enqueue(T value);

    /**
     * Removes the oldest value from the queue.
     * @return the oldest value added to the queue
     */
    T dequeue();
}