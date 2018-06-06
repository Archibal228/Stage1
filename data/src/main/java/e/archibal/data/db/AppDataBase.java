package e.archibal.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import e.archibal.data.entity.User;

/**
 * Created by Archibal on 30.03.2018.
 */
@Database(entities = {User.class},version = 1)
public abstract class AppDataBase extends RoomDatabase {

  public   abstract UserDao getUserDao();




}
