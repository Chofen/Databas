package com.sqlsamples.Control;


import com.sqlsamples.View.MainView;

public class App
{

    public static void main(String[] args)
    {
        App app = new App();
        app.init();
    }

    public void init()
    {
        ConnectionSQL connection = new ConnectionSQL();
        MainView mainView = new MainView(connection);
    }
}
