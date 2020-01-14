package com.example.demo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn, btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = findViewById(R.id.textView);
        Uri uri = Uri.parse("http://developer.android.com/reference/android/net/Uri.html");
        tv.setText(uri.getScheme() + "\n");
        tv.setText(tv.getText() + uri.getSchemeSpecificPart() + "\n");
        tv.setText(tv.getText() + uri.getAuthority() + "\n");
        tv.setText(tv.getText() + uri.getHost() + "\n");
        tv.setText(tv.getText() + uri.getPath() + "\n");
        tv.setText(tv.getText() + uri.getLastPathSegment() + "\n");

        btn = findViewById(R.id.button);
        btn1 = findViewById(R.id.button2);
        btn.setOnClickListener((View.OnClickListener) this);
        btn1.setOnClickListener((View.OnClickListener) this);
    }

     @Override
     public void onClick(View view) {
        if(view == btn) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://developer.android.com"));
            if (intent.resolveActivity(getPackageManager()) != null)
                startActivity(intent);
            else
                Toast.makeText(getApplicationContext(), "Intent (ACTION_VIEW) не обработан!", Toast.LENGTH_LONG).show();
        }
        if(view == btn1) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:12345"));
            if (intent.resolveActivity(getPackageManager()) != null)
                startActivity(intent);
            else
                Toast.makeText(getApplicationContext(), "Intent (ACTION_DIAL) не обработан!", Toast.LENGTH_LONG).show();
        }
    }
}
