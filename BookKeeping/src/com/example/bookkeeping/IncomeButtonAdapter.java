package com.example.bookkeeping;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

public class IncomeButtonAdapter extends BaseAdapter{

	private Context mContext;
	public  ArrayList<String> mThumbIds;
	public IncomeButtonAdapter(Context c) {
		// TODO Auto-generated constructor stub
		 mContext = c;
		 mThumbIds=new ArrayList<String>();
		 mThumbIds.add("Salary");
		 mThumbIds.add("Stock");
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
