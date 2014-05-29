package com.example.bookkeeping;

import java.util.Calendar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;
//import com.example.bookkeeping.PaymentButtonAdapter;

public class BookKeeping extends Activity{
	public PaymentButtonAdapter pbAdapter;
	public IncomeButtonAdapter ibAdapter;
	public String payment_name;
	public String income_name;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_bookkeeping);
		SharedPreferences sp_add_payment=getSharedPreferences("add_payment",0);
		final SharedPreferences.Editor editor_add_payment=sp_add_payment.edit();
		SharedPreferences sp_add_income=getSharedPreferences("add_income",0);
		SharedPreferences.Editor editor_add_income=sp_add_income.edit();
		pbAdapter=new PaymentButtonAdapter(this);
		ibAdapter=new IncomeButtonAdapter(this);
		GridView gv=(GridView)findViewById(R.id.gridview_payment);
		gv.setAdapter(pbAdapter);
		GridView gv_income=(GridView)findViewById(R.id.gridview_income);
		gv_income.setAdapter(ibAdapter);
		
		/*Click Listener Event for add button*/
		Button add_payment=(Button)findViewById(R.id.add_payment);
		add_payment.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog.Builder payment_builder=new AlertDialog.Builder(BookKeeping.this);
				final EditText edittext_payment=new EditText(BookKeeping.this);
				payment_builder.setTitle("New Payment Method");
				payment_builder.setView(edittext_payment);
				payment_builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
					
					@SuppressLint("NewApi")
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						payment_name=edittext_payment.getText().toString();
						pbAdapter.mThumbIds.add(payment_name);
						pbAdapter.mThumbIds_Set.add(payment_name);
						editor_add_payment.putStringSet("added_payment_button", pbAdapter.mThumbIds_Set);
						//editor_add_payment.remove("added_payment_button");
						editor_add_payment.commit();
						pbAdapter.notifyDataSetChanged();
						
					}
				});
				payment_builder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub		
					}
				});
				AlertDialog ad_payment=payment_builder.create();
				ad_payment.show();
			}
			
		});
		Button add_income=(Button)findViewById(R.id.add_income);
		add_income.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog.Builder income_builder=new AlertDialog.Builder(BookKeeping.this);
				final EditText edittext_income=new EditText(BookKeeping.this);
				income_builder.setTitle("New Income Method");
				income_builder.setView(edittext_income);
				income_builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						income_name=edittext_income.getText().toString();
						ibAdapter.mThumbIds.add(income_name);
						ibAdapter.notifyDataSetChanged();
					}
				});
				income_builder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub		
					}
				});
				AlertDialog ad_income=income_builder.create();
				ad_income.show();
			}
			
		});
		
		Button show_history=(Button)findViewById(R.id.show_history);
		show_history.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(BookKeeping.this, History.class);
				startActivity(intent);
			}
			
		});
		
		/*Click Listener Event for payment gridview*/
		gv.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, final View v, int position, long id) {
				// TODO Auto-generated method stub
				AlertDialog.Builder builder=new AlertDialog.Builder(BookKeeping.this);
				final View layout=CreateEditText();
				builder.setTitle("Input Book Keeping Info");
				builder.setView(layout);
				builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						SharedPreferences infos_payment=getSharedPreferences("info_payment", 0);
						Calendar calendar=Calendar.getInstance();
						SharedPreferences.Editor infos_payment_editor=infos_payment.edit();
						infos_payment_editor.putString("amount",((EditText)layout.findViewById(1)).getText().toString());
						infos_payment_editor.putString("comments",((EditText)layout.findViewById(2)).getText().toString());
						infos_payment_editor.putString("time",String.valueOf(calendar.YEAR)+"."+String.valueOf(calendar.MONTH)+"."+String.valueOf(calendar.DAY_OF_MONTH)+"."+String.valueOf(calendar.HOUR_OF_DAY)+"."+String.valueOf(calendar.MINUTE));
						infos_payment_editor.commit();
						//Toast.makeText(BookKeeping.this, "Test", Toast.LENGTH_SHORT).show();
					}
				});
				builder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
					}
				});
				AlertDialog ad=builder.create();
				ad.show();
				//Toast.makeText(BookKeeping.this, "test "+ position , Toast.LENGTH_LONG).show();
			}
			
		});
		
		gv_income.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, final View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				AlertDialog.Builder builder=new AlertDialog.Builder(BookKeeping.this);
				final View layout=CreateEditText();
				builder.setTitle("Input Book Keeping Info");
				builder.setView(layout);
				builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Calendar calendar=Calendar.getInstance();
						SharedPreferences infos_income=getSharedPreferences("info_income", 0);
						SharedPreferences.Editor infos_income_editor=infos_income.edit();
						infos_income_editor.putString("name", ((Button)arg1).getText().toString());
						infos_income_editor.putString("amount",((EditText)layout.findViewById(1)).getText().toString());
						infos_income_editor.putString("comments",((EditText)layout.findViewById(2)).getText().toString());
						infos_income_editor.putString("time",String.valueOf(calendar.getTime()));
						infos_income_editor.commit();
						//Toast.makeText(BookKeeping.this, "Test", Toast.LENGTH_SHORT).show();
					}
				});
				builder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
					}
				});
				AlertDialog ad=builder.create();
				ad.show();
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public View CreateEditText(){
		LinearLayout layout=new LinearLayout(BookKeeping.this);
		final EditText edittext_amount=new EditText(BookKeeping.this);
		final EditText edittext_remark=new EditText(BookKeeping.this);
		layout.setOrientation(LinearLayout.VERTICAL);
		edittext_amount.setId(1);
		edittext_remark.setId(2);
		edittext_amount.setHint("Input amounts here");
		edittext_remark.setHint("Input coments here");
		layout.addView(edittext_amount);
		layout.addView(edittext_remark);
		return layout;
	}
}
