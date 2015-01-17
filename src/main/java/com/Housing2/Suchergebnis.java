package com.Housing2;

import com.Housing2.data.model.Offer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

import java.util.List;

// TODO: Auto-generated Javadoc

/**
 * The Class Suchergebnis.
 */
public class Suchergebnis extends HorizontalLayout implements View {

    /**
     * The content.
     */
    VerticalLayout content;

    /**
     * Instantiates a new suchergebnis.
     */

    List<Offer> angebote;

    //�bergabe der Ergebnis aus der Suche

    /**
     * Instantiates a new suchergebnis.
     *
     * @param offers the offers
     */
    public Suchergebnis(List<Offer> offers) {

        this.angebote = offers;

        content = new VerticalLayout();

        content.setMargin(true);
        content.setSizeFull();
        content.setSpacing(true);

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
    @SuppressWarnings("deprecation")
    public void setContent() {

        if (angebote.size() == 0) {
            content.addComponent(new Label("Ihre Suche ergab keine Treffer!"));
        } else {
            content.addComponent(new Label("Ihre Suche ergab " + angebote.size() + " Treffer!"));
        }

        for (Offer o : angebote) {

            content.addComponent(new Listenzeile(o));

        }

    }

    /* (non-Javadoc)
     * @see com.vaadin.navigator.View#enter(com.vaadin.navigator.ViewChangeListener.ViewChangeEvent)
     */
    @Override
    public void enter(ViewChangeEvent event) {
        // TODO Auto-generated method stub

    }

}

