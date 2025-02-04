package com.android.support;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;

public class MainActivity extends Activity {

    // Nome da atividade do jogo
    public String GameActivity = "com.unity3d.player.UnityPlayerActivity";
    public boolean hasLaunched = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Verifica e solicita permissão de sobreposição para Android 6.0+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.canDrawOverlays(this)) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
                startActivityForResult(intent, 1234);
            } else {
                // Permissão já concedida, inicia o menu flutuante
                Main.Start(getApplicationContext());
            }
        } else {
            // Versões abaixo do Android 6.0 não precisam da permissão
            Main.Start(getApplicationContext());
        }

        // Lançar a atividade do jogo apenas uma vez
        if (!hasLaunched) {
            hasLaunched = true;
            try {
                MainActivity.this.startActivity(new Intent(MainActivity.this, Class.forName(MainActivity.this.GameActivity)));
            } catch (ClassNotFoundException e) {
                Log.e("MainActivity", "Erro: a atividade principal do jogo não existe.", e);
            }
        }
    }

    // Trata o resultado da solicitação de permissão de sobreposição
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1234) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (Settings.canDrawOverlays(this)) {
                    // Permissão concedida, inicia o menu flutuante
                    Main.Start(getApplicationContext());
                } else {
                    // Permissão negada, loga um erro
                    Log.e("MainActivity", "Permissão de sobreposição negada.");
                }
            }
        }
    }

    // Remove a view flutuante quando a atividade for destruída para evitar vazamento de memória
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (Main.menu != null && Main.menu.rootFrame != null) {
            Main.menu.mWindowManager.removeView(Main.menu.rootFrame);
        }
    }
}
