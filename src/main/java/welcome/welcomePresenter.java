package welcome;

import api.ApiClient;
import api.ApiInterface;
import java.util.List;
import models.loginModel;
import models.usersModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *
 * @author mohware
 */
public class welcomePresenter {

    private welcomeView view;

    public welcomePresenter(welcomeView view) {
        this.view = view;

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

    public void updateUser(final String post_string1, final String post_string2) {

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<usersModel> call = apiInterface.updateUsers(post_string1, post_string2);

        call.enqueue(new Callback<usersModel>() {
            @Override
            public void onResponse(Call<usersModel> call, Response<usersModel> response) {

                if (response.isSuccessful() && response.body() != null) {

                    Boolean success = response.body().getSuccess();
                    if (success) {
                        view.onUpdateSuccess(response.body().getMessage());

                    } else {
                        view.onAddError(response.body().getMessage());

                    }

                }
            }

            @Override
            public void onFailure(Call<usersModel> call, Throwable t) {
                String error = "Internet Connection Error...";
                view.onAddError(error);

            }
        });

    }

}
