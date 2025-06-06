// ..
//    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-130

package com.openbravo.pos.panels;

import java.util.Enumeration;
import javax.swing.tree.TreeNode;

//file format
public class SQLColumn implements TreeNode {
    
    private SQLTable m_table;
    private String m_sName;
    
    /** Creates a new instance of SQLColumn
     * @param t
     * @param name */
    public SQLColumn(SQLTable t, String name) {
        m_table = t;
        m_sName = name;
    }
    @Override
    public String toString() {
        return m_sName;
    }
    
    @Override
    public Enumeration children(){
        return null;
    }
    @Override
    public boolean getAllowsChildren() {
        return false;
    }
    @Override
    public TreeNode getChildAt(int childIndex) {
        throw new ArrayIndexOutOfBoundsException();
    }
    @Override
    public int getChildCount() {
        return 0;
    }
    @Override
    public int getIndex(TreeNode node){
        throw new ArrayIndexOutOfBoundsException();
    }
    @Override
    public TreeNode getParent() {
        return m_table;
    }
    @Override
    public boolean isLeaf() {
        return true;
    }      
}
