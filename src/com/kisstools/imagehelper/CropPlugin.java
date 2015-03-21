/**
 * @author dawson dong
 */

package com.kisstools.imagehelper;

import android.graphics.Bitmap;

public class CropPlugin implements ImagePlugin {

	public static final String TAG = "CropPlugin";

	public int left;
	public int top;
	public int width;
	public int height;

	public CropPlugin(int w, int h) {
		this(0, 0, w, h);
	}

	public CropPlugin(int l, int t, int w, int h) {
		this.left = l;
		this.top = t;
		this.width = w;
		this.height = h;
	}

	@Override
	public Bitmap process(Bitmap original) {
		Bitmap bitmap = Bitmap.createBitmap(original, top, left, width, height);
		return bitmap;
	}
}
