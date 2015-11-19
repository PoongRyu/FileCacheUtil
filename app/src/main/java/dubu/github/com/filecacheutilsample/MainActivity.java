package dubu.github.com.filecacheutilsample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import dubu.github.com.filecacheutil.FileCache;
import dubu.github.com.filecacheutil.FileCacheAleadyExistException;
import dubu.github.com.filecacheutil.FileCacheFactory;
import dubu.github.com.filecacheutil.FileCacheNotFoundException;
import dubu.github.com.filecacheutil.FileEntry;

public class MainActivity extends AppCompatActivity {

    private FileCache fileCache;
    private String cacheName = "dubulee";
    private final int cacheSize = 1024;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        try {
            FileCacheFactory.initialize(this);
            if (! FileCacheFactory.getInstance().has(cacheName)) {

                    FileCacheFactory.getInstance().create(cacheName, cacheSize);


            }
            fileCache = FileCacheFactory.getInstance().get(cacheName);
        } catch (FileCacheAleadyExistException e) {
            e.printStackTrace();
        } catch (FileCacheNotFoundException e) {
            e.printStackTrace();
        } finally {
        }

    }

    public void load() {
//        FileEntry fileEntry = fileCache.get(key);
//        if (fileEntry != null) {
//            String data = loadDataFromFile(fileEntry.getFile());
//            processing(data);
//            return;
//        }
//
//        String data = loadingDataRealSource();
//
//        fileCache.put(key, ByteProviderUtil.create(dataFile));
//
//        processing(data);
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
}


