package com.example.databaseproject.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.databaseproject.MainActivity;
import com.example.databaseproject.R;
import com.example.databaseproject.ui.notifications.NotificationsFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class DashboardFragment extends Fragment {
TextView txtgpa,txtid;
FirebaseDatabase database;
DatabaseReference reference;
RadioGroup rg,rg1;
RadioButton it,cs,is,mm,spring,summer,winter,automn;
CardView Lit,Lis,Lcs,Lmm;
FloatingActionButton fag;

CheckBox itnetwork,subject2it,subject3it,subject4it,subject5it,subject6it,subject7it,subject8it,subject9it;
CheckBox subject1cs,subject2cs,subject3cs,subject4cs,subject5cs,subject6cs,subject7cs,subject8cs,subject9cs;
CheckBox subject1is,subject2is,subject3is,subject4is,subject5is,subject6is,subject7is,subject8is,subject9is;
CheckBox subject1mm,subject2mm,subject3mm,subject4mm,subject5mm,subject6mm,subject7mm,subject8mm,subject9mm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    public DashboardFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_register, container, false);
        database = FirebaseDatabase.getInstance();
        txtgpa = v.findViewById(R.id.gpa_register);
        txtid = v.findViewById(R.id.txt_id_register);
        rg = v. findViewById(R.id.radio_group_depart);
        rg1 = v.findViewById(R.id.radio_group_term);

        //radiobuttons

        it = v.findViewById(R.id.it);
        is = v.findViewById(R.id.is);
        cs = v.findViewById(R.id.cs);
        mm = v.findViewById(R.id.mm);

        spring = v.findViewById(R.id.spring);
        winter = v.findViewById(R.id.winter);
        summer = v.findViewById(R.id.summer);
        automn = v.findViewById(R.id.autumn);


        //layouts

        Lcs = v.findViewById(R.id.Lcs);
        Lis = v.findViewById(R.id.Lis);
        Lit = v.findViewById(R.id.Lit);
        Lmm = v.findViewById(R.id.Lmm);

        //it department

        itnetwork = v.findViewById(R.id.itnetwork);
        subject2it = v.findViewById(R.id.subject2it);
        subject3it = v.findViewById(R.id.subject3it);
        subject4it = v.findViewById(R.id.subject4it);
        subject5it = v.findViewById(R.id.subject5it);
        subject6it = v.findViewById(R.id.subject6it);
        subject7it = v.findViewById(R.id.subject7it);
        subject8it = v.findViewById(R.id.subject8it);
        subject9it = v.findViewById(R.id.subject9it);

        //cs department

        subject1cs = v.findViewById(R.id.subject1cs);
        subject2cs = v.findViewById(R.id.subject2cs);
        subject3cs = v.findViewById(R.id.subject3cs);
        subject4cs = v.findViewById(R.id.subject4cs);
        subject5cs = v.findViewById(R.id.subject5cs);
        subject6cs = v.findViewById(R.id.subject6cs);
        subject7cs = v.findViewById(R.id.subject7cs);
        subject8cs = v.findViewById(R.id.subject8cs);
        subject9cs = v.findViewById(R.id.subject9cs);

        //is department

        subject1is = v.findViewById(R.id.suject1is);
        subject2is = v.findViewById(R.id.suject2is);
        subject3is = v.findViewById(R.id.suject3is);
        subject4is = v.findViewById(R.id.suject4is);
        subject5is = v.findViewById(R.id.suject5is);
        subject6is = v.findViewById(R.id.suject6is);
        subject7is = v.findViewById(R.id.suject7is);
        subject8is = v.findViewById(R.id.suject8is);
        subject9is = v.findViewById(R.id.suject9is);

        //mm department
        subject1mm = v.findViewById(R.id.subject1mm);
        subject2mm = v.findViewById(R.id.subject2mm);
        subject3mm = v.findViewById(R.id.subject3mm);
        subject4mm = v.findViewById(R.id.subject4mm);
        subject5mm = v.findViewById(R.id.subject5mm);
        subject6mm = v.findViewById(R.id.subject6mm);
        subject7mm = v.findViewById(R.id.subject7mm);
        subject8mm = v.findViewById(R.id.subject8mm);
        subject9mm = v.findViewById(R.id.subject9mm);



        fag = v.findViewById(R.id.fab);

rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (it.isChecked()){
            reference = FirebaseDatabase.getInstance().getReference().child(txtid.getText().toString()).child("DepartmentCurrent");
            reference.setValue(it.getText().toString());



            Lit.setVisibility(View.VISIBLE);
            Lcs.setVisibility(View.GONE);
            Lis.setVisibility(View.GONE);
            Lmm.setVisibility(View.GONE);


        }
        else if (is.isChecked()){

            reference = FirebaseDatabase.getInstance().getReference().child(txtid.getText().toString()).child("DepartmentCurrent");
            reference.setValue(is.getText().toString());

            Lit.setVisibility(View.GONE);
            Lcs.setVisibility(View.GONE);
            Lis.setVisibility(View.VISIBLE);
            Lmm.setVisibility(View.GONE);
        }
        else if (cs.isChecked()){

            reference = FirebaseDatabase.getInstance().getReference().child(txtid.getText().toString()).child("DepartmentCurrent");
            reference.setValue(cs.getText().toString());
            Lit.setVisibility(View.GONE);
            Lcs.setVisibility(View.VISIBLE);
            Lis.setVisibility(View.GONE);
            Lmm.setVisibility(View.GONE);
        }
        else if (mm.isChecked()){

            reference = FirebaseDatabase.getInstance().getReference().child(txtid.getText().toString()).child("DepartmentCurrent");
            reference.setValue(mm.getText().toString());

            Lit.setVisibility(View.GONE);
            Lcs.setVisibility(View.GONE);
            Lis.setVisibility(View.GONE);
            Lmm.setVisibility(View.VISIBLE);
        }
    }
});

rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (spring.isChecked()){
            reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("seasons");
            reference.setValue(spring.getText().toString());
        }

        if (summer.isChecked()){
            reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("seasons");
            reference.setValue(summer.getText().toString());
        }

        if (winter.isChecked()){
            reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("seasons");
            reference.setValue(winter.getText().toString());
        }

        if (automn.isChecked()){
            reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("seasons");
            reference.setValue(automn.getText().toString());
        }
    }
});

