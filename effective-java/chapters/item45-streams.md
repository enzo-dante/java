# use streams & iteration combination

streams do not make iteration obsolete.

---

*streams only support:*

int, long, and double


*streams are evaluated lazily:*

evaluation doesn't start until the terminal operation is invoked and data elements that aren't required in order to complete the terminal operation are never computed.

*streams are fluent*:

calls comprised into a sequential pipeline can be chained into a single expression. its possible to chain multiple pipelines together.

---

# best use of streams

uniformly transform sequence of elements.

filter sequence of elements.
- search a sequence of elements for a specific element based on criteria.

combine sequence of elements using a single operation.
- add them for sum.

group sequence of elements into a collection.

# stream heuristics

*don't over use streams:*

overusing streams makes programs hard to read and maintain.

---

*modularize methods in streams:*

helper method logic separate from the stream for readability.

---

*stream parameter naming:*

lambda parameters should be carefully named in stream pipelines.

---

*refrain from char streams:*

no char support because elements of a char stream would return int values due to overloading.
- could fix with casting

---

*don't convert all loops into streams*

it could potentially hurt readability.

# stream difficulties

*access corresponding elements from multiple stages of a pipeline simultaneously.*

**once you map a value to some other value, the original is lost? pg 207**

*workaround:*

invert mapping when you need access to the earlier-stage value.

*example:*


![](/imgs/mersenne-prime.svg)

a program to print the first twenty Mersenne primes.

```
static Stream<BigInteger> primes() {
    return Stream.iterate(TWO, BigInteger::nextProbablePrime);
}

public static void main(String[] args) {
    primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
        .filter(mersenne -> mersenne.isProbablePrime(50))
        .limit(20)
        .forEach(System.out::println);
}

```
# streams vs iteration

iteration might be better for general readability

*iteration example:*

```
private staic List<Card> newDeck() {
    List<Card> result = new ArrayList();

    for (Suit suit : Suit.values())
        for (Rank rank: Rank.values())
            result.add(new Card(suit, rank))
    return result;
}
```

*stream example:*

flatMap(): maps each element in a stream to a stream and then concatenates all of these new streams into a single stream (flatten).

![](/imgs/cartesian-product-definition.png)

![](/imgs/cartesian-product-calculation.png)


```

private static List<Card> newDeck() {
    return Stream.of(Suit.values())
        flatMap(suit ->
            Stream.of(Rank.values())
                .map(rank -> new Card(suit, rank)))
        .collect(toList());
}
```

# streams vs code blocks

code blocks can read/update any local variable in scope.

lambdas in streams only read final variables and cannot modify local variables.

---

code blocks can return, break, or continue an enclosing method.

lambdas in streams cannot.

---

