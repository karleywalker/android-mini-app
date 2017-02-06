package cs4720.cs.virginia.edu.testing;

/**
 * An Activity that lets a user add an item to the list
 */

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



import cs4720.cs.virginia.edu.BucketListActivity.R;

public class AddItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        ActionBar actionBar = getActionBar();
        ///actionBar.setDisplayHomeAsUpEnabled(true);    //Attempt to invoke virtual method
            //  'void android.app.ActionBar.setDisplayHomeAsUpEnabled(boolean)'
            // on a null object reference

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
}