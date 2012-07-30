package org.mariotaku.twidere.extension.sample;

import org.mariotaku.twidere.Twidere;
import org.mariotaku.twidere.model.ParcelableUserList;

public class SampleUserListExtensionActivity extends BaseActivity<ParcelableUserList> {

	public static final String DESCRIPTION = "This is an example of Twidere extension, you can see what you get from Twidere.";

	@Override
	public ParcelableUserList getData() {
		return Twidere.getUserListFromIntent(getIntent());
	}

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}

}
