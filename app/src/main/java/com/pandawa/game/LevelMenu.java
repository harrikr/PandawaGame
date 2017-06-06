package com.pandawa.game;

import com.pandawa.game.level1.Soal1Activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class LevelMenu extends Activity {
MainActivity playlagi;
Button level1;
ImageButton level2,level3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_level);
		level1=(Button)findViewById(R.id.level1);
		level2=(ImageButton)findViewById(R.id.level2);
		level3=(ImageButton)findViewById(R.id.level3);
		level1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent soal1=new Intent(getApplicationContext(), Soal1Activity.class);
				startActivity(soal1);
				finish();
			}
		});
		level2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			Toast.makeText(getApplicationContext(), "Masih dalam tahap pembangunan", 
					Toast.LENGTH_LONG).show();	
			}
		});
		level3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Masih dalam tahap pembangunan", 
						Toast.LENGTH_LONG).show();		
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.level_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	public void backtomenu(){
		AlertDialog.Builder pesan= new AlertDialog.Builder(this);
		pesan.setMessage("Kembali ke menu?")
		.setCancelable(false)
		.setPositiveButton("Ya", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				Intent level =new Intent(getApplicationContext(),MainActivity.class);
				startActivity(level);
				finish();
			}
		})
		.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.cancel();
			}
		}).show();
	}
	@Override
		public boolean onKeyDown(int keyCode, KeyEvent event) {
			// TODO Auto-generated method stub
			if(keyCode==KeyEvent.KEYCODE_BACK){
				backtomenu();
			}
			return super.onKeyDown(keyCode, event);
		}
}