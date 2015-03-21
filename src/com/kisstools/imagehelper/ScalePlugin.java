/**
 * @author dawson dong
 */

package com.kisstools.imagehelper;

import android.graphics.Bitmap;
import android.graphics.Matrix;

public class ScalePlugin implements ImagePlugin {

	public static final String TAG = "ScalePlugin";

	public int targetWidth;
	public int targetHeight;

	public ScalePlugin(int w, int h) {
		this.targetWidth = w;
		this.targetHeight = h;
	}

	@Override
	public Bitmap process(Bitmap original) {
		Matrix matrix = new Matrix();
		int width = original.getWidth();
		int height = original.getHeight();
		float scaleW = ((float) targetWidth) / width;
		float scaleH = ((float) targetHeight) / height;
		matrix.postScale(scaleW, scaleH);
		Bitmap bitmap = Bitmap.createBitmap(original, 0, 0, width, height,
				matrix, true);
		return bitmap;
	}
}
