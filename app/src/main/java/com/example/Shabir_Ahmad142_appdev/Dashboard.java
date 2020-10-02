package com.example.Shabir_Ahmad142_appdev;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Dashboard extends AppCompatActivity {
    protected  static long  applicationsSubmitCount;
    protected static long pendingApprovalCount = 98;
    protected  long applicationApprovedCount = 001;
    protected  long applicationsRejectedCount = 000;
    protected  long leadGeneratedCount =  001;
    TextView applicationsSubmitted;
    TextView pendingApproval;
    TextView applicationsApproved;
    TextView applicationsRejected;
    TextView leadGenerated;
    Button newSubmitDataEntry;
    int requestCode = 105;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getApplicationSubmittedCount();
        applicationsSubmitted = (TextView)findViewById(R.id.applications_submitted);
        pendingApproval = (TextView)findViewById(R.id.pending_approval);
        applicationsApproved = (TextView)findViewById(R.id.applications_approved);
        pendingApproval = (TextView)findViewById(R.id.pending_approval);
        applicationsRejected = (TextView)findViewById(R.id.applications_rejected);
        leadGenerated = (TextView)findViewById(R.id.lead_generated);
        long count = applicationsSubmitCount+100;
        pendingApprovalCount = count-2;

        applicationsSubmitted.setText(applicationsSubmitted.getText()+ "-"+Long.toString(count));
        pendingApproval.setText(pendingApproval.getText()+"-  "+Long.toString(pendingApprovalCount));
        applicationsApproved.setText(applicationsApproved.getText()+"- "+Long.toString(applicationApprovedCount));
        applicationsRejected.setText(applicationsRejected.getText()+"- "+Long.toString(applicationsRejectedCount));
        leadGenerated.setText(leadGenerated.getText()+"-  "+Long.toString(leadGeneratedCount));
        newSubmitDataEntry = (Button)findViewById(R.id.new_submit_entry);
        newSubmitDataEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),NewApplication.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void getApplicationSubmittedCount() {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("users");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                long count = snapshot.getChildrenCount();
                applicationsSubmitCount = count;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
