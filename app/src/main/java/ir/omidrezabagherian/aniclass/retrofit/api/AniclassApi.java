package ir.omidrezabagherian.aniclass.retrofit.api;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

interface AniclassApi {

  @GET("/api/v1/")
  Observable<Object> testApi();

}
