//    KriolOS POS
//    Copyright (c) 2019-2023 KriolOS
//
//    This program is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    This program is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with this program.  If not, see <http://www.gnu.org/licenses/>.

package com.openbravo.pos.panels;

import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.tree.TreeNode;

//file format
public class SQLTable implements TreeNode { 
    
    private SQLDatabase m_db;
    private String m_sName;
    
    private ArrayList m_aColumns;
    
    /** Creates a new instance of SQLTable
     * @param db
     * @param name */
    public SQLTable(SQLDatabase db, String name) {
        m_db = db;
        m_sName = name;
        m_aColumns = new ArrayList();
    }
    
    /**
     *
     * @return
     */
    public String getName() {
        return m_sName;
    }
    
    /**
     *
     * @param name
     */
    public void addColumn(String name) {
        SQLColumn c = new SQLColumn(this, name);
        m_aColumns.add(c);
    }
    
    @Override
    public String toString() {
        return m_sName;
    }
    
    @Override
    public Enumeration children(){
        return new EnumerationIter(m_aColumns.iterator());
    }
    @Override
    public boolean getAllowsChildren() {
        return true;
    }
    @Override
    public TreeNode getChildAt(int childIndex) {
        return (TreeNode) m_aColumns.get(childIndex);
    }
    @Override
    public int getChildCount() {
        return m_aColumns.size();
    }
    @Override
    public int getIndex(TreeNode node){
        return m_aColumns.indexOf(node);
    }
    @Override
    public TreeNode getParent() {
        return m_db;
    }
    @Override
    public boolean isLeaf() {
// JG 16 May 2013 use isEmpty instead of size.
        return m_aColumns.isEmpty();
    }   
//    public Enumeration children(){
//    }
//    public boolean getAllowsChildren() {
//    }
//    public TreeNode getChildAt(int childIndex) {
//    }
//    public int getChildCount() {
//    }
//    public int getIndex(TreeNode node){
//    }
//    public TreeNode getParent() {
//    }
//    public boolean isLeaf() {
//    }  
}
