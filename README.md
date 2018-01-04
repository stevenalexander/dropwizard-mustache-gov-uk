# Dropwizard Mustache gov.uk

Simple example Dropwizard application using Dropwizard views with Mustache templates importing gov.uk styles.

Requires:
* Java (9)
* Gradle (uses local wrapper so no install required)
* Node.js and npm (to update gov.uk styles)

## Run

```
./gradlew run
# runs on http://localhost:8080 and healthchecks on http://localhost:8081
```

## Update gov.uk styles

Uses a gulp task to copy the latest styles from [govuk_template_mustache](https://www.npmjs.com/package/govuk_template_mustache) into Dropwizard resources.

```
npm install
npm start
```

## Notes

* This is not a production ready implementation
* Uses a static application.css, should be updated to pull and build CSS from SASS using full [govuk-elements-sass](https://www.npmjs.com/package/govuk-elements-sass) assets
* Dropwizard has no automatic re-compile function for templates, so needs restarted each change
* Mustache does not officially support inheritance, so the govuk mustache uses a raw html variable approach to handle this, which is not ideal
* Should refactor to replace passing the MustacheViewRenderer to Resources/Views with a proper GovUkViewRenderer, so resources only need to be aware of their own views