package Web.Calculator;


import android.app.Activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Offline extends Activity {
    /** Called when the activity is first created. */
	double firstNumber;
	 double secondNumber;
	String First="";
	 String Second="";
	char OP;
	boolean trigger=false;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.offlinecalc);
        buttonClickListener();
    }
    public void buttonClickListener(){
    	Button one = (Button) findViewById(R.id.button1);
    	Button two = (Button) findViewById(R.id.button2);
    	Button three = (Button) findViewById(R.id.button3);
    	Button plus = (Button) findViewById(R.id.button4);
    	Button four = (Button) findViewById(R.id.button6);
    	Button five = (Button) findViewById(R.id.button7);
    	Button six = (Button) findViewById(R.id.button8);
    	Button minus = (Button) findViewById(R.id.button9);
    	Button seven = (Button) findViewById(R.id.button11);
    	Button eight = (Button) findViewById(R.id.button12);
    	Button nine = (Button) findViewById(R.id.button13);
    	Button mul = (Button) findViewById(R.id.button10);
    	Button dot = (Button) findViewById(R.id.button15);
    	Button zero = (Button) findViewById(R.id.button18);
    	Button equal = (Button) findViewById(R.id.button5);
    	Button div = (Button) findViewById(R.id.button17);
    	final EditText et =(EditText) findViewById(R.id.editText1);
    	
    	one.setOnClickListener(new OnClickListener(){
    		public void onClick(View view) {
    			addNum("1");
    			
			}
    	});
    	two.setOnClickListener(new OnClickListener(){
    		public void onClick(View view) {
    			addNum("2");
			}
    	});
    	three.setOnClickListener(new OnClickListener(){
    		public void onClick(View view) {
    			addNum("3");
			}
    	});
    	four.setOnClickListener(new OnClickListener(){
    		public void onClick(View view) {
    			addNum("4");
			}
    	});
    	five.setOnClickListener(new OnClickListener(){
    		public void onClick(View view) {
    			addNum("5");
			}
    	});
    	six.setOnClickListener(new OnClickListener(){
    		public void onClick(View view) {
    			addNum("6");
			}
    	});
    	seven.setOnClickListener(new OnClickListener(){
    		public void onClick(View view) {
    			addNum("7");
			}
    	});
    	eight.setOnClickListener(new OnClickListener(){
    		public void onClick(View view) {
    			addNum("8");
			}
    	});
    	
    	nine.setOnClickListener(new OnClickListener(){
    		public void onClick(View view) {
    			addNum("9");
			}
    	});
    	zero.setOnClickListener(new OnClickListener(){
    		public void onClick(View view) {
    			addNum("0");
			}
    	});
    	
    	plus.setOnClickListener(new OnClickListener(){
    		public void onClick(View view) {
    			addOperator("+");
			}
    	});
    	minus.setOnClickListener(new OnClickListener(){
    		public void onClick(View view) {
    			addOperator("-");
			}
    	});
    	mul.setOnClickListener(new OnClickListener(){
    		public void onClick(View view) {
    			addOperator("*");
			}
    	});
    	div.setOnClickListener(new OnClickListener(){
    		public void onClick(View view) {
    			addOperator("/");
			}
    	});
    	dot.setOnClickListener(new OnClickListener(){
    		public void onClick(View view) {
    			addNum("0");
			}
    	});
    	equal.setOnClickListener(new OnClickListener(){
    		public void onClick(View view) {
    			String EZ = getResult();
    			
    			et.setText(EZ, TextView.BufferType.NORMAL);
			}
    	});
    	
    	
    	
    	
    }
    public void addNum(String GG){
    	// Toast.makeText(mContext, GG, Toast.LENGTH_SHORT).show();
    if (trigger==false){
    	First=First+GG;
    	//et.setText(First, TextView.BufferType.NORMAL);
    }
    else {Second = Second+GG;
   // et.setText(Second, TextView.BufferType.NORMAL); \
    }   
    
    
    }
    
    public void addOperator(String GG){
    	// Toast.makeText(mContext, GG, Toast.LENGTH_SHORT).show();
    if (trigger == false) {trigger = true;} 
    else trigger=true;
    OP=GG.charAt(0);
    //et.setText(OP, TextView.BufferType.NORMAL);
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