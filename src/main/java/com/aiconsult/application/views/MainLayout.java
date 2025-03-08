package com.aiconsult.application.views;

import com.aiconsult.application.views.home.HomeView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.theme.lumo.LumoUtility;

@AnonymousAllowed
public class MainLayout extends AppLayout {

    private H1 viewTitle;

    public MainLayout() {
        setPrimarySection(Section.NAVBAR); // Changed to navbar
        addToNavbar(true, createHeaderContent());
        addToDrawer(createDrawerContent());
    }
    private Component createHeaderContent(){
        DrawerToggle toggle = new DrawerToggle();
        toggle.setAriaLabel("Menu toggle");
        viewTitle = new H1("Adept AI Solutions");
        viewTitle.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);

        HorizontalLayout headerContent = new HorizontalLayout(toggle, viewTitle);
        headerContent.setWidthFull();
        headerContent.setAlignItems(FlexComponent.Alignment.CENTER);
        return headerContent;
    }
    private Component createDrawerContent(){
        Scroller scroller = new Scroller(createNavigation());
        return new VerticalLayout(scroller);
    }
    private SideNav createNavigation() {
        SideNav nav = new SideNav();

        nav.addItem(new SideNavItem("Home", HomeView.class, VaadinIcon.HOME.create()));
        // nav.addItem(new SideNavItem("Services", ServicesView.class, VaadinIcon.TOOLS.create()));
        // nav.addItem(new SideNavItem("About Us", AboutView.class, VaadinIcon.INFO_CIRCLE.create()));
        // nav.addItem(new SideNavItem("Contact", ContactView.class, VaadinIcon.ENVELOPE.create()));

        return nav;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        // viewTitle.setText(getCurrentPageTitle()); // No need to get page header from menu config
    }
}
