package eighteen.cmp.nan.itourbradford;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

public class Navigate extends AppCompatActivity implements LocationListener {
    LocationManager locationManager;
    Double lat,lan;
    private WebView wv1;
    TextView t1,t2,t3,t4;
    public static final String PREFS_ID = "idd";
    public static final String PREFS_ID1 = "idd1";
    String tablee1,tablee,name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigate);

        Bundle extra=getIntent().getExtras();

        String res_lat=extra.getString("key");
        String res_lan=extra.getString("key1");
        String name=extra.getString("namee");



        t1=(TextView)findViewById(R.id.one);
        t2=(TextView)findViewById(R.id.two);
        t3=(TextView)findViewById(R.id.head);
        t4=(TextView)findViewById(R.id.desc);

        t3.setText(name);
        String res=t3.getText().toString();
        if (ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION}, 101);

        }
        getLocation();


        if(res.contentEquals("cartwright hall")){
            t4.setText("Cartwright Hall is the civic art gallery in Bradford, West Yorkshire, England, situated about a mile from the city centre in the Manningham district. It was built on the former site of Manningham Hall using a gift of £40,000 donated by Samuel Lister and it is named after Edmund Cartwright. ");
        }
        else if(res.contentEquals("bradford tourist information centre")){
            t4.setText("Visit Bradford is proud to run four Visitor Information Centres, located in Haworth, Ilkley, Saltaire and Bradford.  They offer a range of services such as helping you find where to stay to make it easy to extend your break that little longer.Each Visitor Information Centre has knowledgeable, friendly staff who are always happy to help.   ");
        }

        else if(res.contentEquals("alhambra theatre,bradford")){
            t4.setText("The Alhambra Theatre is a theatre in Bradford, West Yorkshire, England, named after the Alhambra palace in Granada, Spain, which was the place of residence of the Emir of the Emirate of Granada. It was built in 1913 at a cost of £20,000 for theatre impresario Francis Laidler, and opened on Wednesday 18 March 1914.  ");
        }
        else if(res.contentEquals("city park mirror pool and fountain")){
            t4.setText("The award-winning Mirror Pool in Bradford City Park is the largest urban water feature in the UK. The vast pool is animated by over 100 fountains, the largest of which, \"the Bradford Blast\" rises to 30 metres.Bradford City Park with its Mirror Pool is a great example of how investment in the public realm has the ability to completely change perceptions of an area and even effect social change. ");
        }
        else if(res.contentEquals("st george's hall")){
            t4.setText("St George's Hall is a strategic grade II* listed Victorian building located in the centre of Bradford, West Yorkshire, England.[1] Originally designed with a seating capacity of 3,500, the hall seats 1,500 people.[2] It is the oldest concert hall still in use in the United Kingdom and the third oldest in the whole of Europe ");
        }
        else if(res.contentEquals("national trust, east riddlesden hall")){
            t4.setText("East Riddlesden Hall is a 17th-century manor house in Keighley, West Yorkshire, now owned by the National Trust. The hall was built in 1642 by a wealthy Halifax clothier, James Murgatroyd. The hall is a Grade I listed building. There is a medieval tithebarn in the grounds.  ");
        }
        else if(res.contentEquals("saltaire village")){
            t4.setText("Saltaire is a Victorian model village located in Shipley, part of the City of Bradford Metropolitan District, in West Yorkshire, England. The Victorian era Salt's Mill and associated residential district located by the River Aire and Leeds and Liverpool Canal is a designated UNESCO World Heritage Site and an Anchor Point of the European Route of Industrial Heritage. ");
        }
        else if(res.contentEquals("bradford industrial museum")){
            t4.setText("Bradford Industrial Museum, established 1974 in Moorside Mills, Eccleshill, Bradford, United Kingdom, specializes in relics of local industry, especially printing and textile machinery, kept in working condition for regular demonstrations to the public. There is a Horse Emporium in the old canteen block plus a shop in the mill, and entry is free of charge.  ");
        }
        else if(res.contentEquals("bolling hall museum")){
            t4.setText("Bolling Hall is one of the oldest buildings in Bradford, West Yorkshire, England. It is currently used as a museum and education centre. The building is about a mile from the centre of Bradford. Its surroundings are suburban in character.Before the Industrial Revolution, Bradford was a small town and difficult to defend as it lay in a basin.  ");
        }
        else if(res.contentEquals("lister park")){
            t4.setText("Lister Park (also known as Manningham Park) is a picturesque public park in Bradford, West Yorkshire, England, between Manningham, Heaton and Frizinghall. It has won various national awards. It is situated about a mile outside the city centre on Manningham Lane, the main road between Bradford and Shipley.  ");
        }
        else if(res.contentEquals("shipley glen cable tramway")){
            t4.setText("The Shipley Glen Tramway is an historic funicular tramway situated in the wooded Shipley Glen near the village of Saltaire in the English county of West Yorkshire. The lower station of the funicular is some 660 feet (200 m) by foot from Saltaire railway station, and a similar distance from the historic Salts Mill, now occupied by shops and restaurants as well as the David Hockney gallery.   ");
        }
        else if(res.contentEquals("roberts park")){
            t4.setText("Roberts Park is a 14 acres (5.7 ha) public urban park in Baildon, West Yorkshire, England.[2] Higher Coach Road, Baildon, is to the north and the park is bounded to the south by the River Aire. A pedestrian footbridge crosses the Aire and links the park to the village of Saltaire. The park is an integral part of the Saltaire World Heritage site.  ");
        }
        else if(res.contentEquals("bradford cathedral")){
            t4.setText("Bradford Cathedral, full name Cathedral Church of St Peter and formerly Bradford Parish Church, is situated in the heart of Bradford in West Yorkshire, England, on a site used for Christian worship since the 8th century when missionaries based in Dewsbury evangelised the region. For most of its history the building was the parish church of St Peter.   ");
        } else if(res.contentEquals("omar khan's restaurant")){
            t4.setText("Buzzing Indian restaurant with white linen and smart decor, offering set meal and early bird deals.Address: 30 Little Horton Ln, Bradford BD5 0AL, UKHours: Closed ⋅ Opens 5PMMenu: omarkhans.co.ukReservations: opentable.co.ukPhone: +44 1274 390777 ");
        }
        else if(res.contentEquals("my thai restaurant")){
            t4.setText("We welcome your questions and comments! Please email or phone us for special orders, catering or take out!393 St. Paul Ave.Brantford, ONP: 519.751.8374E: info@mythai.caSun – Thurs: 11am – 9pmFri & Sat: 11am – 10pmFor holiday hours, please contact the location directly. ");
        } else if(res.contentEquals("cona restaurant")){
            t4.setText("Minimalist space with booths and designer lighting, for menu of prime beef cuts and seasonal dishes.Address: 20 E Parade, Bradford BD1 5HD, UKHours: Closed ⋅ Opens 12PM WedMenu: conarestaurant.comReservations: conarestaurant.comPhone: +44 1274 727747  ");
        }
        else if(res.contentEquals("classic persian restaurant")){
            t4.setText("Classic Persian restaurant is based in the heart of Bradford, we have recreated the beauty and warmth of Iran within a friendly environment. Persian cuisine has been around through many centuries and generations and brings out the taste of the fresh ingredients used to prepare this unique persian food. We only use the finest fresh ingredients to prepare all our dishes ensuring the highest quality dining experience for our customers. ");
        }
        else if(res.contentEquals("bab tooma syrian restaurant")){
            t4.setText("The BAB TOOMA restaurant is a completely new type of eaterie in BRADFORD.For a start its origins are Syrian and the food is very different to 99% of the restaurants in Bradford. That should not put anyone off from eating here, especially for those who...More. 3 Thank PETALDUST. timdudal1000. Bradford, United Kingdom.  ");
        }
        else if(res.contentEquals("akbar's restaurant")){
            t4.setText("Our main Bradford restaurant provides a superb atmosphere for you to enjoy a traditional Indian dining experience with our world-renown curries.Akbar's Bradford Menu. Starters. Popadom £0.75; Pickle Tray £1.50; Lime Pickle £0.70; Aubergine Pickle £0.70; Seekh Kebabs £3.50 Tender minced lamb with onions, herbs, fresh coriander and green chillies cooked over charcoal.  ");
        }
        else if(res.contentEquals("jinnah bradford")){
            t4.setText("Jinnah Bradford, the newest addition to the Jinnah group popular throughout the Yorkshire. Bringing Fresh ingredients, cooked to perfection using our own authentic Kashmiri and continental recipes. Jinnah is the place to be for outstanding quality! Boasting a varied menu of cuisines including Chinese, Italian, Mexican.  ");
        }
        else if(res.contentEquals("bharat restaurant")){
            t4.setText("Welcome to BHARAT Restaurant, where Northern Indian/Gujarati food is cooked with a homely touch so you can enjoy an unique dining experience. BHARAT Restaurant is situated on Great Horton Road, Bradford, and is a family business founded in 1987  ");
        }
        else if(res.contentEquals("sweet centre restaurant")){
            t4.setText("Bustling, simple diner serving authentic Kashmiri cuisine since 1964, plus breakfast at weekends.Address: 110-114 Lumb Ln, Bradford BD8 7RS, UKHours: Closed ⋅ Opens 11:30AMMenu: sweetcentrerestaurant.co.uk");
        }
        else if(res.contentEquals("shimlas")){
            t4.setText("Smart popular contemporary venue dealing in barbecue and curry dishes from Kashmir and the Punjab.Address: 121-125 Great Horton Rd, Bradford BD7 1PS, UKHours: Closed ⋅ Opens 11:30AMMenu: shimlas.coPhone: +44 1274 723992  ");
        } else if(res.contentEquals("mylahore bradford delivery")){
            t4.setText("Welcome to MyLahore where we love to WOW and serve superlicious food in a welcomtastic place for all! We're proud to be the most loved British Asian Kitchen Experience. MyLahore can take care of your catering requirements with a wide variety of canapes, starters, mains, desserts and showpiece cakes for all kinds of events at any venue of your choosing. ");
        }
        else if(res.contentEquals("dhesi grill")){
            t4.setText("Casual, brightly lit South Asian eatery with classic Indian plates, plus burgers and grill dishes.Address: 29 Lilycroft Rd, Bradford BD9 5AD, UKHours: Closed ⋅ Opens 11AMPhone: +44 1274 786550Menu: dhesigrill.co.uk  ");
        }
        else if(res.contentEquals("napoleons casino & restaurant bradford")){
            t4.setText("There is so much more going on at Napoleons than just a casino, we serve mouth-watering British food complimented by an exciting wine list in our fantastic 120-seater restaurant. With bars in the restaurant & on the gaming floor you can enjoy a drink while you decide what to do next.  ");
        }
        else if(res.contentEquals("bhajis n beer")){
            t4.setText("As resident of Bradford, I’m never short of options for a great curry. Isn’t Chicken Tikka Masala actually our national dish now? If not, it will certainly be up there. My calling is always a Madras, once again I am a creature of habit when it comes to curry, I never want to risk getting it wrong and having food envy.  ");
        }
        else if(res.contentEquals("nando's bradford - leisure exchange")){
            t4.setText("Afro-Portuguese chain restaurant serving flame-grilled chicken in spicy chilli sauce. We’ve got more than legendary PERi-PERi chicken up our sleeves! You’ve got some big decisions on your hands  ");
        }
        else if(res.contentEquals("mylahore bradford flagship")){
            t4.setText("South Asian cafe-bar concept offering 4 floors of chic decor for a menu of Indian and eclectic food. All meat and poultry is sourced from British Farms meeting the highest standards of food safety, animal welfare and environmental protection. This means our chicken and meat is not only tasty, but also happy and healthy. ");
        }
        else if(res.contentEquals("sunrise bradford")){
            t4.setText("Calculations of sunrise and sunset in Bradford – England – United Kingdom for April 2018. Generic astronomy calculator to calculate times for sunrise, sunset, moonrise, moonset for many cities, with daylight saving time and time zones taken in account. 6 New Otley Road, Bradford BD3 0RP, England. ... one of the first places to do the cheap buffets. ... Very friendly staff and they are current expanding their banqueting hall to cater for VERY large events.   ");
        } else if(res.contentEquals("corniche")){
            t4.setText("Let us host your memorable day in this amazing setting providing a feeling of royalty for any large function for all the family to enjoy. The Corniche is not only a standard set above the rest in Bradford it is easily accessible, practical, warm and inviting, leaving you with a day that you and your family will treasure forever.   ");
        } else if(res.contentEquals("aagrah pudsey kashmiri restaurant")){
            t4.setText("Situated on a large traffic island with an elephant in the car park. We were looking for a regular meal but the buffet looked spectacular. The chef explained it to us - there was an array of salads, about a dozen starters, breads and probably 15 main courses with a chef cooking kebabs to order. In the centre there was a sweet station with 10 ice creams, Indian sweets and jellies etc all beautifully presented.  ");
        }
        else if(res.contentEquals("karachi restaurant")){
            t4.setText("Long-standing, informal BYOB establishment offering curry house classics in a simple setting.   ");
        }
        else if(res.contentEquals("rajshahi")){
            t4.setText("Homely Indian restaurant, with tandoori chicken and fish, plus Sunday buffet and takeaway.Address: 49 Thorp Garth, Bradford BD10 9LD, UKHours: Closed ⋅ Opens 6PMMenu: rajshahi.co.ukPhone: +44 1274 622662 ");
        }
        else if(res.contentEquals("zouk tea bar and grill")){
            t4.setText("South Asian eatery with a long menu including charcoal-cooked dishes and specials, plus tiffin.Address: 1312 Leeds Rd, Bradford BD3 8LF, UKHours: Closed ⋅ Opens 11AMMenu: zoukteabar.co.ukReservations: zoukteabar.co.ukPhone: +44 1274 258025  ");
        }
