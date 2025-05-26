// ..
//    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-130

package com.openbravo.pos.panels;

import java.util.Enumeration;
import java.util.Iterator;

//file format
public class EnumerationIter implements Enumeration {
    
    private Iterator i;

    /**
     *
     * @param i
     */
    public EnumerationIter(Iterator i) {
        this.i = i;
    }
    @Override
    public boolean hasMoreElements() {
        return i.hasNext();
    }
    @Override
    public Object nextElement() {
        return i.next();
    } 
}
