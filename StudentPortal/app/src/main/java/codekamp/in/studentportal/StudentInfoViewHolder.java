package codekamp.in.studentportal;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by cerebro on 13/03/16.
 */
public class StudentInfoViewHolder extends RecyclerView.ViewHolder {

    public TextView studentNameTextView;
    public TextView attendanceTextView;

    public StudentInfoViewHolder(View itemView) {
        super(itemView);

        studentNameTextView = (TextView)itemView.findViewById(R.id.name_text_view);
        attendanceTextView = (TextView)itemView.findViewById(R.id.attendance_text_view);
    }
}
