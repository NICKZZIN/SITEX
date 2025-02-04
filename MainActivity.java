package com.android.support;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;

public class MainActivity extends Activity {

    public String GameActivity = "com.unity3d.player.UnityPlayerActivity";  // Nome da Activity do jogo
    public boolean hasLaunched = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Verifica e solicita permissão de sobreposição para versões Android 6.0+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.canDrawOverlays(this)) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
                startActivityForResult(intent, 1234);
            }
        }

        // Apenas inicie a Activity do jogo e o menu flutuante uma vez
        if (!hasLaunched) {
            try {
                hasLaunched = true;
                // Lança a Activity do jogo
                MainActivity.this.startActivity(new Intent(MainActivity.this, Class.forName(MainActivity.this.GameActivity)));

                // Inicia o menu flutuante utilizando o contexto da aplicação
                Main.Start(getApplicationContext());
                return;
            } catch (ClassNotFoundException e) {
                Log.e("Mod_menu", "Erro. A principal activity do jogo não existe");
            }
        }

        // Se já tiver lançado o jogo, apenas inicie o menu flutuante
        Main.Start(getApplicationContext());
    }
}

