package org.mariotaku.twidere.extension.sample;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public abstract class BaseActivity<Data> extends Activity {

	public abstract Data getData();

	public abstract String getDescription();

	@Override
	public final void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final TextView descripion = (TextView) findViewById(R.id.description);
		descripion.setText(getDescription());
		final TextView content = (TextView) findViewById(R.id.content);
		content.setMovementMethod(LinkMovementMethod.getInstance());
		final Bundle extras = getIntent().getExtras();
		if (extras == null) return;
		final Data data = getData();
		if (data != null) {
			final Field[] fields = data.getClass().getFields();
			for (final Field field : fields) {
				try {
					if (field.getModifiers() == (Modifier.FINAL | Modifier.PUBLIC)) {
						content.append(field.getName() + ":" + field.get(data) + " (" + field.getType().getSimpleName()
								+ ")\n");
					}
				} catch (final IllegalArgumentException e) {
				} catch (final IllegalAccessException e) {
				}
			}
		}
	}

}
