package prakhar.bingotest1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class LeaderBoard extends AppCompatActivity {

    private ListView listView;
    private DatabaseReference databaseReference;
    private List<String> emailList, scoreList, onlineStatusList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_board);

        listView = (ListView) findViewById(R.id.leaderboardList);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("users");
        getEmailList();
    }

    private void getEmailList() {
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                emailList = new ArrayList<>();
                scoreList = new ArrayList<>();
                onlineStatusList = new ArrayList<>();

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    String email = ds.child("email").getValue().toString();
                    String score = ds.child("score").getValue().toString();
                    String onlineStatus = ds.child("online").getValue().toString();
                    emailList.add(email);
                    scoreList.add(score);
                    onlineStatusList.add(onlineStatus);
                }
                populateData();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        databaseReference.addValueEventListener(valueEventListener);
    }

    private void populateData() {
        LeaderBoardAdapter leaderBoardAdapter = new LeaderBoardAdapter(getLayoutInflater(), emailList, scoreList, onlineStatusList);
        listView.setAdapter(leaderBoardAdapter);
    }

}
