// ..

package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;
import java.util.List;

/**
 *
 * @author JG uniCenta
 */
public interface SentenceList<T> {

    public List<T> list() throws BasicException;

    public List<T> list(Object params) throws BasicException;

    public List<T> listPage(int offset, int length) throws BasicException;

    public List<T> listPage(Object params, int offset, int length) throws BasicException;    
}
