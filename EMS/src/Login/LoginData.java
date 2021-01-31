package Login;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class LoginData {
    String name;
    String mobNumber;
    String userId;
    String password;

    File loginData = new File("EMSLoginData.txt");

    void saveData() {
        try {
            FileWriter write = new FileWriter(loginData, true);

            write.append(name + ";" + mobNumber + ";" + userId + ";" + password + "\n");

            write.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
