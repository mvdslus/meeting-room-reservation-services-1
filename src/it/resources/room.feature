Feature: Rooms require a location and capacity. Optional they have a name and facilities.


Scenario: Room can be found by location
Given a room with name "Berlin", location "1.12" and capacity 12
When searching for room with location "1.12"
Then the room with name "Berlin" should be returned

Scenario: Room can be found by location with facilities
Given a room with name "London", location "1.14" and capacity 12 with facilities: "whiteboard, computer" 
When searching for room with location "1.14"
Then the room with name "London" should be returned
  And the room should have facility "whiteboard"
  And the room should have facility "computer"

