package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class BotClient extends Client {

    public static void main(String[] args) {
        new BotClient().run();
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    public String getUserName() {
        return "date_bot_" + ((int) (Math.random() * 100));
    }

    public class BotSocketThread extends SocketThread {
        @Override
        public void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
            processIncomingMessage(connection.receive().getData());

        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);

            //if (!message.contains(": ")) return;

            String messageOut = null;

            if (message.matches(".*:.*")) {
                String name = message.split(": ")[0].trim();
                String text = message.split(": ")[1].trim();
                Date date = Calendar.getInstance().getTime();
                SimpleDateFormat dateFormat = null;
                switch (text) {
                    case "дата":
                        dateFormat = new SimpleDateFormat("d.MM.YYYY", Locale.ENGLISH);
                        break;
                    case "день":
                        dateFormat = new SimpleDateFormat("d", Locale.ENGLISH);
                        break;
                    case "месяц":
                        dateFormat = new SimpleDateFormat("MMMM", Locale.ENGLISH);
                        break;
                    case "год":
                        dateFormat = new SimpleDateFormat("YYYY", Locale.ENGLISH);
                        break;
                    case "время":
                        dateFormat = new SimpleDateFormat("H:mm:ss", Locale.ENGLISH);
                        break;
                    case "час":
                        dateFormat = new SimpleDateFormat("H", Locale.ENGLISH);
                        break;
                    case "минуты":
                        dateFormat = new SimpleDateFormat("m", Locale.ENGLISH);
                        break;
                    case "секунды":
                        dateFormat = new SimpleDateFormat("s", Locale.ENGLISH);
                        break;
                }

                if (dateFormat != null) {
                    Calendar calendar = Calendar.getInstance();
                    String result = "Информация для " + name + ": ";
                    result += dateFormat.format(calendar.getTime());
                    sendTextMessage(result);
                }
            }

        }
    }
}
