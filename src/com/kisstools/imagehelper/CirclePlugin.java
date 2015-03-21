/**
 * @author dawson dong
 */

package com.kisstools.imagehelper;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;

public class CirclePlugin implements ImagePlugin {
	public static final String TAG = "CirclePlugin";

	public CirclePlugin() {
	}

	@Override
	public Bitmap process(Bitmap original) {
		int width = original.getWidth();
		int height = original.getHeight();
		int diameter = width > height ? height : width;
		Bitmap bitmap = Bitmap.createBitmap(diameter, diameter,
				Config.ARGB_8888);
		Canvas canvas = new Canvas(bitmap);
		Paint paint = new Paint();
		paint.setAntiAlias(true);

		int left = (width - diameter) / 2;
		int top = (height - diameter) / 2;
		Rect source = new Rect(left, top, left + diameter, top + diameter);

		canvas.drawARGB(0, 0, 0, 0);
		int radius = diameter / 2;
		canvas.drawCircle(radius / 2, radius / 2, radius / 2, paint);
		paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
		canvas.drawBitmap(original, source, source, paint);
		canvas.save();
		return bitmap;
	}
}