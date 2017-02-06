package cs4720.cs.virginia.edu.testing;

/**
 * An Activity that lets a user add an item to the list
 */

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import java.util.List;

import cs4720.cs.virginia.edu.BucketListActivity.BucketItem;
import cs4720.cs.virginia.edu.BucketListActivity.EditItemActivity;
import cs4720.cs.virginia.edu.BucketListActivity.MainActivity;
import cs4720.cs.virginia.edu.BucketListActivity.R;
import cs4720.cs.virginia.edu.BucketListActivity.ThingList;

public class AddItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        //onclick method
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //edit in the list of BucketItem
                List<BucketItem> mdata = ThingList.getMdata();
                BucketItem b = new BucketItem();

                EditText edit = (EditText) findViewById(R.id.editText7);
                b.setName(edit.getText().toString());
                edit = (EditText) findViewById(R.id.editText8);
                b.setDescription(edit.getText().toString());
                edit = (EditText) findViewById(R.id.editText9);
                b.setLatitude(edit.getText().toString());
                edit = (EditText) findViewById(R.id.editText10);
                b.setLongitude(edit.getText().toString());

                mdata.add(b);
                ThingList.setMdata(mdata);
                Intent intent = new Intent(AddItemActivity.this, MainActivity.class);
                startActivity(new Intent(intent));
            }
        });

    }
}