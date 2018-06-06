package e.archibal.data.rest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.SocketTimeoutException;

import javax.inject.Singleton;

import e.archibal.data.entity.Error;
import e.archibal.data.entity.ErrorType;
import io.reactivex.FlowableTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Function;
import retrofit2.HttpException;

/**
 * Created by Archibal on 02.04.2018.
 */
@Singleton
public class ErrorTransformers {

   private Gson gson;

    public ErrorTransformers(Gson gson) {
        this.gson = gson;
    }

    public <Model, ErrorTrowable extends Error> ObservableTransformer<Model,Model> parseHttpError(){

        return new ObservableTransformer<Model,Model>(){
            @Override
            public ObservableSource<Model> apply(Observable<Model> upstream) {

             return upstream.onErrorResumeNext(new Function<Throwable, ObservableSource<? extends Model>>() {
                @Override
                public ObservableSource<? extends Model> apply(Throwable throwable) throws Exception {


                    if(throwable instanceof SocketTimeoutException) {
                        return Observable.error(new Error(ErrorType.Server_Not_Available));
                    }else if(throwable instanceof HttpException){
                        HttpException httpException = (HttpException) throwable;

                        String bodyError =  (String)httpException.response().body();
                        Type errorType = new TypeToken<ErrorTrowable>(){}.getType();
                        ErrorTrowable trowable = gson.fromJson(bodyError,errorType);
                        return Observable.error(new Error(ErrorType.Server_Error));
                    }else if(throwable instanceof IOException){
                        return Observable.error(new Error(ErrorType.No_Internet));

                    }else {

                        return Observable.error(new Error(ErrorType.Unknown));

                    }

                }
            });


            }
        };

    }

}
