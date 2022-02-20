##DELIVERABLES

List all books written by an author using following criteria:
• alphabetical asc/desc,
• publication date asc/desc,
• rating asc/desc;

Given a book, know who is the author / are the authors;

How many books has an author written;

Given a Date, what are the books written in that year;

... who is the most prolific author?

(Optional) If you think others functionality are usefull, try to add to the exercise.


##ADDITIONAL INFORMATION

Using the file Books.csv write a program for our amazing library!
Build 2 entities: Author and Book

#The Author 
has a name.

#The Book 
has a title, a year of publication and an average rating.

An author owns a list of books.

In the csv there are many columns: ignore the useless ones.

Pay attention: several books are written by different authors, for example: "The Adventures of Huckleberry Finn" was written by Mark Twain, John Seelye, Guy Cardwell.

In this case, each author will have the same book in their list, so:

Mark Twain -> "The Adventures of Huckleberry Finn"
John Seelye -> "The Adventures of Huckleberry Finn"
Guy Cardwell -> "The Adventures of Huckleberry Finn"

Using the concepts you learned during the course (Composition, polymorphism, ...), create a Library that allows you to:

List all books written by an author using following criteria:
• alphabetical asc/desc,
• publication date asc/desc,
• rating asc/desc;
Given a book, know who is the author / are the authors;
How many books has an author written;
Given a Date, what are the books written in that year;
... who is the most prolific author?
(Optional) If you think others functionality are usefull, try to add to the exercise.
I recommend simple, small and clean methods. Use javadoc, write junits and use a build automation tool (maven or gradle for example)