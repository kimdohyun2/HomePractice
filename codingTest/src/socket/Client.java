package socket;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.net.Socket;
import java.util.ArrayList;

public class Client {
    static class Receiver extends Thread {
        Socket soc;
        BufferedReader sbr;

        public Receiver(Socket soc) throws IOException {
            this.soc = soc;
            sbr = new BufferedReader(new InputStreamReader(soc.getInputStream()));
        }

        @Override
        public void run() {
            try {
                ArrayList<Product> products = new ArrayList<>();
                Gson gson = new Gson();

                String in;
                while ((in = sbr.readLine()) != null) {
                    if (in.equals("WrongNumber")) {
                        System.out.println("잘못된 상품번호입니다.");
                    } else {
                        Type type = new TypeToken<ArrayList<Product>>() {
                        }.getType();
                        products = gson.fromJson(in, type);
                    }
                    soutProduct(products);
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        void soutProduct(ArrayList<Product> products) throws IOException {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            bw.write("\n[상품 목록]\n");
            bw.write("----------------------------------------------\n");
            bw.write("no       name                price       stock\n");
            bw.write("----------------------------------------------\n");
            int i = 1;
            for (Product p : products) {
                bw.write(String.format("%-8d", i));
                bw.write(String.format("%-20s", p.name));
                bw.write(String.format("%-14d", p.price));
                bw.write(String.format("%3d", p.stock));
                bw.newLine();
                i++;
            }
            bw.write("----------------------------------------------\n");
            bw.write("메뉴 1.Create | 2.Update | 3.Delete | 4.Exit\n");
            bw.write("입력 : ");
            bw.flush();
        }
    }

    static class Sender extends Thread {
        Socket soc;
        BufferedWriter sbw;

        public Sender(Socket soc) throws IOException {
            this.soc = soc;
            sbw = new BufferedWriter(new OutputStreamWriter(soc.getOutputStream()));
        }

        @Override
        public void run() {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            Gson gson = new Gson();
            Product product;
            int proNum;
            String name;
            int price;
            int stock;
            try {
                loop:
                while (true) {
                    String n = br.readLine();
                    StringBuilder sb = new StringBuilder();
                    sb.append(n).append("#");
                    try {
                        switch (n) {
                            case "1":
                                System.out.println("[상품 생성]");
                                System.out.print("상품 이름 : ");
                                name = br.readLine();
                                System.out.print("상품 가격 : ");
                                price = Integer.parseInt(br.readLine());
                                System.out.print("상품 재고 : ");
                                stock = Integer.parseInt(br.readLine());
                                product = new Product(name, price, stock);
                                sb.append(gson.toJson(product));
                                break;
                            case "2":
                                System.out.println("[상품 수정]");
                                System.out.print("상품 번호 : ");
                                proNum = Integer.parseInt(br.readLine());
                                sb.append(proNum).append("#");
                                System.out.print("상품 이름 : ");
                                name = br.readLine();
                                System.out.print("상품 가격 : ");
                                price = Integer.parseInt(br.readLine());
                                System.out.print("상품 재고 : ");
                                stock = Integer.parseInt(br.readLine());
                                product = new Product(name, price, stock);
                                sb.append(gson.toJson(product));
                                break;
                            case "3":
                                System.out.println("[상품 삭제]");
                                System.out.print("상품 번호 : ");
                                proNum = Integer.parseInt(br.readLine());
                                sb.append(proNum);
                                break;
                            case "4":
                                break loop;
                            default:
                                System.out.println("잘못된 입력입니다!");
                                break;
                        }
                    }catch (NumberFormatException e){
                        System.out.println("숫자를 입력하시오!");
                    }
                    sbw.write(sb.toString());
                    sbw.newLine();
                    sbw.flush();
                }
                sbw.write("4");
                sbw.newLine();
                sbw.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Socket soc = new Socket("127.0.0.1", 23456);
        Receiver receiver = new Receiver(soc);
        Sender sender = new Sender(soc);
        receiver.start();
        sender.start();
    }
}