else if(res.contentEquals("midland hotel")){
            t4.setText("The Midland Hotel is a 90-bedroom three-star Victorian hotel in Bradford city centre, owned and managed by London-based Peel Hotels. The architect was Charles Trubshaw, who was contracted to design many railway stations for Midland Railway Company. Construction of the hotel began in 1885 and took five years  ");
        }
else if(res.contentEquals("holiday inn express bradford city centre")){
            t4.setText("Holiday Inn Express Bradford City Centre is located within the Leisure Exchange complex, which boasts a casino, ten-pin bowling and various restaurants and bars. Car parking is available in the multi-storey located within the complex (charges apply). Free WiFi is available throughout. The hotel also has an ATM machine. ");
        }
else if(res.contentEquals("clarion cedar court leeds/bradford hotel")){
            t4.setText("With free WiFi and free parking, the Best Western PLUS Cedar Court Bradford is located just 2 minutes’ off the M606 motorway and 10 minutes’ drive from Bradford city centre and 20 minutes' drive from Leeds. The hotel offers an in-door heated pool, a sauna and a gym.  ");
        }
else if(res.contentEquals("jurys inn bradford hotel")){
            t4.setText("One of our top picks in Bradford. An Inside Look at Jurys Inn Bradford. The Jurys Inn Bradford hotel is perfectly situated in this city packed with history. The hotel has 198 comfortable guest bedrooms and Bradford Interchange bus station and Bradford Forster Square rail station is less than 10 minutes away.  ");
        }
