package com.ashxmay.ffpanel;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final int OVERLAY_REQUEST = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button start = new Button(this);
        start.setText("Start Headshot Panel");
        setContentView(start);

        start.setOnClickListener(v -> {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.canDrawOverlays(this)) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                        Uri.parse("package:" + getPackageName()));
                startActivityForResult(intent, OVERLAY_REQUEST);
            } else {
                startService(new Intent(this, FloatingService.class));
                Toast.makeText(this, "Panel started. Open Free Fire.", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == OVERLAY_REQUEST) {
            if (Settings.canDrawOverlays(this)) {
                startService(new Intent(this, FloatingService.class));
                Toast.makeText(this, "Panel started", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Overlay permission required", Toast.LENGTH_LONG).show();
            }
        }
    }
}
