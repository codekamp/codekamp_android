package in.codekamp.databaseconnectorapp.Database;

import android.database.Cursor;
import android.database.CursorWrapper;
import android.util.Log;

import in.codekamp.databaseconnectorapp.Student;

/**
 * Created by cerebro on 19/04/16.
 */
public class StudentCursorWrapper extends CursorWrapper {
    /**
     * Creates a cursor wrapper.
     *
     * @param cursor The underlying cursor to wrap.
     */
    public StudentCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Student getStudent() {

        int idIndex = getColumnIndex("id");
        int nameIndex = getColumnIndex("name");
        int emailIndex = getColumnIndex("email");


        return new Student(getString(nameIndex), getString(emailIndex), getInt(idIndex));
    }
}
