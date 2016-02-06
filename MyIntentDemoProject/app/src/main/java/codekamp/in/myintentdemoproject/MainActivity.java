package codekamp.in.myintentdemoproject;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String[] colleges = {"Stanford", "AKGEC", "ABESEC"};
    String[] branches = {"CS", "IT", "EC", "Civil"};

    TextView collegeNameTextView;
    TextView branchNameTextView;

    private static final int COLLEGE_SELECTION_REQUEST = 0;
    private static final int BRANCH_SELECTION_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        collegeNameTextView = (TextView)findViewById(R.id.collgeTextView);
        branchNameTextView = (TextView)findViewById(R.id.branchTextView);
    }

    public void chooseCollege(View view) {

        Intent i = new Intent(this, MyListActivity.class);
        i.putExtra(MyListActivity.ITEM_KEY, colleges);

        startActivityForResult(i, COLLEGE_SELECTION_REQUEST);


    }

    public void chooseBranch(View view) {

        Intent i = new Intent(this, MyListActivity.class);
        i.putExtra(MyListActivity.ITEM_KEY, branches);
        startActivityForResult(i, BRANCH_SELECTION_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == COLLEGE_SELECTION_REQUEST) {
            if(resultCode == Activity.RESULT_CANCELED) {
                Toast toast = Toast.makeText(this, "You should have selected college. Now prepare to die!", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP, 0, 100);
                toast.show();
            } else if(resultCode == Activity.RESULT_OK) {

                int index = data.getIntExtra(MyListActivity.SELECTED_ITEM_INDEX, 0);
                String selectedCollege = colleges[index];
                collegeNameTextView.setText(selectedCollege);
            }


        } else if (requestCode == BRANCH_SELECTION_REQUEST) {


            if(resultCode == Activity.RESULT_CANCELED) {
                Toast toast = Toast.makeText(this, "You should have selected branch. Now prepare to die!", Toast.LENGTH_SHORT);
                toast.show();
            } else if(resultCode == Activity.RESULT_OK) {

                int index = data.getIntExtra(MyListActivity.SELECTED_ITEM_INDEX, 0);
                String selectedBranch = branches[index];
                branchNameTextView.setText(selectedBranch);
            }
        }
    }
}
