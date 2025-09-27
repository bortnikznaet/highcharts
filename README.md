## Task: prepare the engine for UI tests

### Create a page object for the page https://www.highcharts.com/demo/combo-timeline
- Add Cucumber
- Add a step that will open the page
- Add verification that the page was opened

### Deadline: next Monday, September 29

### How to run
#### Firefox    
    mvn test -Dbrowser=firefox
#### Edge
    mvn test -Dbrowser=edge
#### Chrome   
    mvn test -Dbrowser=chrome