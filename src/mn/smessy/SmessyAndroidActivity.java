package mn.smessy;

import java.io.*;
import java.net.*;
import java.lang.String;

import android.app.Activity;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;


public class SmessyAndroidActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // Watch for send button clicks and send text messages.
        Button happen = (Button) findViewById(R.id.happen_button);
        
        happen.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
         
            	TextView results = (TextView) findViewById(R.id.results);
            	try
            	{
	                Socket socket = new Socket("newyr.me", 8050);
	                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	
		        	String line = in.readLine();
		        	while( line != null ) {
		        		
		        		results.append(line);
		        		
		        		line = in.readLine();
		        	}
		
		        	in.close();
		        	socket.close();
		        	
            	} catch (IOException e) {
	        	
            		results.append(e.toString());
	            }
            }
        });
    }
}