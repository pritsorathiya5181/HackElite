package getgood.dogood.bestocr;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Manual_add extends AppCompatActivity {

    EditText expenses,spent;
    DatabaseReference raff;
    Button save;

    Receipt receipt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_add);

        expenses = (EditText)findViewById(R.id.expenses);
        spent = (EditText)findViewById(R.id.spent);
        save = (Button) findViewById(R.id.btnsave);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                receipt = new Receipt();
                raff = FirebaseDatabase.getInstance().getReference().child("Receipt");
                Float payment = Float.parseFloat(expenses.getText().toString().trim());
                receipt.setPlace(spent.getText().toString().trim());
                receipt.setPayment(payment);
                raff.push().setValue(receipt);
                Toast.makeText(Manual_add.this, "Data Inserted", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
