package com.example.Shabir_Ahmad142_appdev;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class NewApplication extends AppCompatActivity {

    Button submit;
    Button validateNumber;
    EditText clientMobileNumber;
    EditText pGName;
    EditText city;
    EditText locality;
    EditText ownerName;
    EditText prefreredLanguage;
    ProgressBar progressBar;
    private FirebaseDatabase mFireBaseDatabase;
    private DatabaseReference mPhoneDatabaseReference;
    private ChildEventListener mChildEventListener;
    Dialog popUpDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_application);
        submit = (Button)findViewById(R.id.submit_button);
        clientMobileNumber = (EditText)findViewById(R.id.data_entry_mobile_number);
        mFireBaseDatabase  = FirebaseDatabase.getInstance();
        mPhoneDatabaseReference = FirebaseDatabase.getInstance().getReference("users");
        progressBar =(ProgressBar)findViewById(R.id.progressbarNew);
         pGName= (EditText)findViewById(R.id.property_name);
         city= (EditText)findViewById(R.id.city_editText);
         locality= (EditText)findViewById(R.id.locality_editText);
         ownerName = (EditText)findViewById(R.id.owner_name);
         prefreredLanguage = (EditText)findViewById(R.id.preffered_language);

         popUpDialog = new Dialog(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPhoneDatabaseReference = FirebaseDatabase.getInstance().getReference("users");
                String phoneNumber = clientMobileNumber.getText().toString().trim();
                String propertyName = pGName.getText().toString();
                String cityName = city.getText().toString();
                String localityName = locality.getText().toString();
                String owner = ownerName.getText().toString();
                String language = prefreredLanguage.getText().toString();
                String applicationStatus = "Pending";
                if(propertyName.isEmpty() || cityName.isEmpty() || localityName.isEmpty()){
                    if(propertyName.isEmpty()){
                    pGName.setError("Enter Property name");
                    pGName.requestFocus();
                    }else if(cityName.isEmpty()){
                        city.setError("Enter City Name");
                        city.requestFocus();
                    }else if(localityName.isEmpty()) {
                        locality.setError("Enter Area or Locality Name");
                        locality.requestFocus();
                    }
                    return;
                }
                if(owner.isEmpty()){
                    owner = "NA";
                }
                if(language.isEmpty()){
                    language = "NA";
                }
                Log.v("firbase", "getting key");
                String id = mPhoneDatabaseReference.push().getKey();
                Log.v("firebase", id);
                ApplicationForm form = new ApplicationForm(propertyName, phoneNumber, cityName, localityName, owner, language, applicationStatus);
                mPhoneDatabaseReference.child(id).setValue(form);
                Log.v("firebase", "form submitted");
//                addUsers();
                Toast.makeText(NewApplication.this,"Data successfully submitted to database",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(v.getContext(),Dashboard.class);
                startActivity(intent);
                finish();
            }
        });

        validateNumber = (Button)findViewById(R.id.validate_mobileNumber);
        validateNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phoneNumber = clientMobileNumber.getText().toString().trim();
                if (phoneNumber.isEmpty() || phoneNumber.length() !=10) {
                    clientMobileNumber.setError("Enter valid phone number");
                    clientMobileNumber.requestFocus();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                validationProcess();
                progressBar.setVisibility(View.INVISIBLE);

            }
        });
    }

    private void validationProcess() {
        mPhoneDatabaseReference = FirebaseDatabase.getInstance().getReference().child("users");

        mPhoneDatabaseReference.orderByChild("phoneNumber").equalTo(clientMobileNumber.getText().toString().trim())
                .addListenerForSingleValueEvent(new ValueEventListener() {

                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            //phone number exists in Database
                            //show popup
                            showPopUP();
                            Toast.makeText(NewApplication.this,"phoneNumber already exists",Toast.LENGTH_LONG).show();
                        } else {
                            //phone number doesn't exists.
                            //show form applicaiton layout;
                            LinearLayout applicationLayout = (LinearLayout)findViewById(R.id.innerApplication_layout);
                            applicationLayout.setVisibility(View.VISIBLE);
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(NewApplication.this,databaseError.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
    }

//    private void addUsers() {

//        String phoneNumber = clientMobileNumber.getText().toString().trim();
//        String propertyName = pGName.getText().toString();
//        String cityName = city.getText().toString();
//        String localityName = locality.getText().toString();
//        String owner = ownerName.getText().toString();
//        String language = prefreredLanguage.getText().toString();
//        String applicationStatus = "Pending";
//        if((propertyName.isEmpty())){
//
//            pGName.setError("Enter Property name");
//            return;
//            if(propertyName.isEmpty()){
//                pGName.setError("Enter Property name");
//                pGName.requestFocus();
//            }else if(cityName.isEmpty()){
//                city.setError("Enter City Name");
//                city.requestFocus();
//            }else if(localityName.isEmpty()) {
//                locality.setError("Enter Area or Locality Name");
//                locality.requestFocus();
//            }
//        }else {
//            Log.v("firbase", "getting key");
//            String id = mPhoneDatabaseReference.push().getKey();
//            Log.v("firebase", id);
//            ApplicationForm form = new ApplicationForm(propertyName, phoneNumber, cityName, localityName, owner, language, applicationStatus);
//            mPhoneDatabaseReference.child(id).setValue(form);
//            Log.v("firebase", "form submitted");
//        }
//    }

    public void showPopUP(){
        TextView popupMessage;
        Button Dismiss;
        popUpDialog.setContentView(R.layout.popup);
        popupMessage =(TextView) popUpDialog.findViewById(R.id.popup_message);
        popupMessage.setText(R.string.popu_message);
        Dismiss = (Button) popUpDialog.findViewById(R.id.dismiss_button);
        Dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popUpDialog.dismiss();
            }
        });
        popUpDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        popUpDialog.show();

    }

}
