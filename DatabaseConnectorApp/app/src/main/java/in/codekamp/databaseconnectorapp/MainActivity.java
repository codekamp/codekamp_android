package in.codekamp.databaseconnectorapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        long studentId = Database.StudentTable.insert(this, "suresh", "suresh@gmail.com");

        Database.StudentTable.delete(this, studentId);

















        String[] columns = {"name", "email"};
        Cursor cursor = db.query(DatabaseHelper.STUDENTS_TABLE, columns, null, null, null, null, null);

        int nameIndex = cursor.getColumnIndex("name");
        int emailIndex = cursor.getColumnIndex("email");
        while (cursor.moveToNext()) {
            Log.d("codekamp", "name: " + cursor.getString(nameIndex) + ", email:" + cursor.getString(emailIndex));
        }
    }
}
