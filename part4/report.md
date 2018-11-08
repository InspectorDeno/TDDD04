# Part4 Questions

No, all statements have not been executed. It tells us that there is a lack of testes in the program to test all functionality and methods. It's important to have tests that

High coupling between concrete classes are a problem because it is correlated with log cohesion which meant that the program has a bad design with un-structured classes and dependencies. When you have high coupling it can be hard to understand and make assumptions of the tests and see why the test fails if it is caused of one of the dependencies. Instead there is important in each test-class to test only the class we want to test without being dependent on other components. The result would be that in each test-class we could test only the class we want to test without having to make an assumptions or care about the dependencies.

It have also a good effect on the code coverage since we are more independent. But it is also harder to write the predictions of the tests inside the class since we need to predict the behavior of the behaviour of other components.

The effects can be that an developer think that everything works fine since all tests passed but their might be some untested problems in the code. The developer that created the tests maybe wasn’t the one who developed the code or just being a part of a bigger team. So the test creator maybe had a bad overall knowledge of the code.

## Colony Dependencies UML Diagram

![Colony Dependencies](https://raw.githubusercontent.com/InspectorDeno/TDDD04/master/part4/colony_dependencies.png)
