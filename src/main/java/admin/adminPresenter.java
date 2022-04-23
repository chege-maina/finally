package admin;

import api.ApiClient;
import api.ApiInterface;
import java.util.List;
import models.BarsaleModel;
import models.customersModel;
import models.percentModel;
import models.saleModel;
import models.storeModel;
import models.suppliersModel;
import models.usersModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class adminPresenter {

    private adminView view;

    public adminPresenter(adminView view) {
        this.view = view;

    }

    public void addUser(final String post_string1) {

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<storeModel> call = apiInterface.addUser(post_string1);

        call.enqueue(new Callback<storeModel>() {
            @Override
            public void onResponse(Call<storeModel> call, Response<storeModel> response) {

                if (response.isSuccessful() && response.body() != null) {

                    Boolean success = response.body().getSuccess();
                    if (success) {
                        view.onAddUserSuccess(response.body().getMessage());

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

    public void getUsers(final String one, final String two) {
        //view.showLoading();
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<usersModel>> call = apiInterface.loadUsers(one, two);
        call.enqueue(new Callback<List<usersModel>>() {
            @Override
            public void onResponse(Call<List<usersModel>> call, Response<List<usersModel>> response) {

                //view.hideLoading();
                if (response.isSuccessful() && response.body() != null) {
                    view.GetUsers(response.body());

                }
            }

            public void onFailure(Call<List<usersModel>> call, Throwable t) {
                //view.hideLoading();
                String error = "Internet Connection Error...";
                view.onErrorLoading(error);

            }
        });
    }

    public void editUser(final String itemdetails, final String code) {

        //view.showProgress();
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<storeModel> call = apiInterface.editUser(itemdetails, code);

        call.enqueue(new Callback<storeModel>() {
            @Override
            public void onResponse(Call<storeModel> call, Response<storeModel> response) {
                //view.hideProgress();

                if (response.isSuccessful() && response.body() != null) {

                    Boolean success = response.body().getSuccess();
                    if (success) {
                        view.onUserUpdateSuccess(response.body().getMessage());

                    } else {
                        view.onAddError(response.body().getMessage());

                    }

                }
            }

            @Override
            public void onFailure(Call<storeModel> call, Throwable t) {
                //view.hideProgress();
                String error = "Internet Connection Error...";
                view.onAddError(error);

            }
        });

    }

    public void brgetSaleCategory() {
        //view.showLoading();
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<saleModel>> call = apiInterface.brloadSaleCategory();
        call.enqueue(new Callback<List<saleModel>>() {
            @Override
            public void onResponse(Call<List<saleModel>> call, Response<List<saleModel>> response) {

                //view.hideLoading();
                if (response.isSuccessful() && response.body() != null) {
                    view.brGetSaleCategory(response.body());

                }
            }

            public void onFailure(Call<List<saleModel>> call, Throwable t) {
                //view.hideLoading();
                String error = "Internet Connection Error...";
                view.onErrorLoading(error);

            }
        });
    }

    public void BarUnit() {
        //view.showLoading();
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<storeModel>> call = apiInterface.BarUnit();
        call.enqueue(new Callback<List<storeModel>>() {
            @Override
            public void onResponse(Call<List<storeModel>> call, Response<List<storeModel>> response) {

                //view.hideLoading();
                if (response.isSuccessful() && response.body() != null) {
                    view.GetBarUnit(response.body());
                }
            }

            public void onFailure(Call<List<storeModel>> call, Throwable t) {
                //view.hideLoading();
                String error = "Internet Connection Error...";
                view.onErrorLoading(error);

            }
        });
    }
    
     public void Origin() {
        //view.showLoading();
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<storeModel>> call = apiInterface.Origin();
        call.enqueue(new Callback<List<storeModel>>() {
            @Override
            public void onResponse(Call<List<storeModel>> call, Response<List<storeModel>> response) {

                //view.hideLoading();
                if (response.isSuccessful() && response.body() != null) {
                    view.GetOrigin(response.body());
                }
            }

            public void onFailure(Call<List<storeModel>> call, Throwable t) {
                //view.hideLoading();
                String error = "Internet Connection Error...";
                view.onErrorLoading(error);

            }
        });
    }
     
     public void SalesRep() {
        //view.showLoading();
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<storeModel>> call = apiInterface.SalesRep();
        call.enqueue(new Callback<List<storeModel>>() {
            @Override
            public void onResponse(Call<List<storeModel>> call, Response<List<storeModel>> response) {

                //view.hideLoading();
                if (response.isSuccessful() && response.body() != null) {
                    view.GetRep(response.body());
                }
            }

            public void onFailure(Call<List<storeModel>> call, Throwable t) {
                //view.hideLoading();
                String error = "Internet Connection Error...";
                view.onErrorLoading(error);

            }
        });
    }

    public void addCategory(final String category, final String check) {

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<storeModel> call = apiInterface.addCategory(category, check);

        call.enqueue(new Callback<storeModel>() {
            @Override
            public void onResponse(Call<storeModel> call, Response<storeModel> response) {

                if (response.isSuccessful() && response.body() != null) {

                    Boolean success = response.body().getSuccess();
                    if (success) {
                        view.onAddCatSuccess(response.body().getMessage());

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

    public void brgetStoreItemList(final String check, final String value) {
        //view.showLoading();
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<BarsaleModel>> call = apiInterface.brloadSaleItems(check, value);
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

    public void addSaleItem_bar(final String one) {

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<saleModel> call = apiInterface.braddSaleItems(one);

        call.enqueue(new Callback<saleModel>() {
            @Override
            public void onResponse(Call<saleModel> call, Response<saleModel> response) {

                if (response.isSuccessful() && response.body() != null) {

                    Boolean success = response.body().getSuccess();
                    if (success) {
                        view.onAddBarSaleItemSuccess(response.body().getMessage());

                    } else {
                        view.onAddError(response.body().getMessage());

                    }

                }
            }

            @Override
            public void onFailure(Call<saleModel> call, Throwable t) {
                String error = "Internet Connection Error...";
                view.onAddError(error);

            }
        });

    }

    public void addSupplier(final String one) {

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<saleModel> call = apiInterface.addSupplier(one);

        call.enqueue(new Callback<saleModel>() {
            @Override
            public void onResponse(Call<saleModel> call, Response<saleModel> response) {

                if (response.isSuccessful() && response.body() != null) {

                    Boolean success = response.body().getSuccess();
                    if (success) {
                        view.onAddSupplier(response.body().getMessage());

                    } else {
                        view.onAddError(response.body().getMessage());

                    }

                }
            }

            @Override
            public void onFailure(Call<saleModel> call, Throwable t) {
                String error = "Internet Connection Error...";
                view.onAddError(error);

            }
        });

    }
    
    public void addCustomer(final String one) {

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<saleModel> call = apiInterface.addCustomer(one);

        call.enqueue(new Callback<saleModel>() {
            @Override
            public void onResponse(Call<saleModel> call, Response<saleModel> response) {

                if (response.isSuccessful() && response.body() != null) {

                    Boolean success = response.body().getSuccess();
                    if (success) {
                        view.onAddCustomer(response.body().getMessage());

                    } else {
                        view.onAddError(response.body().getMessage());

                    }

                }
            }

            @Override
            public void onFailure(Call<saleModel> call, Throwable t) {
                String error = "Internet Connection Error...";
                view.onAddError(t.toString());

            }
        });

    }

    public void addPercent(final String one) {
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<saleModel> call = apiInterface.addPercent(one);

        call.enqueue(new Callback<saleModel>() {
            @Override
            public void onResponse(Call<saleModel> call, Response<saleModel> response) {

                if (response.isSuccessful() && response.body() != null) {

                    Boolean success = response.body().getSuccess();
                    if (success) {
                        view.onAddPercent(response.body().getMessage());

                    } else {
                        view.onAddError(response.body().getMessage());

                    }

                }
            }

            @Override
            public void onFailure(Call<saleModel> call, Throwable t) {
                String error = "Internet Connection Error...";
                view.onAddError(error);

            }
        });

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

    public void getPercent(final String one, final String two) {
        //view.showLoading();
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<percentModel>> call = apiInterface.getPercent(one, two);
        call.enqueue(new Callback<List<percentModel>>() {
            @Override
            public void onResponse(Call<List<percentModel>> call, Response<List<percentModel>> response) {

                //view.hideLoading();
                if (response.isSuccessful() && response.body() != null) {
                    view.GetPercent(response.body());

                }
            }

            public void onFailure(Call<List<percentModel>> call, Throwable t) {
                //view.hideLoading();
                String error = "Internet Connection Error...";
                view.onErrorLoading(error);

            }
        });
    }

}
