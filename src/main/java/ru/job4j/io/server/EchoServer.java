package ru.job4j.io.server;

import org.apache.log4j.helpers.LogLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.io.UsageLog4j;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String answer = "";
                    String str = in.readLine();
                    if (str.contains("?msg=Exit")) {
                        answer = "Goodbye!";
                        server.close();
                    } else if (str.contains("?msg=Hello")) {
                        answer = "Hello, friend!";
                    } else {
                        answer = "What ?";
                    }
                    System.out.println(str);
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    out.write(answer.getBytes());
                    out.flush();
                }
            }
        } catch (IOException e) {
            LOG.error("IO error: ", e);
        }
    }
}