fag.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if (it.isChecked()) {
    //database.getReference(txtid.getText().toString()).child("chooseDepartment").child("cs").removeValue();
   // database.getReference(txtid.getText().toString()).child("chooseDepartment").child("is").removeValue();
   // database.getReference(txtid.getText().toString()).child("chooseDepartment").child("mm").removeValue();

    if (itnetwork.isChecked()){
    reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject1");
    reference.setValue(itnetwork.getText().toString());
}else {
        reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject1");
        reference.setValue("None");

    }
    if (subject2it.isChecked()){

    reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject2");
    reference.setValue(subject2it.getText().toString());
    }else {
        reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject2");
        reference.setValue("None");
    }
    if (subject3it.isChecked()){

        reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject3");
        reference.setValue(subject3it.getText().toString());
    }else {
        reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject3");
        reference.setValue("None");
    }

    if (subject4it.isChecked()){

        reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject4");
        reference.setValue(subject4it.getText().toString());
    }else {
        reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject4");
        reference.setValue("None");
    }
    if (subject5it.isChecked()){

        reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject5");
        reference.setValue(subject5it.getText().toString());
    }else {
        reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject5");
        reference.setValue("None");
    }

    if (subject6it.isChecked()){

        reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject6");
        reference.setValue(subject6it.getText().toString());
    }else {
        reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject6");
        reference.setValue("None");
    }

    if (subject7it.isChecked()){

        reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject7");
        reference.setValue(subject7it.getText().toString());
    }else {
        reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject7");
        reference.setValue("None");
    }
    reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject8");
    reference.setValue(subject8it.getText().toString());

    reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject9");
    reference.setValue(subject9it.getText().toString());

    Toast.makeText(getActivity(), "saved success", Toast.LENGTH_SHORT).show();


}
       /////////////////////////////////////////////////////////////////////////////////////////////////

        if (cs.isChecked()) {
           // database.getReference(txtid.getText().toString()).child("chooseDepartment").child("it").removeValue();
           // database.getReference(txtid.getText().toString()).child("chooseDepartment").child("is").removeValue();
            //database.getReference(txtid.getText().toString()).child("chooseDepartment").child("mm").removeValue();
            if (subject1cs.isChecked()){
                reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject1");
                reference.setValue(subject1cs.getText().toString());
            }else {
                reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject1");
                reference.setValue("None");

            }
            if (subject2cs.isChecked()){
                reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject2");
                reference.setValue(subject2cs.getText().toString());
            }else {
                reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject2");
                reference.setValue("None");

            }
            if (subject3cs.isChecked()){
                reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject3");
                reference.setValue(subject3cs.getText().toString());
            }else {
                reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject3");
                reference.setValue("None");

            }

            if (subject4cs.isChecked()){
                reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject4");
                reference.setValue(subject4cs.getText().toString());
            }else {
                reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject4");
                reference.setValue("None");

            }
            if (subject5cs.isChecked()){
                reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject5");
                reference.setValue(subject5cs.getText().toString());
            }else {
                reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject5");
                reference.setValue("None");

            }

            if (subject6cs.isChecked()){
                reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject6");
                reference.setValue(subject6cs.getText().toString());
            }else {
                reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject6");
                reference.setValue("None");

            }

            if (subject7cs.isChecked()){
                reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject7");
                reference.setValue(subject7cs.getText().toString());
            }else {
                reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject7");
                reference.setValue("None");

            }
            reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject8");
            reference.setValue(subject8cs.getText().toString());

            reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject9");
            reference.setValue(subject9cs.getText().toString());

            Toast.makeText(getActivity(), "saved success", Toast.LENGTH_SHORT).show();


        }

      //////////////////////////////////////////////////////////////////////////////////////////////////

        if (is.isChecked()) {
           // database.getReference(txtid.getText().toString()).child("chooseDepartment").child("it").removeValue();
           // database.getReference(txtid.getText().toString()).child("chooseDepartment").child("cs").removeValue();
           // database.getReference(txtid.getText().toString()).child("chooseDepartment").child("mm").removeValue();
            if (subject1is.isChecked()){
                reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject1");
                reference.setValue(subject1is.getText().toString());
            }else {
                reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject1");
                reference.setValue("None");

            }
            if (subject2is.isChecked()){
                reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject2");
                reference.setValue(subject2is.getText().toString());
            }else {
                reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject2");
                reference.setValue("None");

            }
            if (subject3is.isChecked()){
                reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject3");
                reference.setValue(subject3is.getText().toString());
            }else {
                reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject3");
                reference.setValue("None");

            }

            if (subject4is.isChecked()){
                reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject4");
                reference.setValue(subject4is.getText().toString());
            }else {
                reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject4");
                reference.setValue("None");

            }
            if (subject5is.isChecked()){
                reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject5");
                reference.setValue(subject5is.getText().toString());
            }else {
                reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject5");
                reference.setValue("None");

            }

            if (subject6is.isChecked()){
                reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject6");
                reference.setValue(subject6is.getText().toString());
            }else {
                reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject6");
                reference.setValue("None");

            }

            if (subject7is.isChecked()){
                reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject7");
                reference.setValue(subject7is.getText().toString());
            }else {
                reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject7");
                reference.setValue("None");

            }
            reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject8");
            reference.setValue(subject8is.getText().toString());

            reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject9");
            reference.setValue(subject9is.getText().toString());

            Toast.makeText(getActivity(), "saved success", Toast.LENGTH_SHORT).show();


        }

      ///////////////////////////////////////////////////////////////////////////////////////////////////

        if (mm.isChecked()) {
           // database.getReference(txtid.getText().toString()).child("chooseDepartment").child("it").removeValue();
          //  database.getReference(txtid.getText().toString()).child("chooseDepartment").child("cs").removeValue();
          //  database.getReference(txtid.getText().toString()).child("chooseDepartment").child("is").removeValue();
            if (subject1mm.isChecked()){
                reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject1");
                reference.setValue(subject1mm.getText().toString());
            }else {
                reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject1");
                reference.setValue("None");

            }
            if (subject2mm.isChecked()){
                reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject2");
                reference.setValue(subject2mm.getText().toString());
            }else {
                reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject2");
                reference.setValue("None");

            }
            if (subject3mm.isChecked()){
                reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject3");
                reference.setValue(subject3mm.getText().toString());
            }else {
                reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject3");
                reference.setValue("None");

            }

            if (subject4mm.isChecked()){
                reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject4");
                reference.setValue(subject4mm.getText().toString());
            }else {
                reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject4");
                reference.setValue("None");

            }
            if (subject5mm.isChecked()){
                reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject5");
                reference.setValue(subject5mm.getText().toString());
            }else {
                reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject5");
                reference.setValue("None");

            }

            if (subject6mm.isChecked()){
                reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject6");
                reference.setValue(subject6mm.getText().toString());
            }else {
                reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject6");
                reference.setValue("None");

            }

            if (subject7mm.isChecked()){
                reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject7");
                reference.setValue(subject7mm.getText().toString());
            }else {
                reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject7");
                reference.setValue("None");

            }
            reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject8");
            reference.setValue(subject8mm.getText().toString());

            reference = FirebaseDatabase.getInstance().getReference(txtid.getText().toString()).child("chooseDepartment").child("subject9");
            reference.setValue(subject9mm.getText().toString());

            Toast.makeText(getActivity(), "saved success", Toast.LENGTH_SHORT).show();


        }


}
});







        Bundle x = new Bundle();
        x= getActivity().getIntent().getExtras();
        String text = x.getString("id");
        txtid.setText(text);

        database.getReference().child(txtid.getText().toString()).child("gpa").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                txtgpa.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return v;
    }
}