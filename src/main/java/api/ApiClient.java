/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 * @author mohware
 */
public class ApiClient {

    //private static final String BASE_URL = "http://localhost:80/kelmo/";//www.bact.ac.ke/aberdarehttp://www.severinombae.net/hilljoint/
    //private static final String BASE_URL = "http://www.severinombae.net/kelmo/";
    //private static final String BASE_URL = "http://192.168.0.251:80/kelmo/";
    private static final String BASE_URL = "http://www.twistyscocktails.com/apps/finally/";
    //private static final String BASE_URL = "http://localhost:80/apps/finally/";
    private static Retrofit retrofit;

    public static Retrofit getApiClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }

}
