package ejercicios.example.pasyntasckexample.rssParser;



public class GeoRSSNode {

	private String mTitle = null;

	private String mDescription = null;

	

	// It's possible use Location structure to save 

	// geolocation data

	Double mLatitude = 0.0;

	Double mLongitude = 0.0;

	

	public GeoRSSNode (String title, String description, Double latitude, Double longitude)

	{
 
	
		
		setmTitle(title);

		setmDescription(description);

		mLatitude = latitude;

		mLongitude = longitude;

	}



	public GeoRSSNode(String name, String description, double latitude,
			double longitude) {
		// TODO Auto-generated constructor stub
	}



	public String getmTitle() {
		return mTitle;
	}



	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
	}



	public String getmDescription() {
		return mDescription;
	}



	public void setmDescription(String mDescription) {
		this.mDescription = mDescription;
	}

	

	

}