else if(res.contentEquals(" the great victoria hotel")){
            t4.setText("The Great Victoria Hotel is situated in the heart of Bradford, offering sophisticated rooms, event spaces and weddings in a fantastic location for ideal prices. The Great Victoria offers a host of facilities and services designed to make your stay in Bradford as enjoyable as possible. ");
        }
else if(res.contentEquals("the bradford hotel")){
            t4.setText("With WiFi available across the hotel, it's easy to get to work in your room or over a coffee in City3 bar. Discover panoramic city views in a roomy home from home when you check in to a The Bradford Hotel suite. Families visiting the world's first UNESCO designated City of Film can enjoy family friendly interconnecting rooms. ");
        }
else if(res.contentEquals("travelodge bradford central")){
            t4.setText("At our Bradford Central hotel you've got all the entertainment and culture the city has to offer right on your doorstep, and footie fans are perfectly placed to watch the Bantams play.Bradford University is conveniently close for visiting friends and relatives there, and the Alhambra Theatre, the North's premier touring venue, and the National Media Museum are just a short walk away. ");
        }
else if(res.contentEquals("hotel ibis budget bradford")){
            t4.setText("The budget hotel is set within Bradford's café and restaurant district, with numerous eateries just 10 minutes' walk away. The city of Bradford is home to various museums, including the National Media Museum. Ibis guests can also visit the World Heritage site of Salt Mill, just 3 miles away in Saltaire. ");
        }
