package org.mariotaku.twidere.extension.sample;

import org.mariotaku.twidere.Twidere;
import org.mariotaku.twidere.model.ParcelableUser;

public class SampleUserExtensionActivity extends BaseActivity<ParcelableUser> {

	public static final String DESCRIPTION = "This is an example of Twidere extension, you can see what you get from Twidere.";

	@Override
	public ParcelableUser getData() {
		return Twidere.getUserFromIntent(getIntent());
	}

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}

}
