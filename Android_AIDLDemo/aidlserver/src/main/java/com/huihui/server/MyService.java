package com.huihui.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class MyService extends Service {

    private String userName;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {

        return new MyBinder();
    }


    class MyBinder extends BookAIDL.Stub {

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public String getName() throws RemoteException {
            return userName;
        }

        @Override
        public void setName(String name) throws RemoteException {

            userName = name;

        }
    }


}
