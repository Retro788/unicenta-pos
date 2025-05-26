// ..

package com.openbravo.data.user;

import java.awt.Component;

/**
 *
 * @author JG uniCenta
 */
public interface EditorRecord<T> extends EditorCreator<T> {

    public void writeValueEOF();

    public void writeValueInsert(); 

    public void writeValueEdit(T value); // not null por definicion.

    public void writeValueDelete(T value); // not null por definicion.

    public void refresh();

    public Component getComponent(); 
}
