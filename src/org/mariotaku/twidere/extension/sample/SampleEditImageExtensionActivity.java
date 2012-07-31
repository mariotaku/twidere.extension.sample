package org.mariotaku.twidere.extension.sample;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class SampleEditImageExtensionActivity extends Activity {

	public static final String DESCRIPTION = "This is an example of Twidere extension, you can see what you get from Twidere.";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final TextView descripion = (TextView) findViewById(R.id.description);
		descripion.setText(DESCRIPTION);
		final TextView content = (TextView) findViewById(R.id.content);
		content.setMovementMethod(LinkMovementMethod.getInstance());
		content.setText(getIntent().getDataString());
	}

}
