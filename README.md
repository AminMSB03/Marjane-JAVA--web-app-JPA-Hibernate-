# Marjane-JAVA--web-app-JPA-Hibernate-



## Context of the project
The hypermarket Marjane Morocco wishes to simplify the management of the promotions of its products at the level of all the centers of the kingdom. To do this, the general administrator of the Marjane group will take charge of the management of each center's administrator per city, which can have 1 or more centers and each center is managed by a single administrator. The management of promotion is managed every day at the center level, from its interface the admin (already created by the general admin email and provisional password sent by email) creates a list of promotions by category of products, for example in the multimedia category we will add a promotion of laptop which will be 10% with 100dhs earned on the loyalty card Thereafter a department manager (created by the admin, email and temporary password sent by email) multimedia connects to its interface to consult its list of promotions to accept or reject according to the quantity of stock available in the center, if for example the quantity of stock of laptops is 80 units, it will accept the promotion by adding a comment that determines the quantity of products available

The Marjane administrator can then consult all the promotions applied and not applied to his center

For a better management of the promotions Marjane requires that all the promotions are consultable by the person in charge of the department only between 8:00 am and 12:00 pm, if a person in charge of the department connects out of this interval the promotions will be unavailable and if the person in charge of the department does not make any action the promotion will be not treated and is posted at the admin

A general rule applies to all promotions of the Marjane Group Morocco:

Each promotion must not exceed 50% of the product price

Each 5% discount is worth 50dhs of loyalty points earned

The promotion of multimedia products should not exceed 20% Each operation made in the system is recorded in the log file and in the database The General Admin of the Marjane Group wishes to view the statistics of promotions applied and not applied on its interface Each promotion is valid according to the amount of stock available and can be viewed once between 8am-12pm, if for example an Admin launches an application at 8am, it will be seen only by the manager of the department of 8am-12pm if it has not processed will not be applied in the system



## NB:

Each promotion a validity period modified by the admin of the center marjane



## Work requested by Marjane :

Realize the Backend part in JAVA/JPA/Hibernate (use of lambda expression + streams)

Add the necessary unit tests

Add a PostgreSQL database adequate to the system

Organize your project with a tool of your choice
