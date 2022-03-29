package ru.job4j.io.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String answer = "";
                    String str = in.readLine();
                        if (str.contains("?msg=")) {
                            if (str.contains("?msg=Exit")) {
                                answer = "Goodbye!";
                                server.close();
                            } else if (str.contains("?msg=Hello")) {
                                answer = "Hello, friend!";
                            } else {
                                answer = "What ?";
                            }
                        System.out.println(str);
                    }
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    out.write(answer.getBytes());
                    out.flush();
                }
            }
        }
    }
}
