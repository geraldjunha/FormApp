package id.sch.smktelkom_mlg.tugas01.xirpl117.formapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    EditText etNama;
    EditText etUmur;
    RadioGroup rgJK;
    Spinner spKota;
    CheckBox cb1, cb2, cb3, cb4;
    Button bOk;
    TextView tvHasil1, tvKategori;
    int nKategori;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etUmur = (EditText) findViewById(R.id.editTextUmur);
        rgJK = (RadioGroup) findViewById(R.id.radiogroupJK);
        spKota = (Spinner) findViewById(R.id.spinnerKota);
        cb1 = (CheckBox) findViewById(R.id.checkBox1);
        cb2 = (CheckBox) findViewById(R.id.checkBox2);
        cb3 = (CheckBox) findViewById(R.id.checkBox3);
        cb4 = (CheckBox) findViewById(R.id.checkBox4);
        cb1.setOnCheckedChangeListener(this);
        cb2.setOnCheckedChangeListener(this);
        cb3.setOnCheckedChangeListener(this);
        cb4.setOnCheckedChangeListener(this);
        bOk = (Button) findViewById(R.id.buttonOk);
        tvHasil1 = (TextView) findViewById(R.id.textViewHasil);
        tvKategori = (TextView) findViewById(R.id.textViewKategori);

        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doClick();
            }
        });
    }

    private void doClick() {
        String Name = etNama.getText().toString();
        String Age = etUmur.getText().toString();
        String hasil = null;
        String From = spKota.getSelectedItem().toString();
        String Kategori = "\nYour Selected         :";

        int startlen = Kategori.length();
        if (cb1.isChecked()) Kategori += cb1.getText() + ",";
        if (cb2.isChecked()) Kategori += cb2.getText() + ",";
        if (cb3.isChecked()) Kategori += cb3.getText() + ",";
        if (cb4.isChecked()) Kategori += cb4.getText();

        if (Kategori.length() == startlen) Kategori += "Anda Salah Pilih!!!";

        if (rgJK.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton)
                    findViewById(rgJK.getCheckedRadioButtonId());
            hasil = rb.getText().toString();
        }
        if (Name.isEmpty()) {
            etNama.setError("Nama Belum Diisi");
        } else if (Name.length() < 4) {
            etNama.setError("Nama Minimal 4 Karakter");
        } else {
            etNama.setError(null);
        }

        if (Age.isEmpty()) {
            etUmur.setError("Umur Anda Belum Diisi");
        } else if (Age.length() > 2)
        {
            etUmur.setError("Format Umur Anda Salah!!!");
        }
        else
        {
            etNama.setError(null);
        }
        tvHasil1.setText("----------(COOKIES FESTIVAL)----------" + "\nName       : " + Name + "\nAge        : " + Age + "\nGender     : " + hasil + "\nFrom       : " + From + Kategori);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) nKategori += 1;
        else nKategori -= 1;
        tvKategori.setText("Hobby (" + nKategori + "selected");
    }
}
