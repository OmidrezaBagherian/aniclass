package ir.omidrezabagherian.aniclass.retrofit;

import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class AniclassRetrofit {

  public static String BASE_URL = "https://omidcoder21.ir";
  public static Retrofit retrofit = null ;

  private AniclassRetrofit() { }

  public static synchronized <T> T getApi(Class<T> clazz) {
    if (retrofit == null) {
      retrofit = new Retrofit
        .Builder()
        .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .baseUrl(BASE_URL)
        .client(getLoggingIntecepter())
        .build();
    }

    return retrofit.create(clazz);
  }


  private static OkHttpClient getLoggingIntecepter() {
    HttpLoggingInterceptor http = new HttpLoggingInterceptor();
    http.setLevel(HttpLoggingInterceptor.Level.BODY);

    return new OkHttpClient
      .Builder()
      .addInterceptor(http)
      .connectTimeout(60 , TimeUnit.SECONDS)
      .writeTimeout(40 , TimeUnit.SECONDS)
      .readTimeout(40 , TimeUnit.SECONDS)
      .build();
  }

}
