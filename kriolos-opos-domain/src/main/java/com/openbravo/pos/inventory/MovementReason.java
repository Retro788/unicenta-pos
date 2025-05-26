// ..
package com.openbravo.pos.inventory;

import com.openbravo.pos.panels.ComboItemLocal;

//file format
public class MovementReason extends ComboItemLocal {

// IN values
    public static final MovementReason IN_PURCHASE = new MovementReason(+1, "stock.in.purchase");
    public static final MovementReason IN_REFUND = new MovementReason(+2, "stock.in.refund");
    public static final MovementReason IN_MOVEMENT = new MovementReason(+4, "stock.in.movement");

// OUT values    
    public static final MovementReason OUT_SALE = new MovementReason(-1, "stock.out.sale");
    public static final MovementReason OUT_REFUND = new MovementReason(-2, "stock.out.refund");
    public static final MovementReason OUT_BREAK = new MovementReason(-3, "stock.out.break");
    public static final MovementReason OUT_MOVEMENT = new MovementReason(-4, "stock.out.movement");

    public static final MovementReason OUT_SAMPLE = new MovementReason(-5, "stock.out.sample");
    public static final MovementReason OUT_FREE = new MovementReason(-6, "stock.out.free");
    public static final MovementReason OUT_USED = new MovementReason(-7, "stock.out.used");
    public static final MovementReason OUT_SUBTRACT = new MovementReason(-8, "stock.out.subtract");

// TRANSFER
    public static final MovementReason OUT_CROSSING = new MovementReason(1000, "stock.out.crossing");

    private MovementReason(Integer iKey, String sKeyValue) {
        super(iKey, sKeyValue);
    }

    public boolean isInput() {
        return m_iKey.intValue() > 0;
    }

    public Double samesignum(Double d) {

        if (d == null || m_iKey == null) {
            return d;
        } else if ((m_iKey.intValue() > 0 && d.doubleValue() < 0.0)
                || (m_iKey.intValue() < 0 && d.doubleValue() > 0.0)) {
            return -d.doubleValue();
        } else {
            return d;
        }
    }

    /**
     *
     * @param dBuyPrice
     * @param dSellPrice
     * @return
     */
    public Double getPrice(Double dBuyPrice, Double dSellPrice) {

        if (this == IN_PURCHASE || this == OUT_REFUND || this == OUT_BREAK) {
            return dBuyPrice;
        } else if (this == OUT_SALE || this == IN_REFUND) {
            return dSellPrice;
        } else {
            return null;
        }
    }

    public static MovementReason get(Integer reason) {
        MovementReason movReason = null;
        String s = String.valueOf(reason);
        if (s.equals("1")) {
            movReason = MovementReason.IN_PURCHASE;
        }
        if (s.equals("2")) {
            movReason = MovementReason.IN_REFUND;
        }
        if (s.equals("4")) {
            movReason = MovementReason.IN_MOVEMENT;
        }
        if (s.equals("-1")) {
            movReason = MovementReason.OUT_SALE;
        }
        if (s.equals("-2")) {
            movReason = MovementReason.OUT_REFUND;
        }
        if (s.equals("-3")) {
            movReason = MovementReason.OUT_BREAK;
        }
        if (s.equals("-4")) {
            movReason = MovementReason.OUT_MOVEMENT;
        }
        if (s.equals("-5")) {
            movReason = MovementReason.OUT_SAMPLE;
        }
        if (s.equals("-6")) {
            movReason = MovementReason.OUT_FREE;
        }
        if (s.equals("-7")) {
            movReason = MovementReason.OUT_USED;
        }
        if (s.equals("-8")) {
            movReason = MovementReason.OUT_SUBTRACT;
        }
        
        return movReason;
    }

}
