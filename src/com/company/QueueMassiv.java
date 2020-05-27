package com.company;

public class QueueMassiv {
    Object[] queue = new Object[1000];
    int[] priorities = new int[1000];

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        int size = 0;
        for (int i = 0; i != 1000 && queue[i] != null; i++) {
            size++;
        }
        return size;
    }

    public void add(Object o, int priority) {
        if (size() == queue.length) {System.out.println("Массив забит!");}
        for (int i = 0; i < queue.length; i++) {
            if (queue[i] != null) {
                if (priorities[i] < priority) {
                    insert(i, o, priority);
                    break;
                }
            } else {
                queue[i] = o;
                priorities[i] = priority;
                break;
            }
        }
    }

    private void insert(int previous, Object toAdd, int priority) {
        Object buff = queue[previous];
        int buff_ = priorities[previous];
        queue[previous] = toAdd;
        priorities[previous] = priority;
        for (int i = previous; i < queue.length-1; i++) {
            if (queue[i] == null) {
                queue[i] = buff;
                priorities[i] = buff_;
            } else {
                Object _buff = queue[i+1];
                int _buff_ = priorities[i+1];
                queue[i+1] = buff;
                priorities[i+1] = buff_;
                buff = _buff;
                buff_ = _buff_;
            }
        }
    }

    public Object removeFirst() {
        if (isEmpty()) {System.out.println("Массив пуст!"); return null;}
        Object buff = queue[0];
        int size = size();
        for (int i = 0; i != 999 && queue[i] != null; i++) {
            queue[i] = queue[i+1];
            priorities[i] = priorities[i+1];
        }
        queue[size-1] = null;
        priorities[size-1] = 0;
        return buff;
    }

    public void showList() {
        for (int i = 0; i < queue.length; i++) {
            if (queue[i] != null)
                System.out.println(queue[i].toString() + " имеет приоритет = "+priorities[i]);
        }
    }

    public void clear() {
        for (int i = 0; i != 1000 && queue[i] != null; i++) {
            queue[i] = null;
            priorities[i] = 0;
        }
    }
}
