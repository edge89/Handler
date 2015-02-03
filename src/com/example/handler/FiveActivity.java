package com.example.handler;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class FiveActivity extends Activity {
	TextView textview;

	Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			textview.setText("OK");
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.five);
		textview = (TextView) findViewById(R.id.textView1);
		new Thread() {
			@Override
			public void run() {
				try {
					sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// handler1();
				// handler2();
				// updateUI();
				viewUI();
			}

		}.start();

	}

	private void handler1() {
		handler.post(new Runnable() {

			@Override
			public void run() {
				textview.setText("OK");
			}
		});
	}

	private void handler2() {
		handler.sendEmptyMessage(0);
	}

	private void updateUI() {
		runOnUiThread(new Runnable() {

			@Override
			public void run() {
				textview.setText("OK");
			}
		});
	}

	private void viewUI() {
		textview.post(new Runnable() {

			@Override
			public void run() {
				textview.setText("OK");
			}
		});
	}
}
