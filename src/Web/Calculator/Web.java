package Web.Calculator;

import android.webkit.WebView;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.Toast;

public class Web extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onlinecalc);
        WebView view = (WebView) findViewById(R.id.webView1);
        String xd = "file:///android_asset/calculatorLayout.html";
        view.getSettings().setJavaScriptEnabled(true);
        view.addJavascriptInterface(new WebAppInterface(this), "Android");
        view.loadUrl(xd);
    }
    public class WebAppInterface {
        Context mContext;
         double firstNumber;
    	 double secondNumber;
    	String First="";
    	 String Second="";
    	char OP;
    	boolean trigger=false;
    	
        WebAppInterface(Context c) {
            mContext = c;
        }
        
        public void showToast(String toast) {
            Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
        }

        public void addNum(String GG){
        	// Toast.makeText(mContext, GG, Toast.LENGTH_SHORT).show();
        if (trigger==false){
        	First=First+GG;
        }
        else Second = Second+GG;
        }
        public void addOperator(String GG){
        	// Toast.makeText(mContext, GG, Toast.LENGTH_SHORT).show();
        if (trigger == false) {trigger = true;} 
        else trigger=true;
        OP=GG.charAt(0);
        
        }
        public String getResult(){
        	firstNumber=Double.parseDouble(First);
        	secondNumber=Double.parseDouble(Second);
        if (OP=='+'){
        	return Double.toString(firstNumber+secondNumber);
        	}
        if (OP=='-'){
        	return Double.toString(firstNumber-secondNumber);
        	}
        if (OP=='*'){
        	return Double.toString(firstNumber*secondNumber);
        	}
        if (OP=='/'){
        	return Double.toString(firstNumber/secondNumber);
        	}
        return "not applicable";
        
        }
}
}