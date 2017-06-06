package com.pandawa.game;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class EndActivity1 extends Activity {
MediaPlayer sukses;
	Button menu;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_end1);
		menu=(Button)findViewById(R.id.menu);
		selesaiLevel1();
		menu.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent level =new Intent(getApplicationContext(),LevelMenu.class);
				startActivity(level);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.end, menu);
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
				// TODO Auto-generated method stub
				finish();
				sukses.stop();
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
	public void selesaiLevel1(){
		sukses=MediaPlayer.create(this, R.raw.fun);
		//set looping true untuk mengulang audio jika telah selesai
		sukses.setLooping(true);
		//set volume audio agar berbunyi
		sukses.setVolume(2, 2);
		//memulai audio
		sukses.start();
	}
}