else if(res.contentEquals("the westleigh hotel")){
            t4.setText("The Westleigh Hotel is friendly, traditional pub and hotel based just outside out the City centre of Bradford serving great, traditional pub food and modern fare. Located in the very heart of Bradford, this traditional Yorkshire stone building offers free Wi-Fi and free private parking. Built around 1900, the family-run Westleigh Hotel is just a 3-minute walk from the University of Bradford");
        }
else if(res.contentEquals("dubrovnik hotel & restaurant")){
            t4.setText("The award-winning Dubrovnik Hotel & Restaurant has stylish, boutique-style rooms with a flat-screen satellite TV and Egyptian cotton sheets. The en suite bathrooms come with free extras for female travellers.The restaurant serves English and European dishes from regularly changing menus.   ");
        }
else if(res.contentEquals("hotel restaurant campanile bradford")){
            t4.setText("The Campanile restaurant serves a traditional cooked and continental breakfast. There are also menu for lunch and evening meals, and the restaurant features a summer terrace for al fresco dining. The restaurant has constantly updated daily deals and food specials.Situated between Bradford and Leeds, ");
        }
else if(res.contentEquals("the highfield")){
            t4.setText("Highfield Restaurant has now opened it's door as a Sizzling restaurant. At Sizzling Pubs we believe you deserve more from your local pub. And it's our job to give you just that. We're a friendly bunch and we pride ourselves on giving the warmest of welcomes. Where good food and drink, great value and a generous serving.");
        }
