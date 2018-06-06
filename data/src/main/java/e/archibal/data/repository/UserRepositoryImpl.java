package e.archibal.data.repository;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import e.archibal.data.db.AppDataBase;
import e.archibal.data.db.UserDao;
import e.archibal.data.entity.User;
import e.archibal.data.rest.RestService;
import e.archibal.domain.entity.UserEntity;
import e.archibal.domain.repository.UserRepository;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by Archibal on 16.03.2018.
 */

public class UserRepositoryImpl implements UserRepository  {
    private Context context;
    private RestService restService;
    private UserDao userDao;


    public UserRepositoryImpl(Context context, RestService restService,AppDataBase dataBase) {

        this.context = context;
        this.restService = restService;
        this.userDao = dataBase.getUserDao();
    }


//    public Flowable<List<UserEntity>> get(){
//        return
//
//                restService.loadUsers()
//                        .doOnNext(new Consumer<List<User>>() {
//                            @Override
//                            public void accept(List<User> userList) throws Exception {
//                                userDao.deleteAll();
//                                userDao.insert(userList);
//                            }
//                        })
//                .onErrorResumeNext(new Function<Throwable, ObservableSource<? extends List<User>>>() {
//                    @Override
//                    public ObservableSource<? extends List<User>> apply(Throwable throwable) throws Exception {
//                        return userDao.getAll().toObservable().take(1);
//                    }
//                })
//                .map(new Function<List<User>, List<UserEntity>>() {
//                    @Override
//                    public List<UserEntity> apply(List<User> userList) throws Exception {
//                        List<UserEntity> list = new ArrayList<>();
//                        for (User user: userList
//                             ) {list.add(new UserEntity(user.getUsername(),user.getProfileUrl(),user.getAge(),user.getObjectId()));
//
//                        }
//                        return list;
//                    }
//                });
//    }


    @Override
    public Observable<UserEntity> getUser(String id) {
        return null;
    }

    @Override
    public Observable<List<UserEntity>> getUsers() {
        return restService.loadUsers().map(new Function<List<User>, List<UserEntity>>() {
            @Override
            public List<UserEntity> apply(List<User> users) throws Exception {
                List<UserEntity> list = new ArrayList<>();
                for (User u : users) {
                    list.add(new UserEntity(u.getUsername(), u.getProfileUrl(), u.getAge(), u.getObjectId(), u.isGender()));
                }
                return list;
            }
                });
    }

    @Override
    public Completable save(UserEntity userEntity) {
        User user = new User("sdads",14,"dadfa",true);
        user.setUsername(userEntity.getUserName());
        user.setProfileUrl(userEntity.getUrl());
        user.setAge(userEntity.getAge());
        user.setObjectId(userEntity.getId());
        return restService.saveUser(user);
    }

    @Override
    public Completable remove(String id) {
        return restService.removeUser(id);
    }
}


