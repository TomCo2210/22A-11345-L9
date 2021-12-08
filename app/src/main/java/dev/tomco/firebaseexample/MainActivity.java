package dev.tomco.firebaseexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView main_LBL_model;
    private TextView main_LBL_model2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_LBL_model = findViewById(R.id.main_LBL_model);
        main_LBL_model2 = findViewById(R.id.main_LBL_model2);

        Car c1 = new Car("Maserati Turismo")
                .setLicensePlate("11-111-11")
                .setColor("Red")
                .setFuel(8.7)
                .setManual(true)
                .setYear(2021);

        Car c2 = new Car("Audi R8")
                .setLicensePlate("888-88-888")
                .setColor("Lime")
                .setFuel(8.7)
                .setManual(true)
                .setYear(2021);
        FirebaseDB.getCarModelByLicense("888-88-888", new FirebaseDB.CallBack_String() {
            @Override
            public void dataReady(String str) {
                main_LBL_model.setText(str);
            }
        });
        main_LBL_model2.setText("mmmmmmmmm");

        FirebaseDB.getAllCars(new FirebaseDB.CallBack_Cars() {
            @Override
            public void dataReady(ArrayList<Car> cars) {
                main_LBL_model2.setText(""+cars.size());
            }
        });
    }

    private void addCar(Car car) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference carsRef = database.getReference("cars");

        carsRef.child(car.getLicensePlate()).setValue(car);
    }


}