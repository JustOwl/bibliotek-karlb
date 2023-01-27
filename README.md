# bibliotek-Karl B

# Run the program from the Menu.java file

## A bit of a retrospective
### - If I had the time and effort to refactor:
If I was to do this again (or had much more time) I would have changed the code to be a bit more generic and used the interface more. Right now I repeat alot of code for each object but I could instead have had a interface method called "get/set uniqeValue" or something like that. The main reason why I did not think about doing that is that they were different data types and thought that would make it a hassle.

This makes the code (and tests) pretty bloated since there are lots of copy paste with slight changes to method calls depending on the class called.

### - Testing:
Tests were the last thing on my mind. Testing in my head is using the debugger and seing if the code does what I expect it to do. I did try and do TDD at the start but then my methods became quite complex. I did try to ensure that methods would return values relevent to the logic in them even if they mostly did internal stuff just so they could be tested in some way later on. Most of the methods that return void are ones that require user input or are just switch methods I use more than once (due to the reason above).

I have not really tried or most likley will not try and implement mocking in this project.
There would be two major things to mock in that case. User input via the terminal and file mocking for the CSVHandler.