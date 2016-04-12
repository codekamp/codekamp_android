package in.codekamp.databaseconnectorapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;

import java.util.List;

/**
 * Created by cerebro on 12/04/16.
 */
public class Database {

    public static final String NAME = "codekamp";
    public static final int VERSION = 4;

    public static class StudentTable {

        public static final String NAME = "students";
        public static final String CREATE_QUERY = "CREATE TABLE " + NAME + " ( _id INT PRIMARY KEY, " + Columns.NAME +" VARCHAR(255) NOT NULL, " + Columns.EMAIL+ " VARCHAR(255)  )";

        public static class Columns {
            public static final String ID = "_id";
            public static final String NAME = "name";
            public static final String EMAIL = "email";
            public static final String AGE = "age";
        }

        public static ContentValues getContentValues(String name, String email) {
            ContentValues values = new ContentValues();
            values.put(Columns.NAME, name);
            values.put(Columns.EMAIL, email);

            return values;
        }

        public static ContentValues getContentValues(String name) {
            return getContentValues(name, null);
        }

        public static long insert(Context context, String name, String email) {
            DatabaseHelper dbHelper = new DatabaseHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            return db.insert(NAME, null, getContentValues(name, email));
        }

        public static boolean update(Context context, long studentId, String newName, String neEmail) {
            return false;
        }


        public static boolean update(Context context, String whereClause, String[] whereArgs, String newName, String newEmail) {
            return false;
        }

        public static boolean delete(Context context, long studentId) {
            return false;
        }

        public static List<Student> query(Context context, String whereClause, String[] whereArgs, String orderBy) {
            return null;
        }

        public static List<Student> all(Context context, String orderBy) {
            return null;
        }

    }

    public static class FacultyTable {
        public static final String NAME = "faculties";
    }
}
