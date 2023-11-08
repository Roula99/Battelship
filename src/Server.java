import java.io.*;
import java.net.*;
import java.util.Random;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Väntar på en klientanslutning...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Klient ansluten.");

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String response;
            String shot = null;
            boolean gameOver = false;

            while (!gameOver) {


                if (gameOver) {
                    out.println(Protocol.GAME_OVER);
                    break;
                }

                // Skicka skottet till klienten
                out.println(new Scanner(System.in).nextLine());
                String meddelande = "i shot xy";
                out.println("klienten skjuter första skottet");

                String meddelande1 = "h shot xy";
                out.println("Bra jobbat! senaste skott var en träff ");

                String meddelande2 = "m shot xy";
                out.println("Tyvärr, skott var en miss ");

                String meddelande3 = "s shot xy";
                out.println("Bra jobbat! senaste skott var en träff som även sänkte ett skepp.");

                String meddelande4 = "game over";
                out.println("GAME OVER!");




                response = in.readLine(); // Ta emot svar från klienten

                // Implementera logik för att hantera klientens svar
                // Uppdatera 'gameOver' om det sista skeppet sänks
            }

            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

