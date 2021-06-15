package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

    protected String getServerAddress() throws IOException {
        System.out.println("Введите адрес сервера: ");
        return ConsoleHelper.readString();
    }

    protected int getServerPort() {
        System.out.println("Введите порт: ");
        return ConsoleHelper.readInt();
    }

    protected String getUserName() {
        System.out.println("Введите имя: ");
        Scanner scanner = new Scanner(System.in);
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            System.out.println("Во время отправки сообщения произошла ошибка!");
            clientConnected = false;
        }

    }

    public void run() {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();

        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                ConsoleHelper.writeMessage("Произошла ошибка.");
            } finally {
                Thread.currentThread().interrupt();
            }
            if (clientConnected)
                ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
            else ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");

            while (clientConnected) {
                String message = ConsoleHelper.readString();
                if (message.equals("exit")) break;
                if (shouldSendTextFromConsole()) sendTextMessage(message);
            }
        }


    }

    public class SocketThread extends Thread {

        @Override
        public void run() {

            try {
                String serverAddress = getServerAddress() ;
                int port = getServerPort();
                Socket socket = new Socket(serverAddress, port);
                Client.this.connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            } catch (IOException | ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
            }
        }

        protected void processIncomingMessage(String message) { //должен выводить текст message в консоль
            System.out.println(message);
        }

        protected void informAboutAddingNewUser(String userName) {
            System.out.println("Участник с именем " + userName + " присоединился к чату.");
        }

        protected void informAboutDeletingNewUser(String userName) {
            System.out.println("Участник с именем " + userName + " покинул чат.");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this) {
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (MessageType.NAME_REQUEST == message.getType()) {
                    connection.send(new Message(MessageType.USER_NAME, getUserName()));
                } else if (MessageType.NAME_ACCEPTED == message.getType()) {
                    notifyConnectionStatusChanged(true);
                    return;
                } else throw new IOException("Unexpected MessageType");
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException { // Обработка полученных от сервера
            // сообщений
            while (true) {
                Message message = connection.receive();

                if (message.getType() != MessageType.TEXT && message.getType() != MessageType.USER_ADDED &&
                        message.getType() != MessageType.USER_REMOVED)
                    throw new IOException("Unexpected MessageType");

                switch (message.getType()) {
                    case TEXT:
                        processIncomingMessage(message.getData());
                        break;
                    case USER_ADDED:
                        informAboutAddingNewUser(message.getData());
                        break;
                    case USER_REMOVED:
                        informAboutDeletingNewUser(message.getData());
                        break;
                    default:
                        throw new IOException("Unexpected MessageType");

                }
            }
        }

    }
}
