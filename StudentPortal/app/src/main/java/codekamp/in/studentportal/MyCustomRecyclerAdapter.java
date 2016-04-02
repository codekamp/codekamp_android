package codekamp.in.studentportal;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by cerebro on 13/03/16.
 */
public class MyCustomRecyclerAdapter extends RecyclerView.Adapter<StudentInfoViewHolder> {

    List<Student> data;

    public MyCustomRecyclerAdapter(List<Student> students) {
        super();

        this.data = students;
    }

    @Override
    public StudentInfoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.student_list_item, parent, false);

        Log.d("codekamp", "new view holder created");

        return new StudentInfoViewHolder(v);


    }

    @Override
    public void onBindViewHolder(StudentInfoViewHolder holder, int position) {

        Student student = data.get(position);

        holder.studentNameTextView.setText(student.name);
        holder.attendanceTextView.setText(Double.toString(student.attendance));
    }

    @Override
    public int getItemCount() {
        return this.data.size();
    }


}
