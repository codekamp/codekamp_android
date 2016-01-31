package codekamp.in.studentportal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView studentListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Student> students = new ArrayList<>();

        students.add(new Student("Suresh", "AKGEC001", 75.5));
        students.add(new Student("Ramesh", "ABES003", 85.5));



        studentListView = (ListView)findViewById(R.id.studentListView);

        MyCustomAdapter adapter = new MyCustomAdapter(this, students);

        studentListView.setAdapter(adapter);


    }
}
