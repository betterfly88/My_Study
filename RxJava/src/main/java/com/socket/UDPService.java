package com.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Scanner;

public class UDPService {
    private final static int PORT = 9992;

    public static void main(String[] args) throws IOException {
        byte [] data = new byte[9999];

        try(DatagramSocket socket = new DatagramSocket()){
            DatagramPacket packet = new DatagramPacket(data, data.length);


            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            InetAddress addr = InetAddress.getByName("localhost");

            String line = null;
            while((line = br.readLine()) != null){
                DatagramPacket sendPacket = new DatagramPacket(line.getBytes(), line.getBytes().length, addr, PORT);
                socket.send(sendPacket);

                if(line.equals("break")){
                    break;
                }

                byte [] buffer = new byte[line.getBytes().length];

                DatagramPacket receivedPakcet = new DatagramPacket(buffer, buffer.length);
                socket.receive(receivedPakcet);

                String msg = new String(packet.getData(), 0, packet.getLength());

                System.out.println("Received message : " + msg);
            }
        };
    }

    public void client(String msg) throws IOException {
        DatagramSocket socket = new DatagramSocket();

        InetAddress addr = InetAddress.getByName("127.0.0.1");
        DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.getBytes().length, addr, PORT);

        socket.send(packet);
        socket.close();
    }

    public void server() throws IOException {
        byte [] data = new byte[9999];

        DatagramSocket socket = new DatagramSocket();
        DatagramPacket packet = new DatagramPacket(data, data.length);


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        InetAddress addr = InetAddress.getByName("127.0.0.1");

        String line = null;
        while((line = br.readLine()) != null){
            DatagramPacket sendPacket = new DatagramPacket(line.getBytes(), line.getBytes().length, addr, PORT);
            socket.send(sendPacket);

            if(line.equals("break")){
                break;
            }

            byte [] buffer = new byte[line.getBytes().length];

            DatagramPacket receivedPakcet = new DatagramPacket(buffer, buffer.length);
            socket.receive(receivedPakcet);

            String msg = new String(packet.getData(), 0, packet.getLength());

            System.out.println("Received message : " + msg);
        }
    }
}
