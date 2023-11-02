import java.io.*;
import java.net.Socket;

class BattleshipClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("server-ip", 12345); // Ange serverns IP-adress och portnummer

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println("Hej, jag är klienten!");

            // Exempel: Ta emot svar från servern
            String response = in.readLine();
            System.out.println("Från servern: " + response);

            // Stäng resurser
            in.close();
            out.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
