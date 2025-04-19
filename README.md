# ClassBuilder
Automatic java class builder (linux only, see below to make it windows ready)

Author ***ZeSpatule***

Version *1.0* since *2025-19-04*

Make sure java is installed on your system.

If you have any question, suggestion, problem, here is my discord : @zespatule

*the documentation is available in the documentation.md file*


## Running the tool

To run the tool, open a terminal (right click > open in Terminal or with cd ~/path/to/ClassBuilder) and type : 
```bash
java ClassBuilder
```
You should get prompted with the name of the file you want to create.
The file will then be created next to the ClassBuilder, you can then move it wherever you want.


## Making the ClassBuilder compatible with windows

You can try to run the file, but if you get an error, you might try the following.

You will need to replace a line in the code (found in ClassBuilder.java)
and recompile the file.

At line 94 : 
```java
p = "./" + name + ".java" ;
```
try removing the part with the semicolon
```java
// result
p = name + ".java" ;
```

then, recompile the file
```bash
javac ClassBuilder.java
```

If you still get an error, try searching on the internet, otherwise, you can contact me on discord.
