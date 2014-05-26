package net.sgoliver;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;

public class AndroidXml extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        RssParserSax saxparser = new RssParserSax("http://212.170.237.10/rss/rss.aspx");
        
        @SuppressWarnings("unused")
		List<Noticia> noticias = saxparser.parse();

        //Tratamiento del array de noticias
        //...
    }
}