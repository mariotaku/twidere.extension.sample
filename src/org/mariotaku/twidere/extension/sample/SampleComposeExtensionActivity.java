package org.mariotaku.twidere.extension.sample;

import org.mariotaku.twidere.Twidere;
import org.mariotaku.twidere.model.ComposingStatus;

import android.view.View;
import android.view.View.OnClickListener;

public class SampleComposeExtensionActivity extends BaseActivity<ComposingStatus> implements OnClickListener{

	public static final String DESCRIPTION = "This is an example of Twidere extension, you can see what you get from Twidere.";

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.replace_text: {
				Twidere.replaceComposeActivityText(this, "Text replaced by extension");
				finish();
				break;
			}
			case R.id.append_text: {
				Twidere.appendComposeActivityText(this, "Text append from extension");
				finish();
				break;
			}
		}
	}

	@Override
	public int getContentViewId() {
		return R.layout.activity_compose;
	}

	@Override
	public ComposingStatus getData() {
		return Twidere.getComposingStatusFromIntent(getIntent());
	}

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}

}
