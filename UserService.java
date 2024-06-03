import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<String, String> users;

    public UserService() {
        users = new HashMap<>();
        // Sample user data
        users.put("user1", "password1");
        users.put("user2", "password2");
    }

    public boolean login(String loginId, String password) {
        return users.containsKey(loginId) && users.get(loginId).equals(password);
    }
}
