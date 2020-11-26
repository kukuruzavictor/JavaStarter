package com.company;

public class MyLinkedList<E> {
    private int size = 0;
    private MyNode<E> first;
    private MyNode<E> last;

    public boolean add(E... element) {
        for (E e : element) {
            addLast(e);
        }
        return true;
    }

    public void add(int index, E element) {
        if (index == 0) {
            addFirst(element);
        } else if (index == size) {
            addLast(element);
        } else if (index > 0 && index < size) {
            MyNode<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            MyNode<E> newNode = new MyNode<>(element, node.prev, node);
            node.prev.next = newNode;
            node.prev = newNode;
            size++;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void addFirst(E element) {
        if (first != null) {
            MyNode<E> newFirst = new MyNode<E>(element, null, first);
            MyNode<E> newNext = first;
            newNext.prev = newFirst;
            first = newFirst;
        } else {
            first = new MyNode<E>(element, null, null);
            last = first;
        }
        size++;
    }

    public void addLast(E element) {
        if (last != null) {
            MyNode<E> newLast = new MyNode<E>(element, last, null);
            MyNode<E> newPrev = last;
            newPrev.next = newLast;
            last = newLast;
        } else {
            last = new MyNode<E>(element, null, null);
            first = last;
        }
        size++;
    }

    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    public E get(int index) {
        return getNode(index).value;
    }

    public E getFirst() {
        return first.value;
    }

    public E getLast() {
        return last.value;
    }

    private MyNode<E> getNode(int index) {
        if (index >= 0 && index < size) {
            if (index < size / 2) {
                MyNode<E> node = first;
                for (int i = 0; i < index; i++) {
                    node = node.next;
                }
                return node;
            } else {
                MyNode<E> node = last;
                for (int i = size - 1; i > index; i--) {
                    node = node.prev;
                }
                return node;
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public int indexOf(E element) {
        int counter = 0;
        MyNode<E> node = first;
        if (node == null) {
            return -1;
        } else {
            while (node != null) {
                if (node.value.equals(element)) {
                    return counter;
                }
                node = node.next;
                counter++;
            }
        }
        return -1;
    }

    public int lastIndexOf(E element) {
        int counter = 0;
        MyNode<E> node = last;
        if (node == null) {
            return -1;
        } else {
            while (node != null) {
                if (node.value.equals(element)) {
                    return size - 1 - counter;
                }
                node = node.prev;
                counter++;
            }
        }
        return -1;
    }

    public E remove() {
        return removeFirst();
    }

    public E removeFirst() {
        MyNode<E> oldNode = first;
        first.next.prev = null;
        first = first.next;
        size--;
        return oldNode.value;
    }

    public E removeLast() {
        MyNode<E> oldNode = last;
        last.prev.next = null;
        last = last.prev;
        size--;
        return oldNode.value;
    }

    public boolean remove(E element) {
        int index = indexOf(element);
        if (index != -1) {
            remove(index);
            return true;
        } else {
            return false;
        }
    }

    public E remove(int index) {
        if (size != 0) {
            MyNode<E> node = getNode(index);
            if (index == 0) {
                removeFirst();
            } else if (index == size - 1) {
                removeLast();
            } else {
                MyNode<E> prevNode = node.prev;
                MyNode<E> nextNode = node.next;
                prevNode.next = node.next;
                nextNode.prev = node.prev;
                size--;
            }
            return node.value;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public E set(int index, E element) {
        if (index >= 0 && index < size) {
            MyNode<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            E oldValue = node.value;
            node.value = element;
            return oldValue;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        MyNode<E> node = first;
        String result = "";
        while (node != null) {
            result += node.value.toString();
            node = node.next;
            if (node != null) {
                result += ", ";
            }
        }
        return "[" +
                result +
                ']';
    }

    private class MyNode<E> {
        private E value;
        private MyNode<E> prev;
        private MyNode<E> next;

        public MyNode(E value, MyNode<E> prev, MyNode<E> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

}
