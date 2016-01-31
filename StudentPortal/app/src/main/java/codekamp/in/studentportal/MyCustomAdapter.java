package codekamp.in.studentportal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by cerebro on 31/01/16.
 */
public class MyCustomAdapter extends BaseAdapter {

    List<Student> data;
    LayoutInflater inflater;

    public MyCustomAdapter(Context context, List<Student> students) {
        this.data = students;

        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.student_list_item, null);

        TextView studentNameTextView = (TextView)view.findViewById(R.id.name_text_view);
        TextView attendanceTextView = (TextView)view.findViewById(R.id.attendance_text_view);

        Student student = data.get(position);

        studentNameTextView.setText(student.name);
        attendanceTextView.setText(Double.toString(student.attendance));

        return view;
    }
}
