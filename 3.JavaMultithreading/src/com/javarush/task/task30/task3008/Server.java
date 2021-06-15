package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Введите номер порта");// убрать при проверке
        ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt());
        System.out.println("Сервер запущен.");

        try {
            while (true) {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }
        } catch (IOException e) {
            System.out.println(" произошла ошибка.");
            serverSocket.close();
        }
    }

    private static class Handler extends Thread {
        Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // 1. Выводить сообщение, что установлено новое соединение с удаленным адресом,
            ConsoleHelper.writeMessage("Установлено новое соединение с удаленным адресом:" +
                    socket.getRemoteSocketAddress().toString());

            try (Connection connection = new Connection(socket)) { // 2. Создавать Connection, используя поле socket.
                //7. Обеспечить закрытие соединения при возникновении исключения.


                    // п.3 рукопожатие сервера и сохранение клиента
                    String userName = serverHandshake(connection);
                    // п. 4 Разослать всем сообщение с именем присоединившегося
                    sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));// п. 4 Разослать всем

                    //5. Сообщать новому участнику о существующих участниках.
                    for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
                        String userNameExist = entry.getKey();
                        if (!userNameExist.equals(userName)){
                            connection.send(new Message(MessageType.USER_ADDED, entry.getKey()));// Поправил строку 02.12.19
                        }
                    }

                    //6. Запускать главный цикл обработки сообщений сервером.


                    notifyUsers(connection, userName); // Отсылаем сообщение всем кроме того кто отправил
                try {
                    serverMainLoop(connection, userName);  // Принимаем сообщение от клиента, формируем строку, отправляем в чат всем.
                } catch (SocketException e){

                }


                // Удаляем клиента из коннекшэнмап
                   connectionMap.remove(userName);
                   sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));

                    ConsoleHelper.writeMessage("Cоединение с удаленным адресом закрыто");
                    //connection.close();

                } catch (Exception e) {
                    System.out.println("Ошибка в работе метода Run Handler!");
                    //e.printStackTrace();
                }
        }

        // Ждем соединения с клиентом, отправляем запрос имени, добавляем в список.
        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            String userNamenew = null;
            while (true) {
                Message messageRequestName = new Message(MessageType.NAME_REQUEST, "Сообщите ваш логин.");
                connection.send(messageRequestName);
                Message message = connection.receive();
                userNamenew = message.getData();

                if (message.getType() == MessageType.USER_NAME && !userNamenew.isEmpty() && !connectionMap.containsKey(userNamenew)) {
                    connectionMap.put(userNamenew, connection);
                    connection.send(new Message(MessageType.NAME_ACCEPTED));
                    break;
                }
            }
            return userNamenew;
        }

        // Отсылаем сообщение всем кроме того кто отправил
        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
                String userNameExist = entry.getKey();
                if (!userNameExist.equals(userName)){
                    Connection connection1 = entry.getValue(); // Поправил строку 02.12.19
                    connection1.send(new Message(MessageType.USER_ADDED, userName));// Поправил строку 02.12.19
                    
                }
            }
        }

        // Принимаем сообщение от клиента, формируем строку, отправляем в чат всем.
        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive(); // получаем сообщение
                if (message.getType() == MessageType.TEXT) {
                    Message message1 = new Message(MessageType.TEXT, userName + ": " + message.getData());
                    sendBroadcastMessage(message1);
                } else ConsoleHelper.writeMessage("Нe правильный формат сообщения отличный от \"TEXT\"!");

            }
        }
    }

    public static void sendBroadcastMessage(Message message) { // Отправка сообщений всем клиентам.
        for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
            String userName = entry.getKey();
            Connection connection = entry.getValue();
            try {
                connection.send(message);
            } catch (IOException e) {
                System.out.println("Не удалось отправить сообщение пользователя: " + userName);
            }

        }
    }
}
