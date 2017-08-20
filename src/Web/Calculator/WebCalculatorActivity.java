package Web.Calculator;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class WebCalculatorActivity extends Activity {
        @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        buttonClickListener();
    }
    public void buttonClickListener(){
    	Button Click = (Button) findViewById(R.id.button1);
    	Click.setOnClickListener(new OnClickListener(){
    		public void onClick(View view) {
    			if(isNetworkAvailable()==false){
    			Intent i = new Intent (getApplicationContext(), Offline.class);
    			startActivity(i);
    			}
    			else 
    				{Intent i = new Intent (getApplicationContext(), Web.class);
    			startActivity(i);}
			}
    	});
    }
    private boolean isNetworkAvailable() {
	    ConnectivityManager connectivityManager 
	          = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
	    return activeNetworkInfo != null && activeNetworkInfo.isConnected();
	}
}