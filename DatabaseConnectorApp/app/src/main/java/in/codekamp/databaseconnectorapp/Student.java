package in.codekamp.databaseconnectorapp;

import android.support.annotation.Nullable;

/**
 * Created by cerebro on 12/04/16.
 */
public class Student {
    private String name;
    private String email;
    private int id;

    public Student(String name, @Nullable String email, int id) {
        this.name = name;
        this.email = email;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }
}
