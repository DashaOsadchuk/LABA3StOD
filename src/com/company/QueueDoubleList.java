package com.company;

public class QueueDoubleList<T> {
    Element<T> first;
    Element<T> last;

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        int size = 0;
        Element<T> current = first;
        while (current != null) {
            size++;
            current = current.getNext();
        }
        return size;
    }

    public void add(T value, int priority) {
        Element<T> t = new Element<>(value, priority, null, null);
        Element<T> current = first;
        if (last == null && first == null) {
            first = t; last = t; return;}
        while (current != null) {
            if (current.priority < priority) {
                insert(current, t);
                return;
            }
            current = current.getNext();
        }
        current = last;
        last = t;
        if (current != null) {
            current.setNext(t);
        } else {
            first = t;
        }
        t.setPrevious(current);
    }

    public void insert(Element<T> next, Element<T> toInsert) {
        Element<T> previous = next.getPrevious();
        if (previous != null) {
            previous.setNext(toInsert);
        } else first = toInsert;
        next.setPrevious(toInsert);
        toInsert.setPrevious(previous);
        toInsert.setNext(next);
    }

    public T removeFirst() {
        if (isEmpty()) {System.out.println("Список пуст!"); return null;}
        T data = first.getData();
        first = first.getNext();
        first.setPrevious(null);
        return data;
    }

    public void showList() {
        Element<T> current = first;
        while (current!=null) {
            current.showElement();
            current = current.getNext();
        }
    }

    public void clear() {
        Element<T> current = first;
        Element<T> next;
        while (current != null) {
            current.prev = null;
            next = current.getNext();
            current.next = null;
            current = next;
        }
    }
}
