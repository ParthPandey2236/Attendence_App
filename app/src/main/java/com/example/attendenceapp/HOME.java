package com.example.attendenceapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;

public class HOME extends AppCompatActivity {
    ImageView scanbtn;
    public static ArrayList<String>  p=new ArrayList<String>();
    public static ArrayList<String>  y=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
       // scanbtn= (ImageView) findViewById(R.id.imageView3);
        //scanbtn.setOnClickListener(this);
    }


    public void onClick(View v) {
        scancode();

    }
    private void scancode(){
        IntentIntegrator integrator=new IntentIntegrator(this);
        integrator.setCaptureActivity(Capture.class);
        integrator.setOrientationLocked(false);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        integrator.setPrompt("Scanning code");
        integrator.initiateScan();
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(result!=null){
            if(result.getContents()!=null){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(result.getContents());
                p.add(result.getContents());
                y.add(result.getContents());
                builder.setTitle("Scanning Result");
                //p=presult.getContents()+"\n";
                builder.setPositiveButton("Scan Again", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        scancode();
                    }
                }).setNegativeButton("Finish", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        openhome();

                    }

                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
            else{
                Toast.makeText(this,"No Results",Toast.LENGTH_SHORT).show();
            }

        }
        else{
            super.onActivityResult(requestCode,resultCode,data);
        }

    }
    public void openhome(){
        Intent intent = new Intent(this,HOME.class);
        startActivity(intent);
    }
    public void present(View view){
        Intent intent = new Intent(this,Presentfile.class);
        //intent.putExtra("p",p);
        startActivity(intent);
    }
    public void food(View view){
        Intent intent = new Intent(this,Food.class);
        startActivity(intent);
    }

}

