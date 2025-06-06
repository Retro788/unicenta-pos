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

package com.openbravo.data.loader;

//file format
public class SessionDBHSQLDB implements SessionDB {

    /**
     *
     * @return
     */
    @Override
    public String TRUE() {
        return "TRUE";
    }

    /**
     *
     * @return
     */
    @Override
    public String FALSE() {
        return "FALSE";
    }

    /**
     *
     * @return
     */
    @Override
    public String INTEGER_NULL() {
        return "CAST(NULL AS INTEGER)";
    }

    /**
     *
     * @return
     */
    @Override
    public String CHAR_NULL() {
        return "CAST(NULL AS CHAR)";
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "HSQLDB";
    }

    /**
     *
     * @param s
     * @param sequence
     * @return
     */
    @Override
    public SentenceFind getSequenceSentence(Session s, String sequence) {
        return new SequenceForGeneric(s, sequence);
        //return new StaticSentence(s, "CALL NEXT VALUE FOR " + sequence, null, SerializerReadInteger.INSTANCE);
    }
    
    /**
     *
     * @param s
     * @param sequence
     * @return
     */
    @Override
    public SentenceExec resetSequenceSentence(Session s, String sequence) {
        SequenceForGeneric seqGeneric = new SequenceForGeneric(s, sequence);
        return seqGeneric.reset();
        //return new StaticSentence(s, "CALL NEXT VALUE FOR " + sequence, null, SerializerReadInteger.INSTANCE);
    }    
}
