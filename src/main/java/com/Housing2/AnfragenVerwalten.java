package com.Housing2;

import com.Housing2.data.model.Offer;
import com.Housing2.data.model.Request;
import com.Housing2.data.model.User;
import com.Housing2.data.provider.RequestProvider;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

import java.util.List;

// TODO: Auto-generated Javadoc

/**
 * The Class Suche.
 */
public class AnfragenVerwalten extends HorizontalLayout implements View {

    /**
     * The content.
     */
    VerticalLayout content;

    /* (non-Javadoc)
     * @see com.vaadin.navigator.View#enter(com.vaadin.navigator.ViewChangeListener.ViewChangeEvent)
     */
    @Override
    public void enter(ViewChangeEvent event) {
        // TODO Auto-generated method stub

    }

    public AnfragenVerwalten() {

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

        //falls der Benutzer eingelogt ist verändert sich die Navigation
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

    public void setContent() {


        RequestProvider rp = new RequestProvider();
        List<Request> reqs;

        reqs = rp.findReq(VaadinSession.getCurrent().getAttribute(User.class));

        int anzahl = reqs.size();
        System.out.println(anzahl);
        for (int i = 0; i < anzahl; i++) {

            Offer o = reqs.get(i).getRequest_idOffer();
            content.addComponent(new Listenzeile(o));
        }


    }


}