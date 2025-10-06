Feature: View Combo Timeline

  @OPT1
  Scenario: Open Combo Timeline page
    When Open the page
    Then Verification that the page was opened


  @OPT2
  Scenario Outline: Hover Point
    When Open the page
    And Agree to Cookies
    And Hide Revenue data
    And On the tracker line, hover point number <No>
    Then Tooltip has date "<keyDate>" and employees "<sumEmployees>"

    Examples:
      | No | keyDate            | sumEmployees |
      | 1  | November 1, 2009   | 1            |
      | 2  | November 20, 2010  | 2            |
      | 3  | April 1, 2011      | 3            |
      | 4  | August 1, 2011     | 4            |
      | 5  | August 5, 2011     | 5            |
      | 6  | June 1, 2012       | 6            |
      | 7  | September 10, 2012 | 5            |
      | 8  | September 15, 2012 | 6            |
      | 9  | August 1, 2013     | 7            |
      | 10 | August 20, 2013    | 8            |
      | 11 | October 1, 2013    | 9            |
      | 12 | August 8, 2014     | 10           |
      | 13 | November 1, 2014   | 11           |
      | 14 | February 1, 2015   | 12           |
      | 15 | May 1, 2015        | 13           |
      | 16 | August 1, 2015     | 15           |
      | 17 | January 1, 2016    | 16           |
      | 18 | February 1, 2016   | 18           |
      | 19 | May 1, 2016        | 17           |
      | 20 | July 1, 2016       | 16           |
      | 21 | August 1, 2016     | 19           |
      | 22 | September 1, 2016  | 20           |
      | 23 | January 1, 2017    | 21           |
      | 24 | March 1, 2017      | 20           |
      | 25 | August 1, 2017     | 19           |
      | 26 | September 1, 2017  | 21           |
      | 27 | November 1, 2017   | 20           |
      | 28 | January 1, 2018    | 23           |
      | 29 | August 1, 2018     | 26           |
      | 30 | February 1, 2019   | 27           |
      | 31 | March 1, 2019      | 28           |
      | 32 | June 1, 2019       | 29           |
      | 33 | August 1, 2019     | 31           |
      | 34 | January 1, 2020    | 29           |
      | 35 | February 1, 2020   | 28           |
      | 36 | June 1, 2020       | 27           |
      | 37 | July 1, 2020       | 26           |
      | 38 | September 1, 2020  | 28           |
      | 39 | October 1, 2020    | 29           |
      | 40 | November 1, 2020   | 30           |
      | 41 | January 1, 2021    | 31           |
      | 42 | February 1, 2021   | 32           |
      | 43 | March 1, 2021      | 33           |
      | 44 | April 1, 2021      | 34           |
      | 45 | June 1, 2021       | 33           |
      | 46 | July 1, 2021       | 34           |
      | 47 | September 1, 2021  | 33           |
      | 48 | October 1, 2021    | 32           |
      | 49 | November 1, 2021   | 33           |
      | 50 | December 1, 2021   | 34           |
      | 51 | February 1, 2022   | 35           |
      | 52 | March 1, 2022      | 34           |
      | 53 | May 1, 2022        | 36           |
      | 54 | June 1, 2022       | 37           |
      | 55 | July 1, 2022       | 36           |
      | 56 | August 1, 2022     | 39           |
      | 57 | September 1, 2022  | 38           |
      | 58 | November 1, 2022   | 39           |
      | 59 | December 1, 2022   | 39           |
      | 60 | January 1, 2023    | 39           |
      | 61 | February 1, 2023   | 39           |
      | 62 | March 1, 2023      | 40           |
      | 63 | April 1, 2023      | 41           |
      | 64 | May 1, 2023        | 41           |
      | 65 | June 1, 2023       | 40           |
      | 66 | July 1, 2023       | 38           |

