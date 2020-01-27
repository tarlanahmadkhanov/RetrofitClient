package com.learnandroid.retrofitclient;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final TextView txtPhoneNumber = findViewById(R.id.txtPhoneNumber);
        final TextView txtName = findViewById(R.id.txtName);
        final TextView txtSurname = findViewById(R.id.txtSurname);
        final TextView txtEmail = findViewById(R.id.txtEmail);

        Button btnGetData = findViewById(R.id.btnGetdata);

        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Requester requester = Requester.getInstance();
                requester.connect();

                ContactItem contactItem = requester.getContactItem();

                if (contactItem!=null) {
                    txtPhoneNumber.setText(contactItem.getPhoneNumber());
                    txtName.setText(contactItem.getName());
                    txtSurname.setText(contactItem.getSurname());
                    txtEmail.setText(contactItem.getEmail());
                }

            }
        });

    }
}
