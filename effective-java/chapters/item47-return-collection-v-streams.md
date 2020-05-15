# return collections over streams

the Collection interface is a subtype of Iterable and has a stream method, so it provides for both iteration and stream access.

most cases, provide users who what to write stream pipelines as well as those who want to write for-each statements.
- if confident a method is only going to be used in a stream pipeline, then return a stream.

# stream problem

*example:*

there no easy solution if an api returns only a stream and some users want to iterate over the returned sequence with a for-each loop.

**solution 1:**

the solution is to cast the method reference as parameterized Iterable.

```
// Hideous workaround to iterate over a stream
for (ProcessHandle ph : (Iterable<ProcessHandle>)
    ProcessHandle.allProcesses()::iterator)
```

**solution 2:**

use an adaptor method:

```
// Adapter from  Stream<E> to Iterable<E>
public static <E> Iterable<E> iterableOf(Stream<E> stream) {
    return stream::iterator;
}

for (ProcessHandle p : iterableOf(ProcessHandle.allProcesses())) {
    // Process the process
}
```

without casting, you can iterate over any stream with a for-each statement.

# collection considerations

disclaimer: do not store a large sequence in a memory just to return it as a collection.

if you already have an elements in a collection or a number of elements in the sequence is small enough to justify creating a new collection, return a standard collection such as ArrayList

if *too large*, consider implementing a custom collection.





