package org.mariotaku.twidere.extension.sample;

import java.lang.ref.WeakReference;

import org.mariotaku.twidere.IImageUploader;

import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;

/**
 * Image uploader example
 * 
 * @author mariotaku
 */
public class SampleImageUploaderService extends Service {

	private final ImageUploaderStub mBinder = new ImageUploaderStub(this);
	
	@Override
	public IBinder onBind(Intent intent) {
		return mBinder;
	}
	
	/**
	 * @param file_uri Image file uri to send
	 * @param message Tweet to send, you can use this to describe image you upload.
	 * @return Image uri server returned.
	 */
	public Uri upload(Uri file_uri, String message) {
		return file_uri;
	}
	
	/*
	 * By making this a static class with a WeakReference to the Service, we
	 * ensure that the Service can be GCd even when the system process still has
	 * a remote reference to the stub.
	 */
	private static final class ImageUploaderStub extends IImageUploader.Stub {

		final WeakReference<SampleImageUploaderService> mService;

		public ImageUploaderStub(SampleImageUploaderService service) {

			mService = new WeakReference<SampleImageUploaderService>(service);
		}
		
		@Override
		public Uri upload(Uri file_uri, String message) {
			return mService.get().upload(file_uri, message);
		}
		
	}

}
