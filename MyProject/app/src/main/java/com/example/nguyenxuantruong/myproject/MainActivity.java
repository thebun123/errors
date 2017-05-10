package com.example.nguyenxuantruong.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.nguyenxuantruong.myproject.Time.Day;
import com.example.nguyenxuantruong.myproject.targets.Targets;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView date;
    private Button thongKe, chiTieu, guiTK, thoat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        showToday();


    }

    private void showToday() {
        Day day = new Day();
        day.getToday();
        date.setText(day.getDate() + "/" + day.getMonth() + "/"  + day.getYear());
    }

    private void initView() {
        //findView
        date = (TextView) findViewById(R.id.tvToday);
        thongKe = (Button) findViewById(R.id.bThong_ke);
        chiTieu = (Button) findViewById(R.id.bChi_tieu);
        guiTK = (Button) findViewById(R.id.bGui_tk);
        thoat = (Button) findViewById(R.id.bOut);

        //setOnclick
        thongKe.setOnClickListener(this);
        chiTieu.setOnClickListener(this);
        guiTK.setOnClickListener(this);
        thoat.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){

            case R.id.bThong_ke :
                Intent i = new Intent(MainActivity.this,Graph.class);
                startActivity(i);
                break;

            case R.id.bChi_tieu :
                Intent intent = new Intent(MainActivity.this, Targets.class);
                intent.putExtra("type","add");
                startActivityForResult(intent,1);
                break;

            case R.id.bGui_tk :
                break;

            case R.id.bOut :
                finish();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            if(requestCode==1){
                Log.e("da",data.getStringExtra("noidung"));

//                Bill bill = new Bill();
//                bill.setSoTien(data.getStringExtra("tien"));
//                bill.setSoTien(data.getStringExtra("ghichu"));
//                bill.setSoTien(data.getStringExtra("nam") +"");
//                bill.setSoTien(data.getStringExtra("ngay")+"");
//                bill.setSoTien(data.getStringExtra("thang")+"");
//                bill.setSoTien(data.getStringExtra("noidung"));
//                bill.setSoTien(data.getStringExtra("chitieu"));
//                Log.e("done",bill.getNgayPhatSinh()+"");
//                Log.e("done",bill.getThangPhatSinh() +"");
//                Log.e("done",bill.getNamPhatSinh() +"");
//                Log.e("done",bill.getSoTien());
//                Log.e("done",bill.getNoiDung());
//                Log.e("done",bill.getGhiChu());
//                Log.e("done",bill.isChiTieu() +"");
            }
        }

    }
}
