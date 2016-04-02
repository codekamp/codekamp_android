package in.codekamp.codekamp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends CodeKampActivity {

    private static final int CONTACT_DETAIL_REQEUST = 1;
    private static final int CONTACT_CREATE_REQEUST = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {


        startActivityForResult(SecondActivity.newIntent(this, "12345"), CONTACT_DETAIL_REQEUST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == CONTACT_DETAIL_REQEUST) {
            Contact contact = SecondActivity.getContact(data);
        } else if(requestCode == CONTACT_CREATE_REQEUST) {

        }
    }
}
