package prakhar.bingotest1;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by prakharag on 08-08-2018.
 */

public class SignUp extends AppCompatActivity {

    private EditText emailText;
    private EditText passwordText;
    private Button signup;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.signup);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        firebaseAuth = FirebaseAuth.getInstance();
        emailText = (EditText)findViewById(R.id.userEmail);
        passwordText = (EditText)findViewById(R.id.userPassword);
        signup = (Button) findViewById(R.id.signupButton);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                authourizeUser();
            }
        });
    }

    void authourizeUser(){
        final String email =  emailText.getText().toString().trim();
        String password = passwordText.getText().toString().trim();
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseUser currentUser = firebaseAuth.getCurrentUser();
                            //write the username to database
                            writeToDB(email);
                            Toast.makeText(getApplicationContext(), "Authentication Success", Toast.LENGTH_SHORT).show();
                            //updateUI(currentUser);
                        }else{
                            Toast.makeText(getApplicationContext(), "Authentication Failed", Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }
                    }
                });
    }


    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if(currentUser==null)
            Toast.makeText(getApplicationContext(), "Authentication Failed", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(getApplicationContext(), "Authentication Success", Toast.LENGTH_SHORT).show();
        //updateUI(currentUser);
    }

    void writeToDB(String email){
        //trim to get the username
        UserDetails userDetails = new UserDetails();
        userDetails.setEmail(firebaseAuth.getCurrentUser().getEmail());
        userDetails.setUserId(firebaseAuth.getCurrentUser().getUid());
        databaseReference.child("user").setValue(userDetails);
    }
}
