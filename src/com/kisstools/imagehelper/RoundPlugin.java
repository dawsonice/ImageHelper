/**
 * @author dawson dong
 */

package com.kisstools.imagehelper;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;

public class RoundPlugin implements ImagePlugin {
	public static final String TAG = "RoundPlugin";

	public int radius;

	public RoundPlugin(int r) {
		this.radius = r;
	}

	@Override
	public Bitmap process(Bitmap original) {
		int height = original.getHeight();
		int width = original.getWidth();
		Bitmap bitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
		Canvas canvas = new Canvas(bitmap);
		final Paint paint = new Paint();
		final Rect rect = new Rect(0, 0, width, height);
		final RectF rectF = new RectF(rect);

		paint.setAntiAlias(true);
		canvas.drawARGB(0, 0, 0, 0);
		canvas.drawRoundRect(rectF, radius, radius, paint);
		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
		canvas.drawBitmap(original, rect, rect, paint);
		return bitmap;
	}
}