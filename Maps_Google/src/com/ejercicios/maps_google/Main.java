package com.ejercicios.maps_google;

import android.app.ProgressDialog;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.*;



public class Main extends MapActivity {

	private TextView tvLocation = null;
	private ProgressDialog pd= null;
	private MapView mapview = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		tvLocation = (TextView) this.findViewById(R.id.tvlocation);
		//pd = ProgressDialog.show(this, "Location", "Waiting for gps location...");
		configGPS();
		mapview = (MapView) findViewById(R.id.myMapView);
		mapview.setBuiltInZoomControls(true);
		mapview.setClickable(true);
	}
	
	private void updateScreen(Location location){
		
		tvLocation.setText("Latitude=" + String.valueOf(location.getLatitude())+ "\n"+ 
		"Longitude=" + String.valueOf(location.getLongitude()));
		
	}
	private void configGPS(){
		LocationManager mLocationManager;
		LocationListener mLocationListener;
		mLocationManager = (LocationManager)
				getSystemService(Context.LOCATION_SERVICE);
		mLocationListener = new  MylocationListener();
		mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
				5000, 10, mLocationListener);
	}
	private class MylocationListener implements LocationListener
	{

		@Override
		public void onLocationChanged(Location location) {
			// TODO Auto-generated method stub
			Log.d("Hello_Gps", "Latitude = " + String.valueOf(location.getLatitude()));
			Log.d("Hello_Gps", "Longitude = " + String.valueOf(location.getLongitude()));
			updateScreen(location);
			pd.dismiss();
		}

		@Override
		public void onProviderDisabled(String provider) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onProviderEnabled(String provider) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			// TODO Auto-generated method stub
			
		}
	}
	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
