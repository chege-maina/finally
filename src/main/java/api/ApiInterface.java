package api;

import java.util.List;
import models.BarsaleModel;
import models.BillsModel;
import models.InvoicesModel;
import models.OrdersModel;
import models.customersModel;
import models.saleModel;
import models.storeModel;
import models.usersModel;
import models.percentModel;
import models.suppliersModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 *
 * @author mohware
 */
public interface ApiInterface {

    @GET("load_users.php")
    Call<List<usersModel>> loadUsers(@Query("post_string1") String post_string1, @Query("post_string2") String post_string2);
    
    @GET("load_orders.php")
    Call<List<OrdersModel>> getOrders(@Query("post_string1") String post_string1, @Query("post_string2") String post_string2);
    
     @GET("load_invoices.php")
    Call<List<InvoicesModel>> getInvoices(@Query("post_string1") String post_string1, @Query("post_string2") String post_string2);

     @GET("load_bills.php")
    Call<List<BillsModel>> getBills(@Query("post_string1") String post_string1, @Query("post_string2") String post_string2);

    @GET("load_suppliers.php")
    Call<List<suppliersModel>> loadSuppliers(@Query("post_string1") String post_string1, @Query("post_string2") String post_string2);

    @GET("load_customers.php")
    Call<List<customersModel>> loadCustomers(@Query("post_string1") String post_string1, @Query("post_string2") String post_string2);

    @GET("load_percent.php")
    Call<List<percentModel>> getPercent(@Query("post_string1") String post_string1, @Query("post_string2") String post_string2);

    @GET("loadsalecategory.php")
    Call<List<saleModel>> loadSaleCategory();

    @GET("brloadsalecategory.php")
    Call<List<saleModel>> brloadSaleCategory();

    @GET("loadstoreunit.php")
    Call<List<storeModel>> loadStoreUnit();

    @GET("brloadstoreunit.php")
    Call<List<storeModel>> BarUnit();

    @GET("origin.php")
    Call<List<storeModel>> Origin();
    
    @GET("sale_rep.php")
    Call<List<storeModel>> SalesRep();

    @GET("brloadsaleitems.php")
    Call<List<BarsaleModel>> brloadSaleItems(@Query("post_string1") String post_string1, @Query("post_string2") String post_string2);

    @GET("brloadsaleitems.php")
    Call<List<BarsaleModel>> loadSaleItems(@Query("post_string1") String post_string1, @Query("post_string2") String post_string2, @Query("post_string3") String post_string3);

    //POST FOR ADDING NEW
    @FormUrlEncoded
    @POST("addcategory.php")
    Call<storeModel> addCategory(@Field("post_string1") String post_string1, @Field("post_string2") String post_string2);
    
    @FormUrlEncoded
    @POST("createorder.php")
    Call<storeModel> createOrder(@Field("post_string1") String post_string1, @Field("post_string2") String post_string2);
    
    @FormUrlEncoded
    @POST("create_cust_invoice.php")
    Call<storeModel> createInvoice(@Field("post_string1") String post_string1, @Field("post_string2") String post_string2);

    @FormUrlEncoded
    @POST("post_bill.php")
    Call<storeModel> postBill(@Field("post_string1") String post_string1, @Field("post_string2") String post_string2, @Field("post_string3") String post_string3);

    @FormUrlEncoded
    @POST("adduser.php")
    Call<storeModel> addUser(@Field("post_string1") String post_string1);

    @FormUrlEncoded
    @POST("braddsaleitems.php")
    Call<saleModel> braddSaleItems(@Field("post_string1") String post_string1);

    @FormUrlEncoded
    @POST("addsupplier.php")
    Call<saleModel> addSupplier(@Field("post_string1") String post_string1);

    @FormUrlEncoded
    @POST("addcustomer.php")
    Call<saleModel> addCustomer(@Field("post_string1") String post_string1);

    @FormUrlEncoded
    @POST("addpercent.php")
    Call<saleModel> addPercent(@Field("post_string1") String post_string1);

    @FormUrlEncoded
    @POST("changepin.php")
    Call<usersModel> ChangePin(@Field("post_string1") String post_string1, @Field("post_string2") String post_string2);

    @FormUrlEncoded
    @POST("updateusers.php")
    Call<storeModel> editUser(@Field("post_string1") String post_string1, @Field("post_string2") String post_string2);

    @FormUrlEncoded
    @POST("updatePass.php")
    Call<usersModel> updateUsers(@Field("post_string1") String post_string1, @Field("post_string2") String post_string2);
}
