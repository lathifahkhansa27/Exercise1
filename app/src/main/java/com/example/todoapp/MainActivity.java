package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Deklarasi variabel untuk button
    Button btnSignin;

    //Deklarasi variabel untuk EditText
    EditText ednama, edpassword;

    //Deklarasi variabel untuk menyimpan email dan password
    String nama, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Menghubungkan variable btnLogin dengan componen button pada Layout
        btnSignin=findViewById(R.id.bSignIn);

        //Menghubungkan variable edEmail dengan componen button pada Layout
        ednama=findViewById(R.id.edNama);

        //Menghubungkan variable edPassword dengan componen button pada Layout
        edpassword=findViewById(R.id.edPassword);

        //membuat fungsi onclivk pada button btnLogin
        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //menyimpan input user di edittext email kedalam variable nama
                nama = ednama.getText().toString();

                //menyimpan input user di edittext password kedalam variable nama
                password = edpassword.getText().toString();

                //mengeset email yang benar
                String nama = "Khansa";

                //mengeset password yang benar
                String pass = "273";

                if (nama.isEmpty() || password.isEmpty()) {
                    //membuat variable toast dan menampilkan pesan "edittext tidak boleh kosong"
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Email dan pasword wajib diisi!!!", Toast.LENGTH_LONG);
                    //menampilkan toast
                    t.show();
                }

                else {
                    //mengecek apakah isi dari email dan password sudah sama dengan email dan password yang sudah diset
                    if (nama.equals(nama) && password.equals(pass)) {
                        //membuat variable toast dan menampilkan pesan "Login Sukses"
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Sukses", Toast.LENGTH_LONG);
                        //menampilkan toast
                        t.show();

                        //membuat objek bundle
                        Bundle b = new Bundle();

                        //memasukan value dari variable password dengan kunci "a" dan dimasukan kedalam bundle
                        b.putString("a", nama.trim());

                        //memasukan value dari variable password dengan kunci "b" dan dimasukan kedalam bundle
                        b.putString("b", password.trim());

                        //membuat objek intent berpinah activity dari mainactivity ke ActivityHasil
                        Intent i = new Intent(getApplicationContext(), HomeActivity.class);

                        //memasukan bundle kedalam intent untuk dikirimkan ke ActivityHasil
                        i.putExtras(b);

                        //berpindah ke ActivityHasil
                        startActivity(i);
                    } else {
                        //membuat variable toast dan menampilkan pesan "Login Gagal"
                        Toast t = Toast.makeText(getApplicationContext(), "Login Gagal", Toast.LENGTH_LONG);

                        //menampilkan toast
                        t.show();
                    }
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //method untuk menampilkan menu
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}