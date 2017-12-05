package com.rizaldev.debtcollector.screens.register;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import com.rizaldev.debtcollector.R;
import com.rizaldev.debtcollector.api.DebtApi;
import com.rizaldev.debtcollector.api.DebtPref;
import com.rizaldev.debtcollector.application.AppController;
import com.rizaldev.debtcollector.models.User;
import com.rizaldev.debtcollector.screens.main.MainActivity;
import com.rizaldev.debtcollector.screens.register.dagger.DaggerRegisterComponent;
import com.rizaldev.debtcollector.screens.register.dagger.RegisterComponent;
import com.rizaldev.debtcollector.screens.register.dagger.RegisterModule;
import com.rizaldev.debtcollector.utils.UiUtils;


import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BiodataActivity extends AppCompatActivity {
    @Inject DebtApi api;
    EditText name, phone, address, city, province, zip;
    Button back, register;
    ProgressDialog progressDialog;

    public BiodataActivity(){}

    public BiodataActivity(DebtApi api, Context context) {

    }

    public static boolean emptyCheck(String check) {
        return !TextUtils.isEmpty(check);
    }

    public static boolean checkPhone(String phone) {
        return !(phone.charAt(0) == 0 || phone.length() < 7 || phone.length() > 13);
    }

    public static boolean checkZip(String zip) {
        return zip.length() < 10;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerRegisterComponent.builder().appComponent(AppController.getNetComponent()).registerModule(new RegisterModule(this)).build().inject(this);
        setContentView(R.layout.activity_biodata);
        name = findViewById(R.id.editTextNameRegister);
        phone = findViewById(R.id.editTextPhoneRegister);
        address = findViewById(R.id.editTextAddressRegister);
        city = findViewById(R.id.editTextCityRegister);
        province = findViewById(R.id.editTextProvinceRegister);
        zip = findViewById(R.id.editTextZipcodeRegister);
        back = findViewById(R.id.buttonBackRegister);
        register = findViewById(R.id.buttonRegisterRegister);

        register.setOnClickListener(view -> {
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
            } else if (!checkZip(zipString)) {
                zip.setError("Zip tidak boleh lebih dari 10 karkater");
                checkValid = false;
            }

            if (checkValid) {
                Intent intent = this.getIntent();
                showLoading("Register", "Mohon Tunggu Sebentar");

                String username = intent.getStringExtra("username");
                String email = intent.getStringExtra("email");
                String password = intent.getStringExtra("password");
                String name = nameString;
                String phone = phoneString;
                String address = addressString;
                String city = cityString;
                String province = provinceString;
                String postal_code = zipString;
                api.register(username,email,password,name,phone,address,city,province,postal_code).enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        User user = response.body();
                        if(user.getStatus().equals("success")){
                            DebtPref.saveTokenPref(user.getToken(),BiodataActivity.this);
                            dismissLoading();
                            navigateToMain();
                        }else {
                            dismissLoading();
                            UiUtils.showSnackbar(view,"Data tidak berhasil dimasukan", Snackbar.LENGTH_LONG);
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {

                    }
                });

            }
        });
    }
    public void navigateToMain() {
        Intent mainIntent = new Intent(this, MainActivity.class);
        this.startActivity(mainIntent);
        this.finish();
    }
    public void showLoading(String title, String mesage) {
        progressDialog = UiUtils.showLoading(this, title, mesage);
    }

    public void dismissLoading() {
        UiUtils.dismissLoading(progressDialog);
    }
}
