// ..

package com.openbravo.pos.inventory;

import com.openbravo.data.loader.DataRead;
import com.openbravo.data.loader.SerializerRead;

/**
 *
 * @author Jack G
 */
public class ProductsBundleInfo {
    private static final long serialVersionUID = 7587646873036L;
    
    protected String id;
    protected String productId;
    protected String productBundleId;
    protected Double quantity;

    /**
     * 
     * @param id
     * @param productId
     * @param productBundleId
     * @param quantity 
     */
    public ProductsBundleInfo(String id, String productId, String productBundleId, Double quantity) {
        this.id = id;
        this.productId = productId;
        this.productBundleId = productBundleId;
        this.quantity = quantity;
    }
    

    public void setM_ID(String id) {
        this.id = id;
    }

    public void setM_sProduct(String productId) {
        this.productId = productId;
    }

    public void setM_sProductBundle(String productBundleId) {
        this.productBundleId = productBundleId;
    }

    public void setM_dQuantity(Double m_dQuantity) {
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductBundleId() {
        return productBundleId;
    }

    public Double getQuantity() {
        return quantity;
    }
    
    
    public static SerializerRead getSerializerRead() {
        return (DataRead dr) -> new ProductsBundleInfo(dr.getString(1)
                , dr.getString(2)
                , dr.getString(3)
                , dr.getDouble(4));
    }
    
}