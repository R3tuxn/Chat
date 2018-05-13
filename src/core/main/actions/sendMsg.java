package core.main.actions;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class sendMsg extends Thread {

    private Scanner sc;
    private Socket ss;
    private String temp;

    public sendMsg(Scanner scanr, Socket sockt) {
        this.sc = scanr;
        this.ss = sockt;
    }

    @Override
    public void run() {
        try {
            while(true) {
                temp = sc.next();
                PrintStream p = new PrintStream(ss.getOutputStream());
                p.println(temp);
            }
        } catch (Exception ex) {
            System.out.println("Error!");
        }
    }
}