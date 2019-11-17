[![Build Status](https://travis-ci.com/johnsourour/FSM_Framework.svg?token=yyTsrjUnkBzUgvDcjdnD&branch=master)](https://travis-ci.com/johnsourour/FSM_Framework)
<br />

# FSM Framework

#### Description

```
A Finite State Machine framework that can help model and implement a program 
by defining several states, transitions and actions.
```

#### Class Diagram

![](class_d.png)

 * FSM:
    This will be the main class that wraps everything
 * Data:
    This class will be mainly responsible for data setting, manipulation and retrieval
 * State
    This class defines every state in the system.
 * Transition 
    This class will be responsible for the flow of the execution of the finite
    state machine
 * Action:
    This class defined the Action on the Data that will be executed inside each state
 
 ###### Note:  Action, Data and State may be defined as interfaces to be implemented for each type of the specific interface
  
    
 #### Testing
 
 To test this framework, one or more application will be implemented. (e.g: vending machine, poker game)




