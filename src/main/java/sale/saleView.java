
package sale;

import java.util.List;
import models.BarsaleModel;
import models.InvoicesModel;
import models.OrdersModel;
import models.customersModel;
import models.suppliersModel;

/**
 *
 * @author mohware
 */
public interface saleView {

    public void GetbrSaleItems(List<BarsaleModel> body);

    public void onErrorLoading(String error);

    public void GetSuppliers(List<suppliersModel> body);

    public void GetCustomers(List<customersModel> body);

    public void onAddError(String error);

    public void onCreateOrder(String message);

    public void GetOrders(List<OrdersModel> body);

    public void onCreateInvoice(String message);

    public void GetInvoices(List<InvoicesModel> body);

    public void onPostBill(String message);

}
