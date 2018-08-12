package prakhar.bingotest1;

/**
 * Created by prakharag on 10-08-2018.
 */
public class UserDetails {
    private String email;
    private int score;
    private boolean online;

    public int getScore() {
        return score;
    }

    public String getEmail() {
        return email;
    }

    public boolean isOnline() {
        return online;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }
}
