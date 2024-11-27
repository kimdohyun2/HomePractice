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
        try (ServerSocket serverSocket = new ServerSocket(23456)){
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
                readFile();
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
                    Product tempPro;
                    Product already;
                    int n;
                    switch (st.nextToken()) {
                        case "1":
                            tempPro = gson.fromJson(st.nextToken(), Product.class);
                            already = alreadyPro(tempPro);
                            if(already == null){
                                products.add(tempPro);
                            }else{
                                already.price = tempPro.price;
                                already.stock += tempPro.stock;
                            }
                            break;
                        case "2":
                            n = Integer.parseInt(st.nextToken());
                            tempPro = gson.fromJson(st.nextToken(), Product.class);
                            already = alreadyPro(tempPro);
                            if(already == null){
                                Product pro = products.get(n - 1);
                                pro.name = tempPro.name;
                                pro.price = tempPro.price;
                                pro.stock = tempPro.stock;
                            } else {
                                products.remove(n-1);
                                already.price = tempPro.price;
                                already.stock += tempPro.stock;
                            }
                            break;
                        case "3":
                            n = Integer.parseInt(st.nextToken());
                            products.remove(n-1);
                            break;
                        case "4":
                            break loop;
                    }
                    writeFile();
                    productsBroadcast();
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

        void readFile() throws FileNotFoundException {
            try {
                FileReader reader = new FileReader("products.json");
                Type type = new TypeToken<ArrayList<Product>>(){}.getType();
                products = gson.fromJson(reader, type);
            } catch (FileNotFoundException ignored) {
            }
        }

        void writeFile() throws IOException {
            FileWriter writer = new FileWriter("products.json");
            gson.toJson(products, writer);
            writer.flush();
            writer.close();
        }

        Product alreadyPro(Product p){
            for (Product product : products) {
                if (product.name.equals(p.name)) {
                    return product;
                }
            }
            return null;
        }

        void productsBroadcast() throws IOException {
            for(ClientHandler c : clients) {
                gson.toJson(products, c.bw);
                c.bw.newLine();
                c.bw.flush();
            }
        }
    }
}
