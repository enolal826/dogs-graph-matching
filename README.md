# FIND THE DOGS MOST CONVENIENT FOR YOU!
## Application overview
This application holds the development of a dog-matching project. Given some input,
the best matching dogs are retrieved.

In this case, we try to find the best dogs for a person based on the answers to 3 questions:
1. What's your home type? (small flat, big flat, house with yard, house without yard)
2. How much time do you spend at home?
3. How many times are you willing to go out with your dog? *(to do)*

With this questions we capture some of the requirements a person has in order to adopt a dog
(some people may go out more often than others, not every dog is suitable for every home type, etc)

## Modeling
In order to find the best matching dogs, we are going to consider several aspects:
- Dog's temperament (active, independent, docile...)
- Size
- Breed

For this purpose, we have used a graph model and a graph database (Neo4j). In this graph, we make
the following types of nodes (i.e. entities on our application domain)
- Dog (representing a single dog individual: name, age...)
- Breed (representing a dog's breed)
- Temperament (representing the different temperaments a dog can have)

and the following relationships (for the moment):

- Dog -> Temperament (a dog has several temperament attributes)
- Breed -> Temperament (a specific breed may also have some temperament attributes associated)
- Dog -> Breed (a dog belongs to a breed)

Therefore, a compound relationship like: *Dog -> Breed -> Temperament* would be valid

## Searching
Once we have the graph, we have to think of a traversal that could be useful. My proposal:

The answers to the question have associated some temperaments, so the search should be done
based on this:
- Search for dogs with the given temperaments
- Search for dogs of breeds having the given temperaments

This means that we're are not only considering invidual dogs but also breeds that are associted
with the answer's temperaments.

## Design
I have followed the DDD guidelines, dividing the application into three layers:
- **application:** this layer contains the use cases of the application and is the entry point
to the application itself regardless of how we access it (http, websockets...)
In the package route, we find the use cases of the application (e.g. FindMatchingDogs). Every use case has
a request and a response
- **domain:** contains entities, value objects and *business logic*
- **infrastructure:** contains all external interfaces and connections (database, http...). I have used GraphQL
so the endpoints can be found under http/graphql

## Testing
I have used the Spock framework.
*(integration tests missing)*

## How to run it
*(to do)*