else if(res.contentEquals("travelodge bradford")){
            t4.setText("At our Bradford Central hotel you've got all the entertainment and culture the city has to offer right on your doorstep, and footie fans are perfectly placed to watch the Bantams play.Bradford University is conveniently close for visiting friends and relatives there, and the Alhambra Theatre, the North's premier touring venue, and the National Media Museum are just a short walk away.   ");
        }
else if(res.contentEquals("trivelles bradford")){
            t4.setText("Comfortable stays in Bradford, self contained apartment units with kitchennettes and ensuite shower rooms for your use at competitive rates, near city centre. ");
        }
else if(res.contentEquals("the park hotel")){
            t4.setText("Visit Bradford is proud to run four Visitor Information Centres, located in Haworth, Ilkley, Saltaire and Bradford.  They offer a range of services such as helping you find where to stay to make it easy to extend your break that little longer.Each Visitor Information Centre has knowledgeable, friendly staff who are always happy to help.   ");
        }
else if(res.contentEquals("bradford digs")){
            t4.setText("Situated in Bradford, 2.1 km from the town centre. Bradford Digs features free super fast WiFi access and free on street parking.Every room comes with a flat-screen TV and tea/coffee making facilities. Rooms are fitted with a shared bathroom.You will find a shared kitchen at the property. A free breakfast is included. ");
        }
else if(res.contentEquals("the cartwright hotel")){
            t4.setText("The Cartwright hotel has recently gone through a £350k refurbishment and now offers quality accommodation with the highest standards. The Cartwright Hotel offers a great experience for your trip to Bradford whether it’s a Weekend Break or business trip. We offer you the complete package.  ");
        }
else if(res.contentEquals("gloucester house")){
            t4.setText("Gloucester House is set in Bradford. Popular points of interest nearby include The Alhambra Theatre, St George's Hall and University of Bradford. Local points of interest like National Media Museum and Bradford City Library are reachable within 1 km and 1.1 km, respectively. ");
        }
else if(res.contentEquals("model farm bed and breakfast")){
            t4.setText("Model Farm B&B is set amongst scenic countryside in the village of East Bierley, but is only 4.8 km from the centre of Bradford. It offers guestrooms and houses, with a lovely garden and freshly cooked breakfasts.Located in the farmhouse or redeveloped barn, each guestroom has free Wi-Fi, a flat-screen TV and tea and coffee.    ");
        }
