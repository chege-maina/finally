/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import java.util.List;
import models.BarsaleModel;
import models.customersModel;
import models.loginModel;
import models.percentModel;
import models.pettyModel;
import models.saleModel;
import models.storeModel;
import models.suppliersModel;
import models.usersModel;

public interface adminView {

    public void onAddUserSuccess(String message);

    public void onAddError(String message);

    public void GetUsers(List<usersModel> body);

    public void GetSuppliers(List<suppliersModel> body);

    public void onErrorLoading(String error);

    public void onUserUpdateSuccess(String message);

    public void brGetSaleCategory(List<saleModel> body);

    public void GetBarUnit(List<storeModel> body);

    public void onAddCatSuccess(String message);

    public void GetbrSaleItems(List<BarsaleModel> body);

    public void onAddBarSaleItemSuccess(String message);

    public void onAddSupplier(String message);

    public void onAddPercent(String message);

    public void GetPercent(List<percentModel> body);

    public void onAddCustomer(String message);

    public void GetOrigin(List<storeModel> body);

    public void GetCustomers(List<customersModel> body);

    public void GetRep(List<storeModel> body);

}
