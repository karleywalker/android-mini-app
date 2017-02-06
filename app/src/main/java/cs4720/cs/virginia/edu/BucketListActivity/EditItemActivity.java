package cs4720.cs.virginia.edu.BucketListActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

/**
 * An Activity that lets a user edit an item already on the list and is pre-populated on launch
 */

public class EditItemActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        String clickname = MainActivity.getclickname();
        List<BucketItem> mdata = ThingList.getListData();
        int x = 0;
        for(int i = 0; i < mdata.size(); i++){
            if(mdata.get(i).getName() == clickname){
                x = i;
            }
        }

        EditText text = (EditText) findViewById(R.id.editText7);
        text.setText(mdata.get(x).getName());
        text = (EditText) findViewById(R.id.editText8);
        text.setText(mdata.get(x).getDescription());
        text = (EditText) findViewById(R.id.editText9);
        text.setText(mdata.get(x).getLatitude());
        text = (EditText) findViewById(R.id.editText10);
        text.setText(mdata.get(x).getLongitude());

        Button button = (Button) findViewById(R.id.edit_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(EditItemActivity.this, MainActivity.class);
                startActivity(new Intent(intent));
            }
        });
    }

}
