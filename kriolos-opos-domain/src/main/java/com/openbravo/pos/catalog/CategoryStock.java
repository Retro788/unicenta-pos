// ..

package com.openbravo.pos.catalog;

import com.openbravo.basic.BasicException;
import com.openbravo.data.loader.DataRead;
import com.openbravo.data.loader.SerializerRead;

/**
 *
 * @author JG uniCenta Dec 17
 * Used in Categories to display all this Categories Products
 */

public class CategoryStock {

    String productId;
    String productName;
    String productCode;
    String categoryId;   

    /**
     * Main method to return all customer's transactions 
     */
    public CategoryStock() {
    }

    /**
     *
     * @param productId
     * @param productName
     * @param cId
     */
    public CategoryStock(String productId, String productName, String productCode, String pId) {
        this.productId = productId;
        this.productName = productName;
        this.productCode = productCode;
        this.categoryId = pId;        
    }

    /**
     *
     * @return product string
     */
    public String getProductId() {
        return productId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     *
     * @return product name string 
     */
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    /**
     *
     * @return product barcode string 
     */
    public String getProductCode() {
        return productCode;
    }
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }    

    /**
     *
     * @return category name string
     */
    public String getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    /**
     *
     * @return products for this category
     */
    public static SerializerRead<CategoryStock> getSerializerRead() {
        return new SerializerRead<CategoryStock>() {
            @Override
            public CategoryStock readValues(DataRead dr) throws BasicException {
                String productId = dr.getString(1);
                String productName = dr.getString(2);
                String productCode = dr.getString(3);                
                String categoryId = dr.getString(4);
                return new CategoryStock(productId, productName, productCode, categoryId);
            }
        };
    }
}