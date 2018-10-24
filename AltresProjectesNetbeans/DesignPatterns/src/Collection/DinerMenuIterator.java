/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;

import java.util.Iterator;

/**
 *
 * @author formacio
 */
public class DinerMenuIterator implements Iterator<String> {

    private int position;
    private String[] items;
    
    public DinerMenuIterator(String[] items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return position < items.length && items[position] != null;
    }

    @Override
    public String next() {
        return items[position++];
    }
    
}
