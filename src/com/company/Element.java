package com.company;

public class Element<T> {
    protected Object data;
    protected int priority;

    protected Element<T> next;
    protected Element<T> prev;

    public Element(Object data, int priority, Element<T> next, Element<T> previous) {
        this.data = data;
        this.priority = priority;
        this.next = next;
        this.prev = previous;
    }

    public Element<T> getNext() {
        return this.next;
    }

    public void setNext(Element<T> element) {
        this.next = element;
    }

    public Element<T> getPrevious() {
        return this.prev;
    }

    public void setPrevious(Element<T> element) {
        this.prev = element;
    }

    public void setData(Object newData) {
        this.data = newData;
    }

    public T getData() {
        return (T)this.data;
    }

    protected void changePriority(int newPriority) {
        this.priority = newPriority;
    }

    protected void showElement() {
        System.out.println(data + ", priority: " + priority);
    }
}
