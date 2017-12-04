package com.rizaldev.debtcollector.screens.register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.rizaldev.debtcollector.R;

public class RegisterActivity extends AppCompatActivity {

    EditText username, email, password, repassword;
    Button next;

    public static boolean emptyCheck(String check) {
        return !TextUtils.isEmpty(check);
    }

    public static boolean checkEmail(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static boolean checkPassLetter(String pass) {
        for (int i = 0; i < pass.length(); i++) {
            if (!Character.isLetterOrDigit((pass.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkPassLength(String pass) {
        return !(TextUtils.isEmpty(pass) || pass.length() < 8);
    }

    public static boolean checkRepass(String pass, String repass) {
        return pass.equals(repass);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = findViewById(R.id.editTextUsernameRegister);
        email = findViewById(R.id.editTextEmailRegister);
        password = findViewById(R.id.editTextPasswordRegister);
        repassword = findViewById(R.id.editTextRepasswordRegister);
        next = findViewById(R.id.buttonNextRegister);

        //================================================//

        next.setOnClickListener(view -> {
            Boolean checkValid = true;
            String usernameString = username.getText().toString();
            String emailString = email.getText().toString();
            String passwordString = password.getText().toString();
            String repasswordString = repassword.getText().toString();

            if (!emptyCheck(usernameString)) {
                username.setError("Username tidak boleh kosong");
                checkValid = false;
            }

            if (!emptyCheck(emailString)) {
                email.setError("Email tidak boleh kosong");
                checkValid = false;
            } else if (!checkEmail(emailString)) {
                email.setError("Format email tidak sesuai");
                checkValid = false;
            }

            if (!emptyCheck(passwordString)) {
                password.setError("Password tidak boleh kosong");
                checkValid = false;
            } else if (!checkPassLetter(passwordString) || !checkPassLength(passwordString)) {
                password.setError("Password minimal 8 karakter dan memiliki huruf dan angka");
                checkValid = false;
            }

            if (!emptyCheck(repasswordString)) {
                repassword.setError("Password kedua tidak boleh kosong");
                checkValid = false;
            } else if (!checkRepass(passwordString, repasswordString)) {
                repassword.setError("Password kedua tidak sesuai");
                checkValid = false;
            }

            if (checkValid) {
                Intent intent = new Intent(getApplicationContext(), BiodataActivity.class);
                Bundle extras = new Bundle();
                extras.putString("username", usernameString);
                extras.putString("email", emailString);
                extras.putString("password", passwordString);
                extras.putString("repassword", repasswordString);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
    }
}