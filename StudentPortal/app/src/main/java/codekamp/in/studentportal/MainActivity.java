package codekamp.in.studentportal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.MotionEvent;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerView.OnItemTouchListener {

    RecyclerView studentRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Student> students = new ArrayList<>();

        students.add(new Student("Suresh", "AKGEC001", 75.5));
        students.add(new Student("Ramesh", "ABES003", 85.5));
        students.add(new Student("Suresh", "AKGEC001", 75.5));
        students.add(new Student("Ramesh", "ABES003", 85.5));
        students.add(new Student("Suresh", "AKGEC001", 75.5));
        students.add(new Student("Ramesh", "ABES003", 85.5));
        students.add(new Student("Suresh", "AKGEC001", 75.5));
        students.add(new Student("Ramesh", "ABES003", 85.5));
        students.add(new Student("Suresh", "AKGEC001", 75.5));
        students.add(new Student("Ramesh", "ABES003", 85.5));
        students.add(new Student("Suresh", "AKGEC001", 75.5));
        students.add(new Student("Ramesh", "ABES003", 85.5));
        students.add(new Student("Suresh", "AKGEC001", 75.5));
        students.add(new Student("Ramesh", "ABES003", 85.5));
        students.add(new Student("Suresh", "AKGEC001", 75.5));
        students.add(new Student("Ramesh", "ABES003", 85.5));
        students.add(new Student("Suresh", "AKGEC001", 75.5));
        students.add(new Student("Ramesh", "ABES003", 85.5));
        students.add(new Student("Suresh", "AKGEC001", 75.5));
        students.add(new Student("Ramesh", "ABES003", 85.5));
        students.add(new Student("Suresh", "AKGEC001", 75.5));
        students.add(new Student("Ramesh", "ABES003", 85.5));
        students.add(new Student("Suresh", "AKGEC001", 75.5));
        students.add(new Student("Ramesh", "ABES003", 85.5));
        students.add(new Student("Suresh", "AKGEC001", 75.5));
        students.add(new Student("Ramesh", "ABES003", 85.5));
        students.add(new Student("Suresh", "AKGEC001", 75.5));
        students.add(new Student("Ramesh", "ABES003", 85.5));
        students.add(new Student("Suresh", "AKGEC001", 75.5));
        students.add(new Student("Ramesh", "ABES003", 85.5));
        students.add(new Student("Suresh", "AKGEC001", 75.5));
        students.add(new Student("Ramesh", "ABES003", 85.5));
        students.add(new Student("Suresh", "AKGEC001", 75.5));
        students.add(new Student("Ramesh", "ABES003", 85.5));
        students.add(new Student("Suresh", "AKGEC001", 75.5));
        students.add(new Student("Ramesh", "ABES003", 85.5));
        students.add(new Student("Suresh", "AKGEC001", 75.5));
        students.add(new Student("Ramesh", "ABES003", 85.5));
        students.add(new Student("Suresh", "AKGEC001", 75.5));
        students.add(new Student("Ramesh", "ABES003", 85.5));



        studentRecyclerView = (RecyclerView)findViewById(R.id.studentRecyclerView);

        studentRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        MyCustomRecyclerAdapter adapter = new MyCustomRecyclerAdapter(students);

        studentRecyclerView.setAdapter(adapter);

        studentRecyclerView.addOnItemTouchListener(this);




    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
