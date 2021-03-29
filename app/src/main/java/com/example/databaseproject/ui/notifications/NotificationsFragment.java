package com.example.databaseproject.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.databaseproject.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class NotificationsFragment extends Fragment {
TextView subject1,subject2,subject3,subject4,subject5,subject6,subject7,hideid;
TextView subject1code,subject1hour;
TextView name,national,department,number;


FirebaseDatabase database;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    public NotificationsFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_current, container, false);

        database =FirebaseDatabase.getInstance();

        subject1 = v.findViewById(R.id.subject1_current);
        subject2 = v.findViewById(R.id.subject2_current);
        subject3 = v.findViewById(R.id.subject3_current);
        subject4 = v.findViewById(R.id.subject4_current);
        subject5 = v.findViewById(R.id.subject5_current);
        subject6 = v.findViewById(R.id.subject6_current);
        subject7 = v.findViewById(R.id.subject7_current);

        subject1code = v.findViewById(R.id.subject1_current_code);
        subject1hour = v.findViewById(R.id.subject1_current_hour);
        hideid = v.findViewById(R.id.hideidcurrent);

        name = v.findViewById(R.id.student_name_current);
        national = v.findViewById(R.id.student_national_current);
        number = v.findViewById(R.id.student_number_current);
        department = v.findViewById(R.id.student_depart_current);

        Bundle x = new Bundle();
        x= getActivity().getIntent().getExtras();
        String text = x.getString("id");
        hideid.setText(text);

database.getReference().child(hideid.getText().toString()).child("DepartmentCurrent").addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot snapshot) {
        department.setText(snapshot.getValue().toString());
    }

    @Override
    public void onCancelled(@NonNull DatabaseError error) {

    }
});



        information_student();

if ( database .getReference().child(hideid.getText().toString()).child("chooseDepartment").child("it")!=null){
    studentit();
}




        return v;


    }

    void studentit(){

            database .getReference().child(hideid.getText().toString()).child("chooseDepartment").child("subject1").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    subject1.setText(snapshot.getValue().toString());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {


                }
            });



        database .getReference().child(hideid.getText().toString()).child("chooseDepartment").child("subject2").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                subject2.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {


            }
        });

        database .getReference().child(hideid.getText().toString()).child("chooseDepartment").child("subject3").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                subject3.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {


            }
        });

        database .getReference().child(hideid.getText().toString()).child("chooseDepartment").child("subject4").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                subject4.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {


            }
        });

        database .getReference().child(hideid.getText().toString()).child("chooseDepartment").child("subject5").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                subject5.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {


            }
        });

        database .getReference().child(hideid.getText().toString()).child("chooseDepartment").child("subject6").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                subject6.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {


            }
        });

        database .getReference().child(hideid.getText().toString()).child("chooseDepartment").child("subject7").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                subject7.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {


            }
        });
    }

    void studentcs(){

        database .getReference().child(hideid.getText().toString()).child("chooseDepartment").child("cs").child("subject1").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                subject1.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {


            }
        });



        database .getReference().child(hideid.getText().toString()).child("chooseDepartment").child("cs").child("subject2").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                subject2.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {


            }
        });

        database .getReference().child(hideid.getText().toString()).child("chooseDepartment").child("cs").child("subject3").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                subject3.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {


            }
        });

        database .getReference().child(hideid.getText().toString()).child("chooseDepartment").child("cs").child("subject4").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                subject4.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {


            }
        });

        database .getReference().child(hideid.getText().toString()).child("chooseDepartment").child("cs").child("subject5").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                subject5.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {


            }
        });

        database .getReference().child(hideid.getText().toString()).child("chooseDepartment").child("cs").child("subject6").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                subject6.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {


            }
        });

        database .getReference().child(hideid.getText().toString()).child("chooseDepartment").child("cs").child("subject7").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                subject7.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {


            }
        });
    }

    void information_student(){
        database.getReference().child(hideid.getText().toString()).child("name").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                name.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
/*
        database.getReference().child(hideid.getText().toString()).child("department").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                department.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
*/
        database.getReference().child(hideid.getText().toString()).child("id").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                number.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        database.getReference().child(hideid.getText().toString()).child("national").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                national.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}