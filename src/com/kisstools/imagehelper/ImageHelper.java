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

	public static final String TAG = "ImagePlugin";

	List<ImagePlugin> plugins;

	public ImageHelper() {
		plugins = new ArrayList<ImagePlugin>();
	}

	public ImageHelper addPlugin(ImagePlugin plugin) {
		this.plugins.add(plugin);
		return this;
	}

	public Bitmap process(Bitmap bitmap) {
		for (ImagePlugin plugin : plugins) {
			bitmap = plugin.process(bitmap);
		}
		return bitmap;
	}
}
