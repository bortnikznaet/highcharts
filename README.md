# TAF tests and verifies text in Highcharts and Highsoft timeline tooltips.
### URL
    https://www.highcharts.com/demo/combo-timeline
### Details:
- Hovers the mouse cursor over each peak on the graph
- Checks the text in each tooltip
- Turns off section data: Revenue

#### Tech stack
    - Java 17
    - Maven
    - Selenium WebDriver
    - Cucumber JVM (JUnit Platform)
    - WebDriverManager

### How to run
    mvn clean test -Dtest=RunCucumberTest -Dcucumber.filter.tags=@OPT2