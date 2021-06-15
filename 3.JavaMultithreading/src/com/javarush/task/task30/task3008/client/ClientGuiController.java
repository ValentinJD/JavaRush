package com.javarush.task.task30.task3008.client;

public class ClientGuiController extends Client {
    private ClientGuiModel model = new ClientGuiModel();
    private ClientGuiView view = new ClientGuiView(this);

    public ClientGuiController() {
    }

    public static void main(String[] args) {
        ClientGuiController clientGuiController = new ClientGuiController();
        clientGuiController.run();
    }
    //, который должен создавать новый объект ClientGuiController и вызывать у него метод run().

    protected SocketThread getSocketThread() {
        GuiSocketThread guiSocketThread = new GuiSocketThread();
        return guiSocketThread;
    }
    //- должен создавать и возвращать объект типа GuiSocketThread.

    public void run() {
        getSocketThread().run();
    }

    //- должен получать объект SocketThread через метод getSocketThread() и вызывать у него метод run().
    //Разберись, почему нет необходимости вызывать метод run() в отдельном потоке, как мы это делали для консольного клиента.
    public String getServerAddress() {
        return this.view.getServerAddress();
    }

    public int getServerPort() {
        return this.view.getServerPort();
    }

    public String getUserName() {
        return this.view.getUserName();
    }
    //Они должны вызывать одноименные методы из представления (view).

    public ClientGuiModel getModel() {
        return model;
    }
    //, который должен возвращать модель.

    public class GuiSocketThread extends SocketThread {
        @Override
        public void processIncomingMessage(String message) {
            model.setNewMessage(message);
            view.refreshMessages();
        }
        // - должен устанавливать новое сообщение у модели и вызывать обновление вывода сообщений у представления.

        @Override
        public void informAboutAddingNewUser(String userName) {
            model.addUser(userName);
            view.refreshUsers();
        }
        //- должен добавлять нового пользователя в модель и вызывать обновление вывода пользователей у отображения.

        @Override
        public void informAboutDeletingNewUser(String userName) {
            model.deleteUser(userName);
            view.refreshUsers();
        }
        //- должен удалять пользователя из модели и вызывать обновление вывода пользователей у отображения.

        @Override
        public void notifyConnectionStatusChanged(boolean clientConnected) {
            view.notifyConnectionStatusChanged(clientConnected);
        }
        //- должен вызывать аналогичный метод у представления.
    }
}
