/*
    Ben Schroth
    PA5 - Dr. Weber CSC 220
    12/7/2018
    ClothingStack class

*/

package clothing;

import java.util.ArrayList;
import javafx.scene.paint.Color;

public class ClothingStack 
{   
  
    private static class Node<ClothingItem> { ClothingItem item; Node next; }
    
    private Node<ClothingItem> first;
    
    public ClothingStack( )
    {
        first = null;
    } // end of constructor
    
    public ClothingStack( ClothingItem item )
    {
        Node<ClothingItem> tmp = new Node<>();
        tmp.item = item;
        tmp.next = null;
        first = tmp;
    }
    
    public void push(ClothingItem item)
    {
        Node<ClothingItem> tmp = new Node<>();
        tmp.item = item;
        if ( first != null )
        {
            first = tmp.next;
            first = tmp;
        }
        else
        {
            first = tmp;
            tmp.next = null;
        }
        
    }
    
    public ClothingItem pop()
    {
        Node<ClothingItem> tmp = new Node<>();
        if ( first == null )
        {
            System.out.println("Can't pop empty stack.");
            return null;
        } 
        else
        {
            tmp.item = first.item;
            first = first.next;
            return tmp.item;
        }
    }
    
    public ClothingItem peek()
    {
        if (first == null)
        {
            System.out.println("Can't peek empty stack.");
            return null;
        }
        else
        {
            return first.item;
        }
    }
    
    //  This is an additional method your code must implement.
    //  Returns true iff there is at least one item on the stack.
    public boolean hasNext()
    {
        if (first != null) {
            return true;
        } else 
        {
            return false;
        }
    }  
    
    @Override
    public String toString()
    {
        if (first == null)
        {
            return "";
        } 
        else 
        {
            return first.item.toString();
        }
    }
    
    public ClothingItem[] itemsOfColor(Color color)
    {
        Node<ClothingItem> tmp = first;
        tmp.item = first.item;
        ClothingItem item = tmp.item;
        ArrayList<ClothingItem> items = new ArrayList<>();
        
        while (tmp.next != null)
        {
            if (item.getColor().equals(color))
            {
                items.add(item);
            }
            tmp = tmp.next;
        }
        if ( tmp.next == null && item.getColor( ).equals(color) )
        {
            items.add( item );
        }
        ClothingItem[] clothesOfColor = 
                    items.toArray(new ClothingItem[items.size()]);
        return clothesOfColor;
    }
    
    public int numberOfItemsWashableAtHighTemperature()
    {
        int highSum = 0;
        Node<ClothingItem> tmp = first;
        ClothingItem item = tmp.item;
        while ( tmp.next != null )
        {
            if ( item.getWash().equals(true))
            {
                highSum += 1;
            }
            tmp = tmp.next;
        }
        if ( tmp.next == null && item.getWash( ).equals(true) )
        {
            highSum += 1;
        }
       
        return highSum;  //  Replace with your own code.
    }
    
    
}
