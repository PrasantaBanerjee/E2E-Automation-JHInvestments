                    ________________________________________
                  _/_                                      _\_
               __/__/          End to End Automation       \__\__
              | « « |             JH Investments            | » » |
               ¯¯\¯¯\      Selenium WebDriver w/Java        /¯¯/¯¯
                  ¯\¯                                      ¯/¯
                    ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯
This repository serves as a codebase for the Automation script developed for JH Investments (Boston-based Asset Management company).
This is a reusable automation framework that blends together Selenium WebDriver, Java & TestNG.

The framework incorporates design principles of POM (Page Object Model) which promotes designing a separate class for every single WebPage of the application. The primary advantage to using Page Objects is that when a component changes in the underlying application, 
it only needs to be changed in the Page object instead of each test. Each page object class serves as an object repository & ultimately helps to avoid code duplication & improves code maintainability & readability.

Project Skeleton:
===================
```
   org
     └── jhi
	  ├── listeners
	  │   ├── AnnotationTransformer.java
	  │   ├── RetryListener.java
	  │   └── TestListener.java
	  └── main
	  │   └── Base.java
	  └── page_objects
	  │   ├── AboutUsPage.java
	  │   ├── HomePage.java
	  │   └── ViewpointsPage.java
	  └── resources
	  │   └── properties
	  │	    └── config.properties
	  └── testcases
	  │   ├── Validations_AboutUs.java
	  │   ├── Validations_Homepage.java
	  │   └── Validations_Viewpoints.java
	  └── utils
	  	├── PropertyFileReader.java
		└── ScreenshotUtils.java
```
Tools & Libraries:
====================
The test automation framework is comprised of the following tools & libraries:
  1. Java 1.8 : Programming language.
  2. Selenium WebDriver 3.141.59 : Web browser automation library.
  3. TestNG : Develop Test framework.
  4. Git : Version control.
  5. Eclipse : Integrated Development Environment. 

Developed & Maintained by:
============================
  Prasanta Banerjee.
  
  QA Automation Engineer.
  
  E-Mail: Prasanta.Banerjee77@gmail.com
