package com.example.Shabir_Ahmad142_appdev;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DetailedDataList extends AppCompatActivity {

    TextView pGName;
    TextView cityName;
    TextView localityName;
    TextView phoneNumber;
    TextView ownerName;
    TextView preferredLanguage;
    TextView applicationStatus;
    Button callOwner;
    Button submit;
    String mpn;
    private  static final  int REQUEST_CALL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_data_list);

        if (getIntent().hasExtra("selected user")) {
            DataList dataList = getIntent().getParcelableExtra("selected user");
            populateView(dataList);

        }
        callOwner = findViewById(R.id.callOwner);
        callOwner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePhoneCall();

           }


       });


    }

    private void populateView(DataList dataList) {
        pGName = (TextView)findViewById(R.id.property_name_detailed_data);
        cityName =  (TextView)findViewById(R.id.city_editText_detailed_data);
        localityName=  (TextView)findViewById(R.id.locality_editText_data);
        phoneNumber=  (TextView)findViewById(R.id.phone_number_detailed_data);
        ownerName=  (TextView)findViewById(R.id.owner_name_detailed_data);
        preferredLanguage=  (TextView)findViewById(R.id.preffered_language_detailed_data);
        applicationStatus =  (TextView)findViewById(R.id.applications_status_detailed_data);
        mpn = dataList.getPhoneNumber();
        callOwner = (Button)findViewById(R.id.callOwner);
        submit  = (Button)findViewById(R.id.submit);

 //       pGName.setText("Property Name: ");
        applicationStatus.setText("Application Status: "+dataList.getApplicationStatus());
 //       cityName.setText("City Name: ");
//        localityName.setText("Locality Name: ");
        phoneNumber.setText("Owner Number: "+dataList.getPhoneNumber());
        ownerName.setText("Owner Name: "+dataList.getOwnerName());

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_CALL){
            if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                makePhoneCall();
            }else{
                Toast.makeText(this,"Permission Denied",Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void makePhoneCall() {
        cityName.setText(mpn);
        String mobileNumber = cityName.getText().toString();
        if(mobileNumber.length()>0){
            if (ActivityCompat.checkSelfPermission(DetailedDataList.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                ActivityCompat.requestPermissions(DetailedDataList.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
                return;
            }else{
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + mobileNumber)));
            }
        }else{
            Toast.makeText(DetailedDataList.this,"Enter a valid phone number",Toast.LENGTH_SHORT).show();
        }
    }
}
