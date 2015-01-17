package com.Housing2;

import com.Housing2.data.model.Offer;
import com.Housing2.data.provider.OfferProvider;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Page;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification.Type;

public class ConfirmDeleteWindow extends Window {

    private static Offer currentOffer;

    public ConfirmDeleteWindow(Offer offer) {
        super("Bitte best�tigen Sie die L�schung...");
        currentOffer = offer;
        initialisieren();
    }

    public void initialisieren() {
        this.center();
        this.setHeight("50%");
        this.setWidth("30%");

        final VerticalLayout content = new VerticalLayout();
        content.setMargin(true);

        //text
        Label text = new Label();
        text.setImmediate(false);
        text.setWidth("-1px");
        text.setHeight("-1px");
        //TODO Zeilenumbruch
        text.setValue("Wollen Sie Ihr Angebot " + currentOffer.getTitle() + " wirklich unwiderruflich l�schen? Alternativ k�nnen Sie es auch deaktivieren, indem Sie das Angebot bearbeiten und dort den Haken bei \"deaktivieren\" setzen. Auf diese Weise k�nnen Sie das Angebot gegebenenfalls sp�ter wieder reaktivieren.");
        content.addComponent(text);

        HorizontalLayout buttons = new HorizontalLayout();

        //cancel-Button
        Button cancel = new Button();
        cancel.setIcon(FontAwesome.MAIL_REPLY);
        cancel.setStyleName("BearbeitenButton");
        cancel.setCaption("Abbrechen");
        cancel.setImmediate(true);
        cancel.setDescription("Angebot endg�ltig l�schen");
        cancel.setWidth("-1px");
        cancel.setHeight("-1px");
        buttons.addComponent(cancel);
        cancel.addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {

                Notification not = new Notification("Das Angebot wurde nicht gel�scht.", Type.HUMANIZED_MESSAGE);//Meldung an den Nutzer
                not.setStyleName("failure");
                not.setDelayMsec(300);
                not.show(Page.getCurrent());
                ConfirmDeleteWindow.this.close();

            }
        });

        //delete-Button
        Button delete = new Button();
        delete.setIcon(FontAwesome.TRASH_O);
        delete.setStyleName("loeschen");
        delete.setCaption("L�schen");
        delete.setImmediate(true);
        delete.setDescription("Angebot endg�ltig l�schen");
        delete.setWidth("-1px");
        delete.setHeight("-1px");
        buttons.addComponent(delete);
        delete.addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {

                //TODO
                new OfferProvider().removeOffer(currentOffer);

                Notification not = new Notification("Das Angebot wurde gel�scht und aus der Datenbank entfernt.", Type.HUMANIZED_MESSAGE);//Meldung an den Nutzer
                not.setStyleName("success");
                not.setIcon(FontAwesome.CHECK_SQUARE_O);
                not.setDelayMsec(300);
                not.show(Page.getCurrent());
                String name = "Angebote verwalten";
                getUI().getNavigator().addView(name, new AngeboteVerwalten());
                getUI().getNavigator().navigateTo(name);

                ConfirmDeleteWindow.this.close();

            }
        });

        content.addComponent(buttons);

        this.setContent(content);

    }

}