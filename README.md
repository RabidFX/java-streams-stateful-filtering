# java-streams-stateful-filtering

## Idea

A test project to get an idea of a good solution for "stateful" filtering of Java Streams.

This small test originated from the following StackOverflow question: [How to filter out only the first element not matching a predicate in a Java sequential Stream?](https://stackoverflow.com/questions/45921259/how-to-filter-out-only-the-first-element-not-matching-a-predicate-in-a-java-sequ)

## First analysis

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

## Contribute!

Feel free to add your own tests or implemntations to take another angle on this and submit a pull request.

### Compare a new algorithm

In order to add a new algorithm, simply create a new `Processor` subclass in the package `com.nullpaperexception.test.java.streams.filtering.processors`. 
The JUnit tests will allow you to make sure your algorithm creates the expected output. Simply extend the test class `com.nullpaperexception.test.java.streams.filtering.processors.ProcessorTest` and provide a `@Before` method that sets the `processor` variable.
The JMH benchmarks will allow you to compare your algorithm performance. Simply extend the `com.nullpaperexception.test.java.streams.filtering.benchmarks.Benckmarks` class, and provide a new instance of your processor in the method to implement.

### Add edge cases

If you feel like a particular set of conditions could make an algorithm fail, feel free to add a test in the `ProcessorTest` test class.

### Add benchmarks

If you would like to measure how the algorithms perform in a specific set of conditions, feel free to add a `@Benchmark` method in the `Benchmarks` class.
