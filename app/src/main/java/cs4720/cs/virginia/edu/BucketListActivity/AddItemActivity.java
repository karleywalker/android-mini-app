package cs4720.cs.virginia.edu.BucketListActivity;

/**
 * An Activity that lets a user add an item to the list
 */

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
                //edit in the list of BucketItem
                List<BucketItem> mdata = BucketItem.getMdata();
                String[] b = new String[4];

                EditText edit = (EditText) findViewById(R.id.editText7);
                b[0] = edit.getText().toString();
                edit = (EditText) findViewById(R.id.editText8);
                b[1] = edit.getText().toString();
                edit = (EditText) findViewById(R.id.editText9);
                b[2] = edit.getText().toString();
                edit = (EditText) findViewById(R.id.editText10);
                b[3] = edit.getText().toString();


                Intent i = new Intent(AddItemActivity.this,MainActivity.class);
                Bundle bb = new Bundle();
                bb.putStringArray("name", b);
                i.putExtras(bb);
                setResult(Activity.RESULT_OK, i);
                finish();
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