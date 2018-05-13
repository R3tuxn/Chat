package core.main;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import core.main.actions.*;

public class main {

    public static void main(String[] args) {

        if(args[0].length() < 2) {
            System.out.println("Usage:\nAs Server: -l <port>\nAs Client: <hostaddress> <port>");
            return;
        }

        String IP;

        if (!args[0].equalsIgnoreCase("-l")) {
            try {
                Scanner sc = new Scanner(System.in).useDelimiter("\\n");
                Socket s = new Socket(args[0], Integer.parseInt(args[1]));
                Scanner sc1 = new Scanner(s.getInputStream()).useDelimiter("\\n");

                    getMsg action1 = new getMsg(sc1, args[0]);
                    sendMsg action2 = new sendMsg(sc, s);

                    action1.start();
                    action2.start();
            } catch (Exception ex) {
                System.out.println("\nAn Error occurred!");
            }
        } else {
            try {
                ServerSocket s1 = new ServerSocket(Integer.parseInt(args[1]));
                Socket ss = s1.accept();
                Scanner sc = new Scanner(ss.getInputStream()).useDelimiter("\\n");
                Scanner sc1 = new Scanner(System.in).useDelimiter("\\n");
                IP = ss.getInetAddress().toString().replace("/", "");
                System.out.println(IP + " connected!");

                    getMsg action1 = new getMsg(sc, IP);
                    sendMsg action2 = new sendMsg(sc1, ss);

                    action1.start();
                    action2.start();
            } catch (Exception ex) {
                System.out.println("\nAn Error occurred!");
            }
        }
    }
}