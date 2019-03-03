package getgood.dogood.bestocr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by sourav on 2/14/2018.
 */


public class ScannedTextActivity extends Activity {

    private ImageView mImageviewBack;
    DatabaseReference raff;
    Receipt receipt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.capture_and_scan_layout);

        String scannedText = getIntent().getStringExtra("scannedText");
        TextView textView = (TextView) findViewById(R.id.error_textView);


        mImageviewBack = (ImageView) findViewById(R.id.back_image);
        mImageviewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();
            }
        });
        textView.setText(scannedText);

//        receipt = new Receipt();
//        raff = FirebaseDatabase.getInstance().getReference().child("Receipt");
//
//        receipt.setTextBill(textView.getText().toString().trim());
//        raff.push().setValue(receipt);
//        Toast.makeText(ScannedTextActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ScannedTextActivity.this, "Enable", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ScannedTextActivity.this,Manual_add.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(ScannedTextActivity.this, RecorgnizeTextActivity.class);
        startActivity(intent);
    }

}
