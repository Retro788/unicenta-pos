// ..

package com.openbravo.data.user;

import com.openbravo.basic.BasicException;
import com.openbravo.data.loader.SentenceList;
import com.openbravo.data.loader.TableDefinition;
import java.util.*;

/**
 *
 * @author JG uniCenta
 */
public class ListProviderCreator<T> implements ListProvider<T> {
    
    private SentenceList<T> sentenceList;
    private EditorCreator<T> editorCreator;
    private Object params;
    
    /** Creates a new instance of ListProviderEditor
     * @param sent
     * @param prov */
    public ListProviderCreator(SentenceList<T> sent, EditorCreator<T> prov) {
        this.sentenceList = sent;
        this.editorCreator = prov;
        this.params = null;
    }
    
    /**
     *
     * @param sent
     */
    public ListProviderCreator(SentenceList<T> sent) {
        this(sent, null);
    }
    
    /**
     *
     * @param table
     */
    public ListProviderCreator(TableDefinition<T> table) {        
        this(table.getListSentence(), null);
    }

    /**
     *
     * @return
     * @throws BasicException
     */
    @Override
    public List<T> loadData() throws BasicException {       
        params = (editorCreator == null) ? null : editorCreator.createValue();
        return refreshData();
    }
    
    /**
     *
     * @return
     * @throws BasicException
     */
    @Override
    public List<T> refreshData() throws BasicException {
        return sentenceList.list(params);
    }    
}
