package com.rizaldev.debtcollector.screens.register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.rizaldev.debtcollector.R;

public class BiodataActivity extends AppCompatActivity {

    EditText name, phone, address, city, province, zip;
    Button back, register;

    public static boolean emptyCheck(String check) {
        if (TextUtils.isEmpty(check)) {
            return false;
        }
        return true;
    }

    public static boolean checkPhone(String phone) {
        if (phone.charAt(0) == 0 || phone.length() < 7 || phone.length() > 13) {
            return false;
        }
        return true;
    }

    public static boolean checkZip(String zip) {
        if (zip.length() >= 10) {
            return false;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biodata);
        name = findViewById(R.id.editTextNameRegister);
        phone = findViewById(R.id.editTextPhoneRegister);
        address = findViewById(R.id.editTextAddressRegister);
        city = findViewById(R.id.editTextCityRegister);
        province = findViewById(R.id.editTextProvinceRegister);
        zip = findViewById(R.id.editTextZipcodeRegister);
        back = findViewById(R.id.buttonBackRegister);
        register = findViewById(R.id.buttonRegisterRegister);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean checkValid = true;
                String nameString = name.getText().toString();
                String phoneString = phone.getText().toString();
                String addressString = address.getText().toString();
                String cityString = city.getText().toString();
                String provinceString = province.getText().toString();
                String zipString = zip.getText().toString();

                if (!emptyCheck(nameString)) {
                    name.setError("Field tidak boleh kosong");
                    checkValid = false;
                }

                if (!emptyCheck(phoneString)) {
                    phone.setError("Field tidak boleh kosong");
                    checkValid = false;
                } else if (!checkPhone(phoneString)) {
                    phone.setError("Nomor Telefon tidak benar");
                    checkValid = false;
                }

                if (!emptyCheck(addressString)) {
                    address.setError("Field tidak boleh kosong");
                    checkValid = false;
                }

                if (!emptyCheck(cityString)) {
                    city.setError("Field tidak boleh kosong");
                    checkValid = false;
                }

                if (!emptyCheck(provinceString)) {
                    province.setError("Field tidak boleh kosong");
                    checkValid = false;
                }

                if (!emptyCheck(zipString)) {
                    zip.setError("Field tidak boleh kosong");
                    checkValid = false;
                }

                if (checkValid) {
                    Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                    Bundle extras = new Bundle();
                    extras.putString("name", nameString);
                    extras.putString("phone", phoneString);
                    extras.putString("address", addressString);
                    extras.putString("city", cityString);
                    extras.putString("province", provinceString);
                    extras.putString("zip", zipString);
                    intent.putExtras(extras);
                    startActivity(intent);
                }
            }
        });
    }
}
