package com.Housing2;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.*;

// TODO: Auto-generated Javadoc

/**
 * The Class Startseite.
 */
public class FAQ extends HorizontalLayout implements View {

    /**
     * The content.
     */
    VerticalLayout content;

    /*
     * (non-Javadoc)
     *
     * @see
     * com.vaadin.navigator.View#enter(com.vaadin.navigator.ViewChangeListener
     * .ViewChangeEvent)
     */
    @Override
    public void enter(ViewChangeEvent event) {
        // TODO Auto-generated method stub

    }

    /**
     * Instantiates a new startseite.
     */
    public FAQ() {
        this.setWidth("100%");

        // linkes rotes Panel
        Panel p = new Panel();
        p.setWidth("100%");
        p.setHeight("100%");
        p.addStyleName("red");
        addComponent(p);
        this.setExpandRatio(p, 1);

        // mittlerer Teil der Seite
        VerticalLayout v = new VerticalLayout();

        // Navigation hinzufuegen
        Navigation nav = new Navigation();
        nav.setWidth("100%");
        nav.addStyleName("navigation");
        v.addComponent(nav);

        NavigationPublic navPublic = new NavigationPublic();
        v.addComponent(navPublic);

        // falls der Benutzer eingelogt ist ver�ndert sich die Navigation
        if (VaadinSession.getCurrent().getAttribute("login").equals(true)) {
            nav.setVisible(true);
            navPublic.setVisible(false);
        } else {
            nav.setVisible(false);
            navPublic.setVisible(true);
        }

        // Inhalt hinzufuegen
        content = new VerticalLayout();
        content.setMargin(true);
        content.setWidth("100%");
        setContent();// Methode zum befuellen des Inhalts aufrufen
        v.addComponent(content);


        // Footer hinzufuegen
        Footer f = new Footer();
        v.addComponent(f);

        // rotes Panel unter dem Footer
        Panel p2 = new Panel();
        p2.setWidth("100%");
        p2.addStyleName("red");
        p2.setHeight("30px");
        v.addComponent(p2);


        addComponent(v);
        this.setExpandRatio(v, 12);

        // rotes rechtes Panel
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
    public void setContent() {

        content = new VerticalLayout();
        content.setMargin(true);

        // Kategorien
        Accordion accordion = new Accordion();
        accordion.setStyleName("startseite");

        accordion.addTab(new Label(),
                "Hier finden Sie h�ufig gestellte Fragen und Antworten",
                FontAwesome.CHEVRON_CIRCLE_DOWN);
        // Tab 1 ..zu Ihrem Account
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);

        // Unterkategorien zu Fragen zu Ihrem Account:
        Accordion sub_accordion = new Accordion();
        sub_accordion.setStyleName("startseite");

        final Label label = new Label(
                "Bitte versuchen Sie zun�chst, sich mit Ihrer E-Mail-Adresse und Ihrem Passwort einzuloggen. \nWenn Sie Ihr Passwort vergessen haben, nutzen Sie die Funktion \"Passwort vergessen?\"");
        sub_accordion.addTab(label,
                "Ich kann mich nicht mehr einloggen. Was nun?",
                FontAwesome.QUESTION);

        // Unterkategorien zu Fragen zu Ihrem Account:
        final Label label_1 = new Label(
                "Ihre Anmeldung l�uft in einer Session. Sind Sie l�ngere Zeit nicht aktiv, \nwird die Session beendet und Sie m�ssen sich erneut anmelden.");
        sub_accordion.addTab(label_1,
                "Was bedeutet \"Ihre Session ist abgelaufen\"?",
                FontAwesome.QUESTION);

        // Unterkategorien zu Fragen zu Ihrem Account:
        final Label label_2 = new Label(
                "Um Ihr Account l�schen zu k�nnen, m�ssen Sie sich zun�chst einloggen. \nKlicken Sie anschlie�end auf die Registerkarte Pers�nliche Daten und Meine Profildaten. Dort finden Sie am Ende der Seite ein Button \"Profil l�schen\". ");
        sub_accordion.addTab(label_2, "Wie l�sche ich mein Account?",
                FontAwesome.QUESTION);

        layout.addComponent(sub_accordion);
        accordion.addTab(layout, "zu Ihrem Accout", FontAwesome.THUMB_TACK);// Tab
        // 1
        // hinzuf�gen

        // Tab 2 zu Wohnungsangebote als Anbieter
        final VerticalLayout layout_1 = new VerticalLayout();
        layout_1.setMargin(true);
        // Unterkategorien zu Fragen zu Wohnungsangebote als Anbieter
        Accordion sub_accordion_1 = new Accordion();
        sub_accordion_1.setStyleName("startseite");

        final Label label_3 = new Label(
                "Um ein Angebot erstellen zu k�nnen, m�ssen Sie sich zun�chst registrieren bzw. einloggen. \nKlicken Sie anschlie�end auf die Registerkarte Wohnung einstellen und Neue Wohnung anbieten.");
        sub_accordion_1.addTab(label_3,
                "Wie kann ich ein Wohnungsangebot erstellen?",
                FontAwesome.QUESTION);

        final Label label_4 = new Label(
                "Um ein Angebot bearbeiten zu k�nnen, m�ssen Sie sich zun�chst einloggen. \nKlicken Sie anschlie�end auf die Registerkarte Wohnung einstellen und Wohnungsangebote verwalten. \nNun erscheint eine Liste Ihrer Angebote. W�hlen Sie das zu bearbeitende Angebot aus. \nAm Ende der Seite befindet sich ein Button \"Bearbeiten\".");
        sub_accordion_1.addTab(label_4,
                "Wie kann ich ein Wohnungsangebot bearbeiten?",
                FontAwesome.QUESTION);

        final Label label_5 = new Label(
                "Um ein Angebot l�schen zu k�nnen, m�ssen Sie sich zun�chst einloggen. \nKlicken Sie anschlie�end auf die Registerkarte Wohnung einstellen und Wohnungsangebote verwalten. \nNun erscheint eine Liste Ihrer Angebote. W�hlen Sie das gew�nschte Angebot aus. \nAm Ende der Seite befindet sich ein Button \"L�schen\". Hinweis: Haben Sie vor das Angebot ggf. sp�ter wieder einzustellen ist es m�glich, das Angebot f�r einen Zeitraum zu deaktivieren.");
        sub_accordion_1.addTab(label_5,
                "Wie kann ich ein Wohnungsangebot l�schen?",
                FontAwesome.QUESTION);

        final Label label_6 = new Label(
                "Um ein Angebot deaktivieren zu k�nnen, m�ssen Sie sich zun�chst einloggen. \nKlicken Sie anschlie�end auf die Registerkarte Wohnung einstellen und Wohnungsangebote verwalten. \nNun erscheint eine Liste Ihrer Angebote. W�hlen Sie das gew�nschte Angebot aus. \nKlicken Sie den Button \"Bearbeiten\". Am Ende der Seite befindet sich ein K�stchen um das Angebot zu deaktivieren.");
        sub_accordion_1.addTab(label_6,
                "Wie kann ich ein Wohnungsangebot deaktivieren?",
                FontAwesome.QUESTION);

        layout_1.addComponent(sub_accordion_1);
        accordion.addTab(layout_1, "zu Wohnungsangebote als Anbieter",
                FontAwesome.THUMB_TACK);// Tab 2 hinzuf�gen

        // Tab 3 zu Wohnungsangebote
        final VerticalLayout layout_2 = new VerticalLayout();
        layout_2.setMargin(true);
        // Unterkategorien zu Fragen zu Wohnungsangebote
        Accordion sub_accordion_2 = new Accordion();
        sub_accordion_2.setStyleName("startseite");

        final Label label_8 = new Label(
                "Ist ein Angebot nicht mehr aktuell und der Anbieter l�scht dieses Angebot, wird es automatisch aus allen Listen gel�scht.");
        sub_accordion_2
                .addTab(label_8,
                        "Warum ist ein Wohnungsangebot in meinen Favoriten verschwunden?",
                        FontAwesome.QUESTION);

        final Label label_9 = new Label(
                "Um ein Anfrage senden zu k�nnen, m�ssen Sie sich zun�chst als DH-Student verifizieren. \nKlicken Sie anschlie�end auf das gew�nschte Angebot. Am Ende der Seite befindet sich ein Button \"Anfragen\", dr�cken Sie diesen. \nNun kommen Sie zum Anfrageformular. In dem Textfeld k�nnen Sie nun Ihre Anfrage formulieren und mit einem Klick auf den Button \"Anfrage versenden\" wird die Anfrage an den Anbieter weitergeleitet.");
        sub_accordion_2.addTab(label_9,
                "Wie kann ich eine Anfrage f�r ein Wohnungsangebot senden?",
                FontAwesome.QUESTION);

        final Label label_10 = new Label(
                "Hat der Anbieter eines Angebots genug Anfragen oder steht das Angebot aus anderen Gr�nden zur Zeit nicht zur Verf�gung, \nhat der Anbieter die M�glichkeit das Angebot zu deaktivieren und zu einem sp�teren Zeitpunkt wieder zu aktivieren. \nJedoch kann w�hrend ein Angebot deaktiviert ist keine Anfrage gestellt werden.");
        sub_accordion_2
                .addTab(label_10,
                        "Warum kann ich zu einem Wohnungsangebot keine Anfrage senden?",
                        FontAwesome.QUESTION);

        final Label label_11 = new Label(
                "Wenn Sie zu einem Angebot bereits eine Anfrage gestellt haben, wird eine erneute Anfrage f�r das selbige Angebot nicht versendet. Da der Anbieter bereits eine Anfrage erhalten hat und wir damit sicher stellen wollen, dass die Anwendung nicht missbraucht wird.");
        sub_accordion_2.addTab(label_11,
                "Warum warum wird meine Anfrage nicht versendet?",
                FontAwesome.QUESTION);

        final Label label_12 = new Label(
                "Um zu sehen welche Angebot Sie bereits angefragt haben m�ssen Sie sich vorerst einloggen. Klicken sie auf die Registrierkarte \"Pers�nliche Daten\" und auf \"Meine Anfragen\". Nun erscheint eine Liste von Wohnungsangebote, die Sie bereits angefragt haben.");
        sub_accordion_2.addTab(label_12,
                "Woher wei� ich, welche Angebote ich bereits angefragt habe?",
                FontAwesome.QUESTION);

        layout_2.addComponent(sub_accordion_2);
        accordion.addTab(layout_2, "zu Wohnungsangebote allgemein",
                FontAwesome.THUMB_TACK);// Tab 3 hinzuf�gen

        // Tab 4
        final VerticalLayout layout_3 = new VerticalLayout();
        layout_3.setMargin(true);
        // TODO
        final Label label_13 = new Label(
                "Sollten Ihre Fragen nicht beantwortet sein, wenden Sie sich bitte an uns:");
        final Label label_14 = new Label(" E-Mail-Adresse");
        layout_3.addComponent(label_13);
        layout_3.addComponent(label_14);

        accordion.addTab(layout_3, "Mehr Hilfe?", FontAwesome.THUMB_TACK);// Tab
        // 4
        // hinzuf�gen

        content.addComponent(accordion);// verschiedene Kategorien hinzuf�gen

    }

}