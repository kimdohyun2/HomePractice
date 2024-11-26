package socket;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Server {
    static Set<ClientHandler> clients;
    static ArrayList<Product> products;

    public static void main(String[] args) throws IOException {
        clients = new HashSet<>();
        try {
            ServerSocket serverSocket = new ServerSocket(23456);
            System.out.println("Server start!");
            while(true) {
                ClientHandler ch = new ClientHandler(serverSocket.accept());
                clients.add(ch);
                ch.start();
                System.out.println("Client enter!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static class ClientHandler extends Thread{
        Socket soc;
        BufferedReader br;
        BufferedWriter bw;
        Gson gson;

        public ClientHandler(Socket soc) throws IOException {
            this.soc = soc;
            br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            bw = new BufferedWriter(new OutputStreamWriter(soc.getOutputStream()));
            gson = new Gson();
        }

        @Override
        public void run() {
            String in;
            StringTokenizer st;
            try {
                read();
                if(products == null){
                    products = new ArrayList<>();
                }else{
                    gson.toJson(products,bw);
                    bw.newLine();
                    bw.flush();
                }
                loop:
                while ((in = br.readLine()) != null) {
                    st = new StringTokenizer(in, "#");
                    switch (st.nextToken()) {
                        case "1":
                            Product insertPro = gson.fromJson(st.nextToken(), Product.class);
                            products.add(insertPro);
                            break;
                        case "2":
                            int n = Integer.parseInt(st.nextToken());
                            Product updatePro = gson.fromJson(st.nextToken(), Product.class);
                            Product pro = products.get(n-1);
                            pro.name = updatePro.name;
                            pro.price = updatePro.price;
                            pro.stock = updatePro.stock;
                            break;
                        case "3":
                            int deleteNum = Integer.parseInt(st.nextToken());
                            products.remove(deleteNum-1);
                            break;
                        case "4":
                            exit();
                            break loop;
                    }
                    gson.toJson(products,bw);
                    bw.newLine();
                    bw.flush();
                }
            } catch (IOException e) {
                System.out.println("Client disconnected!");
            }finally {
                System.out.println("Client exit!");
                clients.remove(Thread.currentThread());
                try {
                    soc.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        void read() throws FileNotFoundException {
            try {
                FileReader reader = new FileReader("products.json");
                Type type = new TypeToken<ArrayList<Product>>(){}.getType();
                products = gson.fromJson(reader, type);
            } catch (FileNotFoundException ignored) {
            }
        }

        void exit() throws IOException {
            FileWriter writer = new FileWriter("products.json");
            gson.toJson(products, writer);
            writer.flush();
            writer.close();
        }
    }
}
