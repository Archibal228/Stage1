package e.archibal.data.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Archibal on 19.03.2018.
 */
@Entity(tableName = "User")
public class User {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    @SerializedName("objectId")
    private String objectId;
    @SerializedName("username")
    private String username;
    @SerializedName("age")
    private int age;
    @SerializedName("profileUrl")
    private String profileUrl;
    @SerializedName("gender")
    private boolean gender;
    public User(String username, int age, String profileUrl, boolean gender){
        this.username = username;
        this.age = age;
        this.profileUrl = profileUrl;
        this.gender = gender;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getObjectId() {
        return objectId;

    }

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }

    public String getProfileUrl() {
        return profileUrl;
    }
}
