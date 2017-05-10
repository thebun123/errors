package com.example.nguyenxuantruong.myproject.targets;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.nguyenxuantruong.myproject.R;

public class Targets extends Activity {

    private String TAG = Targets.class.getSimpleName();//Lấy tn classaaa
    private RadioGroup loaiGiaoDich; //1-thu  2-chi
    private RadioButton thuNhap, chiTieu;
    private EditText ngay_nhap, thang_nhap, nam_nhap, ghiChu, tien;
    private Spinner spNoiDung;
    private ImageView ok, cancel;
    Bill bill;

    String[] noiDung ={ "Hàng điện tử","Hàng hóa chất", "Hàng gia dụng"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_targets);

        initView();

        Bundle bun = getIntent().getExtras();
        final String type =  bun.getString("type");
        Log.e(TAG, type);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(type.equals("add")){
                    getData();
                }
                else if(type.equals("edit")){
                    editData();
                }
                Intent data = new Intent();
                data.putExtra("tien",bill.getSoTien());
                data.putExtra("ghichu",bill.getGhiChu());
                data.putExtra("nam",bill.getNamPhatSinh());
                data.putExtra("ngay",bill.getNgayPhatSinh());
                data.putExtra("thang",bill.getThangPhatSinh());
                data.putExtra("noidung",bill.getNoiDung());
                data.putExtra("chitieu",bill.isChiTieu());
                Log.e("bill",bill.getNgayPhatSinh()+"");
                Log.e("bill",bill.getThangPhatSinh() +"");
                Log.e("bill",bill.getNamPhatSinh() +"");
                Log.e("bill",bill.getSoTien());
                Log.e("bill"," noi dung"+bill.getNoiDung());
                Log.e("bill",bill.getGhiChu());
                Log.e("bill",bill.isChiTieu() +"");
                setResult(RESULT_OK,data);
                finish();
            }
        });
    }

    private void editData() {
    }

    private void getData() {

         bill = new Bill();
        //date
        bill.setNgayPhatSinh(Integer.parseInt(ngay_nhap.getText().toString()));
        bill.setThangPhatSinh(Integer.parseInt(thang_nhap.getText().toString()));
        bill.setNamPhatSinh(Integer.parseInt(nam_nhap.getText().toString()));



        //ghichu
        bill.setGhiChu(ghiChu.getText().toString());

        //tien
        bill.setSoTien(tien.getText().toString());


        //type
        loaiGiaoDich.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group,int checkedId) {
                switch(checkedId){
                    case R.id.rb_ex :
                        bill.setChiTieu(true);//chi
                        break;
                    case R.id.rb_im :
                        bill.setChiTieu(false);//thu
                }
            }
        });

        //noidung
        spNoiDung.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e(TAG, position +"");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void initView() {
        loaiGiaoDich = (RadioGroup) findViewById(R.id.rgType);
        thuNhap = (RadioButton) findViewById(R.id.rb_im);
        chiTieu = (RadioButton) findViewById(R.id.rb_ex);
        ngay_nhap = (EditText) findViewById(R.id.etDate);
        thang_nhap = (EditText) findViewById(R.id.etMonth);
        nam_nhap = (EditText) findViewById(R.id.etYear);
        ghiChu = (EditText) findViewById(R.id.etNote);
        tien = (EditText) findViewById(R.id.etCost);
        ok = (ImageView) findViewById(R.id.ivDone);
        cancel = (ImageView) findViewById(R.id.ivCancel);
        spNoiDung = (Spinner) findViewById(R.id.spMain);
        //mo cai nay ra, face time di
        ArrayAdapter<String> adapterND = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice,noiDung);
        //adapterND.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spNoiDung.setAdapter(adapterND);


    }
}
