package com.example.views.govuk;

import io.dropwizard.views.View;
import io.dropwizard.views.mustache.MustacheViewRenderer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class GovUkView extends View {

    private static final String GOV_UK = "GOV.UK";

    private static final String LICENCE_MESSAGE = "<p>All content is available under the <a href=\"https://www.nationalarchives.gov.uk/doc/open-government-licence/version/3/\" rel=\"license\">Open Government Licence v3.0</a>, except where otherwise stated</p>";

    private static final String CROWN_COPYRIGHT_MESSAGE = "© Crown copyright";

    private final MustacheViewRenderer mustacheViewRenderer;
    private final View contentView;

    public GovUkView(MustacheViewRenderer mustacheViewRenderer, View contentView) {
        super("govuk_template.mustache");
        this.mustacheViewRenderer = mustacheViewRenderer;
        this.contentView = contentView;
    }

    public String getHtmlLang() {return "en"; }

    public String getAssetPath() { return "/public/"; }

    public String getPageTitle() { return GOV_UK; }

    public String getHead() { return GetTemplateHtml(new HeadView()); }

    public String getCookieMessage() { return GetTemplateHtml(new CookieMessageView()); }

    public String getHomepageUrl() { return "/start"; }

    public String getLogoLinkTitle() { return GOV_UK; }

    public String getGlobalHeaderText() { return GOV_UK; }

    public String getPropositionHeader() { return GetTemplateHtml(new NavigationView()); }

    public String getFooterSupportLinks() { return GetTemplateHtml(new FooterLinksView()); }

    public String getLicenceMessage() { return LICENCE_MESSAGE; }

    public String getCrownCopyrightMessage() { return CROWN_COPYRIGHT_MESSAGE; }

    public String getContent() { return GetTemplateHtml(contentView); }

    private String GetTemplateHtml(View view) {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            mustacheViewRenderer.render(view,null, outputStream);
            return outputStream.toString();
        }
        catch (IOException ex) {
            return "";
        }
    }
}
