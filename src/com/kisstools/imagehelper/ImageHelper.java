package com.kisstools.imagehelper;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Bitmap;

/**
 * @author dawson dong
 */

// support the following effect:
// 1. scale to fixed size
// 2. blur image
// 3. crop to fixed size
// 4. round corner
// 5. whole circle image

public class ImageHelper {

	public static final String TAG = "ImageHelper";

	public static final int RECYCLE_ORIGIN = 0x2;

	private List<ImagePlugin> plugins;
	private int options;

	public ImageHelper() {
		this(RECYCLE_ORIGIN);
	}

	public ImageHelper(int options) {
		this.options = options;
		plugins = new ArrayList<ImagePlugin>();
	}

	public ImageHelper addPlugin(ImagePlugin plugin) {
		this.plugins.add(plugin);
		return this;
	}

	public Bitmap process(Bitmap original) {
		for (ImagePlugin plugin : plugins) {
			Bitmap result = plugin.process(original);
			// recycle the original bitmap
			if ((options & RECYCLE_ORIGIN) != 0 && !original.isRecycled()) {
				original.recycle();
			}
			original = result;
		}
		return original;
	}
}
