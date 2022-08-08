package net.hankjin.android.xbrain;

import net.hankjin.android.xbrain.db.DBHelper;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TabHost;

public class MainActivity extends Activity {

    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_main);  
          
        TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);  
        tabHost.setup();
        tabHost.addTab(tabHost.newTabSpec("tabHome").setIndicator("Home").setContent(R.id.tab_home));
        tabHost.addTab(tabHost.newTabSpec("tabBirth").setIndicator("Birth").setContent(R.id.tab_birthday));  
        tabHost.addTab(tabHost.newTabSpec("tabBook").setIndicator("Book").setContent(R.id.tab_book));
        tabHost.addTab(tabHost.newTabSpec("tabTodo").setIndicator("Todo").setContent(R.id.tab_todo));
        tabHost.addTab(tabHost.newTabSpec("tabIdea").setIndicator("Idea").setContent(R.id.tab_idea));
        tabHost.addTab(tabHost.newTabSpec("tabSetting").setIndicator("Setting").setContent(R.id.tab_setting));
        //init database
        DBHelper.initDB(this);
    }  
  
    @Override  
    public boolean onCreateOptionsMenu(Menu menu) {  
        getMenuInflater().inflate(R.menu.main, menu);  
        return true;  
    } 

    public void hello(){
        System.out.println("hello");
    } 

}
