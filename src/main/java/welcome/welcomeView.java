
package welcome;

import java.util.List;
import models.loginModel;
import models.usersModel;


public interface welcomeView {

    
    void onErrorLoading(String error);

    void GetUsers(List<usersModel> body);

    public void onAddError(String error);

    public void onUpdateSuccess(String message);
    
}
