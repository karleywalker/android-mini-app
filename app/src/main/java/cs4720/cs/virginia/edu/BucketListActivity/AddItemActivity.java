package cs4720.cs.virginia.edu.BucketListActivity;

/**
 * An Activity that lets a user add an item to the list
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
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
                BucketItem.setMdata(mdata);
                Intent intent = new Intent(AddItemActivity.this, MainActivity.class);
                startActivity(new Intent(intent));
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}