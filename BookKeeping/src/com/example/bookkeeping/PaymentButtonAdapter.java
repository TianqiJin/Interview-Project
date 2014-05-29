package com.example.bookkeeping;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

public class PaymentButtonAdapter extends BaseAdapter{
	private Context mContext;
	public ArrayList<String> mThumbIds=new ArrayList<String>();
	public Set<String> mThumbIds_Set=new HashSet<String>();
	
	@SuppressLint("NewApi")
	public PaymentButtonAdapter(Context c) {
		// TODO Auto-generated constructor stub
		 mContext = c;
		 mThumbIds.add("Food");
		 mThumbIds.add("Cloth");
		 SharedPreferences sp=c.getSharedPreferences("add_payment",0);
		 mThumbIds.addAll(sp.getStringSet("added_payment_button", mThumbIds_Set));
		 mThumbIds_Set.addAll(sp.getStringSet("added_payment_button", mThumbIds_Set));
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		 return mThumbIds.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		 Button button;
	     if (convertView == null) {  // if it's not recycled, initialize some attributes
	          button = new Button(mContext);
	          button.setLayoutParams(new GridView.LayoutParams(120,60));
	          button.setPadding(8, 8, 8, 8);
	      } 
	      else {
	          button = (Button) convertView;
	      }
	      button.setText(mThumbIds.get(position).toString());
	      button.setTextSize(10);
	      button.setFocusable(false);
	      button.setClickable(false);
	      return button;
	}
}
