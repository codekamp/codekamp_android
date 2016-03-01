package in.codekamp.databaseconnectorapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by cerebro on 01/03/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "codekamp";
    public static final String STUDENTS_TABLE = "students";
    private static final int VERSION = 4;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //code to create Database schema
        Log.d("codekamp", "oncreate of database helper called");
        db.execSQL("CREATE TABLE " + STUDENTS_TABLE + " ( _id INT PRIMARY KEY, name VARCHAR(255) NOT NULL, email VARCHAR(255) );");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("codekamp", "ONUPGRADE of database helper called");
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }
}
