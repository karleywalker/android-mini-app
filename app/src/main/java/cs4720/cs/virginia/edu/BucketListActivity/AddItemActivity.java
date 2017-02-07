package cs4720.cs.virginia.edu.BucketListActivity;

/**
 * An Activity that lets a user add an item to the list
 */

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;


import java.util.List;

public class AddItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        //onclick method
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent i = new Intent();
                // TODO Add extras or a data URI to this intent as appropriate.
                EditText edit = (EditText) findViewById(R.id.editText7);
                i.putExtra("title_key", edit.getText().toString());
                edit = (EditText) findViewById(R.id.editText8);
                i.putExtra("desc_key", edit.getText().toString());
                edit = (EditText) findViewById(R.id.editText9);
                i.putExtra("lat_key", edit.getText().toString());
                edit = (EditText) findViewById(R.id.editText10);
                i.putExtra("lon_key", edit.getText().toString());
                DatePicker dp = (DatePicker) findViewById(R.id.datePicker3);
                i.putExtra("day_key", String.valueOf(dp.getDayOfMonth()));
                i.putExtra("mo_key", String.valueOf(dp.getMonth()));
                i.putExtra("yr_key", String.valueOf(dp.getYear()));
                setResult(Activity.RESULT_OK, i);
                finish();
               /** Intent intent = new Intent(AddItemActivity.this, MainActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("title", b[0]);
                    bundle.putString("desc", b[1]);
                    bundle.putString("lat", b[2]);
                    bundle.putString("lon", b[3]);
                    bundle.putString("mon", b[4]);
                    bundle.putString("day", b[5]);
                    bundle.putString("yr", b[6]);
                intent.putExtras(bundle);
                setResult(Activity.RESULT_OK, intent);   //set the result and intent
                finish();   //finish and return to main activity **/

                /**
                Intent i = new Intent(AddItemActivity.this,MainActivity.class);
                Bundle bb = new Bundle(); // bundle bb
                bb.putStringArray("name", arr); // add string[] arr to bundle
                i.putExtras(bb);    // add the bundle to the intent
                setResult(Activity.RESULT_OK, i);   //set the result and intent
                finish();   //finish and return to main activity **/
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == android.R.id.home){
            Intent returnIntent = new Intent();
            setResult(Activity.RESULT_CANCELED, returnIntent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}