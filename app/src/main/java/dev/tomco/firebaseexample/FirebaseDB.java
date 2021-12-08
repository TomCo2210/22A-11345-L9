package dev.tomco.firebaseexample;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FirebaseDB {
    public interface CallBack_String {
        void dataReady(String str);
    }

    public interface CallBack_Cars {
        void dataReady(ArrayList<Car> cars);
    }

    public static void getAllCars(CallBack_Cars callBack_cars) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference carsRef = database.getReference("cars");
        carsRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<Car> cars = new ArrayList<>();
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    try {


                        cars.add(child.getValue(Car.class));
                    } catch (Exception e) {

                    }
                }
                if (callBack_cars != null)
                    callBack_cars.dataReady(cars);
                Log.d("pttt", "Value is: " + cars);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w("pttt", "Failed to read value.", error.toException());
            }
        });
    }

    public static void getCarModelByLicense(String license, CallBack_String callback_string) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference carsRef = database.getReference("cars");
        carsRef.child(license).child("model").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String model = dataSnapshot.getValue(String.class);
                if (callback_string != null)
                    callback_string.dataReady(model);
                Log.d("pttt", "Value is: " + model);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w("pttt", "Failed to read value.", error.toException());
            }
        });
    }
}





























