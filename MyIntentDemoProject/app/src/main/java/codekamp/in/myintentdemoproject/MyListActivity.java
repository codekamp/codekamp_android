package codekamp.in.myintentdemoproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MyListActivity extends Activity implements AdapterView.OnItemClickListener {

    String[] items;
    ListView listView;

    public static final String  ITEM_KEY = "akkad_bakkad";
    public static final String  SELECTED_ITEM_INDEX = "adsfad_adfadfadf";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);


        items = getIntent().getStringArrayExtra(ITEM_KEY);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);

        listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);

    }

    public void cancel(View view) {
        setResult(Activity.RESULT_CANCELED);
        finish();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i = new Intent();
        i.putExtra(SELECTED_ITEM_INDEX, position);
        setResult(Activity.RESULT_OK, i);
        finish();
    }
}
