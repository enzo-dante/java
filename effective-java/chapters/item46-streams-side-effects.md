# Side-Effect-Free Functions in Streams

*for streams, structure your computation as a sequence of transformations where the result of each state is as close as possible to a pure function of the result of the previous stage.*

a pure function is one whose result only depends on its input.
- it does not depend on any mutable state, nor does it update any state.

the Collectors api used by streams offer many methods to allow for stage pure function computation.
- types of collectors: toList(), toSet(), toCollection(), groupingBy, joining

# stream collect()

*frequency table iteration example:*

The forEach operation should be used only to report the result of a stream  computation,  not  to  perform  the  computation.

```
Map<String, Long> freq = new HashMap<>();

try (Stream<String> words = new Scanner(file).tokens()) {
    words.forEach(word -> {
        freq.merge(word.toLowerCase(), 1L, Long::sum);
        });
    }
```

---

*frequency table stream example:*

in this case, streams are an improvement because collectors can combine (thus reduce) the elements of a stream into a single object (a collection).

The **groupingBy(function, classifier)** method of Collectors class in Java are used for grouping objects by some property and storing results in a Map instance.
- Function- It is the property which is to be applied to the input elements.
- Classifier- It is used to map input elements into the destination map.

the **counting()** method is an example of a downstream collector that returns the number of elements in the category.
- downstream collector produces a value from a stream containing all the elements in a category.

**String::toLowerCase** = example of a map factory

```
Map<String, Long> freq;
try (Stream<String> words = new Scanner(file).tokens()) {
    freq = words
        .collect(groupingBy(String::toLowerCase, counting()));
}
```

---

# stream toList()

This method returns a Collector which collects all the input elements into a List, in encounter order

list top 10 tokenized words

"freq::get" = a table lookup reference method that looks up a word in a frequency table and returns number of times word appears in file.

revered() = sorting words from most frequent to least frequent.

```
List<String> topTen = freq.keySet().stream()
    .sorted(comparing(freq::get).reversed())
    .limit(10)
    .collect(toList());
```

# stream toMap()

*toMap(keyMapper, valueMapper)*
- maps stream element to a key and value.

in its simplest form, each element needs to map a unique key.

---

*overloaded toMap(Function keyMapper, Function valueMapper, BinaryOperator mergeFunction)*
- The task of the function is to merge the values having the same key in a way defined by the coder.

This overloaded method is recommended only in the case when there are same keys for multiple values.

*example:*

the 3rd argument **maxBy** is a **BinaryOperator:**
- a binary operator which takes two operands and operates on them to produce a result of same type.

the Collector methods **minBy & maxBy** use a comparator and return minimum & maximum, respectively.

convert  the  stream  of  albums  to  a  map,  mapping  each  artist  to  the  album that has the best album by sales.

```
// Collector to generate a map from key to chosen element for key

Map<Artist, Album> topHits = albums.collect(
    toMap(Album::artist, a->a, maxBy(comparing(Album::sales))));
```

---

# pg.213 need clarification...

*toMap() last-win policy*

use for non-deterministic results

```
// Collector to impose last-write-wins policy

toMap(keyMapper, valueMapper, (v1, v2) -> v2)
```

# stream CharSequence

CharSequence returns a collector that concatenates the elements.
- can pass delimiter argument to join with delimiter like a comma.










