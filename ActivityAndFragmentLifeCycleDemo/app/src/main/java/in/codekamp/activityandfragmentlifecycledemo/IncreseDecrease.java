package in.codekamp.activityandfragmentlifecycledemo;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class IncreseDecrease extends Fragment implements View.OnClickListener {

    private static final String CURRENT_VALUE = "current_value";


    private int currentValue;
    private TextView textView;
    private Button decreaseButton;
    private Button increaseButton;

    private IncreaseDecraseListner listener;


    public IncreseDecrease() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof IncreaseDecraseListner) {
            listener = (IncreaseDecraseListner)context;
        } else {
            throw new RuntimeException("Activity using IncreseDecrease fragement should implement IncreaseDecraseListner interface");
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if(activity instanceof IncreaseDecraseListner) {
            listener = (IncreaseDecraseListner)activity;
        } else {
            throw new RuntimeException("Activity using IncreseDecrease fragement should implement IncreaseDecraseListner interface");
        }
    }

    public static IncreseDecrease newInstance(int currentValue) {
        IncreseDecrease fragment = new IncreseDecrease();
        Bundle args = new Bundle();
        args.putInt(CURRENT_VALUE, currentValue);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            currentValue = getArguments().getInt(CURRENT_VALUE);
            Log.d("codekamp", "hello world! " + currentValue);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_increse_decrease, container, false);

        textView = (TextView)view.findViewById(R.id.counter);
        decreaseButton = (Button)view.findViewById(R.id.decrease_button);
        increaseButton = (Button)view.findViewById(R.id.increase_button);

        decreaseButton.setOnClickListener(this);
        increaseButton.setOnClickListener(this);
        textView.setText(Integer.toString(currentValue));

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        getArguments().putInt(CURRENT_VALUE, currentValue);
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.increase_button) {
            currentValue++;
        } else {
            currentValue--;
        }
        textView.setText(Integer.toString(currentValue));

        listener.selectedValue(currentValue, getTag());

    }

    public interface IncreaseDecraseListner {
        public void selectedValue(int value, String tag);
    }
}
