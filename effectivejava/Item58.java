/**
* Representative of Item 58: Use checked exceptions for recoverable
* conditions and runtime exceptions for programming errors.
*
* This item is mostly theoritical so you are better off reading it
* from the book itself.
*
* SALIENT POINTS:
* 1. Exceptions are full-fledged objects so methods can be used to derive
* more information about it, instead of parsing the exception string
* (bad practise in itself)
* 2. It is best not to implement any 'Error' subclasses. All unchecked
* throwables you implement should subclass RuntimeException (directly or
* indirectly).
*/
