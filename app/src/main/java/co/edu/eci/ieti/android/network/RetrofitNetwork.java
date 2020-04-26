package co.edu.eci.ieti.android.network;

import java.io.IOException;
import java.util.List;

import co.edu.eci.ieti.android.network.service.AuthService;
import co.edu.eci.ieti.android.network.service.TaskService;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Santiago Carrillo
 * 4/23/19.
 */
public class RetrofitNetwork
{

    private static final HttpUrl BASE_URL = null;
    private AuthService authService;


    public RetrofitNetwork()
    {
        Retrofit retrofit = new Retrofit.Builder().baseUrl( "http:/10.0.2.2:8080/" ) //localhost for emulator
            .addConverterFactory( GsonConverterFactory.create() ).build();

        authService = retrofit.create( AuthService.class );
    }
    
    public RetrofitNetwork( final String token )
    {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor( new Interceptor()
        {
            @Override
            public okhttp3.Response intercept( Chain chain )
                    throws IOException
            {
                Request original = chain.request();

                Request request = original.newBuilder().header( "Accept", "application/json" ).header( "Authorization",
                        "Bearer "
                                + token ).method(
                        original.method(), original.body() ).build();
                return chain.proceed( request );
            }
        } );
        Retrofit retrofit =
                new Retrofit.Builder().baseUrl( BASE_URL ).addConverterFactory( GsonConverterFactory.create() ).client(
                        httpClient.build() ).build();

        TaskService ts = new TaskService() {
            @Override
            public List getTaskList() {
                return null;
            }
        };

    }
    
    public AuthService getAuthService()
    {
        return authService;
    }
}
