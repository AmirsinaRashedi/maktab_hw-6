package domain;

import java.util.Iterator;

public class MyLinkedList<T> implements Iterable {

    private int size;

    private Node<T> first;

    private Node<T> last;

    private Node<T> current;

    private Node<T> pointerToFirst;

    public MyLinkedList() {
        size = 0;
        pointerToFirst = new Node<>(null, null, null);
    }


    public void setFirst(T object) {

        Node<T> f = first;

        Node<T> newNode = new Node<>(null, object, f);

        changeFirst(newNode);

        if (f == null)

            last = newNode;

        else

            f.previous = newNode;

        size++;

    }

    public void setLast(T object) {
        Node<T> l = last;

        Node<T> newNode = new Node<>(l, object, null);

        last = newNode;

        if (l == null) {

            changeFirst(newNode);

        } else

            l.next = newNode;

        size++;
    }

    public void setBefore(T object, Node<T> succ) {

        if (succ != null) {

            Node<T> pred = succ.previous;

            Node<T> newNode = new Node<>(pred, object, succ);

            succ.previous = newNode;

            if (pred == null) {

                changeFirst(newNode);

            } else

                pred.next = newNode;

            size++;
        }

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Integer get(T searchParameter) {

        current = pointerToFirst;

        Integer integer = 0;

        while (this.iterator().hasNext()) {

            this.iterator().next();

            integer++;

            if (current.object.equals(searchParameter))

                return integer;

        }

        return null;

    }

    public T get(int index) {

        try {

            checkIndexInBounds(index);

            for (int i = 0; i < index; i++)
                this.iterator().next();

            return current.object;

        } catch (IndexOutOfBoundsException e) {

            System.out.println(e.getMessage());

            return null;

        }
    }

    public boolean remove(int index) {

        try {

            checkIndexInBounds(index);

            for (int i = 0; i < index; i++)
                this.iterator().next();

            remove(current);

            return true;

        } catch (IndexOutOfBoundsException e) {

            System.out.println(e.getMessage());

            return false;

        }
    }

    public boolean remove(T searchParameter) {

        current = pointerToFirst;

        Integer integer = 0;

        while (this.iterator().hasNext()) {

            this.iterator().next();

            integer++;

            if (current.object.equals(searchParameter)) {

                remove(current);

                return true;

            }

        }
        System.out.println("after while");

        return false;

    }

    public T remove(Node<T> node) {

        T object = node.object;

        Node<T> next = node.next;

        Node<T> prev = node.previous;

        if (prev == null) {

            changeFirst(next);

        } else {

            prev.next = next;

            node.previous = null;
        }

        if (next == null) {

            last = prev;

        } else {

            next.previous = prev;

            node.next = null;

        }

        node.object = null;

        size--;

        return object;
    }

    private void changeFirst(Node<T> node) {

        first = node;

        pointerToFirst.next = node;

    }

    private void checkIndexInBounds(int index) {

        if (this.isEmpty() || index < 1 || index > size)

            throw new IndexOutOfBoundsException("input out of range");

        else

            current = pointerToFirst;

    }

    public void printList() {

        current = pointerToFirst;

        while (this.iterator().hasNext()) {

            System.out.println(this.iterator().next().object);

        }

    }

    @Override
    public Iterator<Node<T>> iterator() {

        return new Iterator<Node<T>>() {
            @Override
            public boolean hasNext() {

                if (current != null) {

                    if (current.next != last || current.next != null)

                        return true;

                    else

                        return false;

                } else

                    return false;

            }

            @Override
            public Node<T> next() {

                current = current.next;

                return current;

            }
        };
    }

    private class Node<T> {

        public Node<T> previous;

        public T object;

        public Node<T> next;

        public Node(Node<T> previous, T object, Node<T> next) {

            this.object = object;

            this.previous = previous;

            this.next = next;
        }

    }
}
