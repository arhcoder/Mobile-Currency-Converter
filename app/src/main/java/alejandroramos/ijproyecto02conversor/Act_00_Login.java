package alejandroramos.ijproyecto02conversor;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Act_00_Login extends AppCompatActivity {

    EditText Text_Contraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_00_login);
        Text_Contraseña = (EditText) findViewById(R.id.Pdw_Contraseña);
    }

    public void acceder(View Vista)
    {
        String Usuario = "Aletz!";
        String Contraseña = "12345";
        String UsuarioX;
        String ContraseñaX;

        if(((EditText) findViewById(R.id.Txt_Usuario)).getText().toString().equals("") ||
                ((EditText) findViewById(R.id.Pdw_Contraseña)).getText().toString().equals(""))
        {
            // Si las casillas están vacias //
            TextView EtiquetaDatos = (TextView) findViewById(R.id.Lbl_Datos);
            EtiquetaDatos.setText("DATOS PENDIENTES");
            EtiquetaDatos.setTextColor(Color.parseColor("#fcff00"));
        }
        else
        {
            UsuarioX = ((EditText) findViewById(R.id.Txt_Usuario)).getText().toString();
            ContraseñaX = ((EditText) findViewById(R.id.Pdw_Contraseña)).getText().toString();
            if (UsuarioX.equals(Usuario) && ContraseñaX.equals(Contraseña))
            {
                // Datos Correctos - Acceso Concedido //
                TextView EtiquetaDatos = (TextView) findViewById(R.id.Lbl_Datos);
                EtiquetaDatos.setText("DATOS CORRECTOS");
                EtiquetaDatos.setTextColor(Color.parseColor("#00b103"));
                // Se mueve a la Actividad 02 //
                Intent IA = new Intent(this, Act_01_Conversor.class);
                startActivity(IA);
                //this.finish();
            }
            else
            {
                TextView EtiquetaDatos = (TextView) findViewById(R.id.Lbl_Datos);
                EtiquetaDatos.setText("DATOS INCORRECTOS");
                Text_Contraseña.setText("");
                EtiquetaDatos.setTextColor(Color.parseColor("#900000"));
            }
        }
    }

    public void registrarse(View Vista)
    {
        // Mostrar Datos de Acceso //
        Toast.makeText(this, "¿Quieres registrarte?\n" +
                "No esperes mucho de esta humilde aplicación.\n" +
                "Los datos para acceder son:\n" +
                "[Usuario: Aletz!]\n" +
                "[Contraseña: 12345] ~ :3", Toast.LENGTH_LONG).show();
    }
}