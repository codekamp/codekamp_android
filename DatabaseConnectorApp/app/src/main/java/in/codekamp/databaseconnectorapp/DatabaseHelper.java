package in.codekamp.databaseconnectorapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by cerebro on 01/03/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {


    public DatabaseHelper(Context context) {
        super(context, Database.NAME, null, Database.VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //code to create Database schema
        Log.d("codekamp", "oncreate of database helper called");
        db.execSQL(Database.StudentTable.CREATE_QUERY);


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
