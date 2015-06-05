package course.examples.moderartui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.ActionBar;
import android.graphics.drawable.ColorDrawable;
import android.graphics.Color;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

/**
 * Main Activity class that shows custom view and takes input from the user via seek bar
 */
public class MainActivity extends Activity {

    private SeekBar seekBar;
    private DrawRectangles rectView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set color for the action bar
        ActionBar bar = getActionBar();
        if (bar != null)
            bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("navy")));

        // set up custom view and seek bar
        rectView = (DrawRectangles)findViewById(R.id.customeView);
        seekBar = (SeekBar) findViewById(R.id.seekBar);

        seekBar.setMax(175);

        //set on seek bar change listener that takes input from the user
        seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

            // change color of the custom view using the seek bar value
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                rectView.changeColor(progressValue);
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        // Create and show dialog box if menu's item clicked
        if (id == R.id.action_settings) {
            StartWebsiteDialogFragment startDialog = new StartWebsiteDialogFragment();
            startDialog.show(MainActivity.this.getFragmentManager(), "StartWebsiteDialog");
            return true;
        }

        return super.onOptionsItemSelected(item);
   }

}
