package com.kisstools.imageplugin;

/**
 * @author dawson dong
 */

public class ImagePlugin {

	public static final String TAG = "ImagePlugin";

	// support the following effect:
	// 1. scale to fixed size
	// 2. blur image
	// 3. crop to fixed size
	// 4. round corner

	public static class BlurOption {
		public int radius;

		public BlurOption(int r) {
			this.radius = r;
		}
	}

	public static class ScaleOption {
		public int targetWidth;
		public int targetHeight;

		public ScaleOption(int w, int h) {
			this.targetWidth = w;
			this.targetHeight = h;
		}
	}

	public static class CropOption {
		public int left;
		public int top;
		public int width;
		public int height;

		public CropOption(int w, int h) {
			this(0, 0, w, h);
		}

		public CropOption(int l, int t, int w, int h) {
			this.left = l;
			this.top = t;
			this.width = w;
			this.height = h;
		}
	}

	public static class RoundOption {
		public int radius;

		public RoundOption(int r) {
			this.radius = r;
		}
	}
}
