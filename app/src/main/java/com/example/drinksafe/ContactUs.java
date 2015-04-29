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
    //declaring all variables/places for the objects to be held to use with code
    EditText subjectField, messageField, name, emailadd;
    TextView toField;
    Button send, home, addname;
    String email, subject, message, names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set page to the activity screen for contact us
        setContentView(R.layout.activity_contact_us);
        //call setUpButtons method below
        setUpButtons();
    }

    private void setUpButtons() {
        //linking above declared fields to the field in the activity screen
        toField = (TextView) findViewById(R.id.tvEmailPopulated);
        //setting the email address to the related field in activity
        toField.setText("Louisedjones@gmail.com");
        //linking fields in activity with allocated variables above
        subjectField = (EditText) findViewById(R.id.etSubject);
        messageField = (EditText) findViewById(R.id.etMessage);
        send = (Button) findViewById(R.id.btnSend);
        home = (Button) findViewById(R.id.btnMain);
        //allowing the two buttons to be listeners to create an action within 'this' class
        send.setOnClickListener(this);
        home.setOnClickListener(this);
        addname=(Button)findViewById(R.id.btnAdd);
       addname.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                newName();
            }
        });
        //setting the onclick listener for the home button to use the intent in manifest to open the main menu
    }

    @Override
    public void onClick(View v) {
        //switch to allow each button an action
        switch (v.getId()) {
            //if select send email button call sendEmail method below
            case R.id.btnSend:
                sendEmail();
                //stop once done do not move on to next in case
                break;
            //if select main menu button use intent created called openMain to open Main menu
            case R.id.btnMain:
                Intent openMain = new Intent(ContactUs.this, MainActivity.class);
                //start created intent to open main menu
                startActivity(openMain);
                //stop once done
                break;
            default:
                break;
        }
    }

    private void sendEmail() {
        //if to field empty
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
            //if message empty display message
            Toast.makeText(ContactUs.this,
                    "A message must be entered", Toast.LENGTH_SHORT).show();

        } else {
            //call details from form method
            detailsFromForm();
            //allocating emailAddress to array
            String emailAddress[] = {email};
            //new intent to send email
            Intent sendEmail = new Intent(android.content.Intent.ACTION_SEND);
            //putextra to carry information to email app
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
        //store in email what the user enters in the subject and message
        email = toField.getText().toString();
        subject = subjectField.getText().toString();
        message = messageField.getText().toString();
    }
    @Override
    public void onStart(){
        super.onStart();
        name=(EditText)findViewById(R.id.etName);
        emailadd=(EditText)findViewById(R.id.etEmail);

    }
    public void newName(){
        myDBHandler dbhandler = new myDBHandler(this, null, null, 1);
        String names = name.getText().toString();
        String emailaddr = emailadd.getText().toString();
         Name name = new Name (names, emailaddr);

        dbhandler.addName(name);
    }
}
