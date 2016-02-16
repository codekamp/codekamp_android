package codekamp.in.kidsmath;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

    private int kisKa = 0;
    private int kahanTak = 0;

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

        if(savedInstanceState != null) {
            Log.d("codekamp", "bundle not null");
            Log.d("codekamp", "kis_ka in bundle: " + savedInstanceState.getInt("kis_ka"));
            Log.d("codekamp", "kahan_tak in bundle: " + savedInstanceState.getInt("kahan_tak"));
        }


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);


        if(this.kisKa > 0 && this.kahanTak > 0) {
            outState.putInt("kis_ka", this.kisKa);
            outState.putInt("kahan_tak", this.kahanTak);

            Log.d("codekamp", "Saved Data to Bundle");
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        this.kisKa = savedInstanceState.getInt("kis_ka", 0);
        this.kahanTak = savedInstanceState.getInt("kahan_tak", 0);

        if(this.kisKa > 0 && this.kahanTak > 0) {
            this.showPahada();
        }
    }

    @Override
    public void onClick(View v) {


        Intent i = new Intent(this, RelativeLayoutDemo.class);
        i.putExtra("my_data_key", "CodeKamp data");
        i.putExtra("roll_number", 1001);
        startActivityForResult(i, 1);


//        this.kisKa = Integer.parseInt(kisKaEditText.getText().toString());
//        this.kahanTak = Integer.parseInt(kahanTakEditText.getText().toString());
//
//        this.showPahada();

    }

    private void showPahada() {
        items.clear();

        for(int i = 1; i <= this.kahanTak; i++) {
            items.add(this.kisKa + " X " + i + " = " + this.kisKa * i);
        }

        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d("codekamp", "Selected college name: " + data.getStringExtra("college_name"));
    }
}
