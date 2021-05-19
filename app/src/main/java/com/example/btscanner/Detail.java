package com.example.btscanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Detail extends AppCompatActivity {

    Button back;
    TextView detail,devicename,address;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        detail=findViewById(R.id.detail);
        address=findViewById(R.id.textView_Address);
        devicename=findViewById(R.id.textView_DeviceName);
        getSupportActionBar().hide();
        Bundle bundle=this.getIntent().getExtras();
        String infomation=bundle.getString("infomation");
        detail.setText(infomation);
        devicename.setText("裝置名稱:"+bundle.getString("devicename"));
        address.setText("位址:"+bundle.getString("address"));
        back=findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent();
                b.setClass(Detail.this,MainActivity.class);
                startActivity(b);
                finish();
            }
        });

    }

}
