package e.archibal.domain.repository;


import java.util.List;

import e.archibal.domain.entity.UserEntity;
import io.reactivex.Completable;
import io.reactivex.Observable;

public interface UserRepository {

    Observable<UserEntity> getUser(String id);

    Observable<List<UserEntity>> getUsers();

    Completable save(UserEntity userEntity);

    Completable remove(String id);

}
