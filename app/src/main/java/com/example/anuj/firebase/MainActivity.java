package com.example.anuj.firebase;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
/*
    private Button submit;
    private Button show;
    private EditText entry;
    private EditText key;

    private TextView data;
    private String dbVal;
*/

    private FirebaseAuth mAuth;

    private EditText email;
    private EditText pass;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setElevation(0);

        mAuth = FirebaseAuth.getInstance();

        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);

        login = findViewById(R.id.login);

        //if (!TextUtils.isEmpty(mEmail) && !TextUtils.isEmpty(mPass)){
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String mEmail = email.getText().toString();
                    String mPass = pass.getText().toString();

                    mAuth.signInWithEmailAndPassword(mEmail, mPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()){
                                Toast.makeText(MainActivity.this, "Sign-in Failed!!!", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(MainActivity.this, "Sign-in Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(MainActivity.this, AddImage.class));
                            }
                        }
                    });
                }
            });
        //}

/*
        submit = findViewById(R.id.submit);
        show = findViewById(R.id.show);
        entry = findViewById(R.id.entry);
        key = findViewById(R.id.key);

        data = findViewById(R.id.data);
        dbVal = "";

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = db.getReference("users");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference childRef = myRef.child(key.getText().toString());
                childRef.setValue(entry.getText().toString());
                //childRef.setValue();
                entry.setText("");
                Toast.makeText(MainActivity.this, "Added to DB", Toast.LENGTH_SHORT).show();
            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ShowDatabase.class);
                startActivity(intent);
            }
        });

*/

    }
}
