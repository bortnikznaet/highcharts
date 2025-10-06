## Task1: prepare the engine for UI tests

### Create a page object for the page https://www.highcharts.com/demo/combo-timeline
- Add Cucumber
- Add a step that will open the page
- Add verification that the page was opened

### How to run
#### Firefox    
    mvn test -Dbrowser=firefox
#### Edge
    mvn test -Dbrowser=edge
#### Chrome   
    mvn test -Dbrowser=chrome

## Task2: extend the TAF, prepare the test that will check text in tooltips in the 'Highcharts and Highsoft timeline'
### Deadline: Monday, October, 06
#### Details:
- Hover the mouse over the graphic or click on each peak  (hover and/or click - at your discretion, it can be mixed if you need)
- Check the text in each tooltip
- The page may NOT contain Revenue:

### How to run
    mvn clean test -Dtest=RunCucumberTest -Dcucumber.filter.tags=@OPT2