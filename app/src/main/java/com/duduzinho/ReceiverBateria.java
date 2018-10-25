package com.duduzinho.projeto;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ReceiverBateria extends BroadcastReceiver {

    public static final String SHOW_NOTIFICATION = "com.duduzinho.projeto.SHOW_NOTIFICATION";
    public static final String HIDE_NOTIFICATION = "com.duduzinho.projeto.HIDE_NOTIFICATION";

    public ReceiverBateria() {
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        switch (action) {

            case Intent.ACTION_BATTERY_LOW:
                show("Pouca bateria", context);
                break;

            case Intent.ACTION_POWER_DISCONNECTED:
                show("Cabo desconectado", context);
                break;

            case Intent.ACTION_POWER_CONNECTED:
                show("Carregando a bateria...", context);
                break;

            case HIDE_NOTIFICATION:
                show("NOTIFICATION HIDE", context);
                break;

            default:
                show("Não detectado!", context);
                break;
        }
    }

    private void show(String message, Context context) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

}
