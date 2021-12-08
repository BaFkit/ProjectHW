package Java_2.Lesson7.Server;

public interface AuthorizationService {
    void start();
    String getNickByLoginPass(String login, String pass);
    void stop();
}
