package e.archibal.data.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import e.archibal.data.entity.User;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Observable;

/**
 * Created by Archibal on 30.03.2018.
 */
@Dao
public interface UserDao {
    @Insert
    void insert(List<User> userList);
    @Query("Select* From User")
    Flowable<List<User>> getAll();

    @Query("Select* From User Where id = :id Limit 1")
    Flowable<List<User>> getById(String id);
@Query("Delete FROM User")
     void deleteAll();



}
