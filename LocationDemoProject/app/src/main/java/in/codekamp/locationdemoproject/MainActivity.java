package in.codekamp.locationdemoproject;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LocationListener {

    private Location currentLocation = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LocationManager manager = (LocationManager) this.getSystemService(LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Toast toast = Toast.makeText(this, "Permission for location access not given", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
            manager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        Log.d("codekamp", "Longitude is: " + location.getLongitude());
        Log.d("codekamp", "Latitude is: " + location.getLatitude());
        Log.d("codekamp", "Provider is: " + location.getProvider());
        Log.d("codekamp", "Accuracy is: " + location.getAccuracy());
        Log.d("codekamp", "Time is: " + location.getTime());

        if(isMoreAccurate(location)) {
            this.currentLocation = location;
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        Log.d("codekamp", provider + " status changed to " + status);
    }

    @Override
    public void onProviderEnabled(String provider) {
        Log.d("codekamp", provider + " enabled");
    }

    @Override
    public void onProviderDisabled(String provider) {
        Log.d("codekamp", provider + " disabled");
    }

    public boolean isMoreAccurate(Location newLocation) {
        if((newLocation.getTime() - currentLocation.getTime()) > 5000) {
            return true;
        }

        if (newLocation.getAccuracy() > currentLocation.getAccuracy()) {
            return true;
        }

        return false;


    }
}
