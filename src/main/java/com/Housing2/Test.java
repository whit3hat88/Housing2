package com.Housing2;

import com.Housing2.data.model.Favorit;
import com.Housing2.data.model.User;
import com.Housing2.data.provider.UserProvider;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

import java.util.List;

// TODO: Auto-generated Javadoc

/**
 * The Class Test.
 */
public class Test extends VerticalLayout implements View {

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

    /**
     * Instantiates a new test.
     */
    public Test() {
        Navigation nav = new Navigation();
        addComponent(nav);

        setContent();
        addComponent(content);

        Footer f = new Footer();
        addComponent(f);
    }

    /**
     * Sets the content.
     */
    public void setContent() {

        content = new VerticalLayout();
        content.setMargin(true);
        /*Button button = new Button("Suche");
        button.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				String s = "Suche";
				getUI().getNavigator().addView(s, new Suche());
				getUI().getNavigator().navigateTo(s);	
			}
		});
		content.addComponent(button);*/

        //TODO Inhalt einfügen

        //Datenbank-Test: Versuche User auszugeben aus Datenbank
        User user = new UserProvider().findById(Integer.parseInt("1"));
        List<Favorit> favs = user.getFavorits();/*new FavoritProvider().findByUser(user);*/
        Panel p = new Panel("DATENBANKABFRAGE:"
                + "User: " + user.getEmail()
                + "     Favorit(en): " + favs.get(0).getFavorit_idOffer().getTitle());
        VerticalLayout v = new VerticalLayout();
        v.setMargin(true);


        Table tabelle = new Table();
        tabelle.setSizeFull();
        tabelle.setSelectable(true);
        tabelle.setMultiSelect(true);
        tabelle.setImmediate(true);
        v.addComponent(tabelle);
        p.setContent(v);

        content.addComponent(p);

    }
}
