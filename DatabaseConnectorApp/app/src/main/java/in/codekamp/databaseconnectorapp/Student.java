package in.codekamp.databaseconnectorapp;

import android.content.Context;

import in.codekamp.databaseconnectorapp.Database.Database;

/**
 * Created by cerebro on 12/04/16.
 */
public class Student {
    private String name;
    private String email;
    private long id = 0;

    public Student(String name, String email, int id) {
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

    public long getId() {
        return id;
    }

    public void save(Context context) {
        if(this.getId() == 0) {
            this.id = Database.StudentTable.insert(context, getName(), getEmail());
        } else {
            Database.StudentTable.update(context, getId(), getName(), getEmail());
        }
    }
}
