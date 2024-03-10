package com.example.dreambuild;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parts extends AppCompatActivity {
    TextView textView19,textView20,textView21,textView22,textView23,textView24,textView25,textView26,textView27,textView38;
    int AmountProcessor,AmountMotherBoard,AmountGraphicsCard,AmountPowerSupply,AmountCabinets,AmountMemory,AmountHardDrives,AmountSsd,AmountCoolers;

    Button buyNow,report,review,totalButton;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    DocumentReference refProcessor=db.collection("User").document("Processor");
    DocumentReference refMotherboard=db.collection("User").document("Motherboard");
    DocumentReference refGraphicsCard=db.collection("User").document("GraphicsCard");
    DocumentReference refPowerSupply=db.collection("User").document("PowerSupply");
    DocumentReference refCabinets=db.collection("User").document("Cabinets");
    DocumentReference refMemory=db.collection("User").document("Memory");
    DocumentReference refHardDrives=db.collection("User").document("HardDrives");
    DocumentReference refSSD=db.collection("User").document("SSD");
    DocumentReference refCoolers=db.collection("User").document("Coolers");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parts2);

        //This line Hides Action Bar(Top Bar)
        getSupportActionBar().hide();

        textView19 = findViewById(R.id.textView19);
        textView20 = findViewById(R.id.textView20);
        textView21 = findViewById(R.id.textView21);
        textView22 = findViewById(R.id.textView22);
        textView23 = findViewById(R.id.textView23);
        textView24 = findViewById(R.id.textView24);
        textView25 = findViewById(R.id.textView25);
        textView26 = findViewById(R.id.textView26);
        textView27 = findViewById(R.id.textView27);
        textView38 = findViewById(R.id.textView38);
        totalButton= findViewById(R.id.totalButton);





        SQLiteDatabase myDatabase = this.openOrCreateDatabase("Dreambuild",MODE_PRIVATE,null);
        myDatabase.execSQL("DROP TABLE IF EXISTS products");
        myDatabase.execSQL("CREATE TABLE IF NOT EXISTS products (product_name VARCHAR(80), product_id INT(6) PRIMARY KEY, price INTEGER(10))");

        //Processor Data
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('Core I3 10100F', 101, 9950)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('Core I3 10100', 102, 12950)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('Core I5-9400F', 103, 10990)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('Core I5 10400F', 104, 14990)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('Core I5 10600K', 105, 21900)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('Core I7 10700K', 106, 31900)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('Core I9 9900KF', 107, 33900)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('Core I9 10900F', 108, 34900)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('Core I9 10900K', 109, 51900)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('AMD Ryzen 3 3100', 110, 13990)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('AMD Ryzen 5 3500', 111, 16990)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('AMD RYZEN 7 3700X', 112, 28900)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('AMD RYZEN 7 3800X', 113, 31900)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('AMD RYZEN 9 3900X', 114, 42900)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('AMD RYZEN 9 5950X', 115, 66900)");

        //MotherBoard Data
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('B365M AORUS Elite', 116, 8950)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('A320 MH', 117, 4790)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('A520M-DS3H', 118, 6900)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('B450M DS3H Wifi', 119, 8550)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('B450M AORUS ELITE', 120, 8950)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('Gigabyte B550M DS3H AC (Wi-Fi)', 121, 10950)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('B550 Aorus Elite Ax WIfi', 122, 16750)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('Z590 GAMING X', 123, 21900)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('Z590 VISION G', 124, 25900)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('B450M PRO-M.2 MAX', 125, 6990)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('B450M-PRO VDH MAX', 126, 7990)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('B550M Pro', 127, 10490)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('B550 Tomahawk', 128, 17900)");

        //Graphics Card Data
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('NVIDIA 1650 SUPER 4gb DDR6 Windforce OC', 129, 32900)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('NVIDIA GTX 1660 OC 6GB GDDR5', 130, 43990)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('NVIDIA RTX 2060 OC 6G DDR6', 131, 54900)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('NVIDIA RTX 2060 SUPER WINDFORCE 8GB', 132, 35450)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('NVIDIA RTX 3060 EAGLE 12 gb DDR6', 133, 69900)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('NVIDIA RTX 3060TI GAMING OC 8gb DDR6', 134, 84900)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('NVIDIA RTX 3070 Eagle 8gb DDR6', 135, 64900)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('NVIDIA RTX 3070 VISION OC 8gb DDR6', 136, 64900)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('NVIDIA RTX 3080 Gaming OC 10GB DDR6X', 137, 134900)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('NVIDIA RTX 3080 Aorus Xtreme 10GB DDR6X', 138, 119900)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('AMD RADEON RX 5500 XT GAMING OC 4GB', 139, 19990)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('AMD RADEON RX 5500 XT Gaming OC 8GB', 140, 18900)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('AMD RADEON RX 5600 XT OC 6GB ddr6', 141, 39900)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('AMD RADEON RX 5700XT GAMING OC', 142, 49990)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('AMD RADEON RX6800 XT GAMING OC 16GB DDR6', 143, 85900)");

        //Power Supply Data
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('CORSAIR VS 500 WATTS 80 Plus White', 144, 3550)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('CORSAIR CX 450 80 Plus Bronze', 145, 3990)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('Corsair CV 550 Watt 80 Plus Bronze', 146, 4290)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('Corsair CX 550 80 Plus Bronze', 147, 5250)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('CORSAIR TX650 80 Plus Gold', 148, 8450)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('CM MWE 750 Watts 80 Plus Bronze V2', 149, 6600)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('CM MWE GOLD 850 V2 FULLY MODULAR', 150, 10950)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('Antec NE 550M 80 Plus Bronze', 151, 4300)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('Antec VP 700P 80Plus White', 152, 4850)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('Antec NE600G Zen 80 plus Gold', 153, 5890)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('GIGABYTE P 650B 80 PLUS BRONZE', 154, 3950)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('GIGABYTE Aorus P850W 80 PLUS GOLD', 155, 11950)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('Thermaltake TOUGHPOWER GRAND 1050W 80 Plus Gold', 156, 16950)");

        //Cabinets Data
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('Thermaltake V200 RGB', 157, 4900)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('Thermaltake V250 ARGB', 158, 6200)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('Coolermaster MB 311 ARGB', 159, 5950)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('Coolermaster MB 511 ARGB', 160, 6950)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('Coolermaster NR200P White Mini ITX', 161, 8950)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('Coolermaster H 500 ARGB', 162, 10450)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('Antec NX 310', 163, 3450)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('Antec NX 410 Black', 164, 4750)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('Antec NX 320', 165, 4990)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('Antec NX 600', 166, 5450)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('Antec NX 800 ARGB WHITE', 167, 7950)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('Corsair iCUE 220T RGB Black', 168, 8450)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('Corsair 780T', 169, 16950)");

        //Memory Data
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('8GB DDR4 TRIDENT Z RGB 3200 MHZ CL16', 170, 5850)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('16 GB DDR4 RIPJAWS V 3000 MHz CL16', 171, 6950)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('16 GB DDR4 RIPJAWS V 3200 MHz CL16', 172, 7190)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('16GB Ripjaws V DDR4 3600MHz CL19', 173, 7390)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('16GB TRIDENT Z RGB 3200 MHZ CL16', 174, 7990)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('32 GB (16x2) DDR4 RIPJAWS V 3000 MHz CL16', 175, 13950)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('8GB DDR4 3600 MHZ VENGEANCE CL18', 176, 4490)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('16GB DDR4 3000 MHZ VENGEANCE', 177, 7050)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('16 GB (16X1) DDR4 3600 MHZ', 178, 7690)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('32GB (16x2) DDR4 3000 MHz VENGEANCE', 179, 14100)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('32 GB (8X4) DDR4 3000 MHZ', 180, 15400)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('64GB (16x4) DDR4 3000 MHZ VENGEANCE', 181, 27960)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('64 GB (16X4) DDR4 3000 MHZ RGB PRO', 182, 26760)");

        //Hard Drives Data
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('2TB WD BLUE 5400 RPM', 183, 4890)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('4 TB WD BLUE 5400 RPM', 184, 7990)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('2TB WD BLACK 7200 RPM', 185, 11990)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('480 GB Green 2.5', 186, 5490)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('1TB WD BLUE 7200RPM X 2', 187, 9780)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('2TB WD BLUE 5400RPM X 2', 188, 6780)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('1 TB BARRACUDA 7200 RPM', 189, 9780)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('2 TB BARRACUDA X 2 5400 RPM', 190, 5490)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('480 GB Green 2.5', 191, 6490)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('500GB Blue 2.5', 192, 5490)");

        //SSD Data
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('250 GB 870 EVO 2.5', 193, 4590)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('250 GB 970 EVO PLUS NVME', 194, 5790)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('500GB 980 NVMe', 195, 6990)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('500 GB 970 EVO PLUS NVME', 196, 7890)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('1TB 870 Qvo 2.5', 197, 9290)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('512 GB 860 Pro 2.5', 198, 10950)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('1 TB 870 EVO 2.5', 199, 11900)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('1 TB 980 NVMe', 200, 11990)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('1 TB 980 PRO Gen4 Nvme', 201, 17450)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('1 tb Nvme A2000', 202, 10650)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('2 TB 970 EVO Plus NVME', 203, 33900)");

        //Coolers Data
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('NOCTUA NH-L12S CPU COOLER', 204, 5790)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('NOCTUA NH-L12S Brown CPU COOLER', 205, 5890)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('NOCTUA NH-C14S CPU COOLER', 206, 6950)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('NOCTUA NH-D15 CPU COOLER', 207, 8750)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('NOCTUA NH-U12A CPU COOLER', 208, 8990)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('Gammaxx 400XT White', 209, 2395)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('Gammaxx 400XT Black', 210, 2295)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('Gammaxx GTE V2', 211, 2450)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('Gammaxx 400 PRO', 212, 2590)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('Gammaxx GTE V2 Black Edition', 213, 2895)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('Gammaxx GT A-RGB', 214, 3495)");
        myDatabase.execSQL("INSERT INTO products (product_name, product_id, price) VALUES ('NZXT KRAKEN X63 RGB 280 MM', 215, 12900)");



        Cursor processorCursor = myDatabase.rawQuery("SELECT * FROM products WHERE product_id BETWEEN 101 AND 115",null);

        Cursor motherBoardCursor = myDatabase.rawQuery("SELECT * FROM products WHERE product_id BETWEEN 116 AND 128",null);

        Cursor graphicsCardCursor = myDatabase.rawQuery("SELECT * FROM products WHERE product_id BETWEEN 129 AND 143",null);

        Cursor powerSupplyCursor = myDatabase.rawQuery("SELECT * FROM products WHERE product_id BETWEEN 144 AND 156",null);

        Cursor cabinetsCursor = myDatabase.rawQuery("SELECT * FROM products WHERE product_id BETWEEN 157 AND 169",null);

        Cursor memoryCursor = myDatabase.rawQuery("SELECT * FROM products WHERE product_id BETWEEN 170 AND 182",null);

        Cursor hardDrivesCursor = myDatabase.rawQuery("SELECT * FROM products WHERE product_id BETWEEN 183 AND 192",null);

        Cursor ssdCursor = myDatabase.rawQuery("SELECT * FROM products WHERE product_id BETWEEN 193 AND 203",null);

        Cursor coolersCursor = myDatabase.rawQuery("SELECT * FROM products WHERE product_id BETWEEN 204 AND 215",null);




        String[] processor = new String[processorCursor.getCount()];
        String[] processorPrice = new String[processorCursor.getCount()];
        int[] processorPriceInt = new int[processorCursor.getCount()];

        String[] motherBoard = new String[motherBoardCursor.getCount()];
        String[] motherBoardPrice = new String[motherBoardCursor.getCount()];
        int[] motherBoardPriceInt = new int[motherBoardCursor.getCount()];

        String[] graphicsCard = new String[graphicsCardCursor.getCount()];
        String[] graphicsCardPrice = new String[graphicsCardCursor.getCount()];
        int[] graphicsCardPriceInt = new int[graphicsCardCursor.getCount()];

        String[] powerSupply = new String[powerSupplyCursor.getCount()];
        String[] powerSupplyPrice = new String[powerSupplyCursor.getCount()];
        int[] powerSupplyPriceInt = new int[powerSupplyCursor.getCount()];

        String[] cabinets = new String[cabinetsCursor.getCount()];
        String[] cabinetsPrice = new String[cabinetsCursor.getCount()];
        int[] cabinetsPriceInt = new int[cabinetsCursor.getCount()];

        String[] memory = new String[memoryCursor.getCount()];
        String[] memoryPrice = new String[memoryCursor.getCount()];
        int[] memoryPriceInt = new int[memoryCursor.getCount()];

        String[] hardDrives = new String[hardDrivesCursor.getCount()];
        String[] hardDrivesPrice = new String[hardDrivesCursor.getCount()];
        int[] hardDrivesPriceInt = new int[hardDrivesCursor.getCount()];

        String[] ssd = new String[ssdCursor.getCount()];
        String[] ssdPrice = new String[ssdCursor.getCount()];
        int[] ssdPriceInt = new int[ssdCursor.getCount()];

        String[] coolers = new String[coolersCursor.getCount()];
        String[] coolersPrice = new String[coolersCursor.getCount()];
        int[] coolersPriceInt = new int[coolersCursor.getCount()];



        int j = 0;
        while(processorCursor.moveToNext()){
            String productName = processorCursor.getString(processorCursor.getColumnIndex("product_name"));
            String productPrice = processorCursor.getString(processorCursor.getColumnIndex("price"));

            int ProductPriceInt=processorCursor.getInt(processorCursor.getColumnIndex("price"));

            processor[j] = productName;
            processorPrice[j] = productPrice;
            processorPriceInt[j]=ProductPriceInt;

            j++;
        }
        processorCursor.moveToFirst();


        //for motherBoard
        int k = 0;
        while(motherBoardCursor.moveToNext()){
         String mProductName = motherBoardCursor.getString(motherBoardCursor.getColumnIndex("product_name"));
         String mProductPrice = motherBoardCursor.getString(motherBoardCursor.getColumnIndex("price"));

         int mProductPriceInt=motherBoardCursor.getInt(motherBoardCursor.getColumnIndex("price"));

         motherBoard[k] = mProductName;
         motherBoardPrice[k] = mProductPrice;
         motherBoardPriceInt[k]= mProductPriceInt;
            k++;
        }
         motherBoardCursor.moveToFirst();

        //for graphicsCard
        int l = 0;
        while(graphicsCardCursor.moveToNext()){
         String gProductName = graphicsCardCursor.getString(graphicsCardCursor.getColumnIndex("product_name"));
         String gProductPrice = graphicsCardCursor.getString(graphicsCardCursor.getColumnIndex("price"));
         int gGraphicsCardInt=graphicsCardCursor.getInt(graphicsCardCursor.getColumnIndex("price"));


         graphicsCard[l] = gProductName;
         graphicsCardPrice[l] = gProductPrice;
         graphicsCardPriceInt[l]= gGraphicsCardInt;

         l++;
        }
         graphicsCardCursor.moveToFirst();

        //for powerSupply
        int m = 0;
        while(powerSupplyCursor.moveToNext()){
         String poProductName = powerSupplyCursor.getString(powerSupplyCursor.getColumnIndex("product_name"));
         String poProductPrice = powerSupplyCursor.getString(powerSupplyCursor.getColumnIndex("price"));
         int poPowerSupplyInt=powerSupplyCursor.getInt(powerSupplyCursor.getColumnIndex("price"));

         powerSupply[m] = poProductName;
         powerSupplyPrice[m] = poProductPrice;
         powerSupplyPriceInt[m]= poPowerSupplyInt;
            m++;
        }
         powerSupplyCursor.moveToFirst();

        //for cabinets
        int n = 0;
        while(cabinetsCursor.moveToNext()){
         String cProductName = cabinetsCursor.getString(cabinetsCursor.getColumnIndex("product_name"));
         String cProductPrice = cabinetsCursor.getString(cabinetsCursor.getColumnIndex("price"));
         int cCabinetsInt=cabinetsCursor.getInt(cabinetsCursor.getColumnIndex("price"));

         cabinets[n] = cProductName;
         cabinetsPrice[n] = cProductPrice;
         cabinetsPriceInt[n]= cCabinetsInt;
            n++;
        }
         cabinetsCursor.moveToFirst();

        //for memory
        int o = 0;
        while(memoryCursor.moveToNext()){
         String meProductName = memoryCursor.getString(memoryCursor.getColumnIndex("product_name"));
         String meProductPrice = memoryCursor.getString(memoryCursor.getColumnIndex("price"));
         int meMemoryInt=memoryCursor.getInt(memoryCursor.getColumnIndex("price"));

         memory[o] = meProductName;
         memoryPrice[o] = meProductPrice;
         memoryPriceInt[o]= meMemoryInt;
            o++;
        }
         memoryCursor.moveToFirst();

        //for hardDrives
        int p = 0;
        while(hardDrivesCursor.moveToNext()){
         String hProductName = hardDrivesCursor.getString(hardDrivesCursor.getColumnIndex("product_name"));
         String hProductPrice = hardDrivesCursor.getString(hardDrivesCursor.getColumnIndex("price"));
         int hHardDriveInt=hardDrivesCursor.getInt(hardDrivesCursor.getColumnIndex("price"));

         hardDrives[p] = hProductName;
         hardDrivesPrice[p] = hProductPrice;
         hardDrivesPriceInt[p]= hHardDriveInt;
            p++;
        }
         hardDrivesCursor.moveToFirst();

        //for ssd
        int q = 0;
        while(ssdCursor.moveToNext()){
         String sProductName = ssdCursor.getString(ssdCursor.getColumnIndex("product_name"));
         String sProductPrice = ssdCursor.getString(ssdCursor.getColumnIndex("price"));
         int sSsdInt=ssdCursor.getInt(ssdCursor.getColumnIndex("price"));

         ssd[q] =sProductName;
         ssdPrice[q] = sProductPrice;
         ssdPriceInt[q]= sSsdInt;
            q++;
        }
         ssdCursor.moveToFirst();

        //for coolers
        int r = 0;
        while(coolersCursor.moveToNext()){
         String coProductName = coolersCursor.getString(coolersCursor.getColumnIndex("product_name"));
         String coProductPrice = coolersCursor.getString(coolersCursor.getColumnIndex("price"));
         int coCoolersInt=coolersCursor.getInt(coolersCursor.getColumnIndex("price"));

         coolers[r] = coProductName;
         coolersPrice[r] = coProductPrice;
         coolersPriceInt[r]= coCoolersInt;
            r++;
        }
         coolersCursor.moveToFirst();


        //Processor Spinner
        Spinner processor_spinner = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> processor_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, processor);
        processor_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        processor_spinner.setAdapter(processor_adapter);

        //motherBoard Spinner
        Spinner motherBoard_spinner = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> motherBoard_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, motherBoard);
        motherBoard_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        motherBoard_spinner.setAdapter(motherBoard_adapter);

        //graphicsCard Spinner
        Spinner graphicsCard_spinner = (Spinner) findViewById(R.id.spinner3);
        ArrayAdapter<String> graphicsCard_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, graphicsCard);
        graphicsCard_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        graphicsCard_spinner.setAdapter(graphicsCard_adapter);

        //powerSupply Spinner
        Spinner powerSupply_spinner = (Spinner) findViewById(R.id.spinner4);
        ArrayAdapter<String> powerSupply_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, powerSupply);
        powerSupply_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        powerSupply_spinner.setAdapter(powerSupply_adapter);

        //cabinets Spinner
        Spinner cabinets_spinner = (Spinner) findViewById(R.id.spinner5);
        ArrayAdapter<String> cabinets_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cabinets);
        cabinets_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cabinets_spinner.setAdapter(cabinets_adapter);

        //memory Spinner
        Spinner memory_spinner = (Spinner) findViewById(R.id.spinner6);
        ArrayAdapter<String> memory_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, memory);
        memory_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        memory_spinner.setAdapter(memory_adapter);

        //hardDrives Spinner
        Spinner hardDrives_spinner = (Spinner) findViewById(R.id.spinner7);
        ArrayAdapter<String> hardDrives_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, hardDrives);
        hardDrives_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hardDrives_spinner.setAdapter(hardDrives_adapter);

        //ssd Spinner
        Spinner ssd_spinner = (Spinner) findViewById(R.id.spinner8);
        ArrayAdapter<String> ssd_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ssd);
        ssd_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ssd_spinner.setAdapter(ssd_adapter);

        //coolers Spinner
        Spinner coolers_spinner = (Spinner) findViewById(R.id.spinner9);
        ArrayAdapter<String> coolers_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, coolers);
        coolers_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        coolers_spinner.setAdapter(coolers_adapter);



        //Price Printed for processor
        processor_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> processor_spinner, View view, int pos, long id) {

                int processorItems=14;
                Object item = processor_spinner.getItemAtPosition(pos);
                String inputProcessor=item.toString();

                for (int ab = 0; ab <= processorItems; ab++){
                    if (item == processor[ab]) {
                        textView19.setText(""+processorPriceInt[ab]);
                        AmountProcessor = processorPriceInt[ab];

                        Map<String, Object> hashMap = new HashMap();
                        hashMap.put("Processor Name",inputProcessor);
                        hashMap.put("Processor Amount",AmountProcessor);
                        db.collection("User").document("Processor").set(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(Parts.this, "Processor Selected", Toast.LENGTH_SHORT);

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Parts.this, e.toString(), Toast.LENGTH_SHORT);


                            }
                        });

                    }
                }
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        //Price Printed for motherBoard
        motherBoard_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> motherBoard_spinner, View view, int pos, long id) {

                int motherBoardItems=12;
                Object item = motherBoard_spinner.getItemAtPosition(pos);
                String inputMotherBoard=item.toString();
                for (int ab = 0; ab <= motherBoardItems; ab++){
                    if (item == motherBoard[ab]) {
                        textView20.setText(""+motherBoardPriceInt[ab]);
                        AmountMotherBoard = motherBoardPriceInt[ab];

                        Map<String, Object> hashMap = new HashMap();
                        hashMap.put("MotherBoard Name",inputMotherBoard);
                        hashMap.put("MotherBoard Amount",AmountMotherBoard);
                        db.collection("User").document("Motherboard").set(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(Parts.this, "MotherBoard Selected", Toast.LENGTH_SHORT);

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Parts.this, e.toString(), Toast.LENGTH_SHORT);


                            }
                        });

                    }
                }
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //Price Printed for graphicsCard
        graphicsCard_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> graphicsCard_spinner, View view, int pos, long id) {

                int graphicsCardItems=14;
                Object item = graphicsCard_spinner.getItemAtPosition(pos);
                String inputGraphicsCard=item.toString();
                for (int ab = 0; ab <= graphicsCardItems; ab++){
                    if (item == graphicsCard[ab]) {
                        textView21.setText(graphicsCardPrice[ab]);
                        AmountGraphicsCard = graphicsCardPriceInt[ab];

                        Map<String, Object> hashMap = new HashMap();
                        hashMap.put("GraphicsCard Name",inputGraphicsCard);
                        hashMap.put("GraphicsCard Amount",AmountGraphicsCard);
                        db.collection("User").document("GraphicsCard").set(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(Parts.this, "GraphicsCard Selected", Toast.LENGTH_SHORT);

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Parts.this, e.toString(), Toast.LENGTH_SHORT);


                            }
                        });

                    }
                }
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //Price Printed for powerSupply
        powerSupply_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> powerSupply_spinner, View view, int pos, long id) {

                int powerSupplyItems=12;
                Object item = powerSupply_spinner.getItemAtPosition(pos);
                String inputPowerSupply=item.toString();
                for (int ab = 0; ab <= powerSupplyItems; ab++){
                    if (item == powerSupply[ab]) {
                        textView22.setText(powerSupplyPrice[ab]);
                        AmountPowerSupply = powerSupplyPriceInt[ab];

                        Map<String, Object> hashMap = new HashMap();
                        hashMap.put("PowerSupply Name",inputPowerSupply);
                        hashMap.put("PowerSupply Amount",AmountPowerSupply);
                        db.collection("User").document("PowerSupply").set(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(Parts.this, "PowerSupply Selected", Toast.LENGTH_SHORT);

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Parts.this, e.toString(), Toast.LENGTH_SHORT);


                            }
                        });

                    }
                }
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //Price Printed for cabinets
        cabinets_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> cabinets_spinner, View view, int pos, long id) {

                int cabinetsItems=12;
                Object item = cabinets_spinner.getItemAtPosition(pos);
                String inputCabinets=item.toString();
                for (int ab = 0; ab <=  cabinetsItems; ab++){
                    if (item == cabinets[ab]) {
                        textView23.setText(cabinetsPrice[ab]);
                        AmountCabinets = cabinetsPriceInt[ab];

                        Map<String, Object> hashMap = new HashMap();
                        hashMap.put("Cabinets Name",inputCabinets);
                        hashMap.put("Cabinets Amount",AmountCabinets);
                        db.collection("User").document("Cabinets").set(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(Parts.this, "Cabinet Selected", Toast.LENGTH_SHORT);

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Parts.this, e.toString(), Toast.LENGTH_SHORT);


                            }
                        });

                    }
                }
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //Price Printed for memory
        memory_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> memory_spinner, View view, int pos, long id) {

                int memoryItems=12;
                Object item = memory_spinner.getItemAtPosition(pos);
                String inputMemory=item.toString();
                for (int ab = 0; ab <= memoryItems; ab++){
                    if (item == memory[ab]) {
                        textView24.setText(memoryPrice[ab]);
                        AmountMemory = memoryPriceInt[ab];

                        Map<String, Object> hashMap = new HashMap();
                        hashMap.put("Memory Name",inputMemory);
                        hashMap.put("Memory Amount",AmountMemory);
                        db.collection("User").document("Memory").set(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(Parts.this, "Memory Selected", Toast.LENGTH_SHORT);

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Parts.this, e.toString(), Toast.LENGTH_SHORT);


                            }
                        });

                    }
                }
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //Price Printed for hardDrives
        hardDrives_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> hardDrives_spinner, View view, int pos, long id) {

                int hardDrivesItems=9;
                Object item = hardDrives_spinner.getItemAtPosition(pos);
                String inputHardDrive=item.toString();
                for (int ab = 0; ab <= hardDrivesItems; ab++){
                    if (item == hardDrives[ab]) {
                        textView25.setText(hardDrivesPrice[ab]);
                        AmountHardDrives = hardDrivesPriceInt[ab];

                        Map<String, Object> hashMap = new HashMap();
                        hashMap.put("HardDrive Name",inputHardDrive);
                        hashMap.put("HardDrive Amount",AmountHardDrives);
                        db.collection("User").document("HardDrives").set(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(Parts.this, "HardDrive Selected", Toast.LENGTH_SHORT);

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Parts.this, e.toString(), Toast.LENGTH_SHORT);


                            }
                        });

                    }
                }
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //Price Printed for ssd
        ssd_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> ssd_spinner, View view, int pos, long id) {

                int ssdItems=10;
                Object item = ssd_spinner.getItemAtPosition(pos);
                String inputSsd=item.toString();
                for (int ab = 0; ab <= ssdItems; ab++){
                    if (item == ssd[ab]) {
                        textView26.setText(ssdPrice[ab]);
                        AmountSsd = ssdPriceInt[ab];

                        Map<String, Object> hashMap = new HashMap();
                        hashMap.put("SSD Name",inputSsd);
                        hashMap.put("SSD Amount",AmountSsd);
                        db.collection("User").document("SSD").set(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(Parts.this, "SSD Selected", Toast.LENGTH_SHORT);

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Parts.this, e.toString(), Toast.LENGTH_SHORT);


                            }
                        });

                    }
                }
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //Price Printed for coolers
        coolers_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> coolers_spinner, View view, int pos, long id) {

                int coolersItems=11;
                Object item = coolers_spinner.getItemAtPosition(pos);
                String inputCoolers=item.toString();
                for (int ab = 0; ab <= coolersItems; ab++){
                    if (item == coolers[ab]) {
                        textView27.setText(coolersPrice[ab]);
                        AmountCoolers = coolersPriceInt[ab];

                        Map<String, Object> hashMap = new HashMap();
                        hashMap.put("Cooler Name",inputCoolers);
                        hashMap.put("Cooler Amount",AmountCoolers);
                        db.collection("User").document("Coolers").set(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(Parts.this, "Cooler Selected", Toast.LENGTH_SHORT);

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Parts.this, e.toString(), Toast.LENGTH_SHORT);


                            }
                        });

                    }
                }
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        totalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refProcessor.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if(documentSnapshot.exists()){
                            Object price=documentSnapshot.get("Processor Amount");
                            int price1=Integer.parseInt(price.toString());

                            refMotherboard.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                @Override
                                public void onSuccess(DocumentSnapshot documentSnapshot) {
                                    Object price=documentSnapshot.get("MotherBoard Amount");
                                    int price2=Integer.parseInt(price.toString());

                                  refGraphicsCard.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                      @Override
                                      public void onSuccess(DocumentSnapshot documentSnapshot) {
                                          Object price=documentSnapshot.get("GraphicsCard Amount");
                                          int price3=Integer.parseInt(price.toString());

                                          refPowerSupply.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                              @Override
                                              public void onSuccess(DocumentSnapshot documentSnapshot) {
                                                  Object price=documentSnapshot.get("PowerSupply Amount");
                                                  int price4=Integer.parseInt(price.toString());

                                                  refCabinets.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                                      @Override
                                                      public void onSuccess(DocumentSnapshot documentSnapshot) {
                                                          Object price=documentSnapshot.get("Cabinets Amount");
                                                          int price5=Integer.parseInt(price.toString());

                                                          refMemory.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                                              @Override
                                                              public void onSuccess(DocumentSnapshot documentSnapshot) {
                                                                  Object price=documentSnapshot.get("Memory Amount");
                                                                  int price6=Integer.parseInt(price.toString());

                                                                  refHardDrives.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                                                      @Override
                                                                      public void onSuccess(DocumentSnapshot documentSnapshot) {
                                                                          Object price=documentSnapshot.get("HardDrive Amount");
                                                                          int price7=Integer.parseInt(price.toString());

                                                                          refSSD.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                                                              @Override
                                                                              public void onSuccess(DocumentSnapshot documentSnapshot) {
                                                                                  Object price=documentSnapshot.get("SSD Amount");
                                                                                  int price8=Integer.parseInt(price.toString());

                                                                                  refCoolers.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                                                                      @Override
                                                                                      public void onSuccess(DocumentSnapshot documentSnapshot) {
                                                                                          Object price=documentSnapshot.get("Cooler Amount");
                                                                                          int price9=Integer.parseInt(price.toString());

                                                                                          int TotalAmount=price1+price2+price3+price4+price5+price6+price7+price8+price9;
                                                                                          textView38.setText(Integer.toString(TotalAmount));

                                                                                          int totalamount=Integer.parseInt(textView38.getText().toString());
                                                                                          Map<String, Object> hashMap = new HashMap();
                                                                                          hashMap.put("Total Amount",totalamount);
                                                                                          db.collection("User").document("Total Amount").set(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                                              @Override
                                                                                              public void onSuccess(Void unused) {
                                                                                                  Toast.makeText(Parts.this, "Amount Saved", Toast.LENGTH_SHORT);

                                                                                              }
                                                                                          }).addOnFailureListener(new OnFailureListener() {
                                                                                              @Override
                                                                                              public void onFailure(@NonNull Exception e) {
                                                                                                  Toast.makeText(Parts.this, e.toString(), Toast.LENGTH_SHORT);


                                                                                              }
                                                                                          });


                                                                                      }
                                                                                  });

                                                                              }
                                                                          });

                                                                      }
                                                                  });

                                                              }
                                                          });
                                                      }
                                                  });
                                              }
                                          });
                                      }
                                  });

                                }
                            });


                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });

            }
        });



        buyNow=findViewById(R.id.button5);
        buyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Parts.this,Address.class);
                startActivity(intent);
            }
        });
        report=findViewById(R.id.button7);
        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Parts.this,Report.class);
                startActivity(intent);
            }
        });
        review=findViewById(R.id.button8);
        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Parts.this,Review.class);
                startActivity(intent);
            }
        });


    }
}