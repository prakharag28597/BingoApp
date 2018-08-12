package prakhar.bingotest1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by prakharag on 12-08-2018.
 */

public class LeaderBoardAdapter extends BaseAdapter {

    LayoutInflater layoutInflator;
    private List<String> emailList, scoreList, onlineStatusList;

    public LeaderBoardAdapter(LayoutInflater layoutInflater, List<String> emailList, List<String> scoreList, List<String> onlineStatusList) {
        this.layoutInflator = layoutInflater;
        this.emailList = emailList;
        this.scoreList = scoreList;
        this.onlineStatusList = onlineStatusList;
    }

    @Override
    public int getCount() {
        return emailList.size();
    }

    @Override
    public Object getItem(int i) {
        UserDetails userDetails = new UserDetails();
        userDetails.setEmail(emailList.get(i));
        userDetails.setOnline(onlineStatusList.get(i));
        userDetails.setScore(scoreList.get(i));
        return userDetails;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = layoutInflator.inflate(R.layout.leaderboard_row_template, null);
        TextView username = (TextView) view.findViewById(R.id.username);
        TextView score = (TextView) view.findViewById(R.id.score);
        TextView online_status = (TextView) view.findViewById(R.id.online_status);

        username.setText(emailList.get(i));
        score.setText(scoreList.get(i));
        online_status.setText(onlineStatusList.get(i));
        return view;
    }
}
