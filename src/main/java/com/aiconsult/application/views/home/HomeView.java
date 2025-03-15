package com.aiconsult.application.views.home;

import com.aiconsult.application.views.MainLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.theme.lumo.LumoUtility;

@PageTitle("Home | Adept AI Solutions")
@Route(value = "home", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@AnonymousAllowed
public class HomeView extends VerticalLayout {
    public HomeView() {
        addClassNames("home-view"); // Add a class name for CSS styling
        setSizeFull();

        // Create a container for the text content
        Div content = new Div();
        content.addClassNames(LumoUtility.Margin.LARGE, LumoUtility.Padding.LARGE, LumoUtility.Background.CONTRAST_5, LumoUtility.BorderRadius.LARGE, LumoUtility.BoxShadow.LARGE);
        content.getStyle().set("opacity", "0.8");

        H2 welcomeText = new H2("Welcome to Adept AI Solutions");
        Paragraph description = new Paragraph("Empowering Your Business with AI");
        content.add(welcomeText, description);
        add(content);

        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }
}
