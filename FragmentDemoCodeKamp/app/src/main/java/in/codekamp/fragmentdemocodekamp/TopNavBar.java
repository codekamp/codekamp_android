package in.codekamp.fragmentdemocodekamp;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class TopNavBar extends Fragment implements View.OnClickListener {

    TopNavBarListner listner;


    public TopNavBar() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View view = inflater.inflate(R.layout.top_nav_bar, container, false);

        view.findViewById(R.id.button1).setOnClickListener(this);
        view.findViewById(R.id.button2).setOnClickListener(this);
        view.findViewById(R.id.button3).setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.button1) {
            listner.tabSelected(0);
        } else if(v.getId() == R.id.button2) {
            listner.tabSelected(1);
        } else if(v.getId() == R.id.button3) {
            listner.tabSelected(2);
        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof TopNavBarListner) {
            this.listner = (TopNavBarListner)context;
        } else {
            throw new RuntimeException("Activity not implmenting TopNavBarListner interface");
        }
    }

    public interface TopNavBarListner {

        public void tabSelected(int index);

    }

}


