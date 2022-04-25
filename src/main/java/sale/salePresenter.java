package sale;

import api.ApiClient;
import api.ApiInterface;
import java.util.List;
import models.BarsaleModel;
import models.BillsModel;
import models.InvoicesModel;
import models.OrdersModel;
import models.RecModel;
import models.customersModel;
import models.saleModel;
import models.storeModel;
import models.suppliersModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class salePresenter {

    private saleView view;

    public salePresenter(saleView view) {
        this.view = view;

    }

    public void getSuppliers(final String one, final String two) {
        //view.showLoading();
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<suppliersModel>> call = apiInterface.loadSuppliers(one, two);
        call.enqueue(new Callback<List<suppliersModel>>() {
            @Override
            public void onResponse(Call<List<suppliersModel>> call, Response<List<suppliersModel>> response) {

                //view.hideLoading();
                if (response.isSuccessful() && response.body() != null) {
                    view.GetSuppliers(response.body());

                }
            }

            public void onFailure(Call<List<suppliersModel>> call, Throwable t) {
                //view.hideLoading();
                String error = "Internet Connection Error...";
                view.onErrorLoading(error);

            }
        });
    }

    public void getCustomers(final String one, final String two) {
        //view.showLoading();
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<customersModel>> call = apiInterface.loadCustomers(one, two);
        call.enqueue(new Callback<List<customersModel>>() {
            @Override
            public void onResponse(Call<List<customersModel>> call, Response<List<customersModel>> response) {

                //view.hideLoading();
                if (response.isSuccessful() && response.body() != null) {
                    view.GetCustomers(response.body());

                }
            }

            public void onFailure(Call<List<customersModel>> call, Throwable t) {
                //view.hideLoading();
                String error = "Internet Connection Error...";
                view.onErrorLoading(error);

            }
        });
    }

    public void getSaleItems(final String check, final String value, final String sup) {
        //view.showLoading();
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<BarsaleModel>> call = apiInterface.loadSaleItems(check, value, sup);
        call.enqueue(new Callback<List<BarsaleModel>>() {
            @Override
            public void onResponse(Call<List<BarsaleModel>> call, Response<List<BarsaleModel>> response) {

                //view.hideLoading();
                if (response.isSuccessful() && response.body() != null) {
                    view.GetbrSaleItems(response.body());
                }
            }

            public void onFailure(Call<List<BarsaleModel>> call, Throwable t) {
                //view.hideLoading();
                String error = "Internet Connection Error...";
                view.onErrorLoading(error);

            }
        });
    }

    public void createOrder(final String category, final String check) {

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<storeModel> call = apiInterface.createOrder(category, check);

        call.enqueue(new Callback<storeModel>() {
            @Override
            public void onResponse(Call<storeModel> call, Response<storeModel> response) {

                if (response.isSuccessful() && response.body() != null) {

                    Boolean success = response.body().getSuccess();
                    if (success) {
                        view.onCreateOrder(response.body().getMessage());

                    } else {
                        view.onAddError(response.body().getMessage());

                    }

                }
            }

            @Override
            public void onFailure(Call<storeModel> call, Throwable t) {
                String error = "Internet Connection Error...";
                view.onAddError(error);

            }
        });

    }

    public void createInvoice(final String category, final String check) {

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<storeModel> call = apiInterface.createInvoice(category, check);

        call.enqueue(new Callback<storeModel>() {
            @Override
            public void onResponse(Call<storeModel> call, Response<storeModel> response) {

                if (response.isSuccessful() && response.body() != null) {

                    Boolean success = response.body().getSuccess();
                    if (success) {
                        view.onCreateInvoice(response.body().getMessage());

                    } else {
                        view.onAddError(response.body().getMessage());

                    }

                }
            }

            @Override
            public void onFailure(Call<storeModel> call, Throwable t) {
                String error = "Internet Connection Error...";
                view.onAddError(error);

            }
        });

    }

    public void postBill(final String category, final String check, final String check1) {

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<storeModel> call = apiInterface.postBill(category, check, check1);

        call.enqueue(new Callback<storeModel>() {
            @Override
            public void onResponse(Call<storeModel> call, Response<storeModel> response) {

                if (response.isSuccessful() && response.body() != null) {

                    Boolean success = response.body().getSuccess();
                    if (success) {
                        view.onPostBill(response.body().getMessage());

                    } else {
                        view.onAddError(response.body().getMessage());

                    }

                }
            }

            @Override
            public void onFailure(Call<storeModel> call, Throwable t) {
                String error = "Internet Connection Error...";
                view.onAddError(error);

            }
        });

    }

    public void getOrders(final String one, final String two) {
        //view.showLoading();
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<OrdersModel>> call = apiInterface.getOrders(one, two);
        call.enqueue(new Callback<List<OrdersModel>>() {
            @Override
            public void onResponse(Call<List<OrdersModel>> call, Response<List<OrdersModel>> response) {

                //view.hideLoading();
                if (response.isSuccessful() && response.body() != null) {
                    view.GetOrders(response.body());

                }
            }

            public void onFailure(Call<List<OrdersModel>> call, Throwable t) {
                //view.hideLoading();
                String error = "Internet Connection Error...";
                view.onErrorLoading(error);

            }
        });
    }

    public void getInvoices(final String one, final String two) {
        //view.showLoading();
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<InvoicesModel>> call = apiInterface.getInvoices(one, two);
        call.enqueue(new Callback<List<InvoicesModel>>() {
            @Override
            public void onResponse(Call<List<InvoicesModel>> call, Response<List<InvoicesModel>> response) {

                //view.hideLoading();
                if (response.isSuccessful() && response.body() != null) {
                    view.GetInvoices(response.body());

                }
            }

            public void onFailure(Call<List<InvoicesModel>> call, Throwable t) {
                //view.hideLoading();
                String error = "Internet Connection Error...";
                view.onErrorLoading(error);

            }
        });
    }

    public void getBills(final String one, final String two) {
        //view.showLoading();
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<BillsModel>> call = apiInterface.getBills(one, two);
        call.enqueue(new Callback<List<BillsModel>>() {
            @Override
            public void onResponse(Call<List<BillsModel>> call, Response<List<BillsModel>> response) {

                //view.hideLoading();
                if (response.isSuccessful() && response.body() != null) {
                    view.GetBills(response.body());

                }
            }

            public void onFailure(Call<List<BillsModel>> call, Throwable t) {
                //view.hideLoading();
                String error = "Internet Connection Error...";
                view.onErrorLoading(error);

            }
        });
    }

}
