# ClassBuilder documentation

This class is used to create a class with attributes, getters, setters, toString method, a default contructor and a full contructor.

author ***ZeSpatule***

version *1.0*
since *2025-04-19*

## Attributes

```java
private static String p ;
```
The path for the created file

```java
private static BufferedWriter writer ;
```
Used to write inside of the created file

```java
private static String name ;
```
The name of the created file

```java
private static Scanner scan = new Scanner(System.in) ;
```
Used to ask the user for instructions


## Methods overview

```java
public static void main(String[] args)
```
This method is used to drive the execution, it will ask the instructions and execute the other methods

```java
public static void fileCreator()
```
This method tries to create a file with the name entered in the main method (the file is created next the ClassBuilder class)

```java
public static void fileWriterFunc(String content)
```
This method uses the FileWriter attribute to write into the previously created file

```java
public static String attributesCreator(List<String> attributes, List<String> types)
public static String getterCreator(List<String> attributes, List<String> types)
public static String setterCreator(List<String> attributes, List<String> types)
public static String toStringCreator(List<String> attributes, List<String> types)
```
Respectively creates the attributes, the getters, the setters and the toString method depending on the attributes and their type

