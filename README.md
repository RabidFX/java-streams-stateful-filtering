# java-streams-stateful-filtering

A test project to get an idea of a good solution for "stateful" filtering of Java Streams.

This small test originated from the following StackOverflow question: [How to filter out only the first element not matching a predicate in a Java sequential Stream?](https://stackoverflow.com/questions/45921259/how-to-filter-out-only-the-first-element-not-matching-a-predicate-in-a-java-sequ)

Various interesting answers have been suggested, and all have their pros and cons. The aim of this project is to compare them as well as possible, and provide insights regarding which method could be suitable for your project.
The following answers have been implemented and tested here:

Method | Contributor
------------ | -------------
Comparator hack | [xenteros](https://stackoverflow.com/users/4723795/xenteros) 
Comaprator hack with dummy | [yegodm](https://stackoverflow.com/users/1654233/yegodm)
Custom collector | [Eugene](https://stackoverflow.com/users/1059372/eugene)
Indexed removal | [Holger](https://stackoverflow.com/users/2711488/holger)
Stateful predicate | [pedromss](https://stackoverflow.com/users/2716383/pedromss)
Straightforward approach | [Misha](https://stackoverflow.com/users/3920048/misha)

You can see my analysis on [this page](https://github.com/RabidFX/java-streams-stateful-filtering/wiki/Results-and-analysis).
