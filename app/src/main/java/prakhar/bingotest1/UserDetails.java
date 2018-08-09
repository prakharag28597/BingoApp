package prakhar.bingotest1;

/**
 * Created by prakharag on 10-08-2018.
 */
public class UserDetails {
    private String userId;
    private String email;
    private int score;

    public int getScore() {
        return score;
    }

    public String getEmail() {
        return email;
    }

    public String getUserId() {
        return userId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
