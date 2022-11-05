Feature: Calculation of the Premium cost

  Scenario: Calculating the insurance for a male underage citizen
    Given An underage Citizen
    And it's gender is "male"
    # The license cannot be valid or invalid is indistinct
    When wants to know the cost
    Then It should be -1

  Scenario: An old man/woman couldn't buy an insurance
    Given An old citizen >=80 y.o
    When wants to know the cost
    Then It should be -1

 Scenario Outline: Calculating the insurance for a male citizen with valid license
    Given A citizen of age <age>
    And it's gender is "male"
    And has valid license
    And his marital status is <marital_status>
    When wants to know the cost
    Then It should be <cost>
   Examples:
     | age | cost |  marital_status  |
     | 18  |  300 | "married"        |
     | 18  | 2000 | "single"         |
     | 24  | 2000 | "single"         |
     | 24  |  300 | "married"        |
     | 25  |  300 | "married"        |
     | 25  |  500 | "single"         |

   Scenario Outline: Calculating the insurance for a citizen with invalid license
     Given A citizen of age <age>
     And has invalid license
     When wants to know the cost
     Then It should be -1
     Examples:
     | age |
     | 17  |
     | 18  |
     | 25  |
     | 45  |
     | 65  |

 Scenario Outline: A male citizen wants to buy the insurance
   Given A citizen of age <age>
   And has valid license
   And it's gender is "male"
   And his marital status is <marital_status>
   When wants to know the cost
   Then It should be <cost>
   Examples:
     | age | marital_status | cost |
     | 17  | "single"       | 2000 |
     | 17  | "married"      |  300 |
     | 24  | "single"       | 2000 |
     | 24  | "married"      |  300 |
     | 25  | "single"       |  500 |
     | 25  | "married"      |  300 |
     | 44  | "single"       |  500 |
     | 44  | "married"      |  300 |
     | 45  | "single"       |  400 |
     | 45  | "married"      |  200 |
     | 64  | "single"       |  400 |
     | 64  | "single"       |  200 |
     | 65  | "single"       |  500 |
     | 65  | "married"      |  300 |
     | 80  | "single"       |   -1 |
     | 80  | "married"      |   -1 |



  Scenario Outline: A woman citizen wants to buy the insurance
       Given A citizen of age <age>
       And has valid license
       And it's gender is "female"
       And his marital status is <marital_status>
       When wants to know the cost
       Then It should be <cost>
       Examples:
         | age |  marital_status  | cost |
         | 17  | "single"         | -1   |
         | 18  | "single"         | 300  |
         | 18  | "married"        | 300  |
         | 25  | "single"         | 300  |
         | 25  | "married"        | 300  |
         | 44  | "single"         | 300  |
         | 44  | "married"        | 300  |
         | 45  | "single"         | 200  |
         | 45  | "married"        | 200  |
         | 64  | "single"         | 200  |
         | 64  | "married"        | 200  |
         | 65  | "single"         | 300  |
         | 65  | "married"        | 300  |
         | 66  | "single"         | 300  |
         | 66  | "married"        | 300  |
         | 80  | "single"         | -1   |




