package in.codekamp.databaseconnectorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import in.codekamp.databaseconnectorapp.Database.Database;
import in.codekamp.databaseconnectorapp.Database.StudentCursorWrapper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        StudentCursorWrapper cursor = Database.StudentTable.all(this);


        cursor.moveToFirst();
        Student student1 = cursor.getStudent();


        student1.setEmail("hello@gmail.com");
        student1.save(this);


















    }
}
