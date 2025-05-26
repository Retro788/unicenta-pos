// ..

package com.openbravo.data.user;

import com.openbravo.basic.BasicException;
import java.util.List;

/**
 *
 * @author JG uniCenta
 */
public interface ListProvider<T> {

    public List<T> loadData() throws BasicException;
    public List<T> refreshData() throws BasicException; 
}
