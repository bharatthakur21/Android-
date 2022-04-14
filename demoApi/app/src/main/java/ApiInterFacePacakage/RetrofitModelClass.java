package ApiInterFacePacakage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitModelClass {

    private static final String url = "http://13.56.178.203:8889/customer/";

    private static final OkHttpClient httpClient = new OkHttpClient.Builder()
            .connectTimeout(2, TimeUnit.MINUTES)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS).build();

    private static final Gson gson = new GsonBuilder().setLenient().create();



    private static final Retrofit.Builder builder = new Retrofit.Builder().baseUrl(url);
    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder.client(httpClient).
                addConverterFactory(GsonConverterFactory.create(gson)).
                build();
        return retrofit.create(serviceClass);
    }
}
