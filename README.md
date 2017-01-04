# BurrViews
Helper classes for registering and resolving view fragments in a Java Spring application using Thymeleaf
This library provides a helper class (ViewProvider) which is injected into the view context in order to provide view fragments. This allows the developer to mock said ViewProvider in tests, isolating the behavior of individual pages and fragments as well as the expected arguments passed to each fragment.
The ViewProvider is available in Thymeleaf templates as `#viewProvider`
It is recommended that you use BurrTesting in conjunction with this library in order to test your view fragments

# Getting started
This library is available on Bintray, via the jcenter repository