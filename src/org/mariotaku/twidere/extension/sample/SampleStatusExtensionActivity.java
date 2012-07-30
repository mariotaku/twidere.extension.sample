package org.mariotaku.twidere.extension.sample;

import org.mariotaku.twidere.Twidere;
import org.mariotaku.twidere.model.ParcelableStatus;

public class SampleStatusExtensionActivity extends BaseActivity<ParcelableStatus> {

	public static final String DESCRIPTION = "This is an example of Twidere extension, you can see what you get from Twidere.";

	@Override
	public ParcelableStatus getData() {
		return Twidere.getStatusFromIntent(getIntent());
	}

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}

}