else if(res.contentEquals("premier inn bradford central")){
            t4.setText("This modern no-frills hotel in a high-rise building is a 5-minute walk from Bradford Interchange rail station and a 6-minute walk from the St George's Hall theatre.Rooms range from singles to family rooms with 2 pull-out beds, where kids aged 15 and under eat and stay free with paying adults  ");
        }




    else if(res.contentEquals("the broadway bradford")){
            t4.setText("The Broadway is a shopping and leisure complex in the centre of Bradford, West Yorkshire, England, which opened on 5 November 2015. It was built and was operated, in its first year, by the Westfield Corporation. ");
        }
    else if(res.contentEquals("bradford plaza")){
            t4.setText("160,970-square-foot center anchored by Giant and Walgreens just minutes from popular downtown West Chester.- The center has a strong mix of tenants which include: Orangetheory Fitness, Petco, Dollar Tree, New Vision Eye Center, AT&T as well as restaurant and service tenants.- Just a few miles from West Chester University, West Chester’s Business District and QVC World Headquarters.- Bradford Plaza is located in the heart of Chester County with quick access to major roadways.  ");
        }
    else if(res.contentEquals("kirkgate shopping centre")){
            t4.setText(" Attracting 15 million visitors per annum, Kirkgate is a key part of Bradford's core retail market. The 3-storey shopping centre is anchored by a 110,000 sq. ft. Primark store, Argos, Boots and Sports Direct. Additionally Kirkgate is home to the renowned Kirkgate market and 661 car park spaces.   ");
        }
    else if(res.contentEquals("cannon mills shopping village")){
            t4.setText("Cannon Mills Shopping Village What a place, came up to Bradford and heard of Cannon Mills as being the go to market. Having been to the market Town of Skipton this was surely different. WOW.. They had a massive collection of stalls.");
        }
    else if(res.contentEquals("forster square")){
            t4.setText("Forster Square in central Bradford was redeveloped in the (2006) Broadway development, but gives its name to Bradford Forster Square railway station and a retail park. Forster Square was laid out in the late-19th century at the bottom of Kirkgate, and named after the 19th-century politician William Edward Forster. Until 1958, it was a spacious city square  ");
        }
    else if(res.contentEquals("sunbridge wells")){
            t4.setText("We created Bradford's first underground retail complex right in the heart of Bradford's historic trading quarter. With easy access from City Park and Sunbridge Road – Sunbridgewells has become a shopping and leisure area right in the center of Bradford linking the area from the new City Park to the Arndale Mall. ");
        }
    else if(res.contentEquals("the mill outlet & garden centre")){
            t4.setText("The Mill is the UK's biggest retail mill, with 4 huge floors of fashion, furniture, homewares and gifts at permanently discounted prices of 30% and more from high street prices. From independents to big brands and designer labels, The Mill Outlet & Garden centre prides itself on being a truly unique destination. ");
        }
    else{
            t4.setText("Oops..Description Not Added Yet...!!! ");
        }









        wv1 = (WebView) findViewById(R.id.wv011);
        wv1.setWebViewClient(new Mybrowser());
        wv1.getSettings().setLoadsImagesAutomatically(true);
        wv1.getSettings().setJavaScriptEnabled(true);
        Log.d("cur_lat",res_lat);
        Log.d("cur_lan",res_lan);

        String latt=t1.getText().toString();
        String lann=t2.getText().toString();


        SharedPreferences logignn =getApplicationContext().getSharedPreferences(PREFS_ID, 0);
        tablee1= logignn.getString("idd", "");


        SharedPreferences logign =getApplicationContext().getSharedPreferences(PREFS_ID1, 0);
        tablee= logign.getString("idd1", "");

        wv1.loadUrl("https://www.google.com/maps/dir/"+"53.80"+","+"-1.76"+"/"+res_lat+","+res_lan);


      //  wv1.loadUrl("https://www.google.com/maps/dir/"+tablee1+","+tablee+"/"+res_lat+","+res_lan);
        String loc="https://www.google.com/maps/dir/"+tablee1+","+tablee+"/"+res_lat+","+res_lan;
      //  Toast.makeText(getApplicationContext(),loc,Toast.LENGTH_SHORT).show();
    }


    void getLocation() {
        try {
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 5000, 5, this);
        }
        catch(SecurityException e) {
            e.printStackTrace();
        }
    }

    private class Mybrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
    @Override
    public void onLocationChanged(Location location) {

        lat=location.getLatitude();
        lan=location.getLongitude();
        /*Log.d("cur_lat",lat);
        Log.d("cur_lan",lan);*/

       // Toast.makeText(getApplicationContext(),lat.toString(),Toast.LENGTH_SHORT).show();
       // Toast.makeText(getApplicationContext(),lan.toString(),Toast.LENGTH_SHORT).show();
        // locationText.setText("Latitude: " + location.getLatitude() + "\n Longitude: " + location.getLongitude());

        SharedPreferences settings = Navigate.this.getSharedPreferences(PREFS_ID, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("idd", lat.toString());


        editor.commit();


        SharedPreferences settings1 = Navigate.this.getSharedPreferences(PREFS_ID1, 0);
        SharedPreferences.Editor editor1 = settings1.edit();
        editor1.putString("idd1", lan.toString());


        editor1.commit();


        t1.setText(lat.toString());
        t2.setText(lan.toString());

        try {
            Geocoder geocoder = new Geocoder(this, Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
           /* locationText.setText(locationText.getText() + "\n"+addresses.get(0).getAddressLine(0)+", "+
                    addresses.get(0).getAddressLine(1)+", "+addresses.get(0).getAddressLine(2));*/
        }catch(Exception e)
        {

        }
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }


}
