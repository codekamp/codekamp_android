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

        DatabaseHelper dbHelper = new DatabaseHelper(this);

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", "Suresh");
        values.put("email", "suresh@5star.com");

        long id = db.insert(DatabaseHelper.STUDENTS_TABLE, null, values);
        Log.d("codekamp", "id of inserted column is " + id);

        ContentValues values1 = new ContentValues();
        values1.put("name", "Ramesh");
        values1.put("email", "ramesh@5star.com");

        long id1 = db.insert(DatabaseHelper.STUDENTS_TABLE, null, values1);
        Log.d("codekamp", "id of inserted column is " + id1);



















        String[] columns = {"name", "email"};
        Cursor cursor = db.query(DatabaseHelper.STUDENTS_TABLE, columns, null, null, null, null, null);

        int nameIndex = cursor.getColumnIndex("name");
        int emailIndex = cursor.getColumnIndex("email");
        while (cursor.moveToNext()) {
            Log.d("codekamp", "name: " + cursor.getString(nameIndex) + ", email:" + cursor.getString(emailIndex));
        }
    }
}
