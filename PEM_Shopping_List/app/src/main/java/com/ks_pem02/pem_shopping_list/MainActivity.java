package com.ks_pem02.pem_shopping_list;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity implements
        GroceriesFragment.OnFragmentInteractionListener,
        AddItemFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GroceriesFragment grocFrag = new GroceriesFragment();
        getFragmentManager().beginTransaction()
                .add(R.id.fragment_container, grocFrag).commit();

        /*AddItemFragment itemFrag = new AddItemFragment();
        getFragmentManager().beginTransaction()
                .add(R.id.fragment_container, itemFrag).commit();*/

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

/*        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewItem();
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(String id) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void createNewItem() {
        AddItemFragment itemFrag = new AddItemFragment();
        getFragmentManager().beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragment_container, itemFrag).commit();
    }
}
