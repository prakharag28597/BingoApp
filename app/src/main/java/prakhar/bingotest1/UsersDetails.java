package prakhar.bingotest1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by prakharag on 09-08-2018.
 */

public class UsersDetails extends AppCompatActivity {

    private ListView userList;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //userList = (ListView)findViewById(R.id.userListView);
        firebaseAuth = FirebaseAuth.getInstance();
        showListView();
    }
    void showListView(){

    }
}
