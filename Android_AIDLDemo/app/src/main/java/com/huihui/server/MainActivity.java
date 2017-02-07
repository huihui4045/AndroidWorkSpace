package com.huihui.server;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText mEditName;
    private TextView mTvName;
    private Button mGetBtn;
    private Button mSetBtn;

    private BookAIDL mBookAIDL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mEditName = ((EditText) findViewById(R.id.editName));

        mTvName = ((TextView) findViewById(R.id.tvName));

        mGetBtn = ((Button) findViewById(R.id.btnGet));

        mSetBtn = ((Button) findViewById(R.id.btnSet));


        //创建Intent，对应服务端注册的Intent
        Intent intent = new Intent();
        intent.setAction("com.huihui.server.action.IPC_SERVICE");

        Intent eintent = new Intent(getExplicitIntent(this,intent));
        //绑定连接远程服务
        bindService(eintent, conn, Service.BIND_AUTO_CREATE);


        mSetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s = mEditName.getText().toString();

                try {
                    mBookAIDL.setName(s);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

        mGetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String name = mBookAIDL.getName();


                    mTvName.setText(name);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });


    }

    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {


            mBookAIDL = BookAIDL.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

            mBookAIDL = null;

        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unbindService(conn);
    }


    public static Intent getExplicitIntent(Context context, Intent implicitIntent) {
        // Retrieve all services that can match the given intent
        PackageManager pm = context.getPackageManager();
        List<ResolveInfo> resolveInfo = pm.queryIntentServices(implicitIntent, 0);
        // Make sure only one match was found
        if (resolveInfo == null || resolveInfo.size() != 1) {
            return null;
        }
        // Get component info and create ComponentName
        ResolveInfo serviceInfo = resolveInfo.get(0);
        String packageName = serviceInfo.serviceInfo.packageName;
        String className = serviceInfo.serviceInfo.name;
        ComponentName component = new ComponentName(packageName, className);
        // Create a new intent. Use the old one for extras and such reuse
        Intent explicitIntent = new Intent(implicitIntent);
        // Set the component to be explicit
        explicitIntent.setComponent(component);
        return explicitIntent;
    }
}
