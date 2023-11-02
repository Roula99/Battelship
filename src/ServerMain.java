import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;

class BattelShipServer {



    public static class BattleshipServer {
        public static void main(String[] args) throws IOException {
            ServerSocket serverSocket = new ServerSocket(12345); // Ange önskad port

            while (true) {
                Socket clientSocket = serverSocket.accept();
                Executors.newFixedThreadPool(2).submit(new BattleshipGame(clientSocket));
            }
        }
    }

    static class BattleshipGame implements Runnable {
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;

        public BattleshipGame(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));



                out.println("Välkommen till Battleship!");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}