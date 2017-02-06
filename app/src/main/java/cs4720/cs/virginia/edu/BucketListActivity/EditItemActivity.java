package cs4720.cs.virginia.edu.BucketListActivity;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * An Activity that lets a user edit an item already on the list and is pre-populated on launch
 */

public class EditItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

    }

}
