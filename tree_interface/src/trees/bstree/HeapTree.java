package trees.bstree;

import trees.Tree;
import java.util.ArrayList;

public class HeapTree<T extends Comparable<T>> implements Tree<T> {
    private final ArrayList<T> heap;

    public HeapTree() {
        this.heap = new ArrayList<>();
    }

    @Override
    public void insert(T value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }

    @Override
    public boolean delete(T value) {
        int index = heap.indexOf(value);
        if (index == -1) return false;

        swap(index, heap.size() - 1);
        heap.removeLast();

        if (index < heap.size()) {
            heapifyDown(index);
            heapifyUp(index);
        }
        return true;
    }

    @Override
    public boolean search(T value) {
        return heap.contains(value);
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;

            if (heap.get(index).compareTo(heap.get(parentIndex)) <= 0) break;

            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    private void heapifyDown(int index) {
        int size = heap.size();
        while (true) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            int largest = index;

            if (leftChild < size && heap.get(leftChild).compareTo(heap.get(largest)) > 0) {
                largest = leftChild;
            }

            if (rightChild < size && heap.get(rightChild).compareTo(heap.get(largest)) > 0) {
                largest = rightChild;
            }

            if (largest == index) break;

            swap(index, largest);
            index = largest;
        }
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
