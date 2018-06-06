package e.archibal.data.rest;

import java.util.List;

import e.archibal.data.entity.User;
import io.reactivex.Completable;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Archibal on 19.03.2018.
 */

public interface RestApi {
    @GET("data/ListUser")
    Observable<List<User>> loadUsers();

    @GET("data/ListUser/{id}")
    Observable<User> loadUserById(@Path("id") String id);

    @PUT("data/ListUser")
    Completable saveUser(@Body User user);

    @DELETE("data/ListUser/{id}")
    Completable removeUser(@Path("id") String id);

}
