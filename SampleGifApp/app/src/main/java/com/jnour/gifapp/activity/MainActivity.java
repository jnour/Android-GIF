package com.jnour.gifapp.activity;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jnour.gifapp.R;
import com.jnour.gifapp.adapter.MenuAdapter;
import com.jnour.gifapp.view.GifImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends Activity {

    private ListView mListview;
    private GifImageView mGifImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListview =(ListView)findViewById(R.id.main_list_view);
        mGifImageView=(GifImageView)findViewById(R.id.gifImageView);

        MenuAdapter adapter = new MenuAdapter(this,getResources().getStringArray(R.array.list_menu),getResources().getStringArray(R.array.sub_list_menu));
        mListview.setAdapter(adapter);
        mListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        showDemoGif();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mGifImageView.stopAnimation();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mGifImageView.startAnimation();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void showDemoGif(){
        AssetManager assetManager = this.getAssets();


        InputStream is = null;
        try{
            is = assetManager.open("giphy.gif");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            mGifImageView.setBytes(buffer);
        }catch(Exception e){
            e.printStackTrace();
        }
        mGifImageView.setVisibility(View.VISIBLE);
        mGifImageView.startAnimation();
    }
}
