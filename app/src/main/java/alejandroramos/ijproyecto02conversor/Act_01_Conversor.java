package alejandroramos.ijproyecto02conversor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Act_01_Conversor extends AppCompatActivity {

    Spinner Spinner_01M;
    Spinner Spinner_02M;
    EditText M1;
    EditText M2;
    TextView Text_Valor;

    double[][] MONEDAS =
            /* Peso */    {{1, 0.052, 0.046, 0.000013},
            /* Dolar */   {19.12, 1, 0.89, 0.00025},
            /* Euro */    {21.60, 1.13, 1, 0.00029},
            /* Bitcoin */ {75654.29, 3956.86, 3503.21, 1}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_00_login);
        Spinner_01M = (Spinner) findViewById(R.id.Spn_01);
        Spinner_02M = (Spinner) findViewById(R.id.Spn_02);
        ArrayAdapter <CharSequence> AdaptadorSpinner = ArrayAdapter.createFromResource(this, R.array.ValoresMonedas,
                android.R.layout.simple_spinner_item);

        M1 = (EditText) findViewById(R.id.Txt_M01);
        M2 = (EditText) findViewById(R.id.Txt_M02);
        Text_Valor = (TextView) findViewById(R.id.Txt_Valor);

        Spinner_01M.setAdapter(AdaptadorSpinner);
        Spinner_02M.setAdapter(AdaptadorSpinner);
    }

    public void convertirMoneda(View Vista)
    {
        int FilaM = 0;
        int ColumnaM = 0;
        float EntradaM = 0f;
        float SalidaM = 0f;
        float EquivalenciaM = 0f;

        if(Spinner_01M.getSelectedItem().equals("Pesos (MXN)"))
        {
            FilaM = 0;
        }
        else if(Spinner_01M.getSelectedItem().equals("Dólares (USD)"))
        {
            FilaM = 1;
        }
        else if(Spinner_01M.getSelectedItem().equals("Euros (EUR)"))
        {
            FilaM = 2;
        }
        else if(Spinner_01M.getSelectedItem().equals("Bitcoins (BIT)"))
        {
            FilaM = 3;
        }

        if(Spinner_02M.getSelectedItem().equals("Pesos (MXN)"))
        {
            ColumnaM = 0;
        }
        else if(Spinner_02M.getSelectedItem().equals("Dólares (USD)"))
        {
            ColumnaM = 1;
        }
        else if(Spinner_02M.getSelectedItem().equals("Euros (EUR)"))
        {
            ColumnaM = 2;
        }
        else if(Spinner_02M.getSelectedItem().equals("Bitcoins (BIT)"))
        {
            ColumnaM = 3;
        }

        if(M1.getText().toString().equals("") || M1.getText().toString().equals("."))
        {
            EntradaM = 0;
            M1.setText(""+EntradaM);
        }
        else
        {
            EntradaM = Float.parseFloat(M1.getText().toString());
            M1.setText(""+EntradaM);
        }

        EquivalenciaM = (float) MONEDAS[FilaM][ColumnaM];
        SalidaM = EntradaM * EquivalenciaM;
        M2.setText(""+SalidaM);
        Text_Valor.setText("1 "+Spinner_01M.getSelectedItem()+" = "+EquivalenciaM+" "+Spinner_02M.getSelectedItem());
    }

    public void abrirMenú_08(View Vista)
    {
        Intent Movimiento = new Intent(this, Act_00_Login.class);
        startActivity(Movimiento);
    }
}