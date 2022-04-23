
package sale;

import java.util.ArrayList;

/**
 *
 * @author mohware
 */
public interface myInterface {

    public void saleItemListener(ArrayList itemzz);

    public void removeRecITM(ArrayList itemzz);

    public void saleEditQty(ArrayList itemzz, String newValue);

    public void orderITMListener(ArrayList itemzz);

    public void invoiceITMListener(ArrayList itemzz);

    public void BillITMListener(ArrayList itemzz);

    public void BillEditQty(ArrayList itemzz, String newValue, Double x);

    public void removeBillITM(ArrayList itemzz);
    
}
