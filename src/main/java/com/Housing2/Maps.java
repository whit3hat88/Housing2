package com.Housing2;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.VaadinSession;
import com.vaadin.tapio.googlemaps.GoogleMap;
import com.vaadin.tapio.googlemaps.client.LatLon;
import com.vaadin.tapio.googlemaps.client.events.MarkerClickListener;
import com.vaadin.tapio.googlemaps.client.overlays.GoogleMapInfoWindow;
import com.vaadin.tapio.googlemaps.client.overlays.GoogleMapMarker;
import com.vaadin.ui.*;

// TODO: Auto-generated Javadoc

/**
 * Google Maps UI for testing and demoing.
 */
@SuppressWarnings("serial")
public class Maps extends HorizontalLayout implements View {
    /**
     * The content.
     */
    private VerticalLayout content;// Layout fuer den Inhalt

    /**
     * The google map.
     */
    private GoogleMap googleMap;

    /**
     * The kakola marker.
     */
    private GoogleMapMarker kakolaMarker = new GoogleMapMarker(
            "DRAGGABLE: Kakolan vankila", new LatLon(60.44291, 22.242415),
            true, null);

    /**
     * The kakola info window.
     */
    private GoogleMapInfoWindow kakolaInfoWindow = new GoogleMapInfoWindow(
            "Kakola used to be a provincial prison.", kakolaMarker);

    /**
     * The api key.
     */
    private final String apiKey = "";


    /**
     * Instantiates a new maps.
     */
    public Maps() {


        this.setWidth("100%");

        //linkes rotes Panel
        Panel p = new Panel();
        p.setWidth("100%");
        p.setHeight("100%");
        p.addStyleName("red");
        addComponent(p);
        this.setExpandRatio(p, 1);

        //mittlerer Teil der Seite
        VerticalLayout v = new VerticalLayout();

        //Navigation hinzufuegen
        Navigation nav = new Navigation();
        nav.setWidth("100%");
        nav.addStyleName("navigation");
        v.addComponent(nav);

        NavigationPublic navPublic = new NavigationPublic();
        v.addComponent(navPublic);

        //falls der Benutzer eingelogt ist ver�ndert sich die Navigation
        if (VaadinSession.getCurrent().getAttribute("login").equals(true)) {
            nav.setVisible(true);
            navPublic.setVisible(false);
        } else {
            nav.setVisible(false);
            navPublic.setVisible(true);
        }

        //Inhalt hinzufuegen
        content = new VerticalLayout();
        content.setMargin(true);
        content.setWidth("100%");
        setContent();//Methode zum befuellen des Inhalts aufrufen
        v.addComponent(content);

        //Footer hinzufuegen
        Footer f = new Footer();
        v.addComponent(f);

        //rotes Panel unter dem Footer
        Panel p2 = new Panel();
        p2.setWidth("100%");
        p2.addStyleName("red");
        p2.setHeight("30px");
        v.addComponent(p2);

        addComponent(v);
        this.setExpandRatio(v, 12);

        //rotes rechtes Panel
        Panel p1 = new Panel();
        p1.setWidth("100%");
        p1.addStyleName("red");
        p1.setHeight("100%");
        addComponent(p1);
        this.setExpandRatio(p1, 1);
    }


    /**
     * Sets the content.
     */
    private void setContent() {
        final TextField location = new TextField();
        googleMap = new GoogleMap(null, null, null);
        googleMap.setCenter(new LatLon(60.440963, 22.25122));
        googleMap.setZoom(10);
        googleMap.setSizeFull();
        kakolaMarker.setAnimationEnabled(false);
        googleMap.addMarker(kakolaMarker);
        googleMap.addMarker("DRAGGABLE: Paavo Nurmi Stadion", new LatLon(
                60.442423, 22.26044), true, "VAADIN/1377279006_stadium.png");
        googleMap.addMarker("NOT DRAGGABLE: Iso-Heikkil�", new LatLon(
                60.450403, 22.230399), false, null);
        googleMap.setMinZoom(4);
        googleMap.setMaxZoom(16);

        googleMap.addMarkerClickListener(new MarkerClickListener() {
            @Override
            public void markerClicked(GoogleMapMarker clickedMarker) {
                Label consoleEntry = new Label("Marker \""
                        + clickedMarker.getCaption() + "\" at ("
                        + clickedMarker.getPosition().getLat() + ", "
                        + clickedMarker.getPosition().getLon() + ") clicked.");
                location.setCaption(consoleEntry.getCaption());
            }
        });
        content.addComponent(googleMap);
        content.addComponent(location);

    }


    /* (non-Javadoc)
     * @see com.vaadin.navigator.View#enter(com.vaadin.navigator.ViewChangeListener.ViewChangeEvent)
     */
    @Override
    public void enter(ViewChangeEvent event) {
        // TODO Auto-generated method stub

    }
}