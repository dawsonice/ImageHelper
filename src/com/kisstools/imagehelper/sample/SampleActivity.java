/**
 * @author dawson dong
 */

package com.kisstools.imagehelper.sample;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import com.kisstools.imagehelper.BlurPlugin;
import com.kisstools.imagehelper.CirclePlugin;
import com.kisstools.imagehelper.CropPlugin;
import com.kisstools.imagehelper.ImageHelper;
import com.kisstools.imagehelper.R;
import com.kisstools.imagehelper.RoundPlugin;
import com.kisstools.imagehelper.ScalePlugin;

public class SampleActivity extends Activity implements OnClickListener {

	private ImageView ivContent;
	private Button btAction;
	private Bitmap bitmap;

	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.activity_sample);

		ivContent = (ImageView) findViewById(R.id.iv_content);
		btAction = (Button) findViewById(R.id.bt_action);
		btAction.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cat);
		ImageHelper helper = new ImageHelper();
		helper.addPlugin(new CropPlugin(20, 20, 1200, 1200));
		helper.addPlugin(new ScalePlugin(400, 400));
		helper.addPlugin(new RoundPlugin(80));
		helper.addPlugin(new CirclePlugin());
		helper.addPlugin(new BlurPlugin(8));
		bitmap = helper.process(bitmap);
		ivContent.setImageBitmap(bitmap);
	}

}
