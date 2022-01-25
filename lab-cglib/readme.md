Circuit breaker
https://martinfowler.com/bliki/CircuitBreaker.html

TryCglibApplicationTest

in testPlainRestTemplate
httpclient receives response every 2 seconds

in testProxiedRestTemplate
httpclient receives first 2 responses every 2 seconds, instant responses afterwards
because the application uses a resttemplate enhanced in GetEntityInterceptor