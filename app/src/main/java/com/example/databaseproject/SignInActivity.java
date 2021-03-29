package com.example.databaseproject;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.databaseproject.ui.home.HomeFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.pranavpandey.android.dynamic.toasts.DynamicToast;

public class SignInActivity extends AppCompatActivity {

    CardView cardView;
    FirebaseAuth auth;
    EditText txtemail, txtpassword, txtid;
    TextView txtForgetPassword;
    String mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        cardView = findViewById(R.id.sign_in);
        txtemail = findViewById(R.id.email_edit);
        txtpassword = findViewById(R.id.pass_edit);
        txtid = findViewById(R.id.id_edit);
        auth = FirebaseAuth.getInstance();
        txtForgetPassword = findViewById(R.id.forget_password);

        txtForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mail = txtemail.getText().toString().trim();
                auth.sendPasswordResetEmail(mail).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(SignInActivity.this, "the password sent to your email success", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(SignInActivity.this, "Failed to send password", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });


        cardView.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                String id = txtid.getText().toString().trim();
                mail = txtemail.getText().toString().trim();
                String password = txtpassword.getText().toString().trim();
                Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

                if (TextUtils.isEmpty(id)) {
                    txtid.setError("enter the id first");
                    txtid.setHint("enter the id first");
                    txtid.setHintTextColor(getResources().getColor(R.color.red));
                    v.vibrate(400);
                    return;
                } else if (TextUtils.isEmpty(mail)) {
                    txtemail.setError("please enter your email ");
                    txtemail.setHint("enter your email");
                    txtemail.setHintTextColor(getResources().getColor(R.color.red));
                    v.vibrate(400);
                    return;
                } else if (TextUtils.isEmpty(password)) {
                    txtpassword.setError("please enter your password ");
                    txtpassword.setHint("enter your password");
                    txtpassword.setHintTextColor(getResources().getColor(R.color.red));
                    v.vibrate(400);
                    return;
                } else if (txtpassword.length() < 6) {
                    txtpassword.setError("must be >6");
                    v.vibrate(400);
                    return;
                }
                auth.signInWithEmailAndPassword(mail, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                       /*
                       Toast  toast = new Toast(SignInActivity.this);
                       ImageView v = new ImageView(SignInActivity.this);
                       v.setImageResource(R.drawable.verified_user_24);
                       toast.setText("sign success");
                       toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                       toast.setDuration(Toast.LENGTH_LONG);
                       toast.setView(v);
                       toast.show();
*/
                            Toast.makeText(SignInActivity.this, "sign success", Toast.LENGTH_SHORT).show();
                            //  DynamicToast.make(SignInActivity.this, "sign success", R.drawable.verified_user_24, Toast.LENGTH_LONG ).show();
                            //  DynamicToast.makeSuccess(SignInActivity.this, "sign success", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(SignInActivity.this, MainActivity.class);
                            i.putExtra("id", txtid.getText().toString());
                            startActivity(i);

                       /* Bundle b = new Bundle();
                        b.putString("id",txtid.getText().toString());
                        HomeFragment s = new HomeFragment();
                        s.setArguments(b);*/


                        } else {
                            Toast.makeText(SignInActivity.this, "Error!!" + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            // DynamicToast.makeWarning(SignInActivity.this, "Error!!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });

            }
        });

    }
}