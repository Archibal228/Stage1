package e.archibal.domain.entity;

/**
 * Created by Archibal on 12.03.2018.
 */

public class UserEntity {

    private String userName;
    private String url;
    private int age;
    private String id;
    private Boolean gender;

    public UserEntity(String userName, String url, int age, String id, Boolean gender) {
        this.userName = userName;
        this.url = url;
        this.age = age;
        this.id = id;
        this.gender = gender;
    }

    public String getUserName() {
        return userName;
    }

    public String getUrl() {
        return url;
    }

    public int getAge() {
        return age;
    }

    public String getId() {
        return id;
    }
}
