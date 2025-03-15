package com.aiconsult.application.views.services;

import com.aiconsult.application.views.MainLayout;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.theme.lumo.LumoUtility;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;

@PageTitle("Services | Adept AI Solutions")
@Route(value = "services", layout = MainLayout.class)
@AnonymousAllowed
public class ServicesView extends VerticalLayout {

    public ServicesView() {
        addClassName("services-view");
        setSizeFull();
        setPadding(false);
        setSpacing(false);

        // Hero Section (Similar to the top section of Singpass)
        VerticalLayout heroSection = createHeroSection();

        // Services Grid (Similar to the grid of Singpass services)
        VerticalLayout servicesGrid = createServicesGrid();

        // Combine Sections
        add(heroSection, servicesGrid);

        // Basic Styling (You can expand on this with CSS or Lumo utilities)
        getStyle().set("text-align", "center");
        setJustifyContentMode(JustifyContentMode.START);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
    }

    private VerticalLayout createHeroSection() {
        VerticalLayout hero = new VerticalLayout();
        hero.addClassNames(LumoUtility.Background.PRIMARY_10, LumoUtility.Padding.XLARGE, LumoUtility.Padding.Horizontal.LARGE);
        hero.setWidthFull();
        hero.setJustifyContentMode(JustifyContentMode.CENTER);
        hero.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        H1 title = new H1("Empowering Your Business with AI");
        title.addClassNames(LumoUtility.TextColor.PRIMARY_CONTRAST, LumoUtility.Margin.NONE);

        Paragraph description = new Paragraph("Discover how our AI solutions can transform your operations and drive growth.");
        description.addClassNames(LumoUtility.TextColor.PRIMARY_CONTRAST, LumoUtility.Margin.Bottom.XLARGE);

        Button contactButton = new Button("Contact Us", new Icon(VaadinIcon.ENVELOPE));
        contactButton.addClassNames(LumoUtility.Background.PRIMARY, LumoUtility.TextColor.PRIMARY_CONTRAST, LumoUtility.Padding.MEDIUM);

        
        // Add a click listener to the contact button
        contactButton.addClickListener(event -> {
            // Open a mailto link when the button is clicked
            String emailAddress = "helloadeptai@gmail.com";
            String mailtoLink = "mailto:" + emailAddress;
            UI.getCurrent().getPage().open(mailtoLink);
        });

        hero.add(title, description, contactButton);
        return hero;
    }

    private VerticalLayout createServicesGrid() {
        VerticalLayout grid = new VerticalLayout();
        grid.addClassNames(LumoUtility.Padding.XLARGE, LumoUtility.Gap.XLARGE);
        grid.setJustifyContentMode(JustifyContentMode.CENTER);
        grid.setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        // Create Service Rows (You can add more rows as needed)
        HorizontalLayout row1 = createServiceRow(
                new ServiceCard("AI-Powered Automation", "Automate repetitive tasks and improve efficiency.", VaadinIcon.AUTOMATION.create()),
                new ServiceCard("Predictive Analytics", "Gain insights and make data-driven decisions.", VaadinIcon.CHART_TIMELINE.create())
        );
        HorizontalLayout row2 = createServiceRow(
                new ServiceCard("Intelligent Chatbots", "Enhance customer service with AI-driven chatbots.", VaadinIcon.COMMENTS.create()),
                new ServiceCard("Custom AI Solutions", "Tailored AI solutions to meet your unique business needs.", VaadinIcon.PUZZLE_PIECE.create())
        );

        grid.add(row1, row2);
        return grid;
    }

    private HorizontalLayout createServiceRow(ServiceCard card1, ServiceCard card2) {
        HorizontalLayout row = new HorizontalLayout(card1, card2);
        row.setWidthFull();
        row.setJustifyContentMode(JustifyContentMode.CENTER);
        row.setDefaultVerticalComponentAlignment(Alignment.STRETCH);
        return row;
    }

    // Helper Class: Service Card
    private class ServiceCard extends VerticalLayout {
        public ServiceCard(String title, String description, com.vaadin.flow.component.Component icon) {
            addClassNames(LumoUtility.Border.ALL, LumoUtility.BorderColor.CONTRAST_10, LumoUtility.Padding.LARGE, LumoUtility.Gap.SMALL, LumoUtility.BoxShadow.MEDIUM, LumoUtility.BorderRadius.LARGE);
            setWidth("400px");
            setHeight("250px");

            H3 serviceTitle = new H3(title);
            serviceTitle.addClassNames(LumoUtility.Margin.NONE);
            Paragraph serviceDescription = new Paragraph(description);
            add(icon, serviceTitle, serviceDescription);
            setJustifyContentMode(JustifyContentMode.CENTER);
            setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        }
    }
}
