package com.example.kalkulator;

// тут должно быть на 10 импортов больше ...
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import org.mariuszgromada.math.mxparser.Expression;


public class MainActivity extends AppCompatActivity {

    TextView previousCalculationView;
    EditText display;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        previousCalculationView = findViewById(R.id.peviousCalculationView);
        display = findViewById(R.id.displayEditText);
        display.setShowSoftInputOnFocus(false);

    }
    public void updateText(String strToAdd) {
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0,cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
        display.setSelection(cursorPos + strToAdd.length());
    }

    public void BTN_clean(View view) {
        // очистка поля
        display.setText("");
        previousCalculationView.setText("");
    }

    public void BTN_deleat(View view) {
        // убрать одно значение справа
        int coursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (coursorPos != 0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(coursorPos-1,coursorPos,"");
            display.setText(selection);
            display.setSelection(coursorPos-1);
        }

    }

    public void btn_scob_l(View view) {
        updateText(getResources().getString(R.string.scob));
    }
    public void btn_scob_r(View view) {
        updateText(getResources().getString(R.string.scobR));
    }
    public void btn_1(View view) {
        updateText(getResources().getString(R.string.one));
    }
    public void btn_2(View view) {
        updateText(getResources().getString(R.string.two));
    }
    public void btn_3(View view) {
        updateText(getResources().getString(R.string.tree));
    }
    public void btn_4(View view) {
        updateText(getResources().getString(R.string.fore));
    }
    public void btn_5(View view) {
        updateText(getResources().getString(R.string.fife));
    }
    public void btn_6(View view) {
        updateText(getResources().getString(R.string.six));
    }
    public void btn_7(View view) {
        updateText(getResources().getString(R.string.seven));
    }
    public void btn_8(View view) {
        updateText(getResources().getString(R.string.eght));
    }
    public void btn_9(View view) {
        updateText(getResources().getString(R.string.nine));
    }
    public void btn_0(View view) {
        updateText(getResources().getString(R.string.zero));
    }
    public void btn_umnozh(View view) {
        updateText(getResources().getString(R.string.ymnozh));
    }
    public void btn_delenie(View view) {
        updateText(getResources().getString(R.string.delenie));    }
    public void btn_plus(View view) {
        updateText(getResources().getString(R.string.plus));
    }
    public void btn_minus(View view) {
        updateText(getResources().getString(R.string.minus));
    }
    public void btn_rapiataya(View view) {
        updateText(getResources().getString(R.string.zapataya));
    }
    // начиная от сюда начинается ересь
    public void btn_sin(View view) {
        updateText(getResources().getString(R.string.sin));
    }
    public void btn_cos(View view) {
        updateText(getResources().getString(R.string.cos));
    }
    public void btn_tang(View view) {
        updateText(getResources().getString(R.string.tang));
    }
    public void btn_ctang(View view) {
        updateText(getResources().getString(R.string.ctg));
    }
    public void btn_coren(View view) {
        updateText(getResources().getString(R.string.coren));
    }
    public void btn_factorial(View view) {
        updateText(getResources().getString(R.string.X_factorial));
    }
    public void btn_log(View view) {
        updateText(getResources().getString(R.string.log));
    }
    public void btn_stepen(View view) {
        updateText(getResources().getString(R.string.X__2));
    }
    // ересь закончилась



    public void btn_rezult(View view) {
        // тут жизни нет
        String userExp = display.getText().toString();
        previousCalculationView.setText(userExp);
        //userExp = userExp.replaceAll(getResources().getString(R.string.здесь что то должно быть), "/");
        //userExp = userExp.replaceAll(getResources().getString(R.string.здесь что то должно быть), "*");
        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());
        display.setText(result);
        display.setSelection(result.length());
    }
}