package cn.edu.gdmec.s07131034.sharepreferencesdemo;

import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	private static final String PREFERENCES_NAME ="pernsonal";
	EditText etName,etAge,etHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = (EditText) findViewById(R.id.editText1);
        etAge =(EditText) findViewById(R.id.editText2);
        etHeight=(EditText) findViewById(R.id.editText3);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
    public void Read(View v){
    	SharedPreferences myPre = getSharedPreferences(PREFERENCES_NAME,Context.MODE_WORLD_READABLE+Context.MODE_WORLD_WRITEABLE);
    	String name = myPre.getString("name", "panweijie");
    	int age = myPre.getInt("age", 18);
    	float height = myPre.getFloat("height", 1.8f);
    	etName.setText(name);
    	etAge.setText(String.valueOf(age));
    	etHeight.setText(String.valueOf(height));
    };
    
    
    public void Write(View v){
    	SharedPreferences myPre = getSharedPreferences(PREFERENCES_NAME,Context.MODE_WORLD_READABLE+Context.MODE_ENABLE_WRITE_AHEAD_LOGGING);
    	SharedPreferences.Editor myEditor = myPre.edit();
    	myEditor.putString("name", etName.getText().toString());
    	myEditor.putInt("age", Integer.parseInt(etAge.getText().toString()));
    	myEditor.putFloat("height", Float.parseFloat(etHeight.getText().toString()));
    	myEditor.commit();
    	
    };
    
}
