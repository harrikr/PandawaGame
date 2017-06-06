package com.pandawa.game;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
MediaPlayer welcome;
Button play,tutorial,saran;
ImageView fb;
private static String URL="https://www.facebook.com/";
private static String TAG="Pandawa-Game";

//Digunakan untuk pemilihan aplikasi membuka URL dan URL2
private static String CHOOSER_TEXT="Pergi ke " + URL;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Welcome();
		fb=(ImageView)findViewById(R.id.fb);
		saran=(Button)findViewById(R.id.saran);
		tutorial=(Button)findViewById(R.id.btnCaramain);
		play=(Button)findViewById(R.id.btnplay);
		play.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				welcome.stop();
				Intent level =new Intent(getApplicationContext(),LevelMenu.class);
				startActivity(level);
			}
		});
		fb.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			PilihAplikasi();	
			}
		});
		saran.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				welcome.stop();
				Intent level =new Intent(getApplicationContext(),SaranActivity.class);
				startActivity(level);
			}
		});
		tutorial.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				welcome.stop();
				Intent level =new Intent(getApplicationContext(),CaraMainActivity.class);
				startActivity(level);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
	public void PilihAplikasi(){
		Log.i(TAG, "Pilihan Aplikasi startImplicitActivation()");
		//buat intent dasar untuk melihat URL dan URL2
		//(Petunjuk: gunakan method createChooser() milik class Intent)
		Intent baseIntent=new Intent(Intent.ACTION_VIEW,Uri.parse(URL));
		Intent chooserIntent=Intent.createChooser(baseIntent, CHOOSER_TEXT);
		Log.i(TAG,"Chooser Intent Action:" + chooserIntent.getAction());
		//Jalankan "chooser Activity" (activity pemilih), menggunakan chooser intent (intent pemilih)
		startActivity(chooserIntent);
	}
	public void keluar(){
		AlertDialog.Builder pesan= new AlertDialog.Builder(this);
		pesan.setMessage("Keluar dari aplikasi?")
		.setCancelable(false)
		.setPositiveButton("Ya", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				finish();
				welcome.stop();
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
				keluar();
			}
			return super.onKeyDown(keyCode, event);
		}
	public void Welcome() {
		// TODO Auto-generated method stub
		//memanggil file welcome dari folder res/raw/welcome.mp3
		welcome=MediaPlayer.create(this, R.raw.welcome);
		//set looping true untuk mengulang audio jika telah selesai
		welcome.setLooping(true);
		//set volume audio agar berbunyi
		welcome.setVolume(2, 2);
		//memulai audio
		welcome.start();
	}
}
