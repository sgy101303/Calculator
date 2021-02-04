/*
    과제명 : Calculator
    분반 : 02분반
    학번 : 20180977
    성명 : 심가연
    제출일 : 2020년 05월 25일

    * 가산점 항목
    1번 화면 디자인 개선
    2번 오류 처리
        2-1.연산 순서 오류로 사칙연산 버튼이나 결과를 구하는 = 가 숫자를 입력하지 않았는데 먼저 나오면 오류 토스트 띄움 ex) =, +, - ...
        2-2.연산 순서 오류로 숫자가 입력이 된 후 사칙연산이 나왔지만 숫자가 나오기 전에 =가 먼저 나오면 오류 토스트 띄움   ex) 4 + =, 3 - 1 * = , ...
        2-3.나눗셈(/)을 할 때 뒤에 나오는 숫자가 0일 때 연산 오류 토스트 띄움 ex) 5 / 0 =, 4 - 2 * 3 / 0 = , ...
        2-4.root와 sinX 버튼을 누를 시 등호가 오지 않으면 오류 토스트 띄움 ex) 4 S_ROOT 5 =, 3 S_ROOT 2 + 치는 순간 오류뜨며 초기화
    3.연속 계산 기능
 */

package ddwucom.mobile.middle.Calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    double num =0.0;
    double rslt=0.0;
    int cnt = 0;
    String btnName = "";

    Button multiply;
    Button division;
    Button minus;
    Button plus;
    Button c;
    Button btnRslt;
    Button power;
    Button sRoot;
    Button sinX;

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);

        multiply = findViewById(R.id.btnMutiply);
        division = findViewById(R.id.btnDivision);
        minus = findViewById(R.id.btnMinus);
        plus = findViewById(R.id.btnPlus);
        c = findViewById(R.id.btnClear);
        btnRslt = findViewById(R.id.btnRslt);
        power = findViewById(R.id.btnPower);
        sRoot = findViewById(R.id.btnSRoot);
        sinX = findViewById(R.id.btnSinX);

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.length() == 0) {
                    Toast.makeText(MainActivity.this, "연산 순서 오류", Toast.LENGTH_SHORT).show();
//                    editText.setText("");
//                    editText.setHint("");
                    cnt = 0;
                }
                else {
                    if(cnt == 0) {
                        num = Double.parseDouble(editText.getText().toString());
                        cnt++;
                        rslt = num;
//                        btnName = "multiply";
                    }
                    else {
                        switch (btnName) {
                            case "multiply":
                                rslt = num * Double.parseDouble(editText.getText().toString());
                                cnt++;
                                num = rslt;
                                break;
                            case "division":
                                if (editText.getText().toString().equals("0")) {
//                                    num = 0.0;
//                                    rslt = 0.0;
//                                    editText.setText("");
//                                    editText.setHint("");
//                                    btnName = "";
                                    cnt = 0;
                                    Toast.makeText(MainActivity.this, "연산 오류", Toast.LENGTH_SHORT).show();
                                } else {
                                    rslt = num / Double.parseDouble(editText.getText().toString());
                                    cnt++;
                                    num = rslt;
                                }
                                break;
                            case "minus":
                                rslt = num - Double.parseDouble(editText.getText().toString());
                                cnt++;
                                num = rslt;
                                break;
                            case "plus":
                                rslt = num + Double.parseDouble(editText.getText().toString());
                                cnt++;
                                num = rslt;
                                break;
                            case "sRoot":
                            case "sinX":
//                                num = 0.0;
//                                rslt = 0.0;
//                                editText.setText("");
//                                editText.setHint("");
//                                btnName = "";
                                cnt = 0;
                                Toast.makeText(MainActivity.this, "연산 오류", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                    if(cnt != 0) {
                        editText.setHint("*");
                        editText.setText("");
                        btnName = "multiply";
                        num = rslt;
                    }
                    else {
                        num = 0.0;
                        rslt = 0.0;
                        editText.setText("");
                        editText.setHint("");
                        btnName = "";
                    }
                }
            }
        });
        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.length() == 0) {
                    Toast.makeText(MainActivity.this, "연산 순서 오류", Toast.LENGTH_SHORT).show();
//                    editText.setText("");
//                    editText.setHint("");
                    cnt = 0;
                }

                else {
                    if(cnt == 0) {
                        num = Double.parseDouble(editText.getText().toString());
                        cnt++;
                        rslt = num;
//                        btnName = "division";
                    }
                    else {
                        switch (btnName) {
                            case "multiply":
                                rslt = num * Double.parseDouble(editText.getText().toString());
                                cnt++;
                                num = rslt;
                                break;
                            case "division":
                                if (editText.getText().toString().equals("0")) {
//                                    num = 0.0;
//                                    rslt = 0.0;
//                                    editText.setText("");
//                                    editText.setHint("");
//                                    btnName = "";
                                    cnt = 0;
                                    Toast.makeText(MainActivity.this, "연산 오류", Toast.LENGTH_SHORT).show();
                                } else {
                                    rslt = num / Double.parseDouble(editText.getText().toString());
                                    cnt++;
                                    num = rslt;
                                }
                                break;
                            case "minus":
                                rslt = num - Double.parseDouble(editText.getText().toString());
                                cnt++;
                                num = rslt;
                                break;
                            case "plus":
                                rslt = num + Double.parseDouble(editText.getText().toString());
                                cnt++;
                                num = rslt;
                                break;
                            case "sRoot":
                            case "sinX":
//                                num = 0.0;
//                                rslt = 0.0;
//                                editText.setText("");
//                                editText.setHint("");
//                                btnName = "";
                                cnt = 0;
                                Toast.makeText(MainActivity.this, "연산 오류", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                    if(cnt != 0) {
                        editText.setHint("/");
                        editText.setText("");
                        btnName = "division";
                        num = rslt;
                    }
                    else {
                        num = 0.0;
                        rslt = 0.0;
                        editText.setText("");
                        editText.setHint("");
                        btnName = "";
                    }
                }
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.length() == 0) {
                    Toast.makeText(MainActivity.this, "연산 순서 오류", Toast.LENGTH_SHORT).show();
//                    editText.setText("");
//                    editText.setHint("");
                    cnt = 0;
                }
                else {
                    if(cnt == 0) {
                        num = Double.parseDouble(editText.getText().toString());
                        cnt++;
                        rslt = num;
//                        btnName = "minus";
                    }
                    else {
                        switch (btnName) {
                            case "multiply":
                                rslt = num * Double.parseDouble(editText.getText().toString());
                                cnt++;
                                num = rslt;
//                                btnName = "minus";
                                break;
                            case "division":
                                if (editText.getText().toString().equals("0")) {
//                                    num = 0.0;
//                                    rslt = 0.0;
//                                    editText.setText("");
//                                    editText.setHint("");
//                                    btnName = "";
                                    cnt = 0;
                                    Toast.makeText(MainActivity.this, "연산 오류", Toast.LENGTH_SHORT).show();
                                } else {
                                    rslt = num / Double.parseDouble(editText.getText().toString());
                                    cnt++;
                                    num = rslt;
                                }
                                break;
                            case "minus":
                                rslt = num - Double.parseDouble(editText.getText().toString());
                                cnt++;
                                num = rslt;
                                break;
                            case "plus":
                                rslt = num + Double.parseDouble(editText.getText().toString());
                                cnt++;
                                num = rslt;
                                break;
                            case "sRoot":
                            case "sinX":
//                                num = 0.0;
//                                rslt = 0.0;
//                                editText.setText("");
//                                editText.setHint("");
//                                btnName = "";
                                cnt = 0;
                                Toast.makeText(MainActivity.this, "연산 오류", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                    if(cnt != 0) {
                        editText.setHint("-");
                        editText.setText("");
                        btnName = "minus";
                        num = rslt;
                    }
                    else {
                        num = 0.0;
                        rslt = 0.0;
                        editText.setText("");
                        editText.setHint("");
                        btnName = "";
                    }
                }
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.length() == 0) {
                    Toast.makeText(MainActivity.this, "연산 순서 오류", Toast.LENGTH_SHORT).show();
//                    editText.setText("");
//                    editText.setHint("");
                    cnt = 0;
                }
                else {
                    if(cnt == 0) {
                        num = Double.parseDouble(editText.getText().toString());
                        cnt++;
                        rslt = num;
//                        btnName = "plus";
                    }
                    else {
                        switch (btnName) {
                            case "multiply":
                                rslt = num * Double.parseDouble(editText.getText().toString());
                                cnt++;
                                num = rslt;
                                break;
                            case "division":
                                if (editText.getText().toString().equals("0")) {
//                                    num = 0.0;
//                                    rslt = 0.0;
//                                    editText.setText("");
//                                    editText.setHint("");
//                                    btnName = "";
                                    cnt = 0;
                                    Toast.makeText(MainActivity.this, "연산 오류", Toast.LENGTH_SHORT).show();
                                } else {
                                    rslt = num / Double.parseDouble(editText.getText().toString());
                                    cnt++;
                                    num = rslt;
                                }
                                break;
                            case "minus":
                                rslt = num - Double.parseDouble(editText.getText().toString());
                                cnt++;
                                num = rslt;
                                break;
                            case "plus":
                                rslt = num + Double.parseDouble(editText.getText().toString());
                                cnt++;
                                num = rslt;
                                break;
                            case "sRoot":
                            case "sinX":
//                                num = 0.0;
//                                rslt = 0.0;
//                                editText.setText("");
//                                editText.setHint("");
//                                btnName = "";
                                cnt = 0;
                                Toast.makeText(MainActivity.this, "연산 오류", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                    if(cnt != 0) {
                        editText.setHint("+");
                        editText.setText("");
                        btnName = "plus";
                        num = rslt;
                    }
                    else {
                        num = 0.0;
                        rslt = 0.0;
                        editText.setText("");
                        editText.setHint("");
                        btnName = "";
                    }
                }
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = 0.0;
                editText.setText("");
                editText.setHint("");
                btnName = "";
            }
        });

        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.length() == 0) {
                    Toast.makeText(MainActivity.this, "연산 순서 오류", Toast.LENGTH_SHORT).show();
                    editText.setText("");
                    editText.setHint("");
                    btnName = "";
                    cnt = 0;
                }
                else {
                    num = Double.parseDouble(editText.getText().toString());
                    editText.setHint("power");
                    editText.setText("");
                    btnName = "power";
                    cnt++;
                }
            }
        });

        sRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.length() == 0) {
                    Toast.makeText(MainActivity.this, "연산 순서 오류", Toast.LENGTH_SHORT).show();
                    editText.setText("");
                    editText.setHint("");
                    btnName = "";
                    cnt = 0;
                }
                else {
                    num = Double.parseDouble(editText.getText().toString());
                    editText.setHint("root");
                    editText.setText("");
                    btnName = "sRoot";
                    cnt++;
                }
            }
        });

        sinX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.length() == 0) {
                    Toast.makeText(MainActivity.this, "연산 순서 오류", Toast.LENGTH_SHORT).show();
                    editText.setText("");
                    editText.setHint("");
                    btnName = "";
                    cnt = 0;
                }
                else {
                    num = Double.parseDouble(editText.getText().toString());
                    editText.setHint("sin");
                    editText.setText("");
                    btnName = "sinX";
                    cnt++;
                }
            }
        });

        btnRslt.setOnClickListener(rsltListner);
    }


    View.OnClickListener rsltListner = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (btnName.equals("sRoot")) {
                if(!editText.getText().toString().equals("")){
                    num = 0.0;
                    editText.setText("");
                    editText.setHint("");
                    btnName = "";
                    cnt = 0;
                    Toast.makeText(MainActivity.this, "연산 오류", Toast.LENGTH_SHORT).show();
                }
                else {
                    rslt = Math.sqrt(num);
                    editText.setText(String.valueOf(rslt));
                    rslt = 0;
                    cnt = 0;
                    btnName = "";
                }
            } else if (btnName.equals("sinX")) {
                if(!editText.getText().toString().equals("")){
                    num = 0.0;
                    editText.setText("");
                    editText.setHint("");
                    btnName = "";
                    cnt = 0;
                    Toast.makeText(MainActivity.this, "연산 오류", Toast.LENGTH_SHORT).show();
                }
                else {
                    rslt = Math.sin(num*Math.PI/180.0);
                    editText.setText(String.valueOf(rslt));
                    rslt = 0;
                    cnt = 0;
                    btnName = "";
                }
            }
            else {
                if (cnt < 1 || editText.length() == 0) {
                    Toast.makeText(MainActivity.this, "연산 순서 오류", Toast.LENGTH_SHORT).show();
                    editText.setText("");
                    editText.setHint("");
                    rslt = 0;
                    cnt = 0;
                    btnName = "";
                } else {
                    if (btnName.equals("multiply")) {
                        rslt = num * Double.parseDouble(editText.getText().toString());
                        editText.setText(String.valueOf(rslt));
                    } else if (btnName.equals("division")) {
                        if (editText.getText().toString().equals("0")) {
                            num = 0.0;
                            editText.setText("");
                            editText.setHint("");
                            Toast.makeText(MainActivity.this, "연산 오류", Toast.LENGTH_SHORT).show();
                        } else {
                            rslt = num / Double.parseDouble(editText.getText().toString());
                            editText.setText(String.valueOf(rslt));
                        }
                    } else if (btnName.equals("minus")) {
                        rslt = num - Double.parseDouble(editText.getText().toString());
                        editText.setText(String.valueOf(rslt));
                    } else if (btnName.equals("plus")) {
                        rslt = num + Double.parseDouble(editText.getText().toString());
                        editText.setText(String.valueOf(rslt));
                    }
                    if (btnName.equals("power")) {
                        double nPower = Double.parseDouble(editText.getText().toString());
                        rslt = Math.pow(num, nPower);
                        editText.setText(String.valueOf(rslt));
//                        rslt = num;
//                        for (int i = 0; i < nPower - 1; i++)
//                            rslt *= num;
                    }
                    rslt = 0;
                    cnt = 0;
                    btnName = "";
                }
            }
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.general :
                item.setChecked(true);
                if(findViewById(R.id.engineeringLine).getVisibility()==View.VISIBLE)
                    findViewById(R.id.engineeringLine).setVisibility(View.INVISIBLE);
                break;
            case R.id.engineering :
                item.setChecked(true);
                if(findViewById(R.id.engineeringLine).getVisibility()==View.INVISIBLE)
                    findViewById(R.id.engineeringLine).setVisibility(View.VISIBLE);
                break;
        }
        return true;
    }

    public void onClick(View v) {
        editText = findViewById(R.id.editText);
        String s = editText.getText().toString();

        switch (v.getId()) {
            case R.id.btn0 :
                s += "0";
                break;
            case R.id.btn1 :
                s += "1";
                break;
            case R.id.btn2 :
                s += "2";
                break;
            case R.id.btn3 :
                s += "3";
                break;
            case R.id.btn4 :
                s += "4";
                break;
            case R.id.btn5 :
                s += "5";
                break;
            case R.id.btn6 :
                s += "6";
                break;
            case R.id.btn7 :
                s += "7";
                break;
            case R.id.btn8 :
                s += "8";
                break;
            case R.id.btn9 :
                s += "9";
                break;
        }
        editText.setText(s);
    }
}
