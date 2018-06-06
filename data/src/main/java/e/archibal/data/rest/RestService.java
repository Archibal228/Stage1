package e.archibal.data.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import e.archibal.data.entity.Error;
import e.archibal.data.entity.User;
import io.reactivex.Completable;
import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Archibal on 19.03.2018.
 */
@Singleton
public class RestService {
    private RestApi restApi;

    private ErrorTransformers errorTransformers;

    @Inject
    public RestService(RestApi restApi, ErrorTransformers errorTransformers ) {
        this.errorTransformers = errorTransformers;
    this.restApi = restApi;

    }
    public Observable<List<User>> loadUsers() {
        return restApi.loadUsers()
                .compose(errorTransformers.<List<User>,Error>parseHttpError());
    }
    public  Observable<User> loadUserById(String id){
        return restApi.loadUserById(id).compose(errorTransformers.<User,Error>parseHttpError());
    }
    public Completable saveUser(User user) {
        return restApi.saveUser(user);
    }

    public Completable removeUser(String id) {
        return restApi.removeUser(id);
    }
}

