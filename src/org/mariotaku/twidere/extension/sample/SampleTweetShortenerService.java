package org.mariotaku.twidere.extension.sample;

import java.lang.ref.WeakReference;

import org.mariotaku.twidere.ITweetShortener;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Tweet shortener example
 * 
 * @author mariotaku
 */
public class SampleTweetShortenerService extends Service {

	private final TweetShortenerStub mBinder = new TweetShortenerStub(this);
	
	@Override
	public IBinder onBind(Intent intent) {
		return mBinder;
	}
	
	/**
	 * @return Shortened tweet.
	 */
	public String shorten(String text, String screen_name, long in_reply_to_status_id) {
		return "This extension will be triggered automatically when tweet text is longer than 140 characters.";
	}
	
	/*
	 * By making this a static class with a WeakReference to the Service, we
	 * ensure that the Service can be GCd even when the system process still has
	 * a remote reference to the stub.
	 */
	private static final class TweetShortenerStub extends ITweetShortener.Stub {

		final WeakReference<SampleTweetShortenerService> mService;

		public TweetShortenerStub(SampleTweetShortenerService service) {
			mService = new WeakReference<SampleTweetShortenerService>(service);
		}

		@Override
		public String shorten(String text, String screen_name, long in_reply_to_status_id) {
			return mService.get().shorten(text, screen_name, in_reply_to_status_id);
		}
		
	}

}
