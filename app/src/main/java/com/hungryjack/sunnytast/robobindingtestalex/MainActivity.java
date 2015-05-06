package com.hungryjack.sunnytast.robobindingtestalex;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import org.robobinding.ViewBinder;
import org.robobinding.binder.BinderFactory;
import org.robobinding.binder.BinderFactoryBuilder;
import org.robobinding.binder.Binders;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private static BinderFactory mReusableBinderFactory;
    private ViewBinder mViewBinder;
    private SimpleListPresentationModel mPresentationModel;
    private List<String> mListObjects = new ArrayList<>();
    private String mLabel = "Item";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewBinder = createViewBinder();
        for (int i =0; i < 5; i++){
            mListObjects.add(mLabel + " " + mListObjects.size());
        }
        mPresentationModel = new SimpleListPresentationModel(mListObjects);
        View rootView = Binders.inflateAndBind(this, R.layout.activity_main, mPresentationModel);
        setContentView(rootView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public ViewBinder createViewBinder(){
        mReusableBinderFactory = new BinderFactoryBuilder().build();
        return mReusableBinderFactory.createViewBinder(this, true);
    }

    public void addMoreItems(View view){
        for (int i =0; i < 5; i++){
            mListObjects.add(mLabel + " " + mListObjects.size());
        }
        mPresentationModel.refresh();
        Toast.makeText(this, R.string.more_items, 1000).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
