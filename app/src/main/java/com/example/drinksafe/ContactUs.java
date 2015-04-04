package com.example.drinksafe;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class ContactUs extends ActionBarActivity implements View.OnClickListener {
    EditText subjectField, messageField;
    TextView toField;
    Button send, home;
    String email, subject, message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        setUpButtons();
    }

    private void setUpButtons() {
        toField = (TextView) findViewById(R.id.tvEmailPopulated);
        toField.setText("To: Louisedjones@gmail.com");
        subjectField = (EditText) findViewById(R.id.etSubject);
        messageField = (EditText) findViewById(R.id.etMessage);
        send = (Button) findViewById(R.id.btnSend);
        home = (Button) findViewById(R.id.btnMain);
        send.setOnClickListener(this);
        home.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSend:
                sendEmail();
                break;
            case R.id.btnMain:
                Intent openMain = new Intent(ContactUs.this, MainActivity.class);
                startActivity(openMain);
                break;
            default:
                break;
        }
    }

    private void sendEmail() {
        if (toField.getText().toString().length() == 0) {
            //if to field empty display message
            Toast.makeText(ContactUs.this,
                    "An e-mail address must be entered", Toast.LENGTH_SHORT).show();
            //if subject field empty display message
        } else if (subjectField.getText().toString().length() == 0) {

            Toast.makeText(ContactUs.this,
                    "A Subject must be entered", Toast.LENGTH_SHORT).show();
            //if message field empty display message
        } else if (messageField.getText().toString().length() == 0) {

            Toast.makeText(ContactUs.this,
                    "A message must be entered", Toast.LENGTH_SHORT).show();

        } else {
            //call details from form method
            detailsFromForm();
            String emailAddress[] = {email};
            //new intent to send email
            Intent sendEmail = new Intent(android.content.Intent.ACTION_SEND);
            sendEmail.putExtra(android.content.Intent.EXTRA_EMAIL, emailAddress);
            sendEmail.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
            sendEmail.putExtra(android.content.Intent.EXTRA_TEXT, message);
            sendEmail.setType("Plain/text");
            //start send email activity
            startActivity(sendEmail);

        }


    }

    private void detailsFromForm() {
        // TODO Auto-generated method stub
        //store in email what the user enters in the to field
        email = toField.getText().toString();
        subject = subjectField.getText().toString();
        message = messageField.getText().toString();
    }
}
