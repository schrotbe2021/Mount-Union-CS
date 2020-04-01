////// file:  LinkedList.java

public class LinkedList {

    protected Link first;
    protected int size;
    private Link last;

    public LinkedList() {
        size = 0;
        first = last = null;
    } // end of constructor

    public Link getFirst() {
        return first;
    } // end of getFirst()

    public int getSize() {
        return size;
    } // end of getSize()

    public void insertFirst(Object newObj) {
        Link newestLink = new Link(newObj);
        if (first == null) {
            first = newestLink;
            last = newestLink;
        } else {
            newestLink.next = first;
            first = newestLink;
        }
        size++;
    } // end of insertFirst()   

    public Object deleteFirst() {
        Object answer = first.data;
        if (size == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;
        }
        size--;
        return answer;
    } // end of deleteFirst()  
    
    public void insertLast(Object obj) {
        Link newLink = new Link(obj);
        if (first == null) {
            newLink.next = null;
            first = newLink;
            last = newLink;
        } else {
            last.next = newLink;
            last = newLink;
        }
        size++;
    }
    
}  // end class LinkedList
