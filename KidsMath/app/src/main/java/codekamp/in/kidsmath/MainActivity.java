package codekamp.in.kidsmath;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText kisKaEditText;
    EditText kahanTakEditText;
    Button submitButton;
    ListView pahadaListView;

    List<String> items = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kisKaEditText = (EditText)findViewById(R.id.kis_ka_edit_text);
        kahanTakEditText = (EditText)findViewById(R.id.kahan_tak_edit_text);
        submitButton = (Button)findViewById(R.id.submit_button);
        pahadaListView = (ListView)findViewById(R.id.pahada_view);


        submitButton.setOnClickListener(this);


        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);

        pahadaListView.setAdapter(adapter);


    }

    @Override
    public void onClick(View v) {

        int kisKa = Integer.parseInt(kisKaEditText.getText().toString());
        int kahanTak = Integer.parseInt(kahanTakEditText.getText().toString());

        items.clear();

        for(int i = 1; i <= kahanTak; i++) {
            items.add(kisKa + " X " + i + " = " + kisKa * i);
        }

        adapter.notifyDataSetChanged();

    }
}
