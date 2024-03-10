package com.example.dreambuild;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    EditText inputEmail,inputPassword;
    TextView textView4;
    Button loginButton;
    String emailPattern="[a-zA-z0-9._-]+@[a-z]+\\.+[a-z]+";


    FirebaseAuth mAuth;
    FirebaseUser mUser;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //This line Hides Action Bar(Top Bar)
        getSupportActionBar().hide();

        loginButton=findViewById(R.id.button);

        inputEmail=findViewById(R.id.editTextTextEmailAddress);
        inputPassword=findViewById(R.id.editTextTextPassword);

        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();

        progressDialog=new ProgressDialog(this);



        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performLogin();
            }
        });

        textView4=findViewById(R.id.textView4);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Signup.class);
                startActivity(intent);
            }
        });
    }

    private void performLogin() {
        String email=inputEmail.getText().toString();
        String password=inputPassword.getText().toString();


        if(!email.matches(emailPattern)){
            inputEmail.setError("Enter Correct Email");
        }
        else if(password.isEmpty() || password.length()<6){
            inputPassword.setError("Enter Proper Password");

        }
        else{

            progressDialog.setMessage("Please Wait While We Login...");
            progressDialog.setTitle("Logging in");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();


            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){

                        progressDialog.dismiss();
                        sendUserToNextActivity();
                        Toast.makeText(MainActivity.this,"Login Successful",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        progressDialog.dismiss();
                        Toast.makeText(MainActivity.this,""+task.getException(),Toast.LENGTH_SHORT).show();
                    }
                }
            });


        }
    }
    private void sendUserToNextActivity() {
        Intent intent=new Intent(MainActivity.this,Parts